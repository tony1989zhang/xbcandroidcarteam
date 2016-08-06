package www.lvchehui.com.carteam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.tools.PhotoUtils;
import www.lvchehui.com.carteam.tools.RegexUtils;
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
    private  PhotoUtils mInstance;
    private String mUrl;

    @Override
    protected void initView() {
        super.initView();
        mInstance = PhotoUtils.getInstance(this, this);
    }

    public void initTextView(String idNumTitle,String desTitle,String desContent){
        m_tv_id_number_title.setText(idNumTitle);
        m_tv_des_title.setText(desTitle);
        m_tv_des_content.setText(desContent);
    }

    @Event(R.id.btn_submit_pt)
    private void submitPt(View v){
        if(null == mInstance)
        return;

        mInstance.showDialog();;
    }

    @Override
    protected void submitOnClick() {
        super.submitOnClick();
        if(!validationAwe(R.id.et_id_number_content, RegexUtils.NOT_EMPTY,R.string.err_no_empty))
            return;
    }

    @Override
    public void onPotoResult(Bitmap ib) {
        //执行上传文件操作，返回url交给子类保存到对应的表当中
        mUrl = "123";
    }

    protected String getUrl(){
        return mUrl;
    }

    protected String getIdNumContent(){
        return  m_et_id_number_content.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInstance.getActivityResult(requestCode,resultCode,data);
    }
}
