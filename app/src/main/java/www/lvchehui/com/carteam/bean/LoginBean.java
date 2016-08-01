package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import java.io.Serializable;

import www.lvchehui.com.carteam.entity.LoginEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * 作者：V先生 on 2016/8/1 17:30
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class LoginBean implements Serializable{
    public int errCode;
    public String resMsg;
    public LoginEntity resData;
}
