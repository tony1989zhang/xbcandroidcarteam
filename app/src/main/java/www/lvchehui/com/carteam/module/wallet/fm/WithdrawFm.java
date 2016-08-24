package www.lvchehui.com.carteam.module.wallet.fm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.common.Callback;
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
 * 作用：闪电提现
 */
public class WithdrawFm extends BaseListFm<LoginBean>
{
    private View m_layout_no_card;

    @Override
    protected void initViews(View root) {
        super.initViews(root);
        m_layout_no_card = root.findViewById(R.id.layout_no_card);
    }
    @Override
    protected int getLayoutRes() {
        return R.layout.fm_with_draw;
    }
    @Override
        protected List convertToBeanList(LoginBean bean) {
            XgoLog.e("carsListBean:" + bean.toString());
            ArrayList<CarsListEntity> list =  new ArrayList<>();
            CarsListEntity entity = new CarsListEntity();
            for (int i = 0;i < 0;i++){
                entity.car_describe = "ss";
                entity.drive_licence_number = "ssssss";
                list.add(entity);
            }

            return list;
        }
    @Override
    public void showEmpty() {
        super.showEmpty();
        mEmptyTips.setVisibility(View.GONE);
        if (null == m_layout_no_card)return;
        m_layout_no_card.setVisibility(View.VISIBLE);
        m_layout_no_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("跳转支付页面");
//                startActivity(new Intent(getActivity(), SetPayPassWordActivity.class));
            }
        });
    }

    @Override
    public void hideEmpty() {
        super.hideEmpty();
        m_layout_no_card.setVisibility(View.GONE);
    }
        @Override
        protected BasePageAdapter initAdapter() {
            return new TxAdapter();
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
            return false;
        }

        @Override
        protected boolean isDataGot() {
            return false;
        }


    class TxAdapter extends BasePageAdapter implements View.OnClickListener{

        class TxItemViewHolder extends RecyclerView.ViewHolder{

            @ViewInject(R.id.et_name)
            private TextView m_tv_name;

            @ViewInject(R.id.tv_other)
            private TextView m_tv_other;
            public TxItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }

        class HeadItemViewHolder extends RecyclerView.ViewHolder{
            @ViewInject(R.id.root)
            private View m_root;
            @ViewInject(R.id.iv_pay_logo)
            private ImageView m_iv_pay_logo;
            @ViewInject(R.id.et_name)
            private TextView m_tv_name;

            public HeadItemViewHolder(View itemView){
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
            View inflate = null;
            if (viewType == 0){
                inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tx_head,viewGroup,false);
                return new HeadItemViewHolder(inflate);
            }
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tx, viewGroup, false);

            return new TxItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {

            if (getItemViewType(position) != 0&&viewHoder instanceof TxItemViewHolder){
                TxItemViewHolder txItemViewHolder = (TxItemViewHolder) viewHoder;
                CarsListEntity bean = (CarsListEntity) mItems.get(position-1);
                txItemViewHolder.m_tv_name.setText(bean.drive_licence_number);
            }else if(getItemViewType(position) == 0 &&viewHoder instanceof HeadItemViewHolder){
                HeadItemViewHolder headItemViewHolder = (HeadItemViewHolder)viewHoder;
                headItemViewHolder.m_root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("跳转账号更改");
                    }
                });
            }
        }


        @Override
        public int getItemViewType(int position) {
            if (position == 0){
                return 0;
            }
            return 1;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
