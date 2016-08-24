package www.lvchehui.com.carteam.module.wallet.activityes;

import android.os.Bundle;
import android.widget.TextView;


import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/7/16.
 * 作用：填写发送短信验证信息
 */
@ContentView(R.layout.act_enter_sms)
public class EnterSmsAct extends BaseAct {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleV(m_title_view,"填写验证码");
        m_tv_submit_ok.setText("验证");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
    }
}
