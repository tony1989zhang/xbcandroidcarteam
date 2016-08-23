package www.lvchehui.com.carteam.module.orders.activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.bean.TextBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.module.crecarteam.activities.VehicleListAct;

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：
 */
public class ChangeVehicleListAct extends BaseListAct<LoginBean> {
    private int index = 0;
    private ArrayList<TextView> textViews = new ArrayList<>();
    @Override
    protected void initViews() {
        super.initViews();
        EventBus.getDefault().register(this);
        setTitleV(mTitleView, "更换车辆");
        m_tv_submit_ok.setText("确定");
    }

    @Override
    protected List convertToBeanList(LoginBean loginBean) {

        ArrayList<CarsListEntity> list =  new ArrayList<>();
        CarsListEntity entity = new CarsListEntity();
        for (int i = 0;i < 2;i++){
            entity.car_describe = "ss";
            entity.drive_licence_number = "ssssss";
            list.add(entity);
        }
        return list;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new ChangeVehicleAdapter();
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
         return CM.getInstance().login("", "", this);
    }

    @Override
    protected boolean isPageEnabled() {
        return false;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }


    class ChangeVehicleAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View view = View.inflate(viewGroup.getContext(), R.layout.item_quote, null);
            View inflate = LayoutInflater.from(ChangeVehicleListAct.this).inflate(R.layout.item_change_vehicle, viewGroup, false);
            return new ChangeVehicleItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof ChangeVehicleItemViewHolder){

                ChangeVehicleItemViewHolder changeVehicle = (ChangeVehicleItemViewHolder) viewHoder;
                textViews.add(changeVehicle.m_tv_car);
                changeVehicle.m_ll_change_car.setOnClickListener(new ChangeVehicleOnClick(position));
            }

        }

        class ChangeVehicleOnClick implements View.OnClickListener{
            private int position;

            public ChangeVehicleOnClick(int position){
                this.position = position;
            }
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.ll_change_car:
                        startActivity(new Intent(ChangeVehicleListAct.this, VehicleListAct.class));
                        index = position;
                        break;
                }
            }
        }




        class ChangeVehicleItemViewHolder extends RecyclerView.ViewHolder {

            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.ll_change_car)
            private LinearLayout m_ll_change_car;

            @ViewInject(R.id.tv_car)
            private TextView m_tv_car; //A 车队名称  闽D8876 8座;

            @ViewInject(R.id.ll_change_driver)
            private LinearLayout m_ll_change_driver;

            @ViewInject(R.id.tv_change_driver)
            private TextView m_tv_change_driver; //王刚  先生  13055778899;
            public ChangeVehicleItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getVehicle(TextBean bean){
           textViews.get(index).setText(bean.a);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textViews.clear();
        textViews = null;
        EventBus.getDefault().unregister(this);
    }
}
