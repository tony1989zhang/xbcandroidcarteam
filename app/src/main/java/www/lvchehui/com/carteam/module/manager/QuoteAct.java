package www.lvchehui.com.carteam.module.manager;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseListAct;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.module.crecarteam.activities.VehicleInfoAct;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：
 */
public class QuoteAct extends BaseListAct<LoginBean> {
    @Override
    protected void initViews() {
        super.initViews();
        setTitleV(mTitleView,"车辆列表");
    }

    @Override
    protected List convertToBeanList(LoginBean bean) {
        XgoLog.e("carsListBean:" + bean.toString());
        ArrayList<CarsListEntity> list =  new ArrayList<>();
        CarsListEntity entity = new CarsListEntity();
        for (int i = 0;i < 20;i++){
            entity.car_describe = "ss";
            entity.drive_licence_number = "ssssss";
            list.add(entity);
        }

        return list;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new CarTeamAdapter();
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
    class CarTeamAdapter extends BasePageAdapter {

        class CarTeamItemViewHolder extends RecyclerView.ViewHolder {

            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_team_type)
            private TextView m_tv_team_type; //A;

            @ViewInject(R.id.tv_team_name)
            private TextView m_tv_team_name; //闽南龙翔快运;

            @ViewInject(R.id.tv_address)
            private TextView m_tv_address; // 福建厦门;

            @ViewInject(R.id.iv_edit)
            private ImageView m_iv_edit;

            @ViewInject(R.id.iv_del)
            private ImageView m_iv_del;


            public CarTeamItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);

            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_car_team, viewGroup, false);
            return new CarTeamItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  CarTeamItemViewHolder){
                CarTeamItemViewHolder msgViewHolder = (CarTeamItemViewHolder) viewHoder;
                CarsListEntity bean = (CarsListEntity) mItems.get(position);
                msgViewHolder.m_tv_team_type.setText(bean.drive_licence_number);
                msgViewHolder.m_tv_address.setText(bean.car_describe);

            }
        }
    }
    @Event(R.id.tv_submit_ok)
    private void submitOk(View v){
        startActivity(new Intent(this,VehicleInfoAct.class));
    }
}
