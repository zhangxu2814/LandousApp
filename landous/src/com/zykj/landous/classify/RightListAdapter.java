package com.zykj.landous.classify;

import java.util.List;

import com.zykj.landous.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class RightListAdapter extends BaseAdapter {
	List<String> lst1;
	Context context;
	LayoutInflater layoutInflater;
	String[][] cities;
	public int foodpoition;

	/*
	 * public adapter1(Context context, List<String> lst1) { this.context =
	 * context; this.lst1 = lst1; layoutInflater =
	 * (LayoutInflater)context.getSystemService
	 * (Context.LAYOUT_INFLATER_SERVICE); }
	 */
	public RightListAdapter(Context context, String[][] cities, int position) {
		this.context = context;
		this.cities = cities;
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.foodpoition = position;
	}

	@Override
	public int getCount() {

		return cities.length;
	}

	@Override
	public Object getItem(int position) {

		return getItem(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.listitem1, null);
			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) convertView
					.findViewById(R.id.textview1);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView.setText(cities[foodpoition%10][position%10]);
		viewHolder.textView.setTextColor(Color.BLACK);
		return convertView;
	}

	public static class ViewHolder {
		public TextView textView;
	}

}
