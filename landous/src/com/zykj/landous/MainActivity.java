package com.zykj.landous;

import com.baidu.frontia.Frontia;
import com.zykj.landous.push.PushActivity;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Frontia.init(this.getApplicationContext(), "iG2ffdkYaq8kIjrSfvjMcUrf");
		
	}
}