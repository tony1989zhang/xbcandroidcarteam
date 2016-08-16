package www.lvchehui.com.carteam.module.orders.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFmAct;
import www.lvchehui.com.carteam.module.orders.fm.QuoteListFm;
import www.lvchehui.com.carteam.module.wallet.fm.TranDetailFm;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.dragtop.BanSlidingViewPage;

/**
 * Created by 张灿能 on 2016/8/16.
 * 作用：
 */
@ContentView(R.layout.act_orders)
public class OrdersAct extends BaseFmAct {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.l1)
    private LinearLayout m_l1;

    @ViewInject(R.id.tv_quote)
    private TextView m_tv_quote; //报价中;

    @ViewInject(R.id.tv_scheduled)
    private TextView m_tv_scheduled;//已预定;

    @ViewInject(R.id.tv_setoff)
    private TextView m_tv_setoff; //已出发;

    @ViewInject(R.id.tv_finish)
    private TextView m_tv_finish; //已完成;

    @ViewInject(R.id.banSlidingView)
    private BanSlidingViewPage m_banSlidingView;
    private ArrayList<Fragment> mFragmentsMsg = new ArrayList<>();
    int currentIndex = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitleView(m_title_view, "我的行程");
        mFragmentsMsg.add(new QuoteListFm());
        mFragmentsMsg.add(new TranDetailFm());
        mFragmentsMsg.add(new TranDetailFm());
        mFragmentsMsg.add(new TranDetailFm());
        ItineraryFragmentAdapter itineraryFragmentAdapter = new ItineraryFragmentAdapter(getSupportFragmentManager());
        m_banSlidingView.setAdapter(itineraryFragmentAdapter);
        m_banSlidingView.setOnPageChangeListener(new ItineraryOnPageChangeListener());
        m_banSlidingView.setOffscreenPageLimit(0);
        m_banSlidingView.setCurrentItem(currentIndex);
        m_banSlidingView.setScanScroll(true);
        m_tv_quote.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
    }

    class ItineraryFragmentAdapter extends FragmentPagerAdapter {

        public ItineraryFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentsMsg.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentsMsg.size();
        }
    }
    class ItineraryOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            m_banSlidingView.setCurrentItem(position);
            switch (position){
                case 0:
                    m_tv_quote.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    m_tv_scheduled.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_setoff.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_finish.setTextColor(getResources().getColor(R.color.text_default_color));
                    break;
                case 1:
                    m_tv_quote.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_scheduled.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    m_tv_setoff.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_finish.setTextColor(getResources().getColor(R.color.text_default_color));
                    break;
                case 2:
                    m_tv_quote.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_scheduled.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_setoff.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    m_tv_finish.setTextColor(getResources().getColor(R.color.text_default_color));
                    break;
                case 3:
                    m_tv_quote.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_scheduled.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_setoff.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_finish.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    break;

            }
            currentIndex = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Event(value = {R.id.tv_quote,R.id.tv_scheduled,R.id.tv_setoff,R.id.tv_finish},type = View.OnClickListener.class)
    private void ItineraryOnClick(View v){

        switch (v.getId()){
            case R.id.tv_quote:
                currentIndex = 0;
                break;
            case R.id.tv_scheduled:
                currentIndex = 1;
                break;
            case R.id.tv_setoff:
                currentIndex = 2;
                break;
            case R.id.tv_finish:
                currentIndex = 3;
                break;
        }
        m_banSlidingView.setCurrentItem(currentIndex);
    }
}
