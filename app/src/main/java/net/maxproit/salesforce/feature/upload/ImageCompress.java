package net.maxproit.salesforce.feature.upload;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import id.zelory.compressor.Compressor;

public class ImageCompress {


    public static File compress(Context context, File file) {
        try {
            return new Compressor(context).compressToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File customCompressImage(Context context, File file) {
        try {
            return new Compressor(context)
                    .setMaxWidth(640)
                    .setMaxHeight(480)
                    .setQuality(80)
                    .setCompressFormat(Bitmap.CompressFormat.WEBP)
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .compressToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
