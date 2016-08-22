package www.lvchehui.com.carteam.module.orders.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;

/**
 * Created by 张灿能 on 2016/8/22.
 * 作用：
 */
public class ChangeDriverListAct extends BaseListAct<LoginBean> {
    @Override
    protected List<LoginBean> convertToBeanList(LoginBean loginBean) {
        return null;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new ChangeDriverAdapter();
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

    class ChangeDriverAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View view = View.inflate(viewGroup.getContext(), R.layout.item_quote, null);
            View inflate = LayoutInflater.from(ChangeDriverListAct.this).inflate(R.layout.item_change_driver, viewGroup, false);
            return new ChangeDriverItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof ChangeDriverItemViewHolder){
            }

        }





        class ChangeDriverItemViewHolder extends RecyclerView.ViewHolder {

            public ChangeDriverItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }
}
