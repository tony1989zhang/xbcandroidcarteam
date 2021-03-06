package www.lvchehui.com.carteam.view.popwin;



import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.http.CUtil;


public class CommonViewHolder {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;

	private CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个ViewHolder对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static CommonViewHolder get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new CommonViewHolder(context, parent, layoutId, position);
		}else{
			CommonViewHolder viewHolder =  (CommonViewHolder) convertView.getTag();
			viewHolder.setPosition(position);
			return viewHolder;
		}
	
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public CommonViewHolder setText(int viewId, String text) {
		TextView view = getView(viewId);
			view.setText(text);
		view.setTextColor(x.app().getResources().getColor(R.color.white));
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public CommonViewHolder setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @return
	 */
	public CommonViewHolder setImageBitmap(int viewId, Bitmap bm) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}
	public CommonViewHolder loadImage(int viewId,String url,int rid){
		ImageView view = getView(viewId);
		CUtil.loadImage(view,url);
		return this;
	}
	public void setVisibility(int viewId,int visibility){
		getView(viewId).setVisibility(visibility);
		//return this;
	}
	public int getPosition() {
		return mPosition;
	}

	public void setPosition(int position) {
		this.mPosition = position;
	}
}
