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
import www.lvchehui.com.carteam.module.crecarteam.activities.DriverListAct;

/**
 * Created by 张灿能 on 2016/8/22.
 * 作用：
 */
public class ChangeDriverListAct extends BaseListAct<LoginBean> {
    private int index;
    private ArrayList<TextView> textViews = new ArrayList<>();
    @Override
    protected void initViews() {
        super.initViews();
        EventBus.getDefault().register(this);
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
                ChangeDriverItemViewHolder itemVH = (ChangeDriverItemViewHolder) viewHoder;
                textViews.add(itemVH.m_tv_change_driver);
                itemVH.m_tv_change_driver.setOnClickListener(new ChangeDriveOnClick(position));
            }

        }

        class ChangeDriveOnClick implements View.OnClickListener{
            int position;
            public ChangeDriveOnClick(int position){
                this.position = position;
            }


            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.tv_change_driver:
                        index = position;
                        startActivity(new Intent(ChangeDriverListAct.this, DriverListAct.class));
                        break;
                }
            }
        }




        class ChangeDriverItemViewHolder extends RecyclerView.ViewHolder {
            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_car)
            private TextView m_tv_car; //A 车队名称  闽D8876 8座;

            @ViewInject(R.id.ll_change_driver)
            private LinearLayout m_ll_change_driver;

            @ViewInject(R.id.tv_change_driver)
            private TextView m_tv_change_driver; //请选择指派的司机;


            public ChangeDriverItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getDriver(TextBean bean){
      textViews.get(index).setText(bean.a);
    }
}
