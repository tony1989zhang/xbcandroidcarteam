package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.evebus.UploadIdPtEvent;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车辆信息
 */
@ContentView(R.layout.act_vehicleinfo)
public class VehicleInfoAct extends BaseFormAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_team_name)
    private EditText m_et_team_name;
    @ViewInject(R.id.et_car_num)
    private EditText m_et_car_num;
    @ViewInject(R.id.et_vehicle_model)
    private EditText m_et_vehicle_model;
    @ViewInject(R.id.et_seat_number_just)
    private EditText m_et_seat_number_just;
    @ViewInject(R.id.et_seat_number_sum_as)
    private EditText m_et_seat_number_sum_as;
    @ViewInject(R.id.et_vehicle_color)
    private EditText m_et_vehicle_color;
    @ViewInject(R.id.et_area)
    private EditText m_et_area;
    @ViewInject(R.id.et_registration_first)
    private EditText m_et_registration_first;
    @ViewInject(R.id.tv_passanger_premium)
    private TextView m_tv_passanger_premium; //乘客险＊;
    @ViewInject(R.id.et_passanger_premium)
    private EditText m_et_passanger_premium;
    @ViewInject(R.id.tv_drive_licence_photo)
    private TextView m_tv_drive_licence_photo; //行驶证＊;
    @ViewInject(R.id.et_drive_licence_photo)
    private EditText m_et_drive_licence_photo;
    @ViewInject(R.id.tv_road_transport_photo)
    private TextView m_tv_road_transport_photo; //道路运输证＊;
    @ViewInject(R.id.et_road_permit_photo)
    private EditText m_et_road_permit_photo;
    @ViewInject(R.id.tv_car_photos_inner_photo)
    private TextView m_tv_car_photos_inner_photo; //车辆内景＊;
    @ViewInject(R.id.et_car_photos_inner_photo)
    private EditText m_et_car_photos_inner_photo;
    @ViewInject(R.id.tv_car_photos_outside_photo)
    private TextView m_tv_car_photos_outside_photo; //车辆外景＊;
    @ViewInject(R.id.et_car_photos_outside_photo)
    private EditText m_et_car_photos_outside_photo;
    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
        setTitleV(m_title_view, "车辆信息");
        m_tv_submit_ok.setText("保存");
    }

    @Event({R.id.et_team_name,R.id.et_registration_first,R.id.et_passanger_premium,R.id.et_drive_licence_photo,
            R.id.et_road_permit_photo,R.id.et_car_photos_inner_photo,R.id.et_car_photos_outside_photo
    })
    private void vehicleOnClick(View v){
        showToast("测试");
        switch (v.getId())
        {

            case R.id.et_team_name:
                startActivity(new Intent(this, CarTeamListAct.class));
                break;
            case  R.id.et_registration_first:
                m_et_registration_first.setText("2016-01-01");
                break;
            case R.id.et_passanger_premium:
                startActivity(new Intent(this,UpdPgersPremPtAct.class));
                break;
            case R.id.et_drive_licence_photo:
                startActivity(new Intent(this,UpdDriveLicencePtAct.class));
                break;
            case  R.id.et_road_permit_photo:
                startActivity(new Intent(this,UpdRoadTranPtAct.class));
                break;
            case R.id.et_car_photos_inner_photo:
                startActivity(new Intent(this,UpdCarInPtAct.class));
                break;
            case R.id.et_car_photos_outside_photo:
                startActivity(new Intent(this,UpdCarOutPtAct.class));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(TextBean textBean){
        if (null != textBean){
            m_et_team_name.setText(textBean.a);
            EventBus.getDefault().removeStickyEvent(textBean);
            App.getInstance().getTopActivity().finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveUploadIdEvent(UploadIdPtEvent event){
        if (null != event){
            if (event.getUpLoadType().equals(UpdPgersPremPtAct.class.getSimpleName()))
            m_et_passanger_premium.setText("已完成");
            if (event.getUpLoadType().equals(UpdPgersPremPtAct.class.getSimpleName()))
                m_et_drive_licence_photo.setText("已完成");
            EventBus.getDefault().removeStickyEvent(event);
            App.getInstance().getTopActivity().finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
