package www.lvchehui.com.carteam.tools;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：检测合法性
 */
public class RegexUtils {
    String TELEPHONE = "/^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/";
    public static final String NOT_EMPTY = "(?m)^\\s*\\S+[\\s\\S]*$";

    private RegexUtils() {
        throw new UnsupportedOperationException();
    }
}
