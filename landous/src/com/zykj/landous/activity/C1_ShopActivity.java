package com.zykj.landous.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.BeeFramework.activity.BaseActivity;
import com.external.maxwin.view.XListView.IXListViewListener;
import com.zykj.landous.R;
import com.zykj.landous.adapter.C1_ShopAdapter;
import com.zykj.landous.view.MyListView;

public class C1_ShopActivity extends BaseActivity implements
		IXListViewListener, OnClickListener {
	private LinearLayout ll_back;
	private LinearLayout ll_menu;
	private LinearLayout shop;
	/**
	 * 收藏按钮
	 */
	private Button btn_collect;
	private MyListView listview;
	private C1_ShopAdapter shopAdapter;
	private Intent it;

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
		listview = (MyListView) findViewById(R.id.listview);
		shopAdapter = new C1_ShopAdapter(getApplicationContext(), null);
		listview.setPullLoadEnable(false);
		listview.setPullRefreshEnable(true);
		listview.setXListViewListener(this, 0);
		listview.setRefreshTime();
		listview.setAdapter(shopAdapter);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_back:
			this.finish();
			break;
		case R.id.ll_menu:
			it = new Intent(getApplicationContext(), C2_ShopClassActivity.class);
			startActivity(it);
			break;
		case R.id.btn_collect:

			break;
		default:
			break;
		}
	}

	@Override
	public void onRefresh(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoadMore(int id) {
		// TODO Auto-generated method stub

	}
}
