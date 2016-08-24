package www.lvchehui.com.carteam.module.wallet.fm;

import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFm;

/**
 * Created by 张灿能 on 2016/8/24.
 * 作用：闪电提现头部
 */
@ContentView(R.layout.fm_withdraw_head)
public class WithHeadFm extends BaseFm {
    @ViewInject(R.id.linearLayout)
    private LinearLayout m_linearLayout;

    @ViewInject(R.id.tv_total_money)
    private TextView m_tv_total_money; //35000;

    @ViewInject(R.id.tv_withdrawal)
    private TextView m_tv_withdrawal; //提 现 ;

    @ViewInject(R.id.tv_balance)
    private TextView m_tv_balance; //未到账30000元;


}
