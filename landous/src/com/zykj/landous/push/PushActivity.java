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
	}

}
