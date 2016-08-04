package www.lvchehui.com.carteam.activities;

import android.os.Bundle;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * 作者：V先生 on 2016/8/4 09:43
 * 作用：登录
 */
@ContentView(R.layout.act_login)
public class LoginAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleV(m_title_view,"登录");
    }

}
