package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.entity.SendSmsEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/24.
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class SendSmsBean extends BaseBean {

    public SendSmsEntity resData;

    @Override
    public String toString() {
        return "SendSmsBean{" +
                "resData=" + resData +
                '}';
    }
}
