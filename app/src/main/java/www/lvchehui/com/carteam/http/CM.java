package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CommonCallback ;
import org.xutils.x;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import www.lvchehui.com.carteam.bean.FastLoginBean;
import www.lvchehui.com.carteam.bean.IdentitySubmitBean;
import www.lvchehui.com.carteam.bean.PictureUploadBean;
import www.lvchehui.com.carteam.bean.RegisterBean;
import www.lvchehui.com.carteam.bean.SendSmsBean;
import www.lvchehui.com.carteam.bean.UserGetTypeBean;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.SPUtil;

/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求
 */
public class CM {

    private static final String SENDSMS_SEND= "sendsms/send";


    private static final String PICTURE_UPLOAD = "picture/upload";
    /*
    *用户基础
    * */
    private static final String USERS_REGISTER = "Users/register";
    private static final String USERS_LOGIN = "Users/login";
    private static final String CARS_GETLIST = "Cars/getList";
    private static final String USERS_FASTLOGIN = "Users/fastLogin";
    /**
     * 负责人身份信息管理
     * */
    private static final String IDENTITY_SUBMIT = "Identity/submit";

    /**
     * 用户访问接口权限
     * */
    private static  final String USERS_GETTYPE = "Users/getType";
    private static CM mCM;

    private CM() {
    }

    public static final CM getInstance() {
        if (mCM == null) {
            mCM = new CM();
        }
        return mCM;
    }

    public Cancelable picUpload(String file,ComCb<PictureUploadBean> comCb){

        HashMap<String, Object> params = new HashMap<>();
        params.put("file",new File(file));
        return CUtil.UpLoadFile(PICTURE_UPLOAD,params,comCb);
    }


    public Cancelable sendSMS(String to,ComCb<SendSmsBean> comcb){
        HashMap<String, Object> params = new HashMap<>();
        params.put("to",to);
        return CUtil.Post(SENDSMS_SEND,params,comcb);
    }

    /**
     * 快速登录
     */
    public Cancelable fastLogin(String username,String code,ComCb<FastLoginBean> comCb){

        HashMap<String, Object> params = new HashMap<>();
        params.put("username",username);
        params.put("code",code);
        return CUtil.Post(USERS_FASTLOGIN,params,comCb);

    }
    /**
     * 获取当前用户类型
     * */
    public Cancelable usersGetType(String users_gid,String client_type, ComCb<UserGetTypeBean> comCb){

        HashMap<String,Object> params = new HashMap<>();
        params.put("users_gid",users_gid);
        params.put("client_type",client_type);
        return  CUtil.Post(USERS_GETTYPE,params,comCb);
    }

    public Cancelable register(String username,String smscode,ComCb<RegisterBean> comCb){
        HashMap<String ,Object> params = new HashMap<>();
        params.put("username",username);
        params.put("smscode",smscode);
        params.put("password",Constants.DEFAULT_PWD);
        return CUtil.Post(USERS_REGISTER,params,comCb);
    }

    public Cancelable login(String uname,String pwd ,CommonCallback comCb) {
       Map<String,Object> params = new HashMap<>();
        params.put("username", "15859254561");
        params.put("password", "E10ADC3949BA59ABBE56E057F20F883E");
        return CUtil.Post(USERS_LOGIN, params, comCb);
    }

    public Cancelable carsGetList(int page,CommonCallback comCb){
        Map<String,Object> params = new HashMap<>();
        params.put("users_gid",(String) SPUtil.getInstant(x.app()).get(Constants.USER_GID,""));
        params.put("page",page);
        return CUtil.Post(CARS_GETLIST,params,comCb);
    }

    /**
     * 提交身份信息
     * */
    public Cancelable identitySubmit(String users_gid,String phone,String phone_backup,String idcard_url,String idcard_number,ComCb<IdentitySubmitBean> comCb){
        Map<String,Object> params = new HashMap<>();
        params.put("users_gid",users_gid);
        params.put("phone",phone);
        params.put("phone_backup",phone_backup);
        params.put("idcard_url",idcard_url);
        params.put("idcard_number",idcard_number);
        return CUtil.Post(IDENTITY_SUBMIT,params,comCb);
    }

}
