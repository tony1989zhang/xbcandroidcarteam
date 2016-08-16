package www.lvchehui.com.carteam.module.orders.fm;

import org.xutils.common.Callback;

import java.util.List;

import www.lvchehui.com.carteam.base.BaseListFm;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;

/**
 * Created by 张灿能 on 2016/8/16.
 * 作用：
 */
public class QuoteListFm extends BaseListFm<LoginBean>{
    @Override
    protected List<LoginBean> convertToBeanList(LoginBean loginBean) {
        return null;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return null;
    }

    @Override
    protected boolean isSwipeRefreshLayoutEnabled() {
        return false;
    }

    @Override
    protected int getSizeInPage() {
        return 0;
    }

    @Override
    protected Cancelable initRequest(int start) {
        return null;
    }

    @Override
    protected boolean isPageEnabled() {
        return false;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }
}
