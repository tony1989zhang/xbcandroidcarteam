package www.lvchehui.com.carteam.module.orders.fm;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.WebAct;
import www.lvchehui.com.carteam.base.BaseListFm;
import www.lvchehui.com.carteam.base.BasePageAdapter;
import www.lvchehui.com.carteam.bean.LoginBean;
import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.CM;

/**
 * Created by 张灿能 on 2016/8/17.
 * 作用：
 */
public class DriverFm extends BaseListFm<LoginBean> {
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
        return new DriverAdapter();
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

    class DriverAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View view = View.inflate(viewGroup.getContext(), R.layout.item_quote, null);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_setoff, viewGroup, false);
            return new SetOffItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof SetOffItemViewHolder){
                CarsListEntity demandSubmitDataBean = (CarsListEntity) mItems.get(position);
                SetOffItemViewHolder holder = (SetOffItemViewHolder) viewHoder;
                DriverOnClickListener quoteOnClickListener = new DriverOnClickListener(position);
                holder.m_tv_ltinerary_title.setOnClickListener(quoteOnClickListener);
                holder.m_ll_ltinerary_content.setOnClickListener(quoteOnClickListener);
            }

        }

        class DriverOnClickListener implements View.OnClickListener{

            private int position;
            public DriverOnClickListener(int position){
                this.position = position;
            }
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tv_ltinerary_title:
                        //跳转
                        break;
                    case R.id.tv_details:
                        showToast("查看详情");
                        Intent intent = new Intent(getActivity(), WebAct.class);
                        intent.putExtra(WebAct.WEB_EXT_TITLE,"订单详情");
                        intent.putExtra(WebAct.WEB_EXT_URL,"http://www.4000592122.com/xbc_wap/pages_dynamic/order_bill.html");
                        startActivity(intent);
                        break;
                    case R.id.ll_ltinerary_content:
                        showToast("position:" + position);
                        break;
                }
            }
        }



        class SetOffItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.tv_ltinerary_title)
            private TextView m_tv_ltinerary_title;

            @ViewInject(R.id.ll_ltinerary_content)
            private LinearLayout m_ll_ltinerary_content;

            @ViewInject(R.id.tv_data_time)
            private TextView m_tv_data_time;

            @ViewInject(R.id.tv_address_content)
            private TextView m_tv_address_content;

            @ViewInject(R.id.tv_dingd_content)
            private TextView m_tv_dingd_content;

            @ViewInject(R.id.tv_ltinerary_type)
            private TextView m_tv_ltinerary_type;

            @ViewInject(R.id.tv_ltinerary_countdown)
            private TextView m_tv_ltinerary_countdown;

            @ViewInject(R.id.tv_cancel_dingd)
            private TextView m_tv_cancel_dingd;

            @ViewInject(R.id.tv_change_car)
            private TextView m_tv_change_car;

            @ViewInject(R.id.tv_getdriver)
            private TextView m_tv_getdriver;

            @ViewInject(R.id.tv_setoff)
            private TextView m_tv_setoff;

            @ViewInject(R.id.textView15)
            private TextView m_textView15;
            public SetOffItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }
}
