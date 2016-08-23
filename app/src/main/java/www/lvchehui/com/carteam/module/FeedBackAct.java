package www.lvchehui.com.carteam.module;

import android.widget.EditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：首页用户反馈
 */
@ContentView(R.layout.act_feedback)
public class FeedBackAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_des)
    private EditText m_et_des;
    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "反馈建议");
        m_tv_submit_ok.setText("提交");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        finish();
    }
}
