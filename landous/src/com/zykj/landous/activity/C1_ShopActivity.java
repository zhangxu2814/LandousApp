package com.zykj.landous.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.BeeFramework.activity.BaseActivity;
import com.zykj.landous.R;

public class C1_ShopActivity extends BaseActivity implements OnClickListener {
	private LinearLayout ll_back;
	private LinearLayout ll_menu;
	private LinearLayout shop;
	/**
	 * 收藏按钮
	 */
	private Button btn_collect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c1_activity_shop);
		init();
	}

	@SuppressLint("NewApi")
	private void init() {
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setOnClickListener(this);
		ll_menu = (LinearLayout) findViewById(R.id.ll_menu);
		ll_menu.setOnClickListener(this);
		shop = (LinearLayout) findViewById(R.id.shop);
		shop.setBackground(null);
		btn_collect = (Button) findViewById(R.id.btn_collect);
		btn_collect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_back:
			this.finish();
			break;
		case R.id.ll_menu:

			break;
		case R.id.btn_collect:

			break;
		default:
			break;
		}
	}
}
