package www.lvchehui.com.carteam.http;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import www.lvchehui.com.carteam.R;

import static www.lvchehui.com.carteam.R.*;

/**
 * 作者：V先生 on 2016/8/1 14:40
 * 作用：
 */
public class ConnectionUtil {
    private Drawable drawableResult;
    private ImageOptions imageOptions;
    private ConnectionUtil(){

    }

    private static ConnectionUtil connectionUtil;

    public static final ConnectionUtil getInstance() {
        if (connectionUtil == null)
        {
            connectionUtil = new ConnectionUtil();
        }
        return  connectionUtil;
    }
    private void initImageOptions(){
        if (null == imageOptions)
        {
            imageOptions = new ImageOptions.Builder().setSize(DensityUtil.dip2px(120),DensityUtil.dip2px(120))
                    .setRadius(DensityUtil.dip2px(5)).setCrop(true)
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP).setLoadingDrawableId(mipmap.ic_launcher)
                    .setFailureDrawableId(mipmap.ic_launcher).build();
        }
    }

    public Drawable loadImage(ImageView iv, String picUrl){
        initImageOptions();
        x.image().bind(iv,picUrl,imageOptions,new Callback.CommonCallback<Drawable>(){
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
        return  drawableResult;
    }
}
