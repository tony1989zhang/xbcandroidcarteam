package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.entity.FaseLoginEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/25.
 * 作用：快速登录
 */
@HttpResponse(parser = JRParser.class)
public class FastLoginBean extends  BaseBean{
    public FaseLoginEntity resData;
}
