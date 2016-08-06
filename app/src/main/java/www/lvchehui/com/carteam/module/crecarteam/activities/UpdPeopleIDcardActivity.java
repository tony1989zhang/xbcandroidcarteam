package www.lvchehui.com.carteam.module.crecarteam.activities;

import org.xutils.DbManager;

import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.app.App;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用：
 */
public class UpdPeopleIDcardActivity extends UploadIdPtAct {

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        String url = getUrl();
        DbManager dbManager = App.getInstance().getDbManager();
        //获取到数据库管理器，进行查询保存数据库操作。
    }
}
