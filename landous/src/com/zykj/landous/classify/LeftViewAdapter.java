package com.zykj.landous.classify;

import java.util.List;

import com.zykj.landous.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LeftViewAdapter extends BaseAdapter {
	Context context;
	private List<String> lst;
	LayoutInflater inflater;
	String[] foods;
	int last_item;
	int[] image;
	private int selectedPosition = -1;
	// 用来标示是否需要隐藏图片和描述文字
	private boolean hideFlag;

	public void setSelectedPosition(int position) {
		selectedPosition = position;
	}

	/*
	 * public myadapter(Context context,List<String > lst){ this.context =
	 * context; this.lst = lst; inflater =
	 * (LayoutInflater)context.getSystemService
	 * (Context.LAYOUT_INFLATER_SERVICE);
	 * 
	 * }
	 */
	public LeftViewAdapter(Context context, String[] foods, int[] image,
			int last_item) {
		this.context = context;
		this.foods = foods;
		this.image = image;
		this.last_item = last_item;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		return foods.length;
	}

	@Override
	public Object getItem(int position) {
		return foods[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listitem, null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.textview);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageview);
			holder.layout = (RelativeLayout) convertView
					.findViewById(R.id.colorlayout);
			holder.description = (TextView) convertView
					.findViewById(R.id.txt_description);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		/*
		 * if(last_item == position){
		 * holder.textView.setBackgroundColor(R.color.bg); }
		 */
		// 设置选中效果
		if (selectedPosition == position) {
			holder.textView.setTextColor(Color.BLUE);

			holder.layout.setBackgroundColor(Color.LTGRAY);
		} else {
			holder.textView.setTextColor(Color.WHITE);
			holder.layout.setBackgroundColor(Color.TRANSPARENT);
		}

		holder.textView.setText(foods[position]);
		holder.textView.setTextColor(Color.BLACK);
		// holder.imageView.setBackgroundResource(image[position%10]);
		if (hideFlag) {
			holder.imageView.setVisibility(View.INVISIBLE);
			holder.description.setVisibility(View.INVISIBLE);
		} else {
			holder.imageView.setVisibility(View.VISIBLE);
			holder.description.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

	public static class ViewHolder {
		public TextView textView;
		public ImageView imageView;
		public RelativeLayout layout;
		public TextView description;
	}

	public boolean isHideFlag() {
		return hideFlag;
	}

	public void setHideFlag(boolean hideFlag) {
		this.hideFlag = hideFlag;
	}
}
