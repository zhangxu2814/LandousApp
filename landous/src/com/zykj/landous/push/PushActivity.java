package com.zykj.landous.push;

import com.baidu.android.pushservice.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.zykj.landous.Tools.ToastView;

import android.app.Activity;
import android.app.Notification;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;

public class PushActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// helloworld
		PushManager.startWork(getApplicationContext(),
				PushConstants.LOGIN_TYPE_API_KEY, "DpzGAu7CGC8Ive01Epb28giz");
		ToastView toastView = new ToastView(getApplicationContext(),
				"自定义toast测试");
		toastView.setGravity(Gravity.CENTER, 0, 0);
		toastView.show();
		// Push: 如果想基于地理位置推送，可以打开支持地理位置的推送的开关
		// PushManager.enableLbs(getApplicationContext());//这个测试失败
		// Resources resource = this.getResources();
		// String pkgName = this.getPackageName();
		// CustomPushNotificationBuilder cBuilder = new
		// CustomPushNotificationBuilder(
		// getApplicationContext(), resource.getIdentifier(
		// "notification_custom_builder", "layout", pkgName),
		// resource.getIdentifier("notification_icon", "id", pkgName),
		// resource.getIdentifier("notification_title", "id", pkgName),
		// resource.getIdentifier("notification_text", "id", pkgName));
		// cBuilder.setNotificationFlags(Notification.FLAG_AUTO_CANCEL);
		// cBuilder.setNotificationDefaults(Notification.DEFAULT_SOUND
		// | Notification.DEFAULT_VIBRATE);
		// cBuilder.setStatusbarIcon(this.getApplicationInfo().icon);
		// cBuilder.setLayoutDrawable(resource.getIdentifier(
		// "simple_notification_icon", "drawable", pkgName));
		// PushManager.setNotificationBuilder(this, 1, cBuilder);
	}

}
