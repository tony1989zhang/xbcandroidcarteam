package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.evebus.CarTeamEvent;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队信息
 */
public class CarTeamListAct extends BaseListAct<LoginBean> {
    @Override
    protected void initViews() {
        super.initViews();
        EventBus.getDefault().register(this);
        setTitleView(mTitleView, "消息中心");
    }

    @Override
    protected List convertToBeanList(LoginBean t) {
        XgoLog.e("json:" + t);
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
        return true;
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
            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_team_type)
            private TextView m_tv_team_type; //A;

            @ViewInject(R.id.tv_team_name)
            private TextView m_tv_team_name; //闽南龙翔快运;

            @ViewInject(R.id.tv_team_add)
            private TextView m_tv_team_add; //福建厦门;

            @ViewInject(R.id.iv_edit)
            private ImageView m_iv_edit;

            @ViewInject(R.id.iv_del)
            private ImageView m_iv_del;


            public MessageItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);

            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_car_team, viewGroup, false);
            return new MessageItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  MessageItemViewHolder){
                MessageItemViewHolder msgViewHolder = (MessageItemViewHolder) viewHoder;
                final TextBean bean = (TextBean) mItems.get(position);
                msgViewHolder.m_root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventBus.getDefault().post(bean);
                    }
                });
                msgViewHolder.m_tv_team_type.setText(bean.a);
                msgViewHolder.m_tv_team_add.setText(bean.b);

            }
        }
    }

    @Event(R.id.tv_submit_ok)
    private void submitOk(View v){
        startActivity(new Intent(this,CarTeamInfoAct.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveStickyEvent(CarTeamEvent event) {
        if (event.isCarTeamOnClick())
        {
            showToast("我已经刷新了");
            onRefresh();
            EventBus.getDefault().removeAllStickyEvents();
        }
    }
}

