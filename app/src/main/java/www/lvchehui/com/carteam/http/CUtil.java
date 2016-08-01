package www.lvchehui.com.carteam.http;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.Map;
import java.util.Objects;

import www.lvchehui.com.carteam.R;

/**
 * 作者：V先生 on 2016/8/1 16:05
 * 作用：网络请求工具类
 */
public class CUtil {
    private static final String SERVER_URL = "192.168.1.66/api.php/main/";
    private static CM mCM;
    private static Drawable drawableResult;
    private static ImageOptions imageOptions;

    //get方法
    public static<T>Callback.Cancelable Get(String path, Map<String,String> map, Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,String> entry:map.entrySet()){
                params.addQueryStringParameter(entry.getKey(),entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable Post(String path, Map<String,Object> map, Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,Object> entry:map.entrySet())
            {
               params.addParameter(entry.getKey(),entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable UpLoadFile(String path,Map<String,Object> map,Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,Object> entry:map.entrySet())
            {
                params.addParameter(entry.getKey(),entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable DownLoadFile(String url, String filePath, Callback.CommonCallback<T> callback)
    {
        RequestParams params = new RequestParams(getUrl(url));
        params.setAutoRename(true);
        params.setSaveFilePath(filePath);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    private static String getUrl(String path) {
        return "http://" + SERVER_URL + path;
    }

    public static Drawable loadImage(ImageView iv, String picUrl) {
        initImageOptions();
        x.image().bind(iv, picUrl, imageOptions, new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                drawableResult = result;
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                drawableResult = x.app().getResources().getDrawable(R.mipmap.ic_launcher);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                drawableResult = x.app().getResources().getDrawable(R.mipmap.ic_launcher);
            }

            @Override
            public void onFinished() {
                drawableResult = x.app().getResources().getDrawable(R.mipmap.ic_launcher);
            }
        });
        return drawableResult;
    }


    private static void initImageOptions() {
        if (null == imageOptions) {
            imageOptions = new ImageOptions.Builder().setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                    .setRadius(DensityUtil.dip2px(5)).setCrop(true)
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP).setLoadingDrawableId(R.mipmap.ic_launcher)
                    .setFailureDrawableId(R.mipmap.ic_launcher).build();
        }
    }
}
