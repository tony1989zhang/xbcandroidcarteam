package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.PermissionListAct;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.CarsListBean;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.evebus.CarTeamEvent;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：车辆列表
 */
public class VehicleListAct extends BaseListAct<LoginBean> {

    String lastAct = "";
    @Override
    protected void initViews() {
        super.initViews();
        EventBus.getDefault().register(this);
        setTitleV(mTitleView, "车辆列表");

        lastAct = getIntent().getStringExtra(LAST_ACTIVITY_NAME);

        if (lastAct == null||!lastAct.equals(CreCarTeamAct.class.getName())){
            m_include_btn_submit.setVisibility(View.GONE);
        }
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

            @ViewInject(R.id.tv_vehicleInfo)
            private TextView m_tv_vehicleInfo;


            @ViewInject(R.id.iv_edit)
            private ImageView m_iv_edit;

            @ViewInject(R.id.iv_del)
            private ImageView m_iv_del;

            @ViewInject(R.id.checkbox_car)
            private CheckBox m_checkbox_car;



            public MessageItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
                if (lastAct == null ||!lastAct.equals(CreCarTeamAct.class.getName())){
                    m_iv_edit.setVisibility(View.GONE);
                    m_iv_del.setVisibility(View.GONE);
                }
            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vehicle, viewGroup, false);
            return new MessageItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  MessageItemViewHolder){
                MessageItemViewHolder msgViewHolder = (MessageItemViewHolder) viewHoder;
                final TextBean bean = (TextBean) mItems.get(position);
                bean.a = "A 车队名称  闽D8876 8座";
                msgViewHolder.m_root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventBus.getDefault().post(bean);
                    }
                });
                msgViewHolder.m_tv_vehicleInfo.setText("A 车队名称  闽D8876 8座");
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
