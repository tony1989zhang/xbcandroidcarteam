package www.lvchehui.com.carteam.module.manager;

import android.content.Intent;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
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
        Intent intent = new Intent(this, PermissionListAct.class);
        switch (v.getId())
        {
            case R.id.rl_quote:
                showToast("点击效果");

                intent.putExtra(PermissionListAct.PERMISSSION_NAME, PermissionListAct.PerMissType);

                break;
            case R.id.rl_scar_missauga:
                intent.putExtra(PermissionListAct.PERMISSSION_NAME, PermissionListAct.PerMissType2);
                break;
            case R.id.rl_replace_driver:
                intent.putExtra(PermissionListAct.PERMISSSION_NAME, PermissionListAct.PerMissType3);
                break;
            case R.id.rl_replace_vehicle:
                intent.putExtra(PermissionListAct.PERMISSSION_NAME, PermissionListAct.PerMissType4);
                break;
        }
        startActivity(intent);
    }
}
