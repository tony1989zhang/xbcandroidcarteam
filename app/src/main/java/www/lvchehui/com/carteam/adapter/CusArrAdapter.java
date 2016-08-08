package www.lvchehui.com.carteam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import www.lvchehui.com.carteam.impl.AdapterViewSetListener;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：自定义Adapter
 */
public class CusArrAdapter<T> extends ArrayAdapter<T> {

    private int mResource;
    private Context mContext;
    private AdapterViewSetListener mItemViewListener;
    private ArrayList<T> mList;

    public CusArrAdapter(Context context, int resource,AdapterViewSetListener itemViewListener,ArrayList<T> list) {
        super(context, resource);
        mResource = resource;
        mContext = context;
        mItemViewListener = itemViewListener;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        mItemViewListener.getItemView(inflate, mList, position);
        return inflate;
    }
}
