package www.lvchehui.com.carteam.view.et;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import www.lvchehui.com.carteam.R;

/**
 * 作者：V先生 on 2016/8/4 10:22
 * 作用：带清除功能的文本输入框
 */
public class ClearET extends EditText  implements TextWatcher, View.OnFocusChangeListener {
    private OnFocusChangeListener focusChangeListener;
    public ClearET(Context context) {
        super(context);
    }

    public ClearET(Context context, AttributeSet attrs) {

        super(context,attrs,android.R.attr.editTextStyle);
    }

    public ClearET(Context context, AttributeSet attrs, int defStyleAttr) {
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
            mClearDrawable = getResources().getDrawable(R.drawable.edit_search_clear);
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }
}
