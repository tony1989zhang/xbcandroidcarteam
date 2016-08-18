package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.module.HomeAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队入住的信息
 */
@ContentView(R.layout.act_crecar_team)
public class CreCarTeamAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.rl_responInfo)
    private RelativeLayout m_rl_responInfo;

    @ViewInject(R.id.tv_responInfo)
    private TextView m_tv_responInfo;

    @ViewInject(R.id.iv_responInfo)
    private ImageView m_iv_responInfo;

    @ViewInject(R.id.rl_carTeamInfo)
    private RelativeLayout m_rl_carTeamInfo;

    @ViewInject(R.id.tv_carTeamInfo)
    private TextView m_tv_carTeamInfo;

    @ViewInject(R.id.iv_photo)
    private ImageView m_iv_photo;

    @ViewInject(R.id.rl_vehicleInfo)
    private RelativeLayout m_rl_vehicleInfo;

    @ViewInject(R.id.tv_vehicleInfo)
    private TextView m_tv_vehicleInfo;

    @ViewInject(R.id.iv_application)
    private ImageView m_iv_application;

    @ViewInject(R.id.rl_driverInfo)
    private RelativeLayout m_rl_driverInfo;

    @ViewInject(R.id.tv_driverInfo)
    private TextView m_tv_driverInfo;

    @ViewInject(R.id.iv_driverInfo)
    private ImageView m_iv_driverInfo;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "填写入驻信息");
        String lastAct = getIntent().getStringExtra(LAST_ACTIVITY_NAME);
        if (HomeAct.class.getName().equals(lastAct))
        {

        }
    }

    @Event({R.id.rl_responInfo, R.id.rl_carTeamInfo, R.id.rl_vehicleInfo, R.id.rl_driverInfo, R.id.tv_submit_ok})
    private void onCreCarTeamOnClick(View v) {
        Class t = null;
        switch (v.getId()) {
            case R.id.rl_responInfo:
                showToast("负责人信息填写");
                t = ResponInfoAct.class;
                break;
            case R.id.rl_carTeamInfo:
                showToast("车队信息填写");
                t = CarTeamListAct.class;
                break;
            case R.id.rl_vehicleInfo:
                showToast("车辆信息填写");
                t = VehicleListAct.class;
//                t = VehicleInfoAct.class;
                break;
            case R.id.rl_driverInfo:
                showToast("司机信息填写");
                t = DriverInfoAct.class;
                break;
            case R.id.tv_submit_ok:
                showToast("提交服务端");
                break;
        }
        if (null != t) {
            Intent intent = new Intent();
            intent.setClass(this, t);
            startActivity(intent);
        }
    }
}
