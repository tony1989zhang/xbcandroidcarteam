package www.lvchehui.com.carteam.app;
import android.app.Activity;
import android.app.Application;

import com.google.gson.Gson;

import org.xutils.BuildConfig;
import org.xutils.DbManager;
import org.xutils.x;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.toast.ToastManager;
/**
 * 作者：V先生 on 2016/7/29 20:06
 * 作用：软件入口
 */
public class App extends Application {
    private static App mApp;
    public List<WeakReference<Activity>> aliveActivitys = new ArrayList<>();
    private  DbManager.DaoConfig daoConfig;
    public DbManager.DaoConfig getDaoConfig(){
        if (null == daoConfig){
            initDb();
        }
        return  daoConfig;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);//是否输出debug日记，开启会影响性能
        initDb();
    }
    public static App getInstance(){
        if (mApp == null)
        {
            mApp = new App();
        }
        return mApp;
    }
    public void initDb(){
        new DbManager.DaoConfig().setDbName("xbc_cart_team_db").setDbVersion(1).setDbUpgradeListener(new DbManager.DbUpgradeListener() {
            @Override
            public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    XgoLog.e("数据库更新" + newVersion);
            }
        });//数据库更新操作
    }
    public <T>T getBeanFromJson(String ret,Class<T> c){
        T bean = null;
        try {
            bean = new Gson().fromJson(ret, c);
        }catch(Exception e)
        {
            ToastManager.getManager().show("Gson解析错误:" + e.toString());
            XgoLog.e("Gson解析错误");
        }
        return bean;
    }

    public void finishAllActivity(){
        for (int i = 0;i < aliveActivitys.size();i++)
        {
            if (aliveActivitys.get(i) != null)
            {
                aliveActivitys.get(i).get().finish();
            }
        }
    }
    public Activity getTopActivity(){
        return aliveActivitys.get(aliveActivitys.size() - 1).get();
    }
}
