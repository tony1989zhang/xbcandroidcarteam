package www.lvchehui.com.carteam.module.manager;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.PermissionListAct;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：权限管理
 */
@ContentView(R.layout.act_manager)
public class ManagerAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "权限管理");
        XgoLog.e("initView");
    }

    @Event({R.id.rl_quote,R.id.rl_scar_missauga,R.id.rl_replace_driver,R.id.rl_replace_vehicle})
    private void managerOnClick(View v){
        switch (v.getId())
        {
            case R.id.rl_quote:
                showToast("点击效果");
                startActivity(new Intent(this,PermissionListAct.class));
                break;
            case R.id.rl_scar_missauga:
                break;
            case R.id.rl_replace_driver:
                break;
            case R.id.rl_replace_vehicle:
                break;
        }
    }
}
