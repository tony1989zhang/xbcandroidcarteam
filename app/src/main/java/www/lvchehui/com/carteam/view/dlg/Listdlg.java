package www.lvchehui.com.carteam.view.dlg;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import www.lvchehui.com.carteam.R;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：多项的选择Dlg
 */
public class Listdlg extends Dialog {
    private LinearLayout layoutContent;

    public Listdlg(Context context, View view, View.OnClickListener listener) {
        super(context, R.style.AlertDialogStyle);
        initView(context, view);
        findViewById(R.id.btnLayout).setVisibility(View.VISIBLE);
        findViewById(R.id.dialogListConfirmBtn).setOnClickListener(listener);
    }

    public Listdlg(Context context, View view) {
        super(context, R.style.AlertDialogStyle);
        initView(context, view);
    }

    /**
     * 更改主题类型
     * */
    public Listdlg(Context context, View view,int themeResId) {
        super(context,themeResId);
        initView(context, view);
    }


    public void initView(Context context, View view) {
        setContentView(R.layout.dlg_list);
        layoutContent = (LinearLayout) findViewById(R.id.dialog_layout_content);
        layoutContent.addView(view);
        findViewById(R.id.iv_dialog_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listdlg.this.dismiss();
            }
        });

		/*DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		int screenHeight = dm.heightPixels;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		if (metrics.heightPixels < screenHeight / 2) {
			this.getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		} else {
			this.getWindow().setLayout(LayoutParams.WRAP_CONTENT, screenHeight / 2);
		}*/
    }
}
