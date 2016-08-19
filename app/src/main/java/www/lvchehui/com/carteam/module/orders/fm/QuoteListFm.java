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
import www.lvchehui.com.carteam.impl.OnOperationListener;
import www.lvchehui.com.carteam.module.orders.activities.DingDAct;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.dlg.CusDlg;
import www.lvchehui.com.carteam.view.timecountdown.CountdownView;

/**
 * Created by 张灿能 on 2016/8/16.
 * 作用：
 */
public class QuoteListFm extends BaseListFm<LoginBean>{
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
        return new QuoteAdapter();
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

    class QuoteAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View view = View.inflate(viewGroup.getContext(), R.layout.item_quote, null);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_quote, viewGroup, false);
            return new QuoteItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof QuoteItemViewHolder){
                CarsListEntity demandSubmitDataBean = (CarsListEntity) mItems.get(position);
                QuoteItemViewHolder holder = (QuoteItemViewHolder) viewHoder;
                holder.m_tv_ltinerary_countdown.start(2 * 60 * 60 * 1000); // Millisecond
                QuoteOnClickListener quoteOnClickListener = new QuoteOnClickListener(position);
                holder.m_tv_ltinerary_title.setOnClickListener(quoteOnClickListener);
                holder.m_tv_details.setOnClickListener(quoteOnClickListener);
                holder.m_ll_ltinerary_content.setOnClickListener(quoteOnClickListener);
            }

        }

        class QuoteOnClickListener implements View.OnClickListener{

            private int position;
            public QuoteOnClickListener(int position){
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
                        Intent intent = new Intent(getActivity(), DingDAct.class);
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



        class QuoteItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.tv_ltinerary_title)
            private TextView m_tv_ltinerary_title; //已报价3家;

            @ViewInject(R.id.ll_ltinerary_content)
            private LinearLayout m_ll_ltinerary_content;

            @ViewInject(R.id.tv_data_time)
            private TextView m_tv_data_time; //02月23日 14:23;

            @ViewInject(R.id.tv_address_content)
            private TextView m_tv_address_content; //厦门北站商务营运中心3678号5楼享莫某上的方式发送到发送到水电费水电费水电费水电费;

            @ViewInject(R.id.tv_dingd_content)
            private TextView m_tv_dingd_content; //订单号：XM201606020001;

            @ViewInject(R.id.tv_ltinerary_type)
            private TextView m_tv_ltinerary_type; //单程用车;

            @ViewInject(R.id.tv_ltinerary_countdown)
            private CountdownView m_tv_ltinerary_countdown;

            @ViewInject(R.id.tv_details)
            private TextView m_tv_details;

            @ViewInject(R.id.textView15)
            private TextView m_textView15;
            public QuoteItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }
}
