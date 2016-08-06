package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CreCarTeamAct;
import www.lvchehui.com.carteam.view.btn.CaptchaButton;
import www.lvchehui.com.carteam.view.et.ClearEt;

/**
 * 作者：V先生 on 2016/8/4 09:43
 * 作用：登录
 */
@ContentView(R.layout.act_login)
public class LoginAct extends BaseAct {
    @ViewInject(R.id.account_et)
    private ClearEt m_account_et;
    @ViewInject(R.id.captcha_et)
    private EditText m_captcha_et;
    @ViewInject(R.id.btn_captcha)
    private CaptchaButton m_btn_captcha;
    @ViewInject(R.id.login_tv)
    private TextView m_login_tv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(value = {R.id.btn_captcha,R.id.login_tv})
    private void loginOnClick(View v){

        switch (v.getId())
        {
            case R.id.btn_captcha:
                m_btn_captcha.startCountdown();
                break;
            case R.id.login_tv:
                showToast("登录注册同一个页面");
                startActivity(new Intent(this,CreCarTeamAct.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        m_btn_captcha.cancelCountdown();
    }
}
