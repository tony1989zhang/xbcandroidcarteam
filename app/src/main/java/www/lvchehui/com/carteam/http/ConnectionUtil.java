package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;
import java.util.Objects;

/**
 * 作者：V先生 on 2016/8/1 16:05
 * 作用：
 */
public class ConnectionUtil {
    private static final String SERVER_URL = "192.168.1.66/api.php/main/";

    //get方法
    public static<T>Callback.Cancelable Get(String path, Map<String,String> map, Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,String> entry:map.entrySet()){
                params.addQueryStringParameter(entry.getKey(),entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable Post(String path, Map<String,Object> map, Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,Object> entry:map.entrySet())
            {
               params.addParameter(entry.getKey(),entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable UpLoadFile(String path,Map<String,Object> map,Callback.CommonCallback<T> callback){
        RequestParams params = new RequestParams(getUrl(path));
        if (null != map)
        {
            for (Map.Entry<String,Object> entry:map.entrySet())
            {
                params.addParameter(entry.getKey(),entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    public static <T>Callback.Cancelable DownLoadFile(String url, String filePath, Callback.CommonCallback<T> callback)
    {
        RequestParams params = new RequestParams(getUrl(url));
        params.setAutoRename(true);
        params.setSaveFilePath(filePath);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    private static String getUrl(String path) {
        return "http://" + SERVER_URL + path;
    }
}
