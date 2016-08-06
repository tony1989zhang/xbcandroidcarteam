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
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import www.lvchehui.com.carteam.view.toast.ToastManager;

/**
 * 作者：V先生 on 2016/8/2 10:13
 * 作用：
 */
public class PhotoUtils {
    private GetPhotoResultListener mGetPhotoResultListener;
    private static PhotoUtils photoUtils;
    private static final int PHOTO_CARMERA = 1;
    private static final int PHOTO_PICK = 2;
    private String picname;
    private Activity mActivity;
    private int width;
    private int height;

    private File file;
    private PhotoUtils(Activity acy, GetPhotoResultListener getPRListener)
    {
        mActivity = acy;
        mGetPhotoResultListener = getPRListener;
        picname = "IMG_" + System.currentTimeMillis() / 1000 + ".png";
        file = new File(Environment.getExternalStorageDirectory(), picname);
        Display display = acy.getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }
    public static PhotoUtils getInstance(Activity acy, GetPhotoResultListener getPhotoResultListener){
        if (null == photoUtils)
        {
            photoUtils = new PhotoUtils(acy,getPhotoResultListener);
        }
        return photoUtils;
    }
    public void showDialog()
    {
        //  //拍照
        startCamera();
      //相册获取
//        startPick();
    }
    private void startCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.ACTION_IMAGE_CAPTURE, Uri.fromFile(file));
        mActivity.startActivityForResult(intent,PHOTO_CARMERA);
    }
    private void startPick(){
        Intent intent = new Intent(Intent.ACTION_PICK,null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        mActivity.startActivityForResult(intent,PHOTO_PICK);
    }
    public void getActivityResult(int requestCode,int resultCode,Intent data)
    {
        if (resultCode != Activity.RESULT_OK)
        return;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_UNKNOWN))
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
            //传递给activity
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
    public interface GetPhotoResultListener{
        void onPotoResult(Bitmap ib);
    }
    // 将剪切后的图片保存到本地图片上！
    public String saveBitmap(Bitmap bitmap) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMddHHmmss");
        String cutnameString = dateFormat.format(date);
        String filename = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera" + "/" + cutnameString + ".jpg";
        File f = new File(filename);
        FileOutputStream fOut = null;
        try {
            f.createNewFile();
            fOut = new FileOutputStream(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);// 把Bitmap对象解析成流
        try {
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
    public interface PhotoResultIml{
        void OnPotoResult(Bitmap ib);
    }
}
