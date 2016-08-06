package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队信息
 */
public class CarTeamListAct extends BaseListAct {


    class TextBean{
        String a;
        String b;
    }
    @Override
    protected void initViews() {
        super.initViews();
        setTitleView(mTitleView,"消息中心");
    }

    @Override
    protected List convertToBeanList(String json) {
        XgoLog.e("json:" + json);
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
        return new MessageListAdapter();
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


    class MessageListAdapter extends BasePageAdapter {

        class MessageItemViewHolder extends RecyclerView.ViewHolder {
            View root;
            TextView tvMsg;
            TextView tvData;
            public MessageItemViewHolder(View itemView) {
                super(itemView);
                root = itemView.findViewById(R.id.root);
                tvMsg = (TextView) itemView.findViewById(R.id.tv_msg);
                tvData = (android.widget.TextView) itemView.findViewById(R.id.tv_data);

            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
            return new MessageItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  MessageItemViewHolder){
                MessageItemViewHolder msgViewHolder = (MessageItemViewHolder) viewHoder;
                TextBean bean = (TextBean) mItems.get(position);
                msgViewHolder.tvMsg.setText(bean.a);
                msgViewHolder.tvData.setText(bean.b);

            }
        }

    }
}
