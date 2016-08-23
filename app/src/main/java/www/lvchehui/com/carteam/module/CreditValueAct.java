package www.lvchehui.com.carteam.module;

import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：
 */
@ContentView(R.layout.act_credit_value)
public class CreditValueAct extends BaseAct {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.tv_jl)
    private TextView m_tv_jl;
    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"信用值");
    }
}
