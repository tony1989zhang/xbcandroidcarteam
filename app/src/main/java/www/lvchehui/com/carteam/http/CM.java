package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CommonCallback ;
import org.xutils.x;

import java.net.CacheRequest;
import java.util.HashMap;
import java.util.Map;

import www.lvchehui.com.carteam.bean.RegisterBean;
import www.lvchehui.com.carteam.bean.SendSmsBean;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.SPUtil;

/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求。设置为可以兼容CUtil 与ConnecionUtil
 */
public class CM {

    private static final String SENDSMS_SEND= "sendsms/send";


    /*
    *用户基础
    * */
    private static final String USERS_REGISTER = "Users/register";
    private static final String USERS_LOGIN = "Users/login";
    private static final String CARS_GETLIST = "Cars/getList";
    private static CM mCM;

    private CM() {
    }

    public static final CM getInstance() {
        if (mCM == null) {
            mCM = new CM();
        }
        return mCM;
    }


    public Cancelable sendSMS(String to,ComCb<SendSmsBean> comcb){
        HashMap<String, Object> params = new HashMap<>();
        params.put("to",to);
        return CUtil.Post(SENDSMS_SEND,params,comcb);
    }

//
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
        params.put("users_gid",(String) SPUtil.getInstant(x.app()).get(Constants.USERS_GID,""));
        params.put("page",page);
        return CUtil.Post(CARS_GETLIST,params,comCb);
    }
}
