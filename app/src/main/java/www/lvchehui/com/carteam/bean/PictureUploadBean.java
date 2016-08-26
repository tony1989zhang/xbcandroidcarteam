package www.lvchehui.com.carteam.bean;

import org.xutils.http.annotation.HttpResponse;

import www.lvchehui.com.carteam.entity.PictureUploadEntity;
import www.lvchehui.com.carteam.http.JRParser;

/**
 * Created by 张灿能 on 2016/8/26.
 * 作用：
 */
@HttpResponse(parser = JRParser.class)
public class PictureUploadBean extends BaseBean {
    public PictureUploadEntity resData;

    @Override
    public String toString() {
        return "PictureUploadBean{" +
                "retData=" + resData +
                '}';
    }
}
