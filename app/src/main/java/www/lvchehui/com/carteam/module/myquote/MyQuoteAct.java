package www.lvchehui.com.carteam.module.myquote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseFmAct;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CarTeamListAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/19.
 * 作用：我的报价
 */
@ContentView(R.layout.act_my_quote)
public class MyQuoteAct extends BaseFormAct {
    @ViewInject(R.id.title_view)
    private www.lvchehui.com.carteam.view.TitleView m_title_view;

    @ViewInject(R.id.tv_data_time)
    private TextView m_tv_data_time; //02月23日 13:23-02月23日 21:00;

    @ViewInject(R.id.tv_use_car_type)
    private TextView m_tv_use_car_type;

    @ViewInject(R.id.tv_car_type)
    private TextView m_tv_car_type; //期望车型：35座x1辆 32座x1辆 33座x1辆;

    @ViewInject(R.id.tv_people_num)
    private TextView m_tv_people_num; //90人;

    @ViewInject(R.id.ll_checkbox_sarah)
    private LinearLayout m_ll_checkbox_sarah;

    @ViewInject(R.id.checkbox_sarah)
    private CheckBox m_checkbox_sarah;

    @ViewInject(R.id.ll_checkbox_accommodation)
    private LinearLayout m_ll_checkbox_accommodation;

    @ViewInject(R.id.checkbox_accommodation)
    private CheckBox m_checkbox_accommodation;

    @ViewInject(R.id.ll_checkbox_fuel)
    private LinearLayout m_ll_checkbox_fuel;

    @ViewInject(R.id.checkbox_fuel)
    private CheckBox m_checkbox_fuel;

    @ViewInject(R.id.ll_checkbox_toll_fee)
    private LinearLayout m_ll_checkbox_toll_fee;

    @ViewInject(R.id.checkbox_toll_fee)
    private CheckBox m_checkbox_toll_fee;

    @ViewInject(R.id.ll_checkbox_parking)
    private LinearLayout m_ll_checkbox_parking;

    @ViewInject(R.id.checkbox_parking)
    private CheckBox m_checkbox_parking;

    @ViewInject(R.id.ll_checkbox_replace_car)
    private LinearLayout m_ll_checkbox_replace_car;

    @ViewInject(R.id.checkbox_replace_car)
    private CheckBox m_checkbox_replace_car;

    @ViewInject(R.id.view_add)
    private LinearLayout m_view_add;

    @ViewInject(R.id.ll_add_car)
    private LinearLayout m_ll_add_car;

    @ViewInject(R.id.et_note)
    private EditText m_et_note;

    @ViewInject(R.id.et_deadline)
    private EditText m_et_deadline;

    @ViewInject(R.id.et_deposit_odds)
    private EditText m_et_deposit_odds;

    @ViewInject(R.id.ll_checkbox_according_to_days)
    private LinearLayout m_ll_checkbox_according_to_days;

    @ViewInject(R.id.et_start_time)
    private EditText m_et_start_time;

    @ViewInject(R.id.checkbox_according_to_days)
    private CheckBox m_checkbox_according_to_days;

    @ViewInject(R.id.ll_team_offer)
    private LinearLayout m_ll_team_offer;

    @ViewInject(R.id.tv_team_offer)
    private EditText m_tv_team_offer;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"立即报价");
    }

    @Event({R.id.ll_checkbox_sarah,
            R.id.ll_checkbox_fuel,
            R.id.ll_checkbox_toll_fee,
            R.id.ll_checkbox_parking,
            R.id.ll_checkbox_accommodation,
            R.id.ll_checkbox_replace_car,
            R.id.ll_checkbox_according_to_days
    })
    private void checkOnClick(View v){
        switch (v.getId())
        {
            case R.id.ll_checkbox_sarah:
                m_checkbox_sarah.setChecked(!m_checkbox_sarah.isChecked());
                break;
            case R.id.ll_checkbox_fuel:
                m_checkbox_fuel.setChecked(!m_checkbox_fuel.isChecked());
                break;
            case R.id.ll_checkbox_toll_fee:
                m_checkbox_toll_fee.setChecked(!m_checkbox_toll_fee.isChecked());
                break;
            case R.id.ll_checkbox_parking:
                m_checkbox_parking.setChecked(!m_checkbox_parking.isChecked());
                break;
            case R.id.ll_checkbox_accommodation:
                m_checkbox_accommodation.setChecked(!m_checkbox_accommodation.isChecked());
                break;
            case R.id.ll_checkbox_replace_car:
                m_checkbox_replace_car.setChecked(!m_checkbox_replace_car.isChecked());
                break;
            case R.id.ll_checkbox_according_to_days:
                m_checkbox_according_to_days.setChecked(!m_checkbox_according_to_days.isChecked());
                break;
        }
    }

    @Event({R.id.ll_select_vehicle})
    private void actOnClick(View view){
        startActivity(new Intent(this, CarTeamListAct.class));
    }
    @Event(value = {R.id.checkbox_sarah,
            R.id.checkbox_fuel
            ,R.id.checkbox_toll_fee,
            R.id.checkbox_parking,
            R.id.checkbox_accommodation,
            R.id.checkbox_replace_car,
            R.id.checkbox_according_to_days
    },
            type = CompoundButton.OnCheckedChangeListener.class)
    private void onCheck(CompoundButton bv,boolean isChecked){
        showToast("isChecked:" + isChecked);
    }


}
