package www.lvchehui.com.carteam.module.crecarteam.activities;

import org.xutils.view.annotation.ContentView;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.UploadIdPtAct;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：上传道路运输证
 */
@ContentView(R.layout.act_updroad_tranpt)
public class UpdRoadTranPtAct extends UploadIdPtAct {
    @Override
    protected void initView() {
        super.initView();
        initTextView("上传道路运输证","道路运输证号","上传道路运输证图片","请在道路运输证复印件上，按如下要求完成并拍照上传。注：手写“仅用于享包车认证”，并在复印件上加盖红色公章。",
                "http://www.szccjl.com/eWebEditor/UploadFile/200832517381505.jpg");
    }
}
