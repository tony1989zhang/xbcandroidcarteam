package www.lvchehui.com.carteam.module.wallet.activityes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.jungly.gridpasswordview.GridPasswordView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/7/15.
 * 作用：设置支付密码
 */
@ContentView(R.layout.act_set_pay_password)
public class SetPayPassWordAct extends BaseAct implements  GridPasswordView.OnPasswordChangedListener{

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.gv_pay_password)
    private GridPasswordView m_gv_pay_password;
    @ViewInject(R.id.tv_title)
    private TextView m_tv_title;
    @ViewInject(R.id.tv_title_smail)
    private TextView m_tv_title_smail; 
    private boolean isFirst = true;
    private String firstPwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleV(m_title_view, "闪电提现");
        m_tv_title.setText("请输入提现密码");
        m_gv_pay_password.setOnPasswordChangedListener(this);
    }

    @Override
    public void onTextChanged(String psw) {
    }

    @Override
    public void onInputFinish(String psw) {
        if (isFirst){
            m_gv_pay_password.clearPassword();
            isFirst = false;
            firstPwd = psw;
            m_tv_title.setText("请再次输入一次密码");
        }else if(!isFirst){
            if (psw.equals(firstPwd)){
                showToast("设置密码成功");
                //上传服务端设置密码
                startActivity(new Intent(this,PayAccountAct.class));
            }else{
                showToast("密码错误");
                m_gv_pay_password.clearPassword();
                isFirst = true;
            }
        }
    }
}
