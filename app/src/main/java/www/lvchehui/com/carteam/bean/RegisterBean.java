package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.entity.RegisterEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/24.
 * 作用：注册的bean
 */
@HttpResponse(parser = JRParser.class)
public class RegisterBean extends BaseBean {

    public RegisterEntity resData;

}
