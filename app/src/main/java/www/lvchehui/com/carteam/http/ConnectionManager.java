package www.lvchehui.com.carteam.http;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求。
 */
public class ConnectionManager {
    private static final String SERVER_URL = "192.168.1.66/api.php/main/";
    private static final String USERS_LOGIN = "Users/login";
    private static ConnectionManager mConnectionManager;
    private ConnectionManager(){
    }
    public static final ConnectionManager getInstance(){
        if (mConnectionManager == null)
        {
            mConnectionManager = new ConnectionManager();
        }
        return mConnectionManager;
    }
    public void login(ComCb comCb){
        RequestParams requestParams = new RequestParams(getUrl(USERS_LOGIN));
        requestParams.addBodyParameter("username","15859254561");
        requestParams.addBodyParameter("password","E10ADC3949BA59ABBE56E057F20F883E");
        x.http().post(requestParams,comCb);
    }
    public String getUrl(String path){
        return "http://" + SERVER_URL + path;
    }
}
