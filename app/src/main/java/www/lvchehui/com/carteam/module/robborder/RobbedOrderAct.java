package www.lvchehui.com.carteam.module.robborder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

/**
 * Created by 张灿能 on 2016/8/23.
 * 作用：
 */
public class RobbedOrderAct extends BaseListAct<LoginBean> {
    @Override
    protected void initViews() {
        super.initViews();
        setTitleV(mTitleView,"被抢订单");
    }

    @Override
    protected List convertToBeanList(LoginBean loginBean) {
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
        return new RobbedOrderListAdapter();
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

    class RobbedOrderListAdapter extends BasePageAdapter {

        class RobbedOrderItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.root)
            View root;
            @ViewInject(R.id.tv_msg)
            TextView tvMsg;
            @ViewInject(R.id.tv_data)
            TextView tvData;
            public RobbedOrderItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View inflate = View.inflate(viewGroup.getContext(), R.layout.item_message, false);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_robbedorder, viewGroup, false);
            return new RobbedOrderItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {

            if (viewHoder instanceof  RobbedOrderItemViewHolder){
                RobbedOrderItemViewHolder msgViewHolder = (RobbedOrderItemViewHolder) viewHoder;
            }
        }

    }
}
