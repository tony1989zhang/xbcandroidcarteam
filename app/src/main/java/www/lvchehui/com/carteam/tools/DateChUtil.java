package www.lvchehui.com.carteam.tools;

import android.view.Gravity;
import android.view.View;

import org.xutils.x;

import www.lvchehui.com.carteam.view.wheelview.ChangeDatePickPopWin;

/**
 * Created by 张灿能 on 2016/8/15.
 * 作用：
 */
public class DateChUtil {

    //年月日 时分 选择
    public static void showDatePickPopupWind(View v,ChangeDatePickPopWin.DateChooseListener dl) {
        showDatePickPopupWind(v, null,dl);
    }

    //年月日 时分 选择
    public static void showDatePickPopupWind(final View v, Boolean hasDaysNoTime,ChangeDatePickPopWin.DateChooseListener dl) {
        ChangeDatePickPopWin mChangeAddressPopwindow = null;
        if (null == hasDaysNoTime) {
            mChangeAddressPopwindow = new ChangeDatePickPopWin(x.app());//月日时分
        } else if (!hasDaysNoTime) {
            mChangeAddressPopwindow = new ChangeDatePickPopWin(x.app(), true, false, false);//有时分没月日
        } else if (hasDaysNoTime) {
            mChangeAddressPopwindow = new ChangeDatePickPopWin(x.app(), false, false, true);//月日没时分
        }
        mChangeAddressPopwindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        mChangeAddressPopwindow
                .setDateListener(dl);
    }
}
