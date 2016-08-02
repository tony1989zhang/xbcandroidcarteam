package www.lvchehui.com.carteam.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * 作者：V先生 on 2016/8/2 18:54
 * 作用：自定义GridView 布局首页
 */
public class XbcGV  extends GridView{
    public XbcGV(Context context) {
        super(context);
    }

    public XbcGV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XbcGV(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE)
        {
            return true;//禁止GridView进行滑动
        }
        return super.dispatchTouchEvent(ev);
    }
}
