package www.lvchehui.com.carteam.view.et;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import www.lvchehui.com.carteam.R;

/**
 * Created by 张灿能 on 2016/8/4.
 * 作用：密码框
 */
public class PwdEt extends EditText {
    private final static String TAG = "EditTextWithDel";
    private Drawable imageOn, imageOff;
    private Context mContext;
    private boolean isHide = true;
    private int drawableWidth;

    public PwdEt(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public PwdEt(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    public PwdEt(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        imageOn = mContext.getResources().getDrawable(R.mipmap.switch_on);
        imageOff = mContext.getResources().getDrawable(R.mipmap.switch_off);
        setDrawable(true);
        //drawableWidth = PixelUtil.dp2px(getContext(), 50);
        Bitmap bm= BitmapFactory.decodeResource(getResources(), R.mipmap.switch_on);
        drawableWidth = bm.getWidth();
        try {
            bm.recycle();
        } catch (Exception e) {
        }

    }

    // 设置删除图片
    private void setDrawable(boolean isHide) {
        if (isHide) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, imageOff, null);
            // 隐藏密码
            //setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            // 显示密码
            setCompoundDrawablesWithIntrinsicBounds(null, null, imageOn, null);

            setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            //setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        this.setSelection(this.getText().length());
    }

    // 处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getCompoundDrawables()[2] != null) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int eventX = (int) event.getRawX();
                int eventY = (int) event.getRawY();
                Rect rect = new Rect();
                getGlobalVisibleRect(rect);
                rect.left = rect.right - drawableWidth;
                if (rect.contains(eventX, eventY)) {
                    if (isHide) {
                        setDrawable(false);
                        isHide = false;

                    } else {
                        setDrawable(true);
                        isHide = true;
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
