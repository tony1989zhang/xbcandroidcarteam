package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/26.
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class IdentityIssueBean extends BaseBean {
    public int resData;
}
