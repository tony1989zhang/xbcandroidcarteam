package www.lvchehui.com.carteam.http;

import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.x;

import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.toast.ToastManager;

/**
 * 作者：V先生 on 2016/7/30 16:40
 * 作用：网络请求返回
 */
public abstract class ComCb implements Callback.CommonCallback<String> {
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
        ToastManager.getManager().show("网络错误");
    }

    @Override
    public void onCancelled(CancelledException cex) {
        XgoLog.e("ex_onError:" + cex.toString());
        ToastManager.getManager().show("ex_onError:" + cex.toString());
    }

    @Override
    public void onFinished() {
    }


}
