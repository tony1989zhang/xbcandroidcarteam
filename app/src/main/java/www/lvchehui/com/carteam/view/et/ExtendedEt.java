package www.lvchehui.com.carteam.view.et;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by 张灿能 on 2016/8/22.
 * 作用：解决多个EditText相互关联导致的问题
 */
public class ExtendedEt extends EditText {
    private ArrayList<TextWatcher> mListeners = null;

    public ExtendedEt(Context ctx)
    {
        super(ctx);
    }

    public ExtendedEt(Context ctx, AttributeSet attrs)
    {
        super(ctx, attrs);
    }

    public ExtendedEt(Context ctx, AttributeSet attrs, int defStyle)
    {
        super(ctx, attrs, defStyle);
    }

    @Override
    public void addTextChangedListener(TextWatcher watcher)
    {
        if (mListeners == null)
        {
            mListeners = new ArrayList<TextWatcher>();
        }
        mListeners.add(watcher);

        super.addTextChangedListener(watcher);
    }

    @Override
    public void removeTextChangedListener(TextWatcher watcher)
    {
        if (mListeners != null)
        {
            int i = mListeners.indexOf(watcher);
            if (i >= 0)
            {
                mListeners.remove(i);
            }
        }

        super.removeTextChangedListener(watcher);
    }

    public void clearTextChangedListeners()
    {
        if(mListeners != null)
        {
            for(TextWatcher watcher : mListeners)
            {
                super.removeTextChangedListener(watcher);
            }

            mListeners.clear();
            mListeners = null;
        }
    }

}
