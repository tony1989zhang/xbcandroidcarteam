package www.lvchehui.com.carteam.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：设置宽高
 */
public class HalfListV extends ListView {
    private int MAX_HEIGHT = 300;
    public HalfListV(Context context) {
        super(context);
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        MAX_HEIGHT  = dm.heightPixels / 2;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(MAX_HEIGHT, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
