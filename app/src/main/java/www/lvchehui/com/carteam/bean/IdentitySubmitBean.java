package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.entity.IdentitySubmitEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/25.
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class IdentitySubmitBean extends BaseBean {

    public IdentitySubmitEntity resData;

    @Override
    public String toString() {
        return "IdentitySubmitBean{" +
                "resData=" + resData +
                '}';
    }
}
