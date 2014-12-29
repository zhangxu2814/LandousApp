package com.zykj.landous.adapter;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.BeeFramework.adapter.BeeBaseAdapter;
import com.baidu.mobstat.f;
import com.zykj.landous.R;

public class B1_GoodsAdapter extends BeeBaseAdapter {
	private ArrayList<Map<String, String>> dataList;
	private Context c;
	private LayoutInflater listContainer;
	private LinearLayout ll_spcar;

	public B1_GoodsAdapter(Context c, ArrayList<Map<String, String>> dataList) {
		super(c, dataList);
		// TODO Auto-generated constructor stub
		this.dataList = dataList;
		this.c = c;
		listContainer = LayoutInflater.from(c);
	}

	@Override
	protected BeeCellHolder createCellHolder(View cellView) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getViewTypeCount() {

		return 1000;
	}

	@Override
	protected View bindData(int position, View cellView, ViewGroup parent,
			BeeCellHolder h) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getItemViewType(int position) {
		return position;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		// return dataList.size();
		return 30;
	}

	@Override
	public View createCellView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView(final int position, View cellView, ViewGroup parent) {
		if (cellView == null) {
			cellView = listContainer.inflate(R.layout.b1_goodslistitem, null);
		}
		TextView tv_title = (TextView) cellView.findViewById(R.id.tv_title);
		TextView tv_price = (TextView) cellView.findViewById(R.id.tv_price);
		TextView tv_oldprice = (TextView) cellView
				.findViewById(R.id.tv_oldprice);
		tv_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		ll_spcar = (LinearLayout) cellView.findViewById(R.id.ll_spcar);
		ll_spcar.setOnClickListener(new Mylistener(position));
		cellView.setOnClickListener(new Mylistener(position));
		return cellView;

	}

	class Mylistener implements View.OnClickListener {
		int position;

		public Mylistener(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(c, position + 1 + "被点击了", Toast.LENGTH_LONG).show();

		}

	}

}
