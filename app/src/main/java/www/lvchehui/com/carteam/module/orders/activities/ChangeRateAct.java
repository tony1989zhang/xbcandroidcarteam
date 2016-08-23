package www.lvchehui.com.carteam.module.orders.activities;

import android.widget.EditText;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.Subscribe;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：费用变更
 */
@ContentView(R.layout.act_change_rate)
public class ChangeRateAct extends BaseFormAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_note)
    private EditText m_et_note;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "费用变更");
        m_tv_submit_ok.setText("确定");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        finish();
    }
}
