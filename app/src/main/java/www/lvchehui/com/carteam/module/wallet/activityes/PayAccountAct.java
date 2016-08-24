package www.lvchehui.com.carteam.module.wallet.activityes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.et.ClearEt;

/**
 * Created by 张灿能 on 2016/7/16.
 * 作用：付款账号
 */
@ContentView(R.layout.act_pay_account)
public class PayAccountAct extends BaseAct {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.tv_pay_type)
    private TextView m_tv_pay_type;
    @ViewInject(R.id.account_et)
    private ClearEt m_account_et;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleV(m_title_view,"绑定到账户");
        m_tv_submit_ok.setText("提交");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        startActivity(new Intent(this, EnterSmsAct.class));
    }

}
