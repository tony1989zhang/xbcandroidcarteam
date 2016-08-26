package www.lvchehui.com.carteam.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 张灿能 on 2016/8/26.
 * 作用：
 */
public class ParseUtil {
    /**
     * 去除特殊符号
     */
    public static String formatUri(String content) {
        if (content.contains("&")) {

            content = content.replace("&#039;", "'");
            content = content.replace("&quot;", "\"");
            content = content.replace("&lt;", "<");
            content = content.replace("&gt;", ">");
            content = content.replace("&amp;", "&");
        }
        return content;
    }

    /**
     * url 解码
     * */
    public static String deCodeString(String content){
        try {
            return URLDecoder.decode(content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
