package www.lvchehui.com.carteam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseViewHolder;
import www.lvchehui.com.carteam.module.HomeAct;

/**
 * 作者：V先生 on 2016/8/3 18:17
 * 作用：
 */
public class GvAdapter2 extends BaseAdapter {
    private Context mContext;

    public String[] img_text2 = { "我的订单", "发布顺风车", "被抢订单", "我的钱包", "车队管理","权限管理","帮助中心", "设置",
            "反馈建议"};
    public int[] imgs2 = { R.mipmap.home_message_icon, R.mipmap.home_message_icon,
            R.mipmap.home_message_icon,  R.mipmap.home_message_icon,
            R.mipmap.home_message_icon,  R.mipmap.home_message_icon,
            R.mipmap.home_message_icon,  R.mipmap.home_message_icon,
            R.mipmap.home_message_icon};

    public int[] bgs2 = {R.drawable.shape_solid_orange,R.drawable.shape_solid_cygreen,R.drawable.shape_solid_orange,
            R.drawable.shape_solid_blue,R.drawable.shape_solid_bpurple,R.drawable.shape_solid_bpurple,R.drawable.shape_solid_dblue,R.drawable.shape_solid_purple,R.drawable.shape_solid_cyan
    };

    public GvAdapter2(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return img_text2.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_gv, parent, false);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof HomeAct)
                    ((HomeAct)mContext).itemClick(position);
            }
        });
        TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
        iv.setBackgroundResource(bgs2[position]);
        iv.setImageResource(imgs2[position]);
        tv.setText(img_text2[position]);
        return convertView;
    }

}
