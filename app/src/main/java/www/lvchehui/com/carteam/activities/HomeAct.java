package www.lvchehui.com.carteam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.dlg.CWayDlg;

@ContentView(R.layout.activity_home)
public class HomeAct extends BaseAct{
    @ViewInject(R.id.fullscreen_content)
    private TextView m_fullscreen_content;
    @ViewInject(R.id.iv)
    private ImageView m_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event( R.id.btn_ok)
    private void onHomeActOnClick(View v){
        new CWayDlg(this).show();
//        CM.getInstance().login("", "", new ComCb<LoginBean>() {
//            @Override
//            public void onSuccess(LoginBean result) {
//                m_fullscreen_content.setText("result:" + result.toString());
//            }
//            @Override
//            public void onFinished() {
//                super.onFinished();
//            }
//        });
    }

}
