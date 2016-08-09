package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.evebus.BankAccEvent;
import www.lvchehui.com.carteam.tools.RegexUtils;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：对公转账
 */
@ContentView(R.layout.act_account)
public class AccountAct extends BaseFormAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.et_bank_name)
    private EditText m_et_bank_name;
    @ViewInject(R.id.et_bank_area)
    private EditText m_et_bank_area;
    @ViewInject(R.id.et_bank_type)
    private EditText m_et_bank_type;
    @ViewInject(R.id.et_bank_account)
    private EditText m_et_bank_account;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view, "对公账户");
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();

        if (validationAwe(R.id.et_bank_name, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_bank_area, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_bank_type, RegexUtils.NOT_EMPTY, R.string.err_no_empty) &&
                validationAwe(R.id.et_bank_account, RegexUtils.NOT_EMPTY, R.string.err_no_empty)) {
            BankAccEvent bankAcc = new BankAccEvent();
            bankAcc.setBankAcc(m_et_bank_account.getText().toString());
            bankAcc.setBankArea(m_et_bank_area.getText().toString());
            bankAcc.setBankName(m_et_bank_name.getText().toString());
            bankAcc.setBankType(m_et_bank_type.getText().toString());
            EventBus.getDefault().post(bankAcc);
            finish();
        }
    }
}
