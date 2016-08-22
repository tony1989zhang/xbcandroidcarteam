package www.lvchehui.com.carteam.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import www.lvchehui.com.carteam.R;

/**
 * Created by 张灿能 on 2016/8/22.
 * 作用：
 */
public final class PhoneUtil {

    private PhoneUtil(){

    }
    public static void call(Context context, String phone) {

        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (SecurityException e) {
            showToast(context, phone);
        }


    }

    public static void showToast(Context context, String hint) {
        showToast(context, hint, Toast.LENGTH_LONG);
    }

    public static void showToast(Context context, String hint, int duration) {

        View toastView = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_LONG);
        toast.setView(toastView);
        TextView tv = (TextView) toastView.findViewById(R.id.toastMessage);
        tv.setText(hint);
        toast.setDuration(duration);
        toast.show();
    }
}
