package www.lvchehui.com.carteam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.http.ComCb;

@ContentView(R.layout.activity_home)
public class HomeAct extends BaseAct{
    @ViewInject(R.id.fullscreen_content)
    private TextView m_fullscreen_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Event( R.id.btn_ok)
    private void onHomeActOnClick(View v){
        CM.getInstance().login("", "", new ComCb<LoginBean>() {
            @Override
            public void onSuccess(LoginBean result) {
                m_fullscreen_content.setText("result:" + result.toString());
            }
            @Override
            public void onFinished() {
                super.onFinished();
            }
        });
    }
}
