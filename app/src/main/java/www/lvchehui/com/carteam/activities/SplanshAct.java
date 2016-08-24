package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
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
        initLoadImage();
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


        DisplayImageOptions options = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.splansh).showImageOnFail(R.mipmap.icon_img_null_bg)
                .cacheInMemory(true).cacheOnDisc(true).considerExifParams(false).build();
        ImageLoader.getInstance().displayImage("http://7xlh8k.com1.z0.glb.clouddn.com/%E8%BD%A6%E9%98%9F%EF%BC%8D%E5%B9%BF%E5%91%8A.png", m_imageView2, options);
        ImageLoader.getInstance().displayImage("http://7xlh8k.com1.z0.glb.clouddn.com/%E8%BD%A6%E9%98%9F%EF%BC%8D%E5%B9%BF%E5%91%8A.png", m_imageView2, options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                // TODO Auto-generated method stub
                super.onLoadingComplete(imageUri, view, loadedImage);
                m_imageView2.setImageBitmap(loadedImage);
                m_imageView2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://img4.imgtn.bdimg.com/it/u=250883362,3555496764&fm=11&gp=0.jpg"));
                        SplanshAct.this.startActivity(intent);
                    }
                });

            }
        });


    }

    /**
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author 张灿能
     * @date Oct 26, 2015 12:15:55 PM .bitmapConfig(Bitmap.Config.RGB_565)
     */
    private void initLoadImage() {
        DisplayImageOptions options = new DisplayImageOptions.Builder() // 设置图片下载期间显示的图�?
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED).cacheInMemory(true) // 设置下载的图片是否缓存在内存�?
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .resetViewBeforeLoading(true)
                        // .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图�?
                .build(); // 创建配置过得DisplayImageOption对象

        // 创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800).threadPoolSize(3)// 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You
                        // can
                        // pass
                        // your
                        // own
                        // memory
                        // cache
                        // implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                        // 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO).discCacheFileCount(100) // 缓存的文件数量
                .defaultDisplayImageOptions(options)
                .imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 * 1000)) // connectTimeout
                        // (5
                        // s),
                        // readTimeout
                        // (30
                        // s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();// 开始构建

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);

    }
}
