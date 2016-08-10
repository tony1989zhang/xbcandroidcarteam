package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.adapter.PopAdapter;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：上传道路运输证
 */
@ContentView(R.layout.act_updroad_tranpt)
public class UpdRoadTranPtAct extends UploadIdPtAct {
    @ViewInject(R.id.et_business_content)
    private EditText m_et_business_content;
    @Override
    protected void initView() {
        super.initView();
        initTextView("上传道路运输证","道路运输证号","上传道路运输证图片","请在道路运输证复印件上，按如下要求完成并拍照上传。注：手写“仅用于享包车认证”，并在复印件上加盖红色公章。",
                "http://www.szccjl.com/eWebEditor/UploadFile/200832517381505.jpg");
    }

    @Event(R.id.et_business_content)
    private void businessOnClick(View v)
    {
        PopAdapter.PopItemOnClickListener itemClick = new PopAdapter.PopItemOnClickListener() {
            @Override
            public void getResult(String result) {
                m_et_business_content.setText(result);
            }
        };
        ArrayList<String> lists = new ArrayList<>();
        lists.add("省际");
        lists.add("市际");
        lists.add("县际");
        showPopupWdLview(lists, m_et_business_content, itemClick);
    }
}
