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
import www.lvchehui.com.carteam.module.crecarteam.activities.DriverListAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.VehicleInfoAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.VehicleListAct;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/17.
 * 作用：
 */
public class PermissionListAct extends BaseListAct<LoginBean>{
    public static final int PerMissType = 1;
    public static final int PerMissType2 = 2;
    public static final int PerMissType3 = 3;
    public static final int PerMissType4 = 4;
    public static final String PERMISSSION_NAME = "PERMISSSION_NAME";
    @Override
    protected void initViews() {
        super.initViews();

        int intExtra = getIntent().getIntExtra(PERMISSSION_NAME,0);
        if (intExtra == PerMissType)
        {
            setTitleV(mTitleView, "包车报价");
        }else if(intExtra == PerMissType2)
        {
            setTitleV(mTitleView, "发布顺风车");
        }else if(intExtra == PerMissType3)
        {
            setTitleV(mTitleView, "更换司机");
        }else if(intExtra == PerMissType4)
        {
            setTitleV(mTitleView, "更换车辆");
        }

        m_tv_submit_ok.setText("新增");
    }

    @Override
    protected List convertToBeanList(LoginBean bean) {
        XgoLog.e("carsListBean:" + bean.toString());
        ArrayList<CarsListEntity> list =  new ArrayList<>();
        CarsListEntity entity = new CarsListEntity();
        for (int i = 0;i < 3;i++){
            entity.car_describe = "ss";
            entity.drive_licence_number = "ssssss";
            list.add(entity);
        }

        return list;
    }

    @Override
    protected BasePageAdapter initAdapter() {
        return new PermissionAdapter();
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
        return true;
    }

    @Override
    protected boolean isDataGot() {
        return false;
    }
    class PermissionAdapter extends BasePageAdapter {

        class PermissionItemViewHolder extends RecyclerView.ViewHolder {

            @ViewInject(R.id.root)
            private LinearLayout m_root;

            @ViewInject(R.id.tv_people)
            private TextView m_tv_people;

            @ViewInject(R.id.iv_del)
            private ImageView m_iv_del;


            public PermissionItemViewHolder(View itemView) {
                super(itemView);
                x.view().inject(this,itemView);

            }
        }
        @Override
        protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_permission, viewGroup, false);
            return new PermissionItemViewHolder(inflate);
        }


        @Override
        public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
            if (viewHoder instanceof  PermissionItemViewHolder){
                PermissionItemViewHolder msgViewHolder = (PermissionItemViewHolder) viewHoder;
                CarsListEntity bean = (CarsListEntity) mItems.get(position);

            }
        }
    }

    @Override
    public void submitOnClick() {
        super.submitOnClick();
        startActivity(new Intent(this,DriverListAct.class));
    }
}
