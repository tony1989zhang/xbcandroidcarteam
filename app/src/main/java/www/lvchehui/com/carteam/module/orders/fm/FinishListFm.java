package www.lvchehui.com.carteam.module.orders.fm;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import www.lvchehui.com.carteam.module.eva.AddEvaAct;

/**
 * Created by 张灿能 on 2016/8/17.
 * 作用：
 */
public class FinishListFm extends BaseListFm<LoginBean> {
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
        return new FinishAdapter();
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
        return  CM.getInstance().login("", "", this);
    }

    @Override
    protected boolean isPageEnabled() {
        return false;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }

    class FinishAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_finish, viewGroup, false);
            return new FinishItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  FinishItemViewHolder)
            {
               FinishItemViewHolder itemViewHolder = (FinishItemViewHolder) viewHoder;
                itemViewHolder.m_tv_eva.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), AddEvaAct.class));
                    }
                });
            }

        }





        class FinishItemViewHolder extends RecyclerView.ViewHolder {
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

            @ViewInject(R.id.tv_eva)
            private TextView m_tv_eva;

            @ViewInject(R.id.textView15)
            private TextView m_textView15;


            public FinishItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }
}
