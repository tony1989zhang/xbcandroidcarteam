package www.lvchehui.com.carteam.module.crecarteam.activities;

import org.xutils.DbManager;

import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.app.App;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用：上传用户身份证
 */
public class UpdPeopleIDcardActivity extends UploadIdPtAct {

    @Override
    protected void initView() {
        super.initView();
        //获取数据库进行查询操作。
        initTextView("身份证","大家好","瞎扯淡","");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();

        String idNumContent = getIdNumContent();
        String url = getUrl();
        DbManager dbManager = App.getInstance().getDbManager();
        //获取到数据库管理器，进行查询保存数据库操作。
        showToast("url:" + url + "idNum:" + idNumContent);
    }
}
