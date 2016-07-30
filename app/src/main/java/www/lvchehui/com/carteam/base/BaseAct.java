package www.lvchehui.com.carteam.base;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

/**
 * 作者：V先生
 * 作用：Activity 基类
 */
public class BaseAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
