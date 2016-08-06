package www.lvchehui.com.carteam.activities;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseFormAct;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用：提交上传id的类
 */
@ContentView(R.layout.act_upload_id_pt)
public class UploadIdPtAct extends BaseFormAct {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;

    @ViewInject(R.id.ll_id_number)
    private LinearLayout m_ll_id_number;

    @ViewInject(R.id.tv_id_number_title)
    private TextView m_tv_id_number_title; //证件号码标题;

    @ViewInject(R.id.tv_id_number_content)
    private EditText m_tv_id_number_content;

    @ViewInject(R.id.tv_des_title)
    private TextView m_tv_des_title; //标题;

    @ViewInject(R.id.tv_des_content)
    private TextView m_tv_des_content; //内容;

    @ViewInject(R.id.iv_photo)
    private ImageView m_iv_photo;

    @ViewInject(R.id.btn_submit_pt)
    private Button m_btn_submit_pt; //拍照/上传;


    public void initTextView(String idNumTitle,String desTitle,String desContent){
        m_tv_id_number_title.setText(idNumTitle);
        m_tv_des_title.setText(desTitle);
        m_tv_des_content.setText(desContent);
    }
}
