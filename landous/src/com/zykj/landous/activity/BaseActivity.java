package com.zykj.landous.activity;

import com.zykj.landous.model.ActivityManagerModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class BaseActivity extends Activity implements Handler.Callback {
	public BaseActivity() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		ActivityManagerModel.addLiveActivity(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		ActivityManagerModel.addVisibleActivity(this);
	}

	@Override
	protected void onStop() {
		super.onStop();

		ActivityManagerModel.removeVisibleActivity(this);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();

		ActivityManagerModel.addForegroundActivity(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		ActivityManagerModel.removeForegroundActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityManagerModel.removeLiveActivity(this);
	}

	@Override
	public boolean handleMessage(Message arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
