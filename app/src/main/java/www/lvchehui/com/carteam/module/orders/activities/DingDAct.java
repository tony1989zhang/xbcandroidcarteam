package www.lvchehui.com.carteam.module.orders.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.WebAct;
import www.lvchehui.com.carteam.module.myquote.MyQuoteAct;

/**
 * Created by 张灿能 on 2016/8/19.
 * 作用：我的订单
 */
@ContentView(R.layout.act_dingd)
public class DingDAct extends WebAct {

    @ViewInject(R.id.tv_submit_ok)
    private TextView m_tv_submit_ok;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_tv_submit_ok.setText("立即报价");
    }

    @Event(R.id.tv_submit_ok)
    private void submitOk(View v)
    {
        //我要报价
        startActivity(new Intent(this,MyQuoteAct.class));
    }
}
