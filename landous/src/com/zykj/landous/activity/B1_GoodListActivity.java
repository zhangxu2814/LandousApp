package com.zykj.landous.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.BeeFramework.activity.BaseActivity;
import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import com.external.maxwin.view.XListView.IXListViewListener;
import com.zykj.landous.R;
import com.zykj.landous.adapter.B1_GoodsAdapter;
import com.zykj.landous.view.MyListView;

public class B1_GoodListActivity extends BaseActivity implements
		BusinessResponse, IXListViewListener, OnClickListener {
	private LinearLayout ll_tab1, ll_tab2, ll_tab3, ll_tab4;
	private LinearLayout[] tabs = null;
	private MyListView mGoodsListview;
	private int tabs_type = 0;
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			tabs[msg.what].setBackgroundResource(R.drawable.icon_sort_below);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b1_listofgoods);
		init();
	}

	private void init() {
		ll_tab1 = (LinearLayout) findViewById(R.id.ll_tab1);
		ll_tab1.setOnClickListener(this);
		ll_tab2 = (LinearLayout) findViewById(R.id.ll_tab2);
		ll_tab2.setOnClickListener(this);
		ll_tab3 = (LinearLayout) findViewById(R.id.ll_tab3);
		ll_tab3.setOnClickListener(this);
		ll_tab4 = (LinearLayout) findViewById(R.id.ll_tab4);
		ll_tab4.setOnClickListener(this);
		tabs = new LinearLayout[] { ll_tab1, ll_tab2, ll_tab3, ll_tab4 };
		mGoodsListview = (MyListView) findViewById(R.id.goodslistview);
		mGoodsListview.setPullLoadEnable(false);
		mGoodsListview.setPullRefreshEnable(true);
		mGoodsListview.setXListViewListener(this, 0);
		mGoodsListview.setRefreshTime();
		B1_GoodsAdapter goodsAdapter = new B1_GoodsAdapter(this, null);
		mGoodsListview.setAdapter(goodsAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_tab1:
			setBg(0);
			break;
		case R.id.ll_tab2:
			setBg(1);
			break;
		case R.id.ll_tab3:
			setBg(2);
			break;
		case R.id.ll_tab4:
			setBg(3);
			break;

		}

	}

	private void setBg(int p) {
		int bgid = tabs_type % 2 == 0 ? R.drawable.icon_sort_act_below
				: R.drawable.icon_sort_act_top;
		tabs_type++;
		tabs[p].setBackgroundResource(bgid);
		for (int i = 0; i <= 3; i++) {
			if (i != p) {
				Message message = new Message();
				message.what = i;
				mHandler.sendMessage(message);
			}
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

	@Override
	public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status)
			throws JSONException {
		// TODO Auto-generated method stub

	}

}
