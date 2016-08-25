package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.http.ComCb;
import www.lvchehui.com.carteam.module.HomeAct;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.SPUtil;
import www.lvchehui.com.carteam.tools.StringUtils;

/**
 * Created by 张灿能 on 2016/8/24.
 * 作用：
 */
@ContentView(R.layout.act_splansh)
public class SplanshAct extends BaseAct {
    private long splanshTime = 4000;

    @ViewInject(R.id.imageView2)
    private ImageView m_imageView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.zoomin, 0);//activity 进入动画
        x.task().postDelayed(new Runnable() {
            @Override
            public void run() {

                //放广告页面，暂不存放东西
                showAdverSplan();
            }
        }, 1000);

        doJump();
    }

    private void doJump() {
        final boolean isFristStart = (boolean) SPUtil.getInstant(this).get(Constants.IS_FRIST_START_APP, false);
        x.task().postDelayed(new Runnable() {
            @Override
            public void run() {
                Class activity = null;
                if (!isFristStart) {
                    activity = WelAct.class;
                    SPUtil.getInstant(SplanshAct.this).save(Constants.IS_FRIST_START_APP, true);
                } else {
                    if (StringUtils.isEmpty(SPUtil.getInstant(SplanshAct.this).get(Constants.USER_GID, ""))) {
                        activity = LoginAct.class;
                    } else {
                        //判断是否填写完毕，填写完毕跳转主页
                        activity = HomeAct.class;
                        //如果没有填写完毕，则跳转信息填写的页面
                    }
                }
                startActivity(new Intent(SplanshAct.this, activity));
                finish();
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        }, splanshTime);
    }

    public void showAdverSplan() {


        ImageOptions options = new ImageOptions.Builder()
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.icon_img_null_bg)
                        //设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.icon_img_null_bg)
                        //设置使用缓存
                .setUseMemCache(true)
                        //设置显示圆形图片
                .setCircular(false)
                        //设置支持gif
                .setIgnoreGif(false)
                .build();
        //https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1472088194&di=db4dca288e8967cf60d7a5971703f4b1&src=http://img.zcool.cn/community/01313f56c3d5546ac7256cb094ff05.jpg
        //http://7xlh8k.com1.z0.glb.clouddn.com/%E8%BD%A6%E9%98%9F%EF%BC%8D%E5%B9%BF%E5%91%8A.png
        x.image().loadDrawable("http://7xlh8k.com1.z0.glb.clouddn.com/%E8%BD%A6%E9%98%9F%EF%BC%8D%E5%B9%BF%E5%91%8A.png", options, new ComCb<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {

                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                ViewGroup.LayoutParams layoutParams = m_imageView2.getLayoutParams();
                int height = ViewGroup.LayoutParams.WRAP_CONTENT;

                m_imageView2.setLayoutParams(layoutParams);
                m_imageView2.setMaxWidth(dm.widthPixels);
                m_imageView2.setMaxHeight((int)(dm.widthPixels*5));
                m_imageView2.setImageDrawable(result);
                m_imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://img4.imgtn.bdimg.com/it/u=250883362,3555496764&fm=11&gp=0.jpg"));
                        SplanshAct.this.startActivity(intent);
                    }
                });
            }
        });


    }
}
