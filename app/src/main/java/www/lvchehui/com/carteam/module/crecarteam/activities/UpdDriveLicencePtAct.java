package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.UploadIdPtAct;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：上传行驶证
 */
@ContentView(R.layout.act_upd_drive_licence_pt)
public class UpdDriveLicencePtAct extends UploadIdPtAct {
    @ViewInject(R.id.iv_photo2)
    private ImageView m_iv_photo2;
    @ViewInject(R.id.btn_submit_pt2)
    private Button m_btn_submit_pt2;
    private static final int PT_NUM_SEC = 2;

    @Override
    protected void initView() {
        super.initView();
        initTextView("上传道路经营许可证", "道路经营许可证号", "上传道路经营许可证图片", "请在道路经营许可证复印件上，按如下要求完成并拍照上传。注：手写“仅用于享包车认证”，并在复印件上加盖红色公章。", "http://img5.imgtn.bdimg.com/it/u=4022192071,1728188534&fm=21&gp=0.jpg");
    }

    @Event(R.id.btn_submit_pt2)
    private void updPtOnClick(View v){
        if(null == mInstance)
            return;
        mInstance.showDialog(this);
        pTtype = PT_NUM_SEC;

    }

    @Override
    public void onPotoResult(Bitmap ib) {
        if (pTtype == PT_NUM_SEC){
            m_iv_photo2.setImageBitmap(ib);
        }else {
            super.onPotoResult(ib);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInstance.getActivityResult(this, requestCode, resultCode, data);
    }
}
