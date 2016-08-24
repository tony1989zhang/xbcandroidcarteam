package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.module.HomeAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CreCarTeamAct;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.btn.CaptchaButton;
import www.lvchehui.com.carteam.view.et.ClearEt;
import www.lvchehui.com.carteam.view.wheelview.ChangeAddressPopWin;
import www.lvchehui.com.carteam.view.wheelview.ChangeDatePickPopWin;

/**
 * 作者：V先生 on 2016/8/4 09:43
 * 作用：登录
 */
@ContentView(R.layout.act_login)
public class LoginAct extends BaseAct implements Callback.CommonCallback<LoginBean> {
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

    @Event(value = {R.id.btn_captcha, R.id.login_tv, R.id.register_tv})
    private void loginOnClick(View v) {

        switch (v.getId()) {
            case R.id.btn_captcha:
                m_btn_captcha.startCountdown();
                CM.getInstance().login("", "", this);
                break;
            case R.id.login_tv:
                showToast("登录注册同一个页面");
                startActivity(new Intent(this, HomeAct.class));
                break;
            case R.id.register_tv:

//                startActivity(new Intent(this, CreCarTeamAct.class));
                startActivity(new Intent(this,RegisterAct.class));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        m_btn_captcha.cancelCountdown();
    }


    @Override
    public void onSuccess(LoginBean result) {
        XgoLog.e(result.toString());
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
