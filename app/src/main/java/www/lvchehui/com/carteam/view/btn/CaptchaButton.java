package www.lvchehui.com.carteam.view.btn;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import www.lvchehui.com.carteam.R;
/**
 * v先生
 * 获取验证码
 * */

public class CaptchaButton extends TextView {
	private Timer countdownTimer;
	private int countdownSecond;
	private int COUNTDOWN_TIME = 60; //倒计时默认时间

	public CaptchaButton(Context context) {
		super(context);
		initView();
	}

	public CaptchaButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public CaptchaButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	private void initView() {
		setText(getContext().getResources().getString(R.string.get_cap));
		this.setTextColor(this.getResources().getColor(R.color.text_default_color));
		this.setSingleLine();
		this.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		this.setMarqueeRepeatLimit(-1);
		this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
	}

	private Handler countdownHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				cancelCountdown();
				setText(CaptchaButton.this.getContext().getResources()
						.getString(R.string.get_cap));
				CaptchaButton.this.setEnabled(true);

			} else {
				CaptchaButton.this.setText("获取验证码(" + msg.what + ")");
			}
			super.handleMessage(msg);
		}
	};

	/**
	  * @Title: startCountdown
	  * @Description: 开始倒计时
	  * @throws
	  */
	public void startCountdown() {
		if (countdownTimer == null) {
			countdownTimer = new Timer();
			countdownSecond = COUNTDOWN_TIME;
			this.setEnabled(false);
			countdownTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					Message msg = new Message();
					msg.what = countdownSecond--;
					countdownHandler.sendMessage(msg);
				}

			}, 0, 1000);
		}
	}

	/**
	  * @Title: cancelCountdown
	  * @Description: 取消倒计时
	  */
	public void cancelCountdown() {
		if (countdownTimer != null) {
			countdownTimer.cancel();
			countdownTimer = null;
		}
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		cancelCountdown();
	}
}
