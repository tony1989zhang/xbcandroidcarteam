package www.lvchehui.com.carteam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
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
        setTitleV(m_title_view,"填写入驻信息");
    }
    @Event({R.id.rl_responInfo,R.id.rl_carTeamInfo,R.id.rl_vehicleInfo,R.id.rl_driverInfo,R.id.tv_ok})
    private void onCreCarTeamOnClick(View v){
        switch (v.getId())
        {
            case R.id.rl_responInfo:
                showToast("负责人信息填写");
                break;
            case R.id.rl_carTeamInfo:
                showToast("车队信息填写");
                break;
            case R.id.rl_vehicleInfo:
                showToast("车辆信息填写");
                break;
            case R.id.rl_driverInfo:
                showToast("司机信息填写");
                break;
            case R.id.tv_ok:
                showToast("提交服务端");
                break;
        }
    }
}
