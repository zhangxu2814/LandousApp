package com.zykj.landous.activity;

import com.BeeFramework.activity.BaseActivity;
import com.external.maxwin.view.XListView.IXListViewListener;
import com.zykj.landous.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

/**
 * 店铺商品分类
 * 
 * @author zhangxu
 * 
 */

public class C2_ShopClassActivity extends BaseActivity implements
		IXListViewListener, OnClickListener {
	private ListView listview;
	String str[] = new String[] { "全部", "生鲜冷冻", "进口商品", "粮油", "牛奶", "洗涤", "护肤",
			"锅具", "箱包", "毛巾", "自有产品", "黄油奶酪" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c2_activityshopclass);
		init();
	}

	private void init() {
		listview = (ListView) findViewById(R.id.listview);

	}

	@Override
	public void onClick(View arg0) {

	}

	@Override
	public void onRefresh(int id) {

	}

	@Override
	public void onLoadMore(int id) {

	}
}
