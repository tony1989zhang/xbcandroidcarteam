package www.lvchehui.com.carteam.base;

import android.graphics.Color;
import android.view.WindowManager;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

/**
 * Created by 张灿能 on 2016/8/6.
 * 作用:表单Act
 */
public class BaseFormAct extends BaseAct {

    @Override
    protected void initView() {
        super.initView();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private AwesomeValidation mAwesomeValidation;
//    RegexUtils.TELEPHONE
    protected boolean validationAwe(int v,String regex,int errMsgId){
        mAwesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
        mAwesomeValidation.setColor(Color.YELLOW);
        mAwesomeValidation.addValidation(this, v, regex, errMsgId);
        return mAwesomeValidation.validate();
//        mAwesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
//        mAwesomeValidation.setColor(Color.YELLOW);
//        mAwesomeValidation.addValidation(this, R.id.et_respon_sex, RegexUtils.NOT_EMPTY, R.string.err_tel);
//        mAwesomeValidation.validate();
    }
    protected void clearAwe(){
        if (null == mAwesomeValidation)
            mAwesomeValidation.clear();
    }
}
