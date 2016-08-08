package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.adapter.CusArrAdapter;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.entity.MotorcadeTypeEntity;
import www.lvchehui.com.carteam.evebus.CarTeamEvent;
import www.lvchehui.com.carteam.impl.AdapterViewSetListener;
import www.lvchehui.com.carteam.impl.ListDlgItemClickListener;
import www.lvchehui.com.carteam.tools.RegexUtils;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队信息
 */
@ContentView(R.layout.act_car_team_info)
public class CarTeamInfoAct extends BaseFormAct implements ListDlgItemClickListener<MotorcadeTypeEntity>, AdapterViewSetListener<MotorcadeTypeEntity> {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_team_type)
    private EditText m_et_team_type;
    @ViewInject(R.id.et_team_name)
    private EditText m_et_team_name;
    @ViewInject(R.id.et_representative)
    private EditText m_et_representative;
    @ViewInject(R.id.et_address)
    private EditText m_et_address;
    @ViewInject(R.id.et_area)
    private EditText m_et_area;
    @ViewInject(R.id.et_business_lic_photo)
    private EditText m_et_business_lic_photo;
    @ViewInject(R.id.et_road_permit_photo)
    private EditText m_et_road_permit_photo;
    @ViewInject(R.id.et_account)
    private EditText m_et_account;
    private int motorcadeDefaultType = 0;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "车队信息");
    }

    @Event({R.id.et_team_type, R.id.et_address, R.id.et_business_lic_photo, R.id.et_road_permit_photo, R.id.et_account})
    private void onCarTeamOnClick(View v) {
        switch (v.getId()) {
            case R.id.et_team_type:

                ArrayList<MotorcadeTypeEntity> list = new ArrayList<>();
                list.add(new MotorcadeTypeEntity(1, "A 旅游客运公司", "正规客运、旅游运输公司等"));
                list.add(new MotorcadeTypeEntity(2, "B 企事业单位", "租凭车行、酒店等"));
                list.add(new MotorcadeTypeEntity(3, "C 私家车", "个人"));
                showListDlg(this, this, this, list);
                break;
            case R.id.et_address:
                break;
            case R.id.et_business_lic_photo:
                break;
            case R.id.et_road_permit_photo:
                break;
            case R.id.et_account:
                break;
        }
    }


    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        boolean isSubmit = false;
        if (validationAwe(R.id.et_team_type, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_team_name, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_representative, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_address, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_area, RegexUtils.NOT_EMPTY, R.string.err_no_empty)) {
            if (motorcadeDefaultType == 3) {
                isSubmit = true;
            }
            if (motorcadeDefaultType == 2 && validationAwe(R.id.et_business_lic_photo, RegexUtils.NOT_EMPTY, R.string.err_no_empty)) {
                isSubmit = true;
            }
            if (motorcadeDefaultType == 1
                    && validationAwe(R.id.et_business_lic_photo, RegexUtils.NOT_EMPTY, R.string.err_no_empty)
                    && validationAwe(R.id.et_road_permit_photo, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                    validationAwe(R.id.et_account, RegexUtils.NOT_EMPTY, R.string.err_no_empty)
                    ) {
                isSubmit = true;
            }


        }
        if (isSubmit) {
            CarTeamEvent carTeamEvent = new CarTeamEvent();
            carTeamEvent.setCarTeamOnClick(true);
            EventBus.getDefault().post(carTeamEvent);
            finish();
        }
    }


    @Override
    public void getItemView(View view, ArrayList<MotorcadeTypeEntity> list, int position) {
        TextView title = (TextView) view.findViewById(R.id.tv_title);
        title.setText(list.get(position).getMotorcadeTypeName());
        TextView des = (TextView) view.findViewById(R.id.tv_des);
        des.setText(list.get(position).getMotorcadeTypeDes());
    }

    @Override
    public void getItem(MotorcadeTypeEntity motorcadeTypeEntity) {
        m_et_team_type.setText(motorcadeTypeEntity.getMotorcadeTypeName());
    }
}