package www.lvchehui.com.carteam.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.bean.SendSmsBean;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.http.ComCb;
import www.lvchehui.com.carteam.tools.StringUtils;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.btn.CaptchaButton;
import www.lvchehui.com.carteam.view.et.ClearEt;

/**
 * Created by 张灿能 on 2016/8/4.
 * 作用：注册时Act
 */
@ContentView(R.layout.act_register)
public class RegisterAct extends BaseAct {
    @ViewInject(R.id.account_et)
    private ClearEt m_account_et;

    @ViewInject(R.id.captcha_et)
    private EditText m_captcha_et;

    @ViewInject(R.id.btn_captcha)
    private CaptchaButton m_btn_captcha; //验证码;

    @ViewInject(R.id.register_tv)
    private TextView m_register_tv; //注册;

    @ViewInject(R.id.retset_pw)
    private TextView m_retset_pw; //@string/agree_msg;

    @Override
    protected void initView() {
        super.initView();
    }




    @Event(R.id.btn_captcha)
    private void sendCaptCha(View v){
        if (StringUtils.isEmpty(m_account_et.getText())){
            showToast("账号不能为空");
            return;
        }
          m_btn_captcha.startCountdown();

        CM.getInstance().sendSMS(m_account_et.getText().toString(),new ComCb<SendSmsBean>(){

            @Override
            public void onSuccess(SendSmsBean result) {
                XgoLog.e("result:"  + result.toString());
                showToast("result:" + result.toString());
            }
        });
    }
    @Event(R.id.register_tv)
    private void onRegisterOnClick(View v){

    }
}
