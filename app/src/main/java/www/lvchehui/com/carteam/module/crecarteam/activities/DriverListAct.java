package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.PermissionListAct;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/19.
 * 作用：司机列表
 */
public class DriverListAct extends BaseListAct<LoginBean> {
    String lastAct = "";
    private boolean isFromPermission = false;
    @Override
    protected void initViews() {
        super.initViews();
        setTitleV(mTitleView, "车辆列表");
        Intent intent = getIntent();
        String lastActivity = intent.getStringExtra(BaseListAct.LAST_ACTIVITY_NAME);
        if (lastActivity.equals(PermissionListAct.class.getName()))isFromPermission = true;


        if (isFromPermission){
            m_tv_submit_ok.setText("确认");
        }

        lastAct = getIntent().getStringExtra(LAST_ACTIVITY_NAME);
        if (!lastAct.equals(CreCarTeamAct.class.getName())){
            m_include_btn_submit.setVisibility(View.GONE);
        }
    }

    @Override
    protected List convertToBeanList(LoginBean bean) {
        XgoLog.e("carsListBean:" + bean.toString());
        ArrayList<TextBean> list =  new ArrayList<>();
        TextBean entity = new TextBean();
        for (int i = 0;i < 20;i++){
            entity.a = "ss";
            entity.b = "ssssss";
            list.add(entity);
        }

        return list;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new VehicleAdapter();
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
    protected Callback.Cancelable initRequest(int start) {
        return CM.getInstance().login("", "", this);
    }

    @Override
    protected boolean isPageEnabled() {
        return true;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }
    class VehicleAdapter extends BasePageAdapter {

        class VehicleItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_driver_info)
            private TextView m_tv_driver_info;


            @ViewInject(R.id.iv_edit)
            private ImageView m_iv_edit;

            @ViewInject(R.id.iv_del)
            private ImageView m_iv_del;

            @ViewInject(R.id.checkbox_car)
            private CheckBox m_checkbox_car;



            public VehicleItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this, itemView);
                if (isFromPermission){
                    m_iv_edit.setVisibility(View.GONE);
                    m_iv_del.setVisibility(View.GONE);
                    m_checkbox_car.setVisibility(View.VISIBLE);
                }
               else if (!lastAct.equals(CreCarTeamAct.class.getName())){
                    m_iv_edit.setVisibility(View.GONE);
                    m_iv_del.setVisibility(View.GONE);
                }
                else{
                    m_iv_edit.setVisibility(View.VISIBLE);
                    m_iv_del.setVisibility(View.VISIBLE);
                    m_checkbox_car.setVisibility(View.GONE);
                }
            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vehicle, viewGroup, false);
            return new VehicleItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  VehicleItemViewHolder){
                final VehicleItemViewHolder vehicleViewHolder = (VehicleItemViewHolder) viewHoder;
                final TextBean bean = (TextBean) mItems.get(position);
                vehicleViewHolder.m_tv_driver_info.setText("王刚  先生  13055778899");
                vehicleViewHolder.m_root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isFromPermission) {
                            vehicleViewHolder.m_checkbox_car.setChecked(!vehicleViewHolder.m_checkbox_car.isChecked());
                        } else {
                            EventBus.getDefault().post(bean);
                        }
                    }
                });

            }
        }
    }
    @Event(R.id.tv_submit_ok)
    private void submitOk(View v){
        if (isFromPermission){
            finish();
        }else {
            startActivity(new Intent(this, VehicleInfoAct.class));
        }
    }
}
