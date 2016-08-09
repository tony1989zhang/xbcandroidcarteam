package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

import www.lvchehui.com.carteam.entity.CarsListEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class CarsListBean {

    public int errCode;
    public String resMsg;
    public List<CarsListEntity> resData;
}
