package www.lvchehui.com.carteam.module.scarmissauga;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：发布顺风车
 */
@ContentView(R.layout.act_scarm_firstep)
public class ScarMFirstepAct extends BaseFormAct {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.et_start_date)
    private EditText m_et_start_date;

    @ViewInject(R.id.et_start_city)
    private EditText m_et_start_city;

    @ViewInject(R.id.et_start_time)
    private EditText m_et_start_time;

    @ViewInject(R.id.et_end_time)
    private EditText m_et_end_time;

    @ViewInject(R.id.ll_add_address)
    private LinearLayout m_ll_add_address;

    @ViewInject(R.id.et_end_add)
    private EditText m_et_end_add;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"发布顺风车");
    }

    @Event({R.id.et_start_date,R.id.et_start_city,
            R.id.et_start_time,R.id.et_end_time,R.id.ll_add_address,R.id.et_end_add})
    private void scarMFirStepOnClic(View v){
        switch (v.getId())
        {
            case R.id.et_start_date:
                showDatePickPopupWind(m_et_start_date,true);
                break;
            case R.id.et_start_city:
                showAddressPopupWind(m_et_start_city,false);
                break;
            case R.id.et_start_time:
                showDatePickPopupWind(m_et_start_time,false);
                break;
            case R.id.et_end_time:
                showDatePickPopupWind(m_et_end_time, false);
                break;
            case R.id.ll_add_address:
                break;
            case R.id.et_end_add:
                showAddressPopupWind(m_et_end_add,false);
                break;
        }

    }
    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        finish();
    }

    @Override
    public void getChangeDatePickTime(String time, View v) {
        super.getChangeDatePickTime(time, v);
        if (v==m_et_start_date)
        {
            m_et_start_date.setText(time);
        }else if(v==m_et_start_time){
            m_et_start_time.setText(time);
        }
        else if(v==m_et_end_time){
            m_et_end_time.setText(time);
        }
        else if(v==m_et_end_time){
            m_et_end_time.setText(time);
        }
    }

    @Override
    public void getAddress(View v,String p, String c, String a) {
        super.getAddress(v,p, c, a);
        if (v==m_et_start_city)
        {
            m_et_start_city.setText(p+c);
        }else if(v==m_et_end_add){
            m_et_end_add.setText(p+c);
        }

    }
}
