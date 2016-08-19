package www.lvchehui.com.carteam.module.myquote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.Random;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseFmAct;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.entity.MotorcadeTypeEntity;
import www.lvchehui.com.carteam.impl.AdapterViewSetListener;
import www.lvchehui.com.carteam.impl.ListDlgItemClickListener;
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

    @ViewInject(R.id.ll_deadline)
    private LinearLayout m_ll_deadline;

    @ViewInject(R.id.et_deadline)
    private EditText m_et_deadline;

    @ViewInject(R.id.et_deposit_odds)
    private EditText m_et_deposit_odds;

    @ViewInject(R.id.ll_checkbox_according_to_days)
    private LinearLayout m_ll_checkbox_according_to_days;

    @ViewInject(R.id.checkbox_according_to_days)
    private CheckBox m_checkbox_according_to_days;

    @ViewInject(R.id.ll_team_offer)
    private LinearLayout m_ll_team_offer;

    @ViewInject(R.id.tv_team_offer)
    private EditText m_tv_team_offer;

    private int itemNum;

    private ArrayList<TextView> tvArrs = new ArrayList<>();
    private int tvNum = 0;


    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
        setTitleV(m_title_view, "立即报价");
        addItem();
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

    @Event({R.id.ll_add_car,R.id.ll_deadline,R.id.et_deadline,R.id.ll_deposit_odds,R.id.et_deposit_odds})
    private void actOnClick(View v){
        switch (v.getId()){
            case R.id.ll_add_car:
                addItem();
                break;
            case R.id.ll_deadline:
            case R.id.et_deadline:
                showDatePickPopupWind(m_ll_deadline);
                break;
            case R.id.ll_deposit_odds:
            case R.id.et_deposit_odds:
                showPopupWindow();
                break;
        }

    }

    private void showPopupWindow() {
        ArrayList<MotorcadeTypeEntity> list = new ArrayList<>();
        list.add(new MotorcadeTypeEntity(1, "2倍", ""));
        list.add(new MotorcadeTypeEntity(1, "3倍", ""));
        list.add(new MotorcadeTypeEntity(1, "4倍", ""));
        list.add(new MotorcadeTypeEntity(1, "5倍", ""));
        list.add(new MotorcadeTypeEntity(1, "6倍", ""));
        list.add(new MotorcadeTypeEntity(1, "7倍", ""));
        list.add(new MotorcadeTypeEntity(1, "8倍", ""));
        list.add(new MotorcadeTypeEntity(1, "9倍", ""));
        showListDlg(MyQuoteAct.this, R.layout.item_list, new ListDlgItemClickListener<MotorcadeTypeEntity>() {
            @Override
            public void getItem(MotorcadeTypeEntity motorcadeTypeEntity) {
                m_et_deposit_odds.setText(motorcadeTypeEntity.getMotorcadeTypeName());
            }
        }, new AdapterViewSetListener<MotorcadeTypeEntity>() {
            @Override
            public void getItemView(View view, ArrayList<MotorcadeTypeEntity> list, int position) {
                TextView tv = (TextView) view;
                tv.setText(list.get(position).getMotorcadeTypeName());
            }
        }, list);
    }

    @Override
    public void getChangeDatePickTime(String time, View v) {
        super.getChangeDatePickTime(time, v);
        m_et_deadline.setText(time);
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


    private void addItem(){
        itemNum++;
        final View inflate = getLayoutInflater().inflate(R.layout.item_add_car, null);

        final TextView m_tv_car = (TextView) inflate.findViewById(R.id.tv_car);
        m_tv_car.setId(1500+itemNum);
        tvArrs.add(m_tv_car);
        final ImageView m_iv_quit = (ImageView) inflate.findViewById(R.id.iv_quit);
        m_iv_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemNum > 1) {
                    m_view_add.removeView(inflate);
                    tvArrs.remove(m_tv_car);
                    itemNum--;
                } else {
                    showToast("设计说最少保留一个");
                }
            }
        });

        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyQuoteAct.this, CarTeamListAct.class));
                tvNum = tvArrs.indexOf(m_tv_car);
            }
        });

        m_view_add.addView(inflate);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveStickyEvent(TextBean event) {
        showToast("event点击效果:" + event.a);
        EventBus.getDefault().removeAllStickyEvents();
        App.getInstance().getTopActivity().finish();
        TextView textView = tvArrs.get(tvNum);
        textView.setText(event.a + event.b);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
