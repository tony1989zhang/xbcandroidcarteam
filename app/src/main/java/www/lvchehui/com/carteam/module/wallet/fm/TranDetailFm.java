package www.lvchehui.com.carteam.module.wallet.fm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseListFm;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.CM;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：交易明细
 */
public class TranDetailFm extends BaseListFm<LoginBean>{
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



    class VehicleAdapter extends BasePageAdapter {

        class VehicleItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_vehicleInfo)
            private TextView m_tv_vehicleInfo; //A;




            public VehicleItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);

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
                VehicleItemViewHolder msgViewHolder = (VehicleItemViewHolder) viewHoder;
                CarsListEntity bean = (CarsListEntity) mItems.get(position);
                msgViewHolder.m_tv_vehicleInfo.setText("A 车队名称  闽D8876 8座");

            }
        }
    }
}
