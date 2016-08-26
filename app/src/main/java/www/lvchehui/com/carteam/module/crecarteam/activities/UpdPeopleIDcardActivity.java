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
        initTextView("上传身份证", "身份证", "从业资格证",
                "身份证各项信息及头像均清晰可见，持证人需免冠，面部无遮拦，无关清洗可见，须露出手肘。",
                "http://img2.imgtn.bdimg.com/it/u=1173121091,4029038941&fm=21&gp=0.jpg");
    }

}
