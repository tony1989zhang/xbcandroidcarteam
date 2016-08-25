package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import www.lvchehui.com.carteam.bean.FastLoginBean;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.SendSmsBean;
import www.lvchehui.com.carteam.bean.UserGetTypeBean;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.http.ComCb;
import www.lvchehui.com.carteam.module.HomeAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CreCarTeamAct;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.SPUtil;
import www.lvchehui.com.carteam.tools.StringUtils;
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
public class LoginAct extends BaseAct{
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
                if (StringUtils.isEmpty(m_account_et.getText().toString())){
                    showToast("用户名不能为空");
                    return;
                }

                CM.getInstance().sendSMS(m_account_et.getText().toString(), new ComCb<SendSmsBean>(){
                    @Override
                    public void onSuccess(SendSmsBean result) {
                        showToast(result.resMsg);
                        if (result.errCode != -1)
                        {
                            m_btn_captcha.startCountdown();
                        }
                    }
                });
                break;
            case R.id.login_tv:
                if (StringUtils.isEmpty(m_account_et.getText().toString()))
                {
                    showToast("用户名不能为空");
                    return;
                }
                if (StringUtils.isEmpty(m_captcha_et.getText().toString()))
                {
                    showToast("验证码不能为空");
                    return;
                }
                showProgressDialog();
                CM.getInstance().fastLogin(m_account_et.getText().toString(), m_captcha_et.getText().toString(),new FastLoginComCb());
                break;
            case R.id.register_tv:
                startActivity(new Intent(this, RegisterAct.class));
                break;
        }
    }

    class FastLoginComCb extends ComCb<FastLoginBean>{

        @Override
        public void onSuccess(FastLoginBean result) {

            showToast(result.resMsg);
            if (result.errCode != -1)
            {
                showProgressDialog("获取当前用户类型");
                //判断用户类型
                CM.getInstance().usersGetType(result.resData.gid, "" + Constants.CLIENT_TYPE,new GetTypeComCb());
                SPUtil.getInstant(LoginAct.this).save(Constants.USER_GID, result.resData.gid);
                SPUtil.getInstant(LoginAct.this).save(Constants.USER_NAME,result.resData.username);
            }
        }


        @Override
        public void onFinished() {
            super.onFinished();
            dismissProgressDialog();
        }
    }


    class GetTypeComCb extends ComCb<UserGetTypeBean>{
        @Override
        public void onSuccess(UserGetTypeBean result) {

            if (result.errCode != -1)
            {

                if (result.resData == Constants.CLIENT_TYPE_OTHER) {
                    showToast("result:" + result.resData);
                    startActivity(new Intent(LoginAct.this,CreCarTeamAct.class));
                }
                switch (result.resData){
                    case Constants.CLIENT_TYPE_PASSENGER:
                        break;
                    case Constants.CLIENT_TYPE_DRIVER:
                        break;
                    case Constants.CLIENT_TYPE_RESPONSIBLE:
                        startActivity(new Intent(LoginAct.this,HomeAct.class));
                        break;
                    case Constants.CLIENT_TYPE_OTHER:
                        startActivity(new Intent(LoginAct.this,CreCarTeamAct.class));
                        break;
                }
            }
        }
        @Override
        public void onFinished() {
            super.onFinished();
            dismissProgressDialog();
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        m_btn_captcha.cancelCountdown();
    }
}
