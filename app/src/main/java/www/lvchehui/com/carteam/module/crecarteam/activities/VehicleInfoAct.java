package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseFormAct;
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
    }

    @Event({R.id.et_team_name,R.id.et_registration_first,R.id.et_passanger_premium,R.id.et_drive_licence_photo,
            R.id.et_road_permit_photo,R.id.et_car_photos_inner_photo,R.id.et_car_photos_outside_photo
    })
    public void vehicleOnClick(View v){
        switch (v.getId())
        {
            case R.id.et_team_name:
                startActivity(new Intent(this,CarTeamListAct.class));
                break;
            case  R.id.et_registration_first:
                break;
            case R.id.et_passanger_premium:
                break;
            case R.id.et_drive_licence_photo:
                break;
            case  R.id.et_road_permit_photo:
                break;
            case R.id.et_car_photos_inner_photo:
                break;
            case R.id.et_car_photos_outside_photo:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
