package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.tools.RegexUtils;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：司机信息
 */
@ContentView(R.layout.act_driver_info)
public class DriverInfoAct extends BaseFormAct{
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_respon_name)
    private EditText m_et_respon_name;
    @ViewInject(R.id.et_respon_sex)
    private EditText m_et_respon_sex;
    @ViewInject(R.id.et_phone)
    private EditText m_et_phone;
    @ViewInject(R.id.et_phone_sec)
    private EditText m_et_phone_sec;
    @ViewInject(R.id.et_preson_id_card)
    private EditText m_et_preson_id_card;

    @ViewInject(R.id.et_drive_licence)
    private EditText m_et_drive_licence;
    @ViewInject(R.id.et_job_licence)
    private EditText m_et_job_licence;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "车辆信息");
    }
    @Event({R.id.et_respon_sex,R.id.et_preson_id_card,R.id.et_drive_licence,R.id.et_job_licence})
    private void driverOnClick(View v){
        switch (v.getId())
        {
            case R.id.et_respon_sex:
                break;
            case R.id.et_preson_id_card:
                startActivity(new Intent(this,UpdPeopleIDcardActivity.class));
                break;
            case R.id.et_drive_licence:
                break;
            case R.id.et_job_licence:
                break;
        }
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        if (
        validationAwe(R.id.et_respon_name, RegexUtils.NOT_EMPTY, R.string.err_no_empty)&&
        validationAwe(R.id.et_respon_sex, RegexUtils.NOT_EMPTY,R.string.err_no_empty)&&
        validationAwe(R.id.et_phone, RegexUtils.NOT_EMPTY,R.string.err_no_empty)&&
        validationAwe(R.id.et_respon_name, RegexUtils.NOT_EMPTY,R.string.err_no_empty)&&
        validationAwe(R.id.et_preson_id_card, RegexUtils.NOT_EMPTY,R.string.err_no_empty)&&
        validationAwe(R.id.et_drive_licence, RegexUtils.NOT_EMPTY,R.string.err_no_empty)){
            finish();
        }
    }
}
