package com.zykj.landous.activity;

import com.zykj.landous.MainActivity;
import com.zykj.landous.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class StartActivity extends Activity {
	private Context context;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final View startView = View.inflate(this, R.layout.activity_start, null);
		setContentView(startView);
		context = this;
		// 娓����
		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(100);
		startView.setAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

				redirectto();
			}
		});
	}

	private void redirectto() {
		Intent intent = new Intent(this, MainActivity
				.class);
		startActivity(intent);
		StartActivity.this.finish();
	}
}
