package www.lvchehui.com.carteam.view.dlg;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import www.lvchehui.com.carteam.R;
/**
 * 作者：V先生 on 2016/8/1 15:36
 * 作用：设置默认的弹框
 */
public class CWayDlg extends Dialog implements View.OnClickListener {
    public CWayDlg(Context context) {
        super(context, R.style.custom_dialog);
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth() / 6 * 5;
        getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {

    }
}
