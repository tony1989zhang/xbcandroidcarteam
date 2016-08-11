package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.http.CUtil;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：车内部情况
 */
@ContentView(R.layout.act_upd_car_inpt)
public class UpdCarInPtAct extends UploadIdPtAct {
    @ViewInject(R.id.iv_photo2)
    private ImageView m_iv_photo2;
    private static final int PT_NUM_SEC = 2;
    private int pTtype = 0;//两张照片的时候可以用到

    @Override
    protected void initView() {
        super.initView();
        initTextView("车身内景", "", "", "" , "http://docs.ebdoor.com/Image/ProductImage/0/1208/12080431_1.jpg");
        CUtil.loadImage(m_iv_photo2, "http://docs.ebdoor.com/Image/ProductImage/0/1208/12080431_1.jpg");
    }

    @Event(R.id.btn_submit_pt2)
    private void updPtOnClick(View v){
        if(null == mInstance)
            return;
        mInstance.showDialog(this);
        pTtype = PT_NUM_SEC;

    }

    @Override
    public void btn_submitPt() {
        pTtype = 0;
        super.btn_submitPt();
        showToast("父类的调用" + pTtype);
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

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
    }
}
