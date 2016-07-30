package www.lvchehui.com.carteam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.http.ComCb;
import www.lvchehui.com.carteam.http.ConnectionManager;

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
        ConnectionManager.getInstance().login(new ComCb() {
            @Override
            public void onSuccess(String result) {
                m_fullscreen_content.setText("result:" + result);
            }
        });
    }
    //测试更改
    //测试一下
}
