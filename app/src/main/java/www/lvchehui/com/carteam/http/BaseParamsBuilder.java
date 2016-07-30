package www.lvchehui.com.carteam.http;

import android.text.TextUtils;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;
import org.xutils.http.app.ParamsBuilder;
import org.xutils.x;

import java.util.HashMap;

import javax.net.ssl.SSLSocketFactory;

import www.lvchehui.com.carteam.tools.SPUtil;

/**
 * 作者：V先生 on 2016/7/30 09:45
 * 作用：网络请求参数的基类
 */
public class BaseParamsBuilder implements ParamsBuilder {
    public static final String SERVER_A = "server_a";
    public static final String SERVER_B = "server_b";
    private static final HashMap<String, String> SERVER_MAP = new HashMap<>();
    private static final HashMap<String, String> DEBUG_SERVER_MAP = new HashMap<>();

    static {
        SERVER_MAP.put(SERVER_A, "http://192.168.1.66");
        SERVER_MAP.put(SERVER_B, "http://192.168.1.66");
        DEBUG_SERVER_MAP.put(SERVER_A, "http://192.168.66");
        DEBUG_SERVER_MAP.put(SERVER_B, "http://192.168.1.66");
    }

    @Override
    public String buildUri(RequestParams params, HttpRequest httpRequest) {
        String url = getHost(httpRequest.host());
        url += "/" + httpRequest.path();
        return url;
    }

    @Override
    public String buildCacheKey(RequestParams params, String[] cacheKeys) {
        return null;
    }

    @Override
    public SSLSocketFactory getSSLSocketFactory() {
        return null;
    }

    @Override
    public void buildParams(RequestParams params) {
        //添加公共部分
        params.addParameter("users_gid", "");
        params.setAsJsonContent(true);
    }

    @Override
    public void buildSign(RequestParams params, String[] signs) {

    }

    private String getHost(String host) {
        String result = null;
        if (x.isDebug()) {
            result = DEBUG_SERVER_MAP.get(host);
        } else {
            result = SERVER_MAP.get(host);
        }
        return TextUtils.isEmpty(result) ? host : result;
    }
}
