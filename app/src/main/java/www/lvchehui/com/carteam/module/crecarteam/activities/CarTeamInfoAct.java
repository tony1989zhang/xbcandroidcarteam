package www.lvchehui.com.carteam.module.crecarteam.activities;

import org.greenrobot.eventbus.EventBus;
import org.xutils.view.annotation.ContentView;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.evebus.CarTeamEvent;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：车队信息
 */
@ContentView(R.layout.act_car_team_info)
public class CarTeamInfoAct extends BaseAct {

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        CarTeamEvent carTeamEvent = new CarTeamEvent();
        carTeamEvent.setCarTeamOnClick(true);
        EventBus.getDefault().post(carTeamEvent);
        finish();
    }
}
