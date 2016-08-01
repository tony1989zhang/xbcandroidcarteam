package www.lvchehui.com.carteam.http;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * 作者：V先生 on 2016/8/1 16:26
 * 作用：结果解析
 */
public class JRParser implements ResponseParser {
    //检测服务端头部
    @Override
    public void checkResponse(UriRequest request) throws Throwable {
        XgoLog.e("checkResponse:" + request);
    }
    /**
     * 转换result 为resultType类型的数据
     * resultType 返回值类型
     * resultClass 返回值的类型
     * result 字符串类型
     * */
    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        XgoLog.e("class:" + resultClass + ","+"result:" + result);
        return new Gson().fromJson(result,resultClass);
    }
}
