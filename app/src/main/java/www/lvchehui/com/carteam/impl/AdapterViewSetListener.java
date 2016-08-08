package www.lvchehui.com.carteam.impl;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：处理Custom的view设置
 */
public interface AdapterViewSetListener<T> {
    void getItemView(View view,ArrayList<T> list,int position);
}
