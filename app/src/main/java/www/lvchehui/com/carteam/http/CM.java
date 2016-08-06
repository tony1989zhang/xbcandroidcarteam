package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback;
import org.xutils.common.Callback.Cancelable;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求。设置为可以兼容CUtil 与ConnecionUtil
 */
public class CM {
    private static final String SERVER_URL = "192.168.1.66/api.php/main/";
    private static final String USERS_LOGIN = "Users/login";
    private static CM mCM;

    private CM() {
    }

    public static final CM getInstance() {
        if (mCM == null) {
            mCM = new CM();
        }
        return mCM;
    }

      public Cancelable login(String uname,String pwd ,Callback.CommonCallback comCb) {
       Map<String,Object> params = new HashMap<>();
        params.put("username", "15859254561");
        params.put("password", "E10ADC3949BA59ABBE56E057F20F883E");
        return CUtil.Post(USERS_LOGIN, params, comCb);
    }
}
