package www.lvchehui.com.carteam.module.setting;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.LoginAct;
import www.lvchehui.com.carteam.activities.WebAct;
import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.impl.OnOperationListener;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.MarketUtils;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.dlg.CusDlg;

/**
 * Created by 张灿能 on 2016/8/18.
 * 作用：
 */
@ContentView(R.layout.act_setting)
public class SettingAct extends BaseAct{
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.ll_about)
    private LinearLayout m_ll_about;

    @ViewInject(R.id.ll_soft_eva)
    private LinearLayout m_ll_soft_eva;

    @ViewInject(R.id.ll_clear_cache)
    private LinearLayout m_ll_clear_cache;

    @Override
    protected void initView() {
        super.initView();
        setTitleV(m_title_view,"设置");
    }


    @Event({R.id.ll_about,R.id.ll_soft_eva,R.id.ll_clear_cache})
    private void setOnClick(View v){
        switch (v.getId())
        {
            case R.id.ll_about:
                Intent intent = new Intent(this, WebAct.class);
                intent.putExtra(WebAct.WEB_EXT_TITLE,getResources().getString(R.string.about));
                intent.putExtra(WebAct.WEB_EXT_URL, Constants.ABOUT_US);
                startActivity(intent);
                break;
            case R.id.ll_soft_eva:
                MarketUtils.launchAppDetail("com.baidu.www", "com.qihoo.appstore");
                break;
            case R.id.ll_clear_cache:
                break;
        }
    }
    @Override
    protected void submitOnClick() {
        super.submitOnClick();
       final CusDlg cusDlg = new CusDlg(this);
        cusDlg.setButtonsText("取消","确定");
        cusDlg.setTitle("退出账号");
        cusDlg.setMessage("是否确认退出账号");
        cusDlg.setOperationListener(new OnOperationListener() {
            @Override
            public void onLeftClick() {
                cusDlg.cancel();
            }

            @Override
            public void onRightClick() {
                startActivity(new Intent(SettingAct.this, LoginAct.class));
                cusDlg.dismiss();
            }
        });
        cusDlg.show();
    }


}
