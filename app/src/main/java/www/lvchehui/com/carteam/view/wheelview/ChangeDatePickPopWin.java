package www.lvchehui.com.carteam.view.wheelview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.view.wheelview.adpter.AbstractWheelTextAdapter1;

/**
 * Created by 张灿能 on 2016/8/11.
 * 作用：自定义防IOS弹框效果
 */
public class ChangeDatePickPopWin extends PopupWindow {
    private Context mContext;
    @ViewInject(R.id.ly_myinfo_change_root)
    private LinearLayout m_ly_myinfo_change_root;

    @ViewInject(R.id.ly_myinfo_change_child)
    private LinearLayout m_ly_myinfo_change_child;

    @ViewInject(R.id.btn_myinfo_cancel)
    private TextView m_btn_myinfo_cancel; //取消;

    @ViewInject(R.id.btn_myinfo_sure)
    private TextView m_btn_myinfo_sure; //完成;

    @ViewInject(R.id.wv_year)
    private WheelView m_wv_year;

    @ViewInject(R.id.wv_day)
    private WheelView m_wv_day;

    @ViewInject(R.id.wv_hour)
    private WheelView m_wv_hour;

    @ViewInject(R.id.wv_min)
    private WheelView m_wv_min;

    private DatePickAdapter mYearAdapter;
    private DatePickAdapter mDateAdapter;
    private DatePickAdapter mHourAdapter;
    private DatePickAdapter mMinuteAdapter;


    //变量
    private ArrayList<String> arry_year = new ArrayList<>();
    private ArrayList<String> arry_date = new ArrayList<>();
    private ArrayList<String> arry_hour = new ArrayList<>();
    private ArrayList<String> arry_minute = new ArrayList<>();

    private int nowDateId = 0;
    private int nowHourId = 0;
    private int nowMinuteId = 0;
    private int nowYearId = 0;

    //常量
    private final int MAX_TEXT_SIZE = 18;
    private final int MIN_TEXT_SIZE = 16;

    private String mYearStr;
    private String mDateStr;
    private String mHourStr;
    private String mMinuteStr;
    private boolean mBlnBeLongTerm = false;//是否需要长期
    private boolean mBlnTimePicker = false;//时间选择是否显示
    private boolean showYear;
    private boolean showDays;
    private DateChooseListener dateListener;


    public ChangeDatePickPopWin(final Context context,boolean showTiemPick,boolean showYear,boolean showDays) {
        this.mContext = context;
        View view = View.inflate(context, R.layout.edit_changedatepick_pop_layout, null);
        this.setContentView(view);
        x.view().inject(this, view);
        mBlnTimePicker = showTiemPick;
        setPopWIin();
        initYear();
        initData();
        initHour();
        initMinute();
        initListener();
        this.showYear = showYear;
        this.showDays = showDays;
        if (showYear){
            m_wv_year.setVisibility(View.VISIBLE);
        }
        if (showDays)
        {
            m_wv_day.setVisibility(View.VISIBLE);
        }else{
            m_wv_day.setVisibility(View.GONE);
        }

        if (mBlnTimePicker){
            m_wv_hour.setVisibility(View.VISIBLE);
            m_wv_min.setVisibility(View.VISIBLE);
        }else{
            m_wv_hour.setVisibility(View.GONE);
            m_wv_min.setVisibility(View.GONE);
        }
    }
    public ChangeDatePickPopWin(final Context context) {
        this.mContext = context;
        View view = View.inflate(context, R.layout.edit_changedatepick_pop_layout, null);
        this.setContentView(view);
        x.view().inject(this, view);
        setPopWIin();
        initYear();
        initData();
        initHour();
        initMinute();
        initListener();

    }


    public void setDateListener(DateChooseListener dateListener) {
        this.dateListener = dateListener;
    }

    private String strTimeToDateFormat(String yearStr, String dateStr, String hourStr, String minuteStr) {

        if (showYear) {
            return yearStr.replace("年", "-") + dateStr.replace("月", "-").replace("日", " ")
                    + hourStr + ":" + minuteStr;
        }
        else {
            if (showDays) {
                return dateStr.replace("月", "-").replace("日", " ")
                        + hourStr + ":" + minuteStr;
            }else{
                return hourStr + ":" + minuteStr;
            }
        }
    }

    private String strTimeToDateFormat(String yearStr, String dateStr) {

        if (showYear)
            return yearStr.replace("年", "-") + dateStr.replace("月", "-").replace("日", "");
        else
            return dateStr.replace("月", "-").replace("日", "");
    }


    @Event({R.id.btn_myinfo_cancel, R.id.btn_myinfo_sure, R.id.ly_myinfo_change_child})
    private void changeDatePickOnclick(View v) {
        if (mBlnTimePicker) {
            dateListener.getDateTime(strTimeToDateFormat(mYearStr, mDateStr, mHourStr, mMinuteStr), mBlnBeLongTerm);
        } else {
            dateListener.getDateTime(strTimeToDateFormat(mYearStr, mDateStr), mBlnBeLongTerm);
        }
        dismiss();
    }

    private void initYear() {
        Calendar nowCalendar = Calendar.getInstance();
        int nowYear = nowCalendar.get(Calendar.YEAR);
        arry_year.clear();
        for (int i = 0; i <= 99; i++) {
            int year = nowYear - 30 + i;
            arry_year.add(year + "年");
            if (nowYear == year) {
                nowYearId = arry_year.size() - 1;
            }
        }
        mYearAdapter = new DatePickAdapter(mContext, arry_year, nowYearId, MAX_TEXT_SIZE, MIN_TEXT_SIZE);
        m_wv_year.setVisibleItems(5);
        m_wv_year.setViewAdapter(mYearAdapter);
        m_wv_year.setCurrentItem(nowYearId);
        mYearStr = arry_year.get(nowYearId);

    }

    private void initData() {
        Calendar nowCalendar = Calendar.getInstance();
        int nowYear = nowCalendar.get(Calendar.YEAR);
        arry_date.clear();
        setDate(nowYear);
        mDateAdapter = new DatePickAdapter(mContext, arry_date, nowDateId, MAX_TEXT_SIZE, MIN_TEXT_SIZE);
        m_wv_day.setVisibleItems(5);
        m_wv_day.setViewAdapter(mDateAdapter);
        m_wv_day.setCurrentItem(nowDateId);

        mDateStr = arry_date.get(nowDateId);
        setTextViewStyle(mDateStr, mDateAdapter);
    }


    private void initHour() {
        Calendar nowCalendar = Calendar.getInstance();
        int nowHour = nowCalendar.get(Calendar.HOUR_OF_DAY);
        arry_hour.clear();
        for (int i = 0; i <= 23; i++) {
            arry_hour.add(i + "");
            if (nowHour == i) {
                nowHourId = arry_hour.size() - 1;
            }
        }

        mHourAdapter = new DatePickAdapter(mContext, arry_hour, nowHourId, MAX_TEXT_SIZE, MIN_TEXT_SIZE);
        m_wv_hour.setVisibleItems(5);
        m_wv_hour.setViewAdapter(mHourAdapter);
        m_wv_hour.setCurrentItem(nowHourId);
        mHourStr = arry_hour.get(nowHourId) + "";
        setTextViewStyle(mHourStr, mHourAdapter);
    }

    private void initMinute() {
        Calendar nowCalendar = Calendar.getInstance();
        int nowMinite = nowCalendar.get(Calendar.MINUTE);
        arry_minute.clear();
        for (int i = 0; i <= 59; i++) {
            arry_minute.add(i + "");
            if (nowMinite == i) {
                nowMinuteId = arry_minute.size() - 1;
            }
        }

        mMinuteAdapter = new DatePickAdapter(mContext, arry_minute, nowMinuteId, MAX_TEXT_SIZE, MIN_TEXT_SIZE);
        m_wv_min.setVisibleItems(5);
        m_wv_min.setViewAdapter(mMinuteAdapter);
        m_wv_min.setCurrentItem(nowMinuteId);
        mMinuteStr = arry_minute.get(nowMinuteId) + "";
        setTextViewStyle(mMinuteStr, mMinuteAdapter);
    }

    /**
     * 初始化滚动监听事件
     */
    private void initListener() {
        //年份*****************************
        m_wv_year.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mYearAdapter);
                mYearStr = arry_year.get(wheel.getCurrentItem()) + "";
            }
        });

        m_wv_year.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mYearAdapter);
            }
        });

        //日期********************
        m_wv_day.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mDateAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mDateAdapter);
//                mDateCalendarTextView.setText(" " + arry_date.get(wheel.getCurrentItem()));
                mDateStr = arry_date.get(wheel.getCurrentItem());
            }
        });

        m_wv_day.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mDateAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mDateAdapter);
            }
        });

        //小时***********************************
        m_wv_hour.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mHourAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mHourAdapter);
                mHourStr = arry_hour.get(wheel.getCurrentItem()) + "";
            }
        });

        m_wv_hour.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mHourAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mHourAdapter);
            }
        });

        //分钟********************************************
        m_wv_min.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mMinuteAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mMinuteAdapter);
                mMinuteStr = arry_minute.get(wheel.getCurrentItem()) + "";
            }
        });

        m_wv_min.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mMinuteAdapter.getItemText(wheel.getCurrentItem());
                setTextViewStyle(currentText, mMinuteAdapter);
            }
        });
    }

    private void setPopWIin() {
        //设置SelectPicPopupWindow的View
//        this.setContentView(view);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//		this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }


    private class DatePickAdapter extends AbstractWheelTextAdapter1 {
        ArrayList<String> list;

        protected DatePickAdapter(Context context, ArrayList<String> list, int currentItem, int maxSize, int minSize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxSize, minSize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }


        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }
    }

    /**
     * 将改年的所有日期写入数组
     *
     * @param year
     */
    private void setDate(int year) {
        boolean isRun = isRunNian(year);
        Calendar nowCalendar = Calendar.getInstance();
        int nowMonth = nowCalendar.get(Calendar.MONTH) + 1;
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);
        for (int month = 1; month <= 12; month++) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    for (int day = 1; day <= 31; day++) {
                        arry_date.add(month + "月" + day + "日");

                        if (month == nowMonth && day == nowDay) {
                            nowDateId = arry_date.size() - 1;
                        }
                    }
                    break;
                case 2:
                    if (isRun) {
                        for (int day = 1; day <= 29; day++) {
                            arry_date.add(month + "月" + day + "日");
                            if (month == nowMonth && day == nowDay) {
                                nowDateId = arry_date.size() - 1;
                            }
                        }
                    } else {
                        for (int day = 1; day <= 28; day++) {
                            arry_date.add(month + "月" + day + "日");
                            if (month == nowMonth && day == nowDay) {
                                nowDateId = arry_date.size() - 1;
                            }
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    for (int day = 1; day <= 30; day++) {
                        arry_date.add(month + "月" + day + "日");
                        if (month == nowMonth && day == nowDay) {
                            nowDateId = arry_date.size() - 1;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private boolean isRunNian(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setTextViewStyle(String curriteItemText, DatePickAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(14);
            } else {
                textvew.setTextSize(12);
            }
        }
    }

    /**
     * 回调选中的时间（默认时间格式"yyyy-MM-dd HH:mm:ss"）
     */
    public interface DateChooseListener {
        void getDateTime(String time, boolean longTimeChecked);
    }
}
