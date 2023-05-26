package com.testapp.ramboostergfxtool.util;

import android.os.Build;

import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CpuInfo {

    public static int getCpuUsageFromFreq() {
        return getCpuUsage(getCoresUsageGuessFromFreq());
    }

    public static int getCpuUsageSinceLastCall() {
        if (Build.VERSION.SDK_INT < 26)
            return getCpuUsage(getCoresUsageDeprecated());
        else
            return 0;
    }

    public static int getCpuUsage(int[] coresUsage) {
        int cpuUsage = 0;
        if (coresUsage.length < 2)
            return 0;
        for (int i = 1; i < coresUsage.length; i++) {
            if (coresUsage[i] > 0)
                cpuUsage += coresUsage[i];
        }
        return cpuUsage / (coresUsage.length - 1);
    }

    public static synchronized int[] getCoresUsageGuessFromFreq()
    {
        initCoresFreq();
        int nbCores = mCoresFreq.size() + 1;
        int[] coresUsage = new int[nbCores];
        coresUsage[0] = 0;
        for (byte i = 0; i < mCoresFreq.size(); i++) {
            coresUsage[i + 1] = mCoresFreq.get(i).getCurUsage();
            coresUsage[0] += coresUsage[i + 1];
        }
        if (mCoresFreq.size() > 0)
            coresUsage[0] /= mCoresFreq.size();
        return coresUsage;
    }

    public static void initCoresFreq()
    {
        if (mCoresFreq == null) {
            int nbCores = getNbCores();
            mCoresFreq = new ArrayList<>();
            for (byte i = 0; i < nbCores; i++) {
                mCoresFreq.add(new CoreFreq(i));
            }
        }
    }

    private static int getCurCpuFreq(int coreIndex) {
        return readIntegerFile("/sys/devices/system/cpu/cpu" + coreIndex + "/cpufreq/scaling_cur_freq");
    }

    private static int getMinCpuFreq(int coreIndex) {
        return readIntegerFile("/sys/devices/system/cpu/cpu" + coreIndex + "/cpufreq/cpuinfo_min_freq");
    }

    private static int getMaxCpuFreq(int coreIndex) {
        return readIntegerFile("/sys/devices/system/cpu/cpu" + coreIndex + "/cpufreq/cpuinfo_max_freq");
    }


    private static int readIntegerFile(String path)
    {
        int ret = 0;
        try {
            RandomAccessFile reader = new RandomAccessFile(path, "r");

            try {
                String line = reader.readLine();
                ret = Integer.parseInt(line);
            } finally {
                reader.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }


    public static int getNbCores() {
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                if(Pattern.matches("cpu[0-9]+", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }

        try {
            File dir = new File("/sys/devices/system/cpu/");
            File[] files = dir.listFiles(new CpuFilter());
            return files.length;
        } catch(Exception e) {
            return 1;
        }
    }


    private static class CoreFreq {
        int num, cur, min = 0, max = 0;

        CoreFreq(int num) {
            this.num = num;
            min = getMinCpuFreq(num);
            max = getMaxCpuFreq(num);
        }

        void updateCurFreq() {
            cur = getCurCpuFreq(num);
            if (min == 0)
                min = getMinCpuFreq(num);
            if (max == 0)
                max = getMaxCpuFreq(num);
        }

        int getCurUsage() {
            updateCurFreq();
            int cpuUsage = 0;
            if (max - min > 0 && max > 0 && cur > 0) {
                cpuUsage = (cur - min) * 100 / (max - min);
            }
            return cpuUsage;
        }
    }

    private static ArrayList<CoreFreq> mCoresFreq;



    public static synchronized int[] getCoresUsageDeprecated() {
        int numCores = getNbCores() + 1;

        if (mPrevCoreStats == null)
            mPrevCoreStats = new ArrayList<>();
        while(mPrevCoreStats.size() < numCores)
            mPrevCoreStats.add(null);

        ArrayList<CoreStat> coreStats = new ArrayList<>();
        while(coreStats.size() < numCores)
            coreStats.add(null);

        int[] coresUsage = new int[numCores];
        for (byte i = 0; i < numCores; i++)
            coresUsage[i] = -1;

        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");

            try {
                CoreStat curCoreStat = null;
                String line = reader.readLine();

                for (byte i = 0; i < numCores; i++) {
                    if (!line.contains("cpu"))
                        break;

                    curCoreStat = readCoreStat(i, line);
                    if (curCoreStat != null) {
                        CoreStat prevCoreStat = mPrevCoreStats.get(i);
                        if (prevCoreStat != null) {
                            float diffActive = curCoreStat.active - prevCoreStat.active;
                            float diffTotal = curCoreStat.total - prevCoreStat.total;
                            if (diffActive > 0 && diffTotal > 0)
                                coresUsage[i] = (int) (diffActive * 100 / diffTotal);
                            if (coresUsage[i] > 100)
                                coresUsage[i] = 100;
                            if (coresUsage[i] < 0)
                                coresUsage[i] = 0;
                        }

                        mPrevCoreStats.set(i, curCoreStat);

                        line = reader.readLine();
                    }
                }

            } finally {
                reader.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return coresUsage;
    }


    private static CoreStat readCoreStat(int coreNum, String line) {
        CoreStat coreStat = null;
        try {
            String cpuStr;
            if (coreNum > 0)
                cpuStr = "cpu" + (coreNum - 1) + " ";
            else
                cpuStr = "cpu ";

            if (line.contains(cpuStr)) {
                String[] toks = line.split(" +");

                long active = Long.parseLong(toks[1]) + Long.parseLong(toks[2])
                        + Long.parseLong(toks[3]);
                long total = Long.parseLong(toks[1]) + Long.parseLong(toks[2])
                        + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                        + Long.parseLong(toks[5]) + Long.parseLong(toks[6])
                        + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

                coreStat = new CoreStat(active, total);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return coreStat;
    }

    private static class CoreStat {
        float active;
        float total;

        CoreStat(float active, float total) {
            this.active = active;
            this.total = total;
        }
    }

    private static ArrayList<CoreStat> mPrevCoreStats;

}
