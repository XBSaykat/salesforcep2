package net.maxproit.salesforce.masum.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ImageUtils {

    public static byte[] imagetoByte(ImageView image){
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,50,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }

    public static Bitmap getBitmapFromByte(byte[] img){
        Bitmap bmp= BitmapFactory.decodeByteArray(img,0,img.length);
        return bmp;
    }


}
