package www.lvchehui.com.carteam.module;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.WebAct;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/18.
 * 作用：
 */
@ContentView(R.layout.act_help)
public class HelpAct extends BaseAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.ll_order_guide)
    private LinearLayout m_ll_order_guide;

    @ViewInject(R.id.ll_faq)
    private LinearLayout m_ll_faq;

    @ViewInject(R.id.ll_over_travel_bill)
    private LinearLayout m_ll_over_travel_bill;

    @ViewInject(R.id.ll_car_level)
    private LinearLayout m_ll_car_level;

    @ViewInject(R.id.ll_membership_agreement)
    private LinearLayout m_ll_membership_agreement;

    @ViewInject(R.id.ll_privacy_policy)
    private LinearLayout m_ll_privacy_policy;


    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"帮助中心");
    }

    @Event({R.id.ll_order_guide,R.id.ll_faq,R.id.ll_over_travel_bill,R.id.ll_car_level,R.id.ll_membership_agreement,R.id.ll_privacy_policy})
    private void onHelpClick(View v)
    {
        String url = "";
        int title = 0;
        Intent intent = new Intent(this, WebAct.class);
        switch (v.getId())
        {
            case R.id.ll_order_guide:
                 url = Constants.ORDER_GUIDE;
                title = R.string.order_guide;
                break;
            case R.id.ll_faq:
                url = Constants.FAQ;
                title = R.string.faq;
                break;
            case R.id.ll_over_travel_bill:
                url = Constants.OVER_TRAVEL_BILL;
                title = R.string.over_travel_bill;
                break;
            case R.id.ll_car_level:
                url = Constants.CAR_LEVEL;
                title = R.string.car_level;
                break;
            case R.id.ll_membership_agreement:
                url = Constants.MEMBERSHIP_AGREEMENT;
                title = R.string.membership_agreement;
                break;
            case R.id.ll_privacy_policy:
                url = Constants.PRIVACY_POLICY;
                title = R.string.privacy_policy;
                break;

        }
        intent.putExtra(WebAct.WEB_EXT_TITLE,getResources().getString(title));
        intent.putExtra(WebAct.WEB_EXT_URL,url);

        startActivity(intent);
    }

}
