package www.lvchehui.com.carteam.module.crecarteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.http.CUtil;
import www.lvchehui.com.carteam.tools.PhotoUtils;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：车外部情况
 */
@ContentView(R.layout.act_upd_car_outpt)
public class UpdCarOutPtAct extends BaseFormAct implements PhotoUtils.GetPhotoResultListener {
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.iv_photo)
    private ImageView m_iv_photo;
    @ViewInject(R.id.iv_photo2)
    private ImageView m_iv_photo2;
    @ViewInject(R.id.iv_photo3)
    private ImageView m_iv_photo3;
    @ViewInject(R.id.iv_photo4)
    private ImageView m_iv_photo4;
    public PhotoUtils mInstance;

    private int car_out_type = 0;
    private static final int CAR_OUT_HEAD = 1001;
    private static final int CAR_OUT_FOOT = 1002;
    private static final int CAR_OUT_LEFT = 1003;
    private static final int CAR_OUT_RIGHT = 1004;

    @Override
    protected void initView() {
        super.initView();
        mInstance = PhotoUtils.getInstance(this, this);
        initTextView("车身外观",
                "http://imagecdn.edeng.cn/uimages/1/95/95/103405875.gif",
                "http://imagecdn.edeng.cn/uimages/1/95/95/103405875.gif",
                "http://imagecdn.edeng.cn/uimages/1/95/95/103405875.gif",
                "http://imagecdn.edeng.cn/uimages/1/95/95/103405875.gif"
                );
    }

    public void initTextView(String titleView, String pic,String pic1,String pic2,String pic3) {
        setTitleV(m_title_view, titleView);
        CUtil.loadImage(m_iv_photo, pic);
        CUtil.loadImage(m_iv_photo2, pic1);
        CUtil.loadImage(m_iv_photo3, pic2);
        CUtil.loadImage(m_iv_photo4, pic3);
    }

    @Event({R.id.btn_submit_pt, R.id.btn_submit_pt2, R.id.btn_submit_pt3, R.id.btn_submit_pt4})
    private void submitPt(View v) {
        switch (v.getId()) {

            case R.id.btn_submit_pt:
                car_out_type = CAR_OUT_HEAD;
                break;
            case R.id.btn_submit_pt2:
                car_out_type = CAR_OUT_FOOT;
                break;
            case R.id.btn_submit_pt3:
                car_out_type = CAR_OUT_LEFT;
                break;
            case R.id.btn_submit_pt4:
                car_out_type = CAR_OUT_RIGHT;
                break;
        }
        if (null == mInstance)
            return;
        mInstance.showDialog(this);
    }


    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        finish();
    }

    @Override
    public void onPotoResult(Bitmap ib) {

        switch (car_out_type) {
            case CAR_OUT_HEAD:
                m_iv_photo.setImageBitmap(ib);
                break;
            case CAR_OUT_FOOT:
                m_iv_photo2.setImageBitmap(ib);
                break;
            case CAR_OUT_LEFT:
                m_iv_photo3.setImageBitmap(ib);
                break;
            case CAR_OUT_RIGHT:
                m_iv_photo4.setImageBitmap(ib);
                break;
        }
        //执行上传文件操作，返回url交给子类保存到对应的表当中
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInstance.getActivityResult(this, requestCode, resultCode, data);
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }
}
