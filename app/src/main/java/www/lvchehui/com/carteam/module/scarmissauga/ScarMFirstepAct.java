package www.lvchehui.com.carteam.module.scarmissauga;

import android.content.Intent;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.entity.MotorcadeTypeEntity;
import www.lvchehui.com.carteam.impl.AdapterViewSetListener;
import www.lvchehui.com.carteam.impl.ListDlgItemClickListener;
import www.lvchehui.com.carteam.tools.CityChUtil;
import www.lvchehui.com.carteam.tools.DateChUtil;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.wheelview.ChangeAddressPopWin;
import www.lvchehui.com.carteam.view.wheelview.ChangeDatePickPopWin;

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

    @ViewInject(R.id.view_add)
    private LinearLayout m_view_add;

    @ViewInject(R.id.et_end_add)
    private EditText m_et_end_add;

    private int pass_city = 0;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "发布顺风车");
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
                addItem();
                break;
            case R.id.et_end_add:
                showAddressPopupWind(m_et_end_add,false);
                break;
        }

    }
    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        startActivity(new Intent(this,ScarMnextAct.class));
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
        super.getAddress(v, p, c, a);
        if (v==m_et_start_city)
        {
            m_et_start_city.setText(p+c);
        }else if(v==m_et_end_add){
            m_et_end_add.setText(p+c);
        }
    }

    private void addItem(){
        if (pass_city > 2){
            showToast("设计说途经城市最多3个");
            return;
        }
        pass_city++;
        final LinearLayout m_item_ly = (LinearLayout) getLayoutInflater().inflate(R.layout.item_scar_add_address, null);
        ImageView m_iv_del = (ImageView) m_item_ly.findViewById(R.id.iv_del);
        m_iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_view_add.removeView(m_item_ly);
                pass_city--;
            }
        });
        final EditText m_et_pass_add = (EditText) m_item_ly.findViewById(R.id.et_pass_add);
        m_et_pass_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("设计说这里要跳城市弹框:" + v);
                CityChUtil.showAddressPopupWind(v, false, new ChangeAddressPopWin.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        m_et_pass_add.setText(province + city);
                    }
                });
            }
        });
       final EditText m_et_amount_time = (EditText) m_item_ly.findViewById(R.id.et_amount_time);
        m_et_amount_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MotorcadeTypeEntity> list = new ArrayList<>();
                list.add(new MotorcadeTypeEntity(1, "0.5小时", ""));
                list.add(new MotorcadeTypeEntity(2, "1小时", ""));
                list.add(new MotorcadeTypeEntity(3, "1.5小时", ""));
                list.add(new MotorcadeTypeEntity(4, "2小时", ""));
                list.add(new MotorcadeTypeEntity(5, "2.5小时", ""));
                list.add(new MotorcadeTypeEntity(6, "3小时", ""));
                list.add(new MotorcadeTypeEntity(7, "3.5小时", ""));
                list.add(new MotorcadeTypeEntity(8, "4小时", ""));
                showListDlg(ScarMFirstepAct.this, R.layout.item_list, new ListDlgItemClickListener<MotorcadeTypeEntity>() {
                    @Override
                    public void getItem(MotorcadeTypeEntity motorcadeTypeEntity) {
                        m_et_amount_time.setText(motorcadeTypeEntity.getMotorcadeTypeName());
                    }
                }, new AdapterViewSetListener<MotorcadeTypeEntity>() {
                    @Override
                    public void getItemView(View view, ArrayList<MotorcadeTypeEntity> list, int position) {
                        TextView tv = (TextView) view;
                        tv.setText(list.get(position).getMotorcadeTypeName());
                    }
                }, list);
            }
        });

        m_view_add.addView(m_item_ly);
    }


}
