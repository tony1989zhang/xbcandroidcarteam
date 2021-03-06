package www.lvchehui.com.carteam.view.popwin;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.tools.PixelUtil;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：
 */
public class PopupWdLview {
    private ListView listview;
    private View popupView;
    private Context context;
    private PopupWindow popupWindow;
    private CommonAdapter adapter;

    public PopupWdLview(Context context, int width, CommonAdapter adapter) {
        init(context, width, adapter);
    }

    public PopupWdLview(Context context, CommonAdapter adapter) {
        init(context, PixelUtil.dp2px(context, 200), adapter);
    }

    private void init(Context context, int width, CommonAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
        popupView = LayoutInflater.from(context).inflate(R.layout.item_popup_lv,
                null);

        listview = (ListView) popupView.findViewById(R.id.lv_popup_window);
        listview.setAdapter(adapter);
        popupWindow = new PopupWindow(popupView, width, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
    }
    public boolean isShowing(){
        return popupWindow==null?false:popupWindow.isShowing();
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        if(listview!=null){
            listview.setOnItemClickListener(listener);
        }
    }
    public void setMargin(int left,int top,int right,int bottom){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) listview.getLayoutParams();
        params.leftMargin=left;
        params.topMargin = top;
        params.rightMargin=right;
        params.bottomMargin = bottom;
        listview.setLayoutParams(params);
    }
    public void setOutsideTouchable(boolean touchable) {
        if (popupWindow != null)
            popupWindow.setOutsideTouchable(touchable);
    }

    public void setAnimationStyle(int animationStyle) {
        if (popupWindow != null)
            popupWindow.setAnimationStyle(animationStyle);
    }

    public void showAsDropDown(View anchor) {
        if (popupWindow != null)
            popupWindow.showAsDropDown(anchor);

    }

    public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (popupWindow != null)
            popupWindow.showAsDropDown(anchor, xoff, yoff);
    }

    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (popupWindow != null){
            Log.e("showAsDropDown", "showAsDropDown:");
            popupWindow.showAsDropDown(anchor, xoff, yoff, gravity);

        }


    }

    public void showAtLocation(View parent, int gravity, int x, int y) {
        if (popupWindow != null)
            popupWindow.showAtLocation(parent, gravity, x, y);
    }

    public void dismiss() {
        if (popupWindow != null)
            popupWindow.dismiss();
    }

    public void notifyDataSetChanged() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }
}
