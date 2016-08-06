package www.lvchehui.com.carteam.tools;

/**
 * Created by 张灿能 on 2016/8/5.
 * 作用：检测合法性
 */
public class RegexUtils {
    public static final String TELEPHONE = "^(((13[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|(15[0-9]{1}))+\\d{8})$";
    public static final String NOT_EMPTY = "(?m)^\\s*\\S+[\\s\\S]*$";

    private RegexUtils() {
        throw new UnsupportedOperationException();
    }
}
