package www.lvchehui.com.carteam.module;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.adapter.GvAdapter;
import www.lvchehui.com.carteam.adapter.GvAdapter2;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.module.crecarteam.activities.CreCarTeamAct;
import www.lvchehui.com.carteam.module.manager.ManagerAct;
import www.lvchehui.com.carteam.module.orders.activities.OrdersAct;
import www.lvchehui.com.carteam.module.robborder.RobbedOrderAct;
import www.lvchehui.com.carteam.module.scarmissauga.ScarMFirstepAct;
import www.lvchehui.com.carteam.module.setting.SettingAct;
import www.lvchehui.com.carteam.module.wallet.activityes.WalletAct;
import www.lvchehui.com.carteam.view.XbcGv;
import www.lvchehui.com.carteam.view.toast.ToastManager;
@ContentView(R.layout.activity_home)
public class HomeAct extends BaseAct{
    @ViewInject(R.id.sv)
    private ScrollView m_sv;
    @ViewInject(R.id.title_right_img)
    private ImageView m_title_right_img;
    @ViewInject(R.id.xbc_gv)
    private XbcGv m_xbc_gv;
    private BaseAdapter imagerAdapter;
    private boolean isTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showProgressDialog();

        if (isTrue)
        imagerAdapter = new GvAdapter(this);
        else
        imagerAdapter = new GvAdapter2(this);

        m_xbc_gv.setAdapter(imagerAdapter);
        m_xbc_gv.setSelector(new ColorDrawable(Color.TRANSPARENT));
        x.task().postDelayed(new Runnable() {
            @Override
            public void run() {
              dismissProgressDialog();
                m_sv.scrollTo(0,0);
            }
        },1000);
    }
    public void itemClick(int position) {
        ToastManager.getManager().show("" + position);
        switch (position)
        {
            case 0:
                startActivity(new Intent(this, OrdersAct.class));
                break;
            case 1:
                startActivity(new Intent(this, ScarMFirstepAct.class));//发布顺风车
                break;
            case 2:
                startActivity(new Intent(this,RobbedOrderAct.class));
                break;
            case 3:
                startActivity(new Intent(this, WalletAct.class));//我的钱包
                break;
            case 4:
                if (isTrue){
                    showToast("我是司机");
                }else{
                    showToast("我是老板");
                    startActivity(new Intent(HomeAct.this, CreCarTeamAct.class));
                }
                break;
            case 5:
                if (isTrue){
                    showToast("我是司机");
                }else{
                    showToast("我是老板");
                    startActivity(new Intent(this, ManagerAct.class));
                }
                break;
            case 6:
                startActivity(new Intent(this, HelpAct.class));
                break;
            case 7:
                startActivity(new Intent(this, SettingAct.class));//设置
                break;
            case 8:
                startActivity(new Intent(this, WalletAct.class));//我的钱包
                break;
            case 9:
                startActivity(new Intent(this, WalletAct.class));//我的钱包
                break;
        }
    }

    @Event(R.id.title_right_img)
    private void homeOnClick(View view){
        startActivity(new Intent(this,MessageAct.class));
    }
}
