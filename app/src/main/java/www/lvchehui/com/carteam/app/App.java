package www.lvchehui.com.carteam.app;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 作者：V先生 on 2016/7/29 20:06
 * 作用：软件入口
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);//是否输出debug日记，开启会影响性能
    }
}
