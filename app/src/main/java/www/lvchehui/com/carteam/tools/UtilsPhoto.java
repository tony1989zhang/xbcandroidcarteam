package www.lvchehui.com.carteam.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Display;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import www.lvchehui.com.carteam.view.toast.ToastManager;

/**
 * 作者：V先生 on 2016/8/2 10:13
 * 作用：
 */
public class UtilsPhoto{
    private GetPhotoResultListener mGetPhotoResultListener;
    private static UtilsPhoto utilsPhoto;
    private static final int PHOTO_CARMERA = 1;
    private static final int PHOTO_PICK = 2;
    private String picname;
    private Activity mActivity;
    private int width;
    private int height;

    private File file;
    private UtilsPhoto(){}
    private UtilsPhoto(Activity acy,GetPhotoResultListener getPRListener)
    {
        mActivity = acy;
        SharedPreferences spf = acy.getSharedPreferences("info_user", Context.MODE_APPEND);
        String picname = "f_" + spf.getString("_id", "") + "_" + System.currentTimeMillis() / 1000 + ".png";
        file = new File(Environment.getExternalStorageDirectory(), picname);
        Display display = acy.getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }
    public static UtilsPhoto getInstance(Activity acy,GetPhotoResultListener getPhotoResultListener){
        if (null == utilsPhoto)
        {
            utilsPhoto = new UtilsPhoto(acy,getPhotoResultListener);
        }
        return utilsPhoto;
    }
    public void showDialog()
    {
        //相册获取
        startCamera();
        //拍照
    }

    private void startCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.ACTION_IMAGE_CAPTURE, Uri.fromFile(file));
        mActivity.startActivityForResult(intent,PHOTO_CARMERA);
    }
    private void startPick(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        mActivity.startActivityForResult(intent,PHOTO_PICK);
    }

    public void getActivityResult(int requestCode,int resultCode,Intent data)
    {
        if (resultCode != Activity.RESULT_OK)
        return;
        if (Environment.MEDIA_UNKNOWN.equals(Environment.getExternalStorageState()))
        {
            ToastManager.getManager().show("SD卡不可用");
            return;
        }
        switch(requestCode)
        {
            case PHOTO_CARMERA:
                setCarmeraToView();
                break;
            case PHOTO_PICK:
                if (null == data)
                    return;
                setPicToView(data.getData());
                break;
        }
    }

    private void setPicToView(Uri data) {
       Uri uri = data;
        Cursor c = mActivity.getContentResolver().query(uri, null, null, null, null);
        if (c.moveToNext())
        {
            String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
            file = new File(path);
            Bitmap bp = getBitmap();
            saveMyBitmap(bp);//保存图片
            if (null !=  mGetPhotoResultListener)
                mGetPhotoResultListener.onPotoResult(bp);
        }
    }

    private void setCarmeraToView() {
        Bitmap bitmap = getBitmap();
        if (null != mGetPhotoResultListener){
            mGetPhotoResultListener.onPotoResult(bitmap);
        }

    }

    private Bitmap getBitmap() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), options);
        int widthRadio = (int)Math.ceil(options.outWidth/width);
        int heightRadio = (int) Math.ceil(options.outHeight/height);

        if (widthRadio >1 || heightRadio > 1)    //如果大于1，进行压缩
        {
            if (widthRadio >= heightRadio)
            {
                options.inSampleSize = widthRadio;
            }else{
                options.inSampleSize = heightRadio;
            }
        }
        options.inJustDecodeBounds = false;//设置为真正的解码图片
        bitmap = BitmapFactory.decodeFile(file.getPath(),options);
        return bitmap;
    }

    public void saveMyBitmap(Bitmap bp)
    {
       file = new File(Environment.getExternalStorageDirectory(),picname);
        FileOutputStream fOut = null;
        try{
            fOut = new FileOutputStream(file);
            bp.compress(Bitmap.CompressFormat.JPEG,100,fOut);
            fOut.flush();
            fOut.close();
            XgoLog.e("name=" + file.getName() + "\n\n path" + file.getPath());
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public interface GetPhotoResultListener{
        void onPotoResult(Bitmap ib);
    }

}
