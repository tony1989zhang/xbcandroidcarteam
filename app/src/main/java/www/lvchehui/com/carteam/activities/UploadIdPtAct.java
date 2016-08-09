package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.evebus.UploadIdPtEvent;
import www.lvchehui.com.carteam.http.CUtil;
import www.lvchehui.com.carteam.tools.PhotoUtils;
import www.lvchehui.com.carteam.tools.RegexUtils;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用：提交上传id的类
 */
@ContentView(R.layout.act_upload_id_pt)
public class UploadIdPtAct extends BaseFormAct implements PhotoUtils.GetPhotoResultListener{
    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.ll_id_number)
    private LinearLayout m_ll_id_number;
    @ViewInject(R.id.tv_id_number_title)
    private TextView m_tv_id_number_title; //证件号码标题;
    @ViewInject(R.id.et_id_number_content)
    private EditText m_et_id_number_content;
    @ViewInject(R.id.tv_des_title)
    private TextView m_tv_des_title; //标题;
    @ViewInject(R.id.tv_des_content)
    private TextView m_tv_des_content; //内容;
    @ViewInject(R.id.iv_photo)
    private ImageView m_iv_photo;
    @ViewInject(R.id.btn_submit_pt)
    private Button m_btn_submit_pt; //拍照/上传;
    public   PhotoUtils mInstance;
    private String mUrl;
    public int pTtype = 0;//两张照片的时候可以用到
    @Override
    protected void initView() {
        super.initView();
        mInstance = PhotoUtils.getInstance(this, this);
    }
    public void initTextView(String titleView,String idNumTitle,String desTitle,String desContent,String pic){
        setTitleV(m_title_view, titleView);
        m_tv_id_number_title.setText(idNumTitle);
        m_tv_des_title.setText(desTitle);
        m_tv_des_content.setText(desContent);
        CUtil.loadImage(m_iv_photo, pic);
    }

    @Event(R.id.btn_submit_pt)
    private void submitPt(View v){
        if(null == mInstance)
        return;
        mInstance.showDialog(this);;
        pTtype = 0;
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        validationAwe(R.id.et_id_number_content, RegexUtils.NOT_EMPTY, R.string.err_no_empty);

        UploadIdPtEvent uploadIdPtEvent = new UploadIdPtEvent();
        uploadIdPtEvent.setIdNum(m_et_id_number_content.getText().toString());
        uploadIdPtEvent.setIdCardPt(mUrl);

        uploadIdPtEvent.setUpLoadType(getClassName());
        EventBus.getDefault().post(uploadIdPtEvent);
        finish();
    }

    @Override
    public void onPotoResult(Bitmap ib) {
        XgoLog.e("onPotoResult:" + ib);
        m_iv_photo.setImageBitmap(ib);
        //执行上传文件操作，返回url交给子类保存到对应的表当中
        mUrl = "123";
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInstance.getActivityResult(this, requestCode, resultCode, data);
    }
    public String getClassName(){

        return this.getClass().getSimpleName();
    }
}
