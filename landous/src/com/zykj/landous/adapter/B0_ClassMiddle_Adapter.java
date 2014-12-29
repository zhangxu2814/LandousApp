package com.zykj.landous.adapter;

import com.zykj.landous.R;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class B0_ClassMiddle_Adapter extends BaseAdapter {

	private String[] res;
	private Activity context;
	private int item = -1;

	public B0_ClassMiddle_Adapter(Activity context, String[] res) {
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
		view.setHeight(20);
		view.setGravity(Gravity.CENTER);
		DisplayMetrics dm = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		view.setWidth(dm.widthPixels / 3);
		if (item != -1 && arg0 == item) {
			view.setBackgroundResource(R.drawable.b0_class_middleactbg);
		} else {
			view.setBackgroundResource(R.drawable.b0_class_middlebg);
		}

		view.setText(this.res[arg0]);
		view.setTextColor(Color.DKGRAY );
		return view;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

}
