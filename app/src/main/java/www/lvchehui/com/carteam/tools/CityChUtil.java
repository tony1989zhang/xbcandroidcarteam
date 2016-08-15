package www.lvchehui.com.carteam.tools;

import android.view.Gravity;
import android.view.View;

import org.xutils.x;

import www.lvchehui.com.carteam.view.wheelview.ChangeAddressPopWin;

/**
 * Created by 张灿能 on 2016/8/15.
 * 作用：自定义选择地址
 */
public class CityChUtil {

    //底部弹框的地址选择 三级联动或二级
    public static void showAddressPopupWind(final View view, final boolean hasArea,ChangeAddressPopWin.OnAddressCListener listener) {
        ChangeAddressPopWin mChangeAddressPopwindow = new ChangeAddressPopWin(x.app(), hasArea);
//        mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
        mChangeAddressPopwindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        mChangeAddressPopwindow
                .setAddresskListener(listener);
    }
}
