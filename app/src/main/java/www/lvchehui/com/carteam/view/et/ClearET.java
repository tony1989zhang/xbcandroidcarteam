package www.lvchehui.com.carteam.view.et;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import www.lvchehui.com.carteam.R;

/**
 * 作者：V先生 on 2016/8/4 10:22
 * 作用：带清除功能的文本输入框
 */
public class ClearEt extends EditText  implements TextWatcher, View.OnFocusChangeListener {
    private OnFocusChangeListener focusChangeListener;
    public ClearEt(Context context) {
        super(context);
    }

    public ClearEt(Context context, AttributeSet attrs) {

        super(context,attrs,android.R.attr.editTextStyle);
    }

    public ClearEt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 清除按钮的引用
     */
    private Drawable mClearDrawable;

    private void initViews() {
        // 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(R.drawable.selector_edit_clear);
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getCompoundDrawables()[2] != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int eventX = (int) event.getRawX();
                int eventY = (int) event.getRawY();
                Rect rect = new Rect();
                getGlobalVisibleRect(rect);
                rect.left = rect.right - 50;
                if (rect.contains(eventX, eventY)) {
                    this.setText("");
                }
            }
        }

        return super.onTouchEvent(event);
    }

    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     *
     * @param visible
     */
    protected void setClearIconVisible(boolean visible) {
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener focusChangeListener){
        this.focusChangeListener =  focusChangeListener;

    }
    /**
     * 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
     */
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
        if(focusChangeListener!=null){
            focusChangeListener.onFocusChange(view, hasFocus);
        }
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        setClearIconVisible(s.length() > 0);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if(this.hasFocus()){
            setClearIconVisible(text.length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    /**
     * 设置晃动动画
     */
    public void setShakeAnimation() {
        this.setAnimation(shakeAnimation(5));
    }

    /**
     * 晃动动画
     *
     * @param counts
     *            1秒钟晃动多少下
     * @return
     */
    public static Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }
}
