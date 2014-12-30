package com.zykj.landous.fragment;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import com.external.maxwin.view.XListView.IXListViewListener;
import com.zykj.landous.R;
import com.zykj.landous.adapter.C0_ShopsAdapter;
import com.zykj.landous.view.MyListView;

public class C0_ShopsFragment extends Fragment implements BusinessResponse,
		IXListViewListener, OnClickListener {
	private LinearLayout ll_tabs;
	private C0_ShopsAdapter shopsApapter;
	private MyListView mShopsListview;
	private ImageView iv_share;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.c0_shops_fragment, null);
		ll_tabs = (LinearLayout) view.findViewById(R.id.ll_tabs);
		ll_tabs.setVisibility(View.GONE);
		iv_share=(ImageView)view.findViewById(R.id.iv_share);
		iv_share.setVisibility(View.INVISIBLE);
		shopsApapter = new C0_ShopsAdapter(getActivity()
				.getApplicationContext(), null);
		mShopsListview = (MyListView) view.findViewById(R.id.listview);
		mShopsListview.setPullLoadEnable(false);
		mShopsListview.setPullRefreshEnable(true);
		mShopsListview.setXListViewListener(this, 0);
		mShopsListview.setRefreshTime();
		mShopsListview.setAdapter(shopsApapter);

		return view;
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status)
			throws JSONException {
		// TODO Auto-generated method stub

	}
}
