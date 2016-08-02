package www.lvchehui.com.carteam.view.dlg;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * 作者：V先生 on 2016/8/1 15:36
 * 作用：设置默认的弹框
 */
public class CWayDlg extends Dialog implements View.OnClickListener {
//    @ViewInject(R.id.tv_tip)
//    private TextView m_tv_tip; //请选择操作;
//
//    @ViewInject(R.id.tv_1)
//    private TextView m_tv_1; //设置为头像;
//
//    @ViewInject(R.id.tv_2)
//    private TextView m_tv_2; //删除图片;
//
//    @ViewInject(R.id.tv_3)
//    private TextView m_tv_3; //替换图片;
//
//    @ViewInject(R.id.divider_3)
//    private View m_divider_3;
//
//    @ViewInject(R.id.tv_cancel)
//    private TextView m_tv_cancel; //取消;


    public CWayDlg(Context context) {
        super(context, R.style.custom_dialog);
        this.setContentView(R.layout.dlg_c_way);
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth() / 6 * 5;
        getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        XgoLog.e("点击");
    }
}
