package www.lvchehui.com.carteam.entity;

/**
 * Created by 张灿能 on 2016/8/26.
 * 作用：
 */
public class PictureUploadEntity {

    public String url;
    public String thumburl;
    public String gid;

    @Override
    public String toString() {
        return "PictureUploadEntity{" +
                "url='" + url + '\'' +
                ", thumburl='" + thumburl + '\'' +
                ", gid='" + gid + '\'' +
                '}';
    }
}
