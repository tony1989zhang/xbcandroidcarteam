package www.lvchehui.com.carteam.module.wallet.activityes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFmAct;
import www.lvchehui.com.carteam.module.wallet.fm.QaFm;
import www.lvchehui.com.carteam.module.wallet.fm.QaHeadFm;
import www.lvchehui.com.carteam.module.wallet.fm.TranDetailFm;
import www.lvchehui.com.carteam.module.wallet.fm.TranDetailHeadFm;
import www.lvchehui.com.carteam.module.wallet.fm.WithHeadFm;
import www.lvchehui.com.carteam.module.wallet.fm.WithdrawFm;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.dragtop.BanSlidingViewPage;
import www.lvchehui.com.carteam.view.dragtop.DragTopLayout;

/**
 * Created by 张灿能 on 2016/8/12.
 * 作用：
 */
@ContentView(R.layout.act_wallet)
public class WalletAct extends BaseFmAct {

    @ViewInject(R.id.titleView)
    private TitleView titleView;

    @ViewInject(R.id.drag_layout)
    private DragTopLayout dragLayout;
    @ViewInject(R.id.banSlidingViewPage_iv)
    private BanSlidingViewPage ivViewPager;
    @ViewInject(R.id.banSlidingViewPage_msg)
    private BanSlidingViewPage msgViewPager;


    @ViewInject(R.id.tv_withdraw)
    private TextView m_tv_withdraw;
    @ViewInject(R.id.tv_trandetail)
    private TextView m_tv_trandetail;

    @ViewInject(R.id.tv_quality_month)
    private TextView m_tv_quality_month;

    private ArrayList<Fragment> mFragmentsIV = new ArrayList<>();
    private ArrayList<Fragment> mFragmentsMsg = new ArrayList<>();


    int currentIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleView(titleView, "我的账单");
        showProgressDailog();
        initViewPager();
        //   dragLayout.setOverDrag(true);//dragLayout.isOverDrag()
    }

    private void initViewPager() {
        mFragmentsIV.add(new TranDetailHeadFm());
        mFragmentsIV.add(new WithHeadFm());
        mFragmentsIV.add(new QaHeadFm());

        mFragmentsMsg.add(new TranDetailFm());
        mFragmentsMsg.add(new WithdrawFm());
        mFragmentsMsg.add(new QaFm());

        IVFragmentAdapter ivAdapter = new IVFragmentAdapter(getSupportFragmentManager());
        ivViewPager.setAdapter(ivAdapter);
        ivViewPager.setOffscreenPageLimit(0);
        MSGFragmentAdapter msgAdapter = new MSGFragmentAdapter(getSupportFragmentManager());
        msgViewPager.setAdapter(msgAdapter);
        msgViewPager.setOffscreenPageLimit(0);

        ivViewPager.setOnPageChangeListener(new AgentOnPageChangeListener());
        msgViewPager.setOnPageChangeListener(new AgentOnPageChangeListener());

        msgViewPager.setCurrentItem(0);
        ivViewPager.setCurrentItem(0);
        ivViewPager.setScanScroll(true);
        msgViewPager.setScanScroll(true);
        m_tv_trandetail.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
        dragLayout.setOverDrag(false);
        x.task().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissProgressDialog();
            }
        },1000);

    }


    @Event(value = {R.id.title_right, R.id.tv_withdraw, R.id.tv_trandetail, R.id.tv_quality_month}, type = View.OnClickListener.class)
    private void AgentOnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_trandetail:
                currentIndex = 0;
                break;
            case R.id.tv_withdraw:
                currentIndex = 1;

                break;

            case R.id.tv_quality_month:
                currentIndex = 2;
                break;

            case R.id.title_right:
                break;

            default:
                break;
        }
        ivViewPager.setCurrentItem(currentIndex);
        msgViewPager.setCurrentItem(currentIndex);

    }

    class IVFragmentAdapter extends FragmentPagerAdapter {

        public IVFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentsIV.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentsIV.size();
        }
    }

    class MSGFragmentAdapter extends FragmentPagerAdapter {

        public MSGFragmentAdapter(FragmentManager fm) {
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

    class AgentOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int position) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            ivViewPager.setCurrentItem(position);
            msgViewPager.setCurrentItem(position);
            switch (position) {
                case 0:
                    m_tv_trandetail.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    m_tv_withdraw.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_quality_month.setTextColor(getResources().getColor(R.color.text_default_color));

                    m_tv_trandetail.getPaint().setFakeBoldText(true);
                    m_tv_withdraw.getPaint().setFakeBoldText(false);
                    m_tv_quality_month.getPaint().setFakeBoldText(false);
                    break;
                case 1:
                    m_tv_withdraw.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
                    m_tv_trandetail.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_quality_month.setTextColor(getResources().getColor(R.color.text_default_color));

                    m_tv_withdraw.getPaint().setFakeBoldText(true);
                    m_tv_trandetail.getPaint().setFakeBoldText(false);
                    m_tv_quality_month.getPaint().setFakeBoldText(false);
                    break;
                case 2:
                    m_tv_trandetail.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_withdraw.setTextColor(getResources().getColor(R.color.text_default_color));
                    m_tv_quality_month.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));

                    m_tv_withdraw.getPaint().setFakeBoldText(false);
                    m_tv_trandetail.getPaint().setFakeBoldText(false);
                    m_tv_quality_month.getPaint().setFakeBoldText(true);
                    break;

                default:
                    break;
            }

            currentIndex = position;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
