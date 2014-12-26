package com.zykj.landous.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClassAdapter extends BaseAdapter {

	private String[] res;
	private String[][] str;
	private Activity context;
	private int item = -1;

	public ClassAdapter(Activity context, String[][] str) {
		this.context = context;
		this.str = str;
	}

	public ClassAdapter(Activity context, String[] res) {
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
		view.setHeight(100);
		view.setGravity(Gravity.CENTER | Gravity.LEFT);
		DisplayMetrics dm = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		view.setWidth(dm.widthPixels / 3);
		if (item != -1 && arg0 == item) {
			view.setBackgroundColor(Color.LTGRAY);
		}
		view.setText(this.res[arg0]);
		return view;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

}
