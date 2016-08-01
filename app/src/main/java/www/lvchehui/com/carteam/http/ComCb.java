package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback.CommonCallback;
import org.xutils.ex.HttpException;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.toast.ToastManager;

/**
 * 作者：V先生 on 2016/7/30 16:40
 * 作用：网络请求返回结果
 */
public  abstract class ComCb<ResultType> implements CommonCallback<ResultType> {
    String errStr = "";
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        errStr = "";
        XgoLog.e("ex_onError:" + ex.toString() + "isOnCallBack:" + isOnCallback);
        if (ex instanceof HttpException){
            //网络错误
            HttpException httpEx = (HttpException)ex;
            int code = httpEx.getCode();
            String msg = httpEx.getMessage();
            String result = httpEx.getResult();
            errStr = "错误码：" + code + "解析:" + msg;
        }else{
            errStr = "网络错误";
        }
        XgoLog.e("errStr:" + errStr);
    }
    @Override
    public void onCancelled(CancelledException cex) {
        XgoLog.e("ex_onError:" + cex.toString());
    }
    @Override
    public void onFinished() {
        ToastManager.getManager().show("加载数据完成");
    }
}
