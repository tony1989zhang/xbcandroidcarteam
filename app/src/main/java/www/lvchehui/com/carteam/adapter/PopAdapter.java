package www.lvchehui.com.carteam.adapter;

import android.content.Context;

import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.view.popwin.CommonAdapter;
import www.lvchehui.com.carteam.view.popwin.CommonViewHolder;

/**
 * Created by 张灿能 on 2016/8/10.
 * 作用：
 */
public class PopAdapter extends CommonAdapter<String> {

    public PopAdapter(Context context, List<String> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(CommonViewHolder helper, String item) {
        helper.setText(R.id.tv_tinted_spinner, item);
    }

  public interface popItemOnClickListener{
          void getResult(String result);
    }
}
