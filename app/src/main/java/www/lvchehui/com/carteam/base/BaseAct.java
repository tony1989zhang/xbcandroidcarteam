package www.lvchehui.com.carteam.base;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import org.xutils.view.annotation.Event;
import org.xutils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.adapter.CusArrAdapter;
import www.lvchehui.com.carteam.adapter.PopAdapter;
import www.lvchehui.com.carteam.app.App;
import www.lvchehui.com.carteam.tools.PixelUtil;
import www.lvchehui.com.carteam.view.HalfListV;
import www.lvchehui.com.carteam.view.TitleView;
import www.lvchehui.com.carteam.view.dlg.CProDlg;
import www.lvchehui.com.carteam.view.dlg.Listdlg;
import www.lvchehui.com.carteam.impl.*;
import www.lvchehui.com.carteam.view.popwin.PopupWdLview;

/**
 * 作者：V先生
 * 作用：Activity 基类
 */
public class BaseAct extends Activity {
    protected final static String LAST_ACTIVITY_NAME = "LAST_ACTIVITY_NAME";
    private CProDlg mProgress;
    private View toastView;
    private Toast toast;
    public WeakReference<Activity> WriActivity = new WeakReference<Activity>(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        App.getInstance().aliveActivitys.add(WriActivity);
        mProgress = CProDlg.createDialog(this);
        toastView = LayoutInflater.from(this).inflate(R.layout.toast_view, null);
        toast = Toast.makeText(this, null, Toast.LENGTH_LONG);
        toast.setView(toastView);
        initView();
    }

    protected void initView() {
    }

    public void setTitleV(TitleView title_v, String title) {
        setTitleV(title_v, title, null);
    }
    public void setTitleV(TitleView title_v, String title, String rightText) {
        if (title_v == null) return;
        title_v.setTitle(title);
        title_v.setTitleBackVisibility(View.VISIBLE);
        title_v.setTitleRightText(rightText);
    }
    public void showProgressDialog() {
        showProgressDialog("请稍后");
    }
    public void showProgressDialog(String strMessage) {
        showProgressDialog(strMessage, false);
    }
    public void showProgressDialog(String strMessage, boolean isCancelAble) {
        if (null == mProgress) {
            return;
        }
        if (isCancelAble) {
            mProgress.setCancelable(true);
            mProgress.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mProgress.dismiss();
                }
            });
        }
        mProgress.setMessage(strMessage);
        mProgress.show();
    }
    public void dismissProgressDialog() {
        if (null != mProgress && mProgress.isShowing()) {
            mProgress.dismiss();
        }
    }
    public void showToast(String hint) {
        showToast(hint, Toast.LENGTH_LONG);
    }
    public void showToast(String hint, int duration) {
        if (null == toast || null == toastView)
            return;
        TextView tv = (TextView) toastView.findViewById(R.id.toastMessage);
        tv.setText(hint);
        toast.setDuration(duration);
        toast.show();
    }
    @Event(value = {R.id.title_back, R.id.title_right})
    private void titleClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right:
                break;
            default:
                break;
        }
    }
    @Override
    public void startActivity(Intent intent) {
        if (null != intent) {
            intent.putExtra(LAST_ACTIVITY_NAME, this.getClass().getName());
        }
        super.startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.view_null);
        mProgress = null;
        App.getInstance().aliveActivitys.remove(WriActivity);
    }

    @Event(R.id.tv_submit_ok)
    private void onBaseOnClick(View v){
        submitOnClick();
    }

    protected void submitOnClick(){

    }

    public <T>void showListDlg(Context context,final ListDlgItemClickListener listener,AdapterViewSetListener<T> adalistener,final ArrayList<T> list) {
        HalfListV halfListView = new HalfListV(this);
        final CusArrAdapter<T> adapter = new CusArrAdapter<>(context, R.layout.item_team_type, adalistener, list);
        halfListView.setAdapter(adapter);
        halfListView.setCacheColorHint(0x000000);
        final Listdlg listDialog = new Listdlg(this,halfListView);
        listDialog.show();
        halfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.getItem(list.get(position));
                listDialog.dismiss();
            }
        });
    }

    public void showPopupWdLview(final ArrayList<String> listDatas,View showAsDropView,final PopAdapter.PopItemOnClickListener itemClick){
//        final List<String> listDatas = new ArrayList<>();
//        listDatas.add("支付宝");
//        listDatas.add("微信");


        PopAdapter commonAdapter = new PopAdapter(this,listDatas,R.layout.spinner_list_item);
        final PopupWdLview popupWindowListView = new PopupWdLview(this, PixelUtil.dp2px(this, 80), commonAdapter);
        popupWindowListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("listDatas:" + listDatas.get(position));
                itemClick.getResult(listDatas.get(position));
                popupWindowListView.dismiss();
            }
        });
        popupWindowListView.showAsDropDown(showAsDropView);
    }
}
