package com.testapp.ramboostergfxtool.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CpuInfoM {
    public long aLong = 0;
    public long aLong1 = 0;
    public long aLong2 = 0;

    public CpuInfoM() {
        readCpuInfo();
    }

    private void readCpuInfo() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split[5]);
            this.aLong2 = (long) ((((float) (parseLong - this.aLong)) * 100.0f) / ((float) (((parseLong - this.aLong) + parseLong2) - this.aLong1)));
            this.aLong = parseLong;
            this.aLong1 = parseLong2;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getUsage() {
        readCpuInfo();
        if (this.aLong2 < 0) {
            this.aLong2 = 0;
        }
        if (this.aLong2 > 100) {
            this.aLong2 = 100;
        }
        return this.aLong2;
    }
}
