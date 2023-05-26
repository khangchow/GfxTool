package com.testapp.ramboostergfxtool.vipgfx.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileUtil {
    private static void createNewFile(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf > 0) {
            makeDir(str.substring(0, lastIndexOf));
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String readFile(String arg5) {
        int v5_2 = 0;
        FileReader v2 = null;
        FileUtil.createNewFile(arg5);
        StringBuilder v0 = new StringBuilder();
        FileReader v1 = null;
        try {
            v2 = new FileReader(new File(arg5));
            v5_2 = 0x400;
        }
        catch(Throwable v5) {
        }

        try {
            char[] v5_3 = new char[v5_2];
            while (true) {
                int v1_1 = v2.read(v5_3);
                if (v1_1 <= 0) {
                    break;
                }

                v0.append(new String(v5_3, 0, v1_1));
            }
        } catch (Throwable v5) {
        }


        try {
            v2.close();
        } catch (Exception v5_4) {
        }

        v1 = v2;
        try {
            v1.close();
        }
        catch(Exception v5_4) {
            v5_4.printStackTrace();
        }



        if(v1 != null) {
            try {
                v1.close();
            }
            catch(Exception v0_1) {
                v0_1.printStackTrace();
            }
        }
        return v0.toString();
    }

    public static void writeFile(String arg3, String arg4) {
        FileWriter v1 = null;
        FileUtil.createNewFile(arg3);
        FileWriter v0 = null;
        try {
            v1 = new FileWriter(new File(arg3), false);
        }
        catch(Throwable v3) {
        }
        try {
            v1.write(arg4);
            v1.flush();
        }
        catch(Throwable v3) {
            v0 = v1;
        }

        try {
            if(v0 == null) {
                return;
            }
        }
        catch(Throwable v3) {
        }

        try {
            v0.close();
            return;
        }
        catch(Throwable f) {
        }


        if(v0 != null) {
            try {
                v0.close();
            }
            catch(IOException v4) {
                v4.printStackTrace();
            }
        }

        try {
            v1.close();
        }
        catch(IOException v3_1) {
            v3_1.printStackTrace();
        }
    }

    public static void copyFile(String arg3, String arg4) {
        int v4_2 = 0;
        FileOutputStream v3 = null;
        FileInputStream v1 = null;
        if(!FileUtil.isExistFile(arg3)) {
            return;
        }

        FileUtil.createNewFile(arg4);
        FileInputStream v0 = null;

        try {
            v1 = new FileInputStream(arg3);
        }
        catch(Throwable v4) {

        }


        try {
            v3 = new FileOutputStream(arg4, false);
            v4_2 = 0x400;
        }
        catch(Throwable v4) {

        }

        try {
            byte[] v4_3 = new byte[v4_2];
            while(true) {
                int v0_1 = v1.read(v4_3);
                if(v0_1 <= 0) {
                    break;
                }

                v3.write(v4_3, 0, v0_1);
            }
        }
        catch(Throwable v4) {
        }


        try {
            v1.close();
        }
        catch(IOException v4_1) {
            v4_1.printStackTrace();
        }

        try {
            v3.close();
            return;
        }
        catch(IOException v3_1) {
        }

        v0 = v1;


        try {
            v0.close();
        }
        catch(IOException v4_1) {
            v4_1.printStackTrace();
        }

        if(v3 != null) {
            try {
                v3.close();
            }
            catch(IOException v3_1) {
                v3_1.printStackTrace();
            }
        }



        if(v0 != null) {
            try {
                v0.close();
            }
            catch(IOException v0_2) {
                v0_2.printStackTrace();
            }
        }

        if(v3 != null) {
            try {
                v3.close();
            }
            catch(IOException v3_1) {
                v3_1.printStackTrace();
            }
        }
        return;
    }



    public static void copyDir(String str, String str2) {
        File[] listFiles = new File(str).listFiles();
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (File file2 : listFiles) {
            String str3 = "eg==";
            if (file2.isFile()) {
                String path = file2.getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(str2));
                sb.append(StringFogImpl.decrypt(str3));
                sb.append(file2.getName());
                copyFile(path, sb.toString());
            } else if (file2.isDirectory()) {
                String path2 = file2.getPath();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2));
                sb2.append(StringFogImpl.decrypt(str3));
                sb2.append(file2.getName());
                copyDir(path2, sb2.toString());
            }
        }
    }

    public static void moveFile(String str, String str2) {
        copyFile(str, str2);
        deleteFile(str);
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteFile(file2.getAbsolutePath());
                    }
                    if (file2.isFile()) {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static boolean isExistFile(String str) {
        return new File(str).exists();
    }

    public static void makeDir(String str) {
        if (!isExistFile(str)) {
            new File(str).mkdirs();
        }
    }

    public static void listDir(String str, ArrayList<String> arrayList) {
        File file = new File(str);
        if (file.exists() && !file.isFile()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0 && arrayList != null) {
                arrayList.clear();
                for (File absolutePath : listFiles) {
                    arrayList.add(absolutePath.getAbsolutePath());
                }
            }
        }
    }

    public static boolean isDirectory(String str) {
        if (!isExistFile(str)) {
            return false;
        }
        return new File(str).isDirectory();
    }

    public static boolean isFile(String str) {
        if (!isExistFile(str)) {
            return false;
        }
        return new File(str).isFile();
    }

    public static long getFileLength(String str) {
        if (!isExistFile(str)) {
            return 0;
        }
        return new File(str).length();
    }

    public static String getExternalStorageDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getPackageDataDir(Context context) {
        return context.getExternalFilesDir(null).getAbsolutePath();
    }

    public static String getPublicDir(String str) {
        return Environment.getExternalStoragePublicDirectory(str).getAbsolutePath();
    }

    public static String convertUriToFilePath(Context arg5, Uri arg6) {
        Uri v0_1;
        String v0;
        String v5_1 = null;
        String v1 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(DocumentsContract.isDocumentUri(arg5, arg6)) {
                String v2 = "bw==";
                if(FileUtil.isExternalStorageDocument(arg6)) {
                    String[] v5 = DocumentsContract.getDocumentId(arg6).split(StringFogImpl.decrypt(v2));
                    if(StringFogImpl.decrypt("JSYvQFknLQ==").equalsIgnoreCase(v5[0])) {
                        v5_1 = Environment.getExternalStorageDirectory() + StringFogImpl.decrypt("eg==") + v5[1];
                    }
                    else {

                    }
                }
                else if(FileUtil.isDownloadsDocument(arg6)) {
                    String v6_1 = DocumentsContract.getDocumentId(arg6);
                    if(!TextUtils.isEmpty(((CharSequence)v6_1))) {
                        v0 = "JzUxFw==";
                        if(v6_1.startsWith(StringFogImpl.decrypt(v0))) {
                            return v6_1.replaceFirst(StringFogImpl.decrypt(v0), "");
                        }
                    }

                    v5_1 = FileUtil.getDataColumn(arg5, ContentUris.withAppendedId(Uri.parse(StringFogImpl.decrypt("NjsoWV07IHwCFzE7MUNUOjUiXhclISRBUTYLIkJPOzgpTFwm")), Long.valueOf(v6_1).longValue()), v1, (null));
                }
                else {
                    if(!FileUtil.isMediaDocument(arg6)) {
                    }

                    String[] v6_2 = DocumentsContract.getDocumentId(arg6).split(StringFogImpl.decrypt(v2));
                    v0 = v6_2[0];
                    if(StringFogImpl.decrypt("PDknSl0=").equals(v0)) {
                        v0_1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    }
                    else if(StringFogImpl.decrypt("Iz0iSFc=").equals(v0)) {
                        v0_1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    }
                    else if(StringFogImpl.decrypt("NCEiRFc=").equals(v0)) {
                        v0_1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    else {
                        v0_1 = (null);
                    }

                    v5_1 = FileUtil.getDataColumn(arg5, v0_1, StringFogImpl.decrypt("Cj0iEAc="), new String[]{v6_2[1]});
                }
            }
            else {
                if(StringFogImpl.decrypt("NjsoWV07IA==").equalsIgnoreCase(arg6.getScheme())) {
                    v5_1 = FileUtil.getDataColumn(arg5, arg6, v1, null);
                }

                if(StringFogImpl.decrypt("Mz0qSA==").equalsIgnoreCase(arg6.getScheme())) {
                    v5_1 = arg6.getPath();
                }

                v5_1 = v1;
            }
        }

        if(v5_1 == null) {
            return v1;
        }

        try {
            return URLDecoder.decode(v5_1, StringFogImpl.decrypt("AAAAAAA="));
        }
        catch(Exception e) {
            return v1;
        }
    }
    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        String str2 = "CjAnWVk=";
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{StringFogImpl.decrypt(str2)}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow(StringFogImpl.decrypt(str2)));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (th != null) {
                        if (th != th) {
                            try {
                                th.addSuppressed(th);
                            } catch (Exception unused) {
                            }
                        }
                        th = th;
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            th = null;
        }
        return str2;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return StringFogImpl.decrypt("NjsrA1k7MDRCUTF6I1VMMCYoTFQmIClfWTIxaElXNiErSFYhJw==").equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return StringFogImpl.decrypt("NjsrA1k7MDRCUTF6Nl9XIz0iSEomeiJCTzs4KUxcJnoiQlsgOSNDTCY=").equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return StringFogImpl.decrypt("NjsrA1k7MDRCUTF6Nl9XIz0iSEomeitIXDw1aElXNiErSFYhJw==").equals(uri.getAuthority());
    }

    private static void saveBitmap(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        createNewFile(str);
        Throwable th = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            if (th != null) {
                if (th != th) {
                    try {
                        th.addSuppressed(th);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                th = th;
            }
            try {
                throw th;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static Bitmap getScaledBitmap(String str, int i) {
        int i2;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        if (width > height) {
            i2 = (int) (((float) height) * (((float) i) / ((float) width)));
        } else {
            int i3 = (int) (((float) width) * (((float) i) / ((float) height)));
            i2 = i;
            i = i3;
        }
        return Bitmap.createScaledBitmap(decodeFile, i, i2, true);
    }

    public static int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            int i6 = i4 / 2;
            int i7 = i3 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap decodeSampleBitmapFromPath(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static void resizeBitmapFileRetainRatio(String str, String str2, int i) {
        if (isExistFile(str)) {
            saveBitmap(getScaledBitmap(str, i), str2);
        }
    }

    public static void resizeBitmapFileToSquare(String str, String str2, int i) {
        if (isExistFile(str)) {
            saveBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), i, i, true), str2);
        }
    }

    public static void resizeBitmapFileToCircle(String str, String str2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawCircle((float) (decodeFile.getWidth() / 2), (float) (decodeFile.getHeight() / 2), (float) (decodeFile.getWidth() / 2), paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(decodeFile, rect, rect, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void resizeBitmapFileWithRoundedBorder(String str, String str2, int i) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            RectF rectF = new RectF(rect);
            float f = (float) i;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(decodeFile, rect, rect, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void cropBitmapFileFromCenter(String str, String str2, int i, int i2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            if (width >= i || height >= i2) {
                int i3 = 0;
                int i4 = width > i ? (width - i) / 2 : 0;
                if (height > i2) {
                    i3 = (height - i2) / 2;
                }
                if (i > width) {
                    i = width;
                }
                if (i2 > height) {
                    i2 = height;
                }
                saveBitmap(Bitmap.createBitmap(decodeFile, i4, i3, i, i2), str2);
            }
        }
    }

    public static void rotateBitmapFile(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void scaleBitmapFile(String str, String str2, float f, float f2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postScale(f, f2);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void skewBitmapFile(String str, String str2, float f, float f2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postSkew(f, f2);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void setBitmapFileColorFilter(String str, String str2, int i) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth() - 1, decodeFile.getHeight() - 1);
            Paint paint = new Paint();
            paint.setColorFilter(new LightingColorFilter(i, 1));
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void setBitmapFileBrightness(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), decodeFile.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void setBitmapFileContrast(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), decodeFile.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static int getJpegRotate(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(StringFogImpl.decrypt("GiYvSFYhNTJEVzs="), -1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException unused) {
            return 0;
        }
    }

    public static File createNewPictureFile(Context context) {
        StringBuilder sb = new StringBuilder(String.valueOf(new SimpleDateFormat(StringFogImpl.decrypt("LC0/VHUYMCJycB05K15L")).format(new Date())));
        sb.append(StringFogImpl.decrypt("ez42Sg=="));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(context.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath()));
        sb3.append(File.separator);
        sb3.append(sb2);
        return new File(sb3.toString());
    }
}
