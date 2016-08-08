package www.lvchehui.com.carteam.module.crecarteam.activities;

import org.xutils.DbManager;

import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.tools.StringUtils;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用：上传用户身份证
 */
public class UpdPeopleIDcardActivity extends UploadIdPtAct {

    @Override
    protected void initView() {
        super.initView();
        XgoLog.e("initView:");
        //获取数据库进行查询操作。
        initTextView("申请人信息", "身份证", "大家好", "瞎扯淡", "");
    }
}
