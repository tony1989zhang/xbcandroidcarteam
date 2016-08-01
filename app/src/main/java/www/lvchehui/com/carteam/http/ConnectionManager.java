package www.lvchehui.com.carteam.http;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import www.lvchehui.com.carteam.R;

/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求。
 */
public class ConnectionManager {
    private static final String SERVER_URL = "192.168.1.66/api.php/main/";
    private static final String USERS_LOGIN = "Users/login";
    private static ConnectionManager mConnectionManager;
    private Drawable drawableResult;
    private ImageOptions imageOptions;

    private ConnectionManager() {
    }

    public static final ConnectionManager getInstance() {
        if (mConnectionManager == null) {
            mConnectionManager = new ConnectionManager();
        }
        return mConnectionManager;
    }

    public void login(ComCb comCb) {
        RequestParams requestParams = new RequestParams(getUrl(USERS_LOGIN));
        requestParams.addBodyParameter("username", "15859254561");
        requestParams.addBodyParameter("password", "E10ADC3949BA59ABBE56E057F20F883E");
        x.http().post(requestParams, comCb);
    }

    public Drawable loadImage(ImageView iv, String picUrl) {
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

    public String getUrl(String path) {
        return "http://" + SERVER_URL + path;
    }

    private void initImageOptions() {
        if (null == imageOptions) {
            imageOptions = new ImageOptions.Builder().setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                    .setRadius(DensityUtil.dip2px(5)).setCrop(true)
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP).setLoadingDrawableId(R.mipmap.ic_launcher)
                    .setFailureDrawableId(R.mipmap.ic_launcher).build();
        }
    }
}
