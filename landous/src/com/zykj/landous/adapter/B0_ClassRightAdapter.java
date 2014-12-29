package com.zykj.landous.adapter;

import com.zykj.landous.R.color;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class B0_ClassRightAdapter extends BaseAdapter {

	private String[] res;
	private Activity context;
	private int item = -1;

	public B0_ClassRightAdapter(Activity context, String[] res) {
		this.context = context;
		this.res = res;

	}

	@Override
	public int getCount() {
		if (res == null)
			return 0;
		else
			return res.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return res[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		TextView view = new TextView(context);
		view.setGravity(Gravity.CENTER);
		DisplayMetrics dm = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		view.setWidth(dm.widthPixels / 3);
		view.setHeight(120);

		view.setBackgroundColor(android.graphics.Color.parseColor("#EC9F32"));
		view.setText(this.res[arg0]);
		view.setTextColor(Color.WHITE);
		return view;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

}
