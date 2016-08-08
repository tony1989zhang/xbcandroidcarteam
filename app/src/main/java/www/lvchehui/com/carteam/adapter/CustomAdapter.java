package www.lvchehui.com.carteam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import www.lvchehui.com.carteam.impl.AdapterViewSetListener;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：自定义Adapter
 */
public class CustomAdapter<T> extends ArrayAdapter<T> {

    private int mResource;
    private Context mContext;
    private AdapterViewSetListener mItemViewListener;

    public CustomAdapter(Context context, int resource,AdapterViewSetListener itemViewListener) {
        super(context, resource);
        mResource = resource;
        mContext = context;
        mItemViewListener = itemViewListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        mItemViewListener.getItemView(inflate);
        return inflate;
    }
}
