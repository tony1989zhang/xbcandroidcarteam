package www.lvchehui.com.carteam.activities;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队负责人信息
 */
@ContentView(R.layout.act_respon_info)
public class ResponInfoAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.ll_respon_name)
    private LinearLayout m_ll_respon_name;

    @ViewInject(R.id.et_respon_name)
    private EditText m_et_respon_name;

    @ViewInject(R.id.ll_respon_sex)
    private LinearLayout m_ll_respon_sex;

    @ViewInject(R.id.tv_respon_sex)
    private EditText m_tv_respon_sex;

    @ViewInject(R.id.ll_preson_id_card)
    private LinearLayout m_ll_preson_id_card;

    @ViewInject(R.id.tv_preson_id_card)
    private TextView m_tv_preson_id_card;

    @ViewInject(R.id.ll_phone)
    private LinearLayout m_ll_phone;

    @ViewInject(R.id.et_phone)
    private EditText m_et_phone;

    @ViewInject(R.id.ll_phone_sec)
    private LinearLayout m_ll_phone_sec;

    @ViewInject(R.id.et_phone_sec)
    private EditText m_et_phone_sec;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"负责人信息");
    }
}
