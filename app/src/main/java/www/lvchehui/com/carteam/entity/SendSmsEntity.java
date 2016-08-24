package www.lvchehui.com.carteam.entity;

/**
 * Created by 张灿能 on 2016/8/24.
 * 作用：
 */
public class SendSmsEntity {

    public String code;
    public String to;

    @Override
    public String toString() {
        return "SendSmsEntity{" +
                "code='" + code + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
