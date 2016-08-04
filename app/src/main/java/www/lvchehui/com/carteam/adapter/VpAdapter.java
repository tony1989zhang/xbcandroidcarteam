package www.lvchehui.com.carteam.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by 张灿能 on 2016/8/4.
 * 作用：欢迎页面使用
 */
public class VpAdapter extends PagerAdapter {

    List<View> pageViews;

    public VpAdapter(List<View> pageViews) {
        this.pageViews = pageViews;
    }
    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        // TODO Auto-generated method stub
        ((ViewPager) arg0).removeView(pageViews.get(arg1));
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(pageViews.get(arg1));
        return pageViews.get(arg1);
    }

}
