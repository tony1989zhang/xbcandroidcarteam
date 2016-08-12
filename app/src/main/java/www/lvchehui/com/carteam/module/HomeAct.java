package www.lvchehui.com.carteam.module;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ScrollView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.adapter.GvAdapter;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.module.scarmissauga.ScarMFirstepAct;
import www.lvchehui.com.carteam.module.wallet.activityes.WalletAct;
import www.lvchehui.com.carteam.view.XbcGv;
import www.lvchehui.com.carteam.view.toast.ToastManager;
@ContentView(R.layout.activity_home)
public class HomeAct extends BaseAct{
    @ViewInject(R.id.sv)
    private ScrollView m_sv;
    @ViewInject(R.id.xbc_gv)
    private XbcGv m_xbc_gv;
    private GvAdapter imagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showProgressDialog();
        imagerAdapter = new GvAdapter(this);
        m_xbc_gv.setAdapter(imagerAdapter);
        m_xbc_gv.setSelector(new ColorDrawable(Color.TRANSPARENT));
        x.task().postDelayed(new Runnable() {
            @Override
            public void run() {
              dismissProgressDialog();
                m_sv.scrollTo(0,0);
            }
        },3000);
    }
    public void itemClick(int position) {
        ToastManager.getManager().show("" + position);
        switch (position)
        {
            case 0:

                break;
            case 1:
                break;
            case 2:
                startActivity(new Intent(this, ScarMFirstepAct.class));//发布顺风车
                break;
            case 3:
                startActivity(new Intent(this, WalletAct.class));
                break;
        }
    }
}
