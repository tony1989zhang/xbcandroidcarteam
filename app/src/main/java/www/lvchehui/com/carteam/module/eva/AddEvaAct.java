package www.lvchehui.com.carteam.module.eva;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.view.RatingBarView;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/6/15.
 * 作用：添加评价页面
 */
@ContentView(R.layout.activity_add_eva)
public class AddEvaAct extends BaseAct implements RatingBarView.OnRatingListener {

    private static final int[] RATING_STATUS = {R.string.eva_ver_bad,R.string.eva_bad,R.string.eva_general,R.string.eva_good};


    private static final int BIND_TYPE_ONTIME = 1;
    private static final int BIND_TYPE_SERVER = 2;
    private static final int BIND_TYPE_HEALTH = 3;
    private static final int BIND_TYPE_CAR_SITUATION = 4;
    public static final int REQUEST_CODE = 1000;


    @ViewInject(R.id.title_view)
    TitleView m_title_view;



    @ViewInject(R.id.rating_ontime)
    private RatingBarView m_rating_ontime;

    @ViewInject(R.id.tv_ontime)
    private TextView m_tv_ontime;

    @ViewInject(R.id.rating_server)
    private RatingBarView m_rating_server;

    @ViewInject(R.id.tv_server)
    private TextView m_tv_server;

    @ViewInject(R.id.rating_health)
    private RatingBarView m_rating_health;

    @ViewInject(R.id.tv_health)
    private TextView m_tv_health;

    @ViewInject(R.id.rating_car_situation)
    private RatingBarView m_rating_car_situation;

    @ViewInject(R.id.tv_car_situation)
    private TextView m_tv_car_situation;


    private final String[] funTitles = {"车辆卫生好", "司机服务差", "车况较新", "旅途很愉快", "车辆没有准时", "享包车很便捷"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleV(m_title_view, "评价");
        setRating();
    }


    private void setRating() {
        m_rating_ontime.setmClickable(true);
        m_rating_ontime.setBindObject(BIND_TYPE_ONTIME);
        m_rating_ontime.setOnRatingListener(this);

        m_rating_server.setmClickable(true);
        m_rating_server.setBindObject(BIND_TYPE_SERVER);
        m_rating_server.setOnRatingListener(this);

        m_rating_health.setmClickable(true);
        m_rating_health.setBindObject(BIND_TYPE_HEALTH);
        m_rating_health.setOnRatingListener(this);

        m_rating_car_situation.setmClickable(true);
        m_rating_car_situation.setBindObject(BIND_TYPE_CAR_SITUATION);
        m_rating_car_situation.setOnRatingListener(this);
    }



    @Override
    public void onRating(Object bindObject, int RatingScore) {
        if (RatingScore > 4){
            RatingScore = 4;
        }
        int bindStaus = (int) bindObject;
        switch (bindStaus){
            case BIND_TYPE_ONTIME:
                m_tv_ontime.setText(RATING_STATUS[RatingScore-1]);
                break;
            case BIND_TYPE_SERVER:
                m_tv_server.setText(RATING_STATUS[RatingScore-1]);
                break;
            case BIND_TYPE_HEALTH:
                m_tv_health.setText(RATING_STATUS[RatingScore-1]);
                break;
            case BIND_TYPE_CAR_SITUATION:
                m_tv_car_situation.setText(RATING_STATUS[RatingScore-1]);
                break;
        }
        showToast(getResources().getString(RATING_STATUS[RatingScore - 1]));
    }

    @Event(value = R.id.btn_ok,type = View.OnClickListener.class)
    private void onAddEvaOnClick(View v){
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        showToast("finish");
    }
}