package www.lvchehui.com.carteam.module.scarmissauga;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CarTeamListAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：发布顺风车费用的变更
 */
@ContentView(R.layout.act_scarmnext)
public class ScarMnextAct extends BaseFormAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.checkbox_sarah)
    private CheckBox m_checkbox_sarah;

    @ViewInject(R.id.checkbox_fuel)
    private CheckBox m_checkbox_fuel;

    @ViewInject(R.id.checkbox_toll_fee)
    private CheckBox m_checkbox_toll_fee;

    @ViewInject(R.id.checkbox_parking)
    private CheckBox m_checkbox_parking;

    @ViewInject(R.id.ll_select_vehicle)
    private LinearLayout m_ll_select_vehicle;

    @ViewInject(R.id.tv_select_vehicle)
    private EditText m_tv_select_vehicle;

    @ViewInject(R.id.et_note)
    private EditText m_et_note;

    @ViewInject(R.id.ll_team_offer)
    private LinearLayout m_ll_team_offer;

    @ViewInject(R.id.tv_team_offer)
    private EditText m_tv_team_offer;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "发布顺风车");
    }

    @Event({R.id.ll_select_vehicle})
    private void actOnClick(View view){
        startActivity(new Intent(this,CarTeamListAct.class));
    }
    @Event(value = {R.id.checkbox_sarah,R.id.checkbox_fuel,R.id.checkbox_toll_fee,R.id.checkbox_parking},type = CompoundButton.OnCheckedChangeListener.class)
    private void onCheck(CompoundButton bv,boolean isChecked){
        showToast("isChecked:" + isChecked);
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        finish();
    }
}
