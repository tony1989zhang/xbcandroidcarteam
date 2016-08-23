package www.lvchehui.com.carteam.module;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：
 */
@ContentView(R.layout.act_xbc_credit)
public class XbcCreditListAct extends BaseListAct<LoginBean> {
    @Override
    protected List convertToBeanList(LoginBean loginBean) {
        ArrayList<TextBean> arr =  new ArrayList<>();
        for (int i = 0;i<30;i++){
            TextBean textBean = new TextBean();
            textBean.a = "a" + i;
            textBean.b = "b" + i;
            arr.add(textBean);
        }
        return arr;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new XbcCreditListAdapter();
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
        return CM.getInstance().login("","",this);
    }

    @Override
    protected boolean isPageEnabled() {
        return false;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }

    class XbcCreditListAdapter extends BasePageAdapter {

        class XbcCreditItemViewHolder extends RecyclerView.ViewHolder {
            public XbcCreditItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_xbc_credit, viewGroup, false);
            return new XbcCreditItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {

            if (viewHoder instanceof  XbcCreditItemViewHolder){
                XbcCreditItemViewHolder msgViewHolder = (XbcCreditItemViewHolder) viewHoder;
            }
        }

    }
}
