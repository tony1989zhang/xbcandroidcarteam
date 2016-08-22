package www.lvchehui.com.carteam.module.orders.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.common.Callback;
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
 * Created by 张灿能 on 2016/8/22.
 * 作用：
 */
public class ChangeDriverListAct extends BaseListAct<LoginBean> {
    @Override
    protected void initViews() {
        super.initViews();
        setTitleV(mTitleView, "指派司机");
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
        return new ChangeDriverAdapter();
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

    class ChangeDriverAdapter extends BasePageAdapter{
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
//            View view = View.inflate(viewGroup.getContext(), R.layout.item_quote, null);
            View inflate = LayoutInflater.from(ChangeDriverListAct.this).inflate(R.layout.item_change_driver, viewGroup, false);
            return new ChangeDriverItemViewHolder(inflate);
        }

        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof ChangeDriverItemViewHolder){
            }

        }





        class ChangeDriverItemViewHolder extends RecyclerView.ViewHolder {

            public ChangeDriverItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }
}
