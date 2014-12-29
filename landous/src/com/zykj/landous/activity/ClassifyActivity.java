package com.zykj.landous.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zykj.landous.R;
import com.zykj.landous.adapter.B0_ClassLeftAdapter;

public class ClassifyActivity extends Activity implements OnItemClickListener {

	private ListView lv_class1 = null;
	private ListView lv_class2 = null;
	private ListView lv_class3 = null;
	String[] str = new String[] { "休闲食品", "个人洗护", "酒水饮料" };
	String[] str1 = new String[] { "西安", "汉中", "咸阳" };
	String[] str2 = new String[] { "莲湖区", "碑林区", "雁塔区" };
	private int flag = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b0_classify);
		loadView();
	}

	private void loadView() {
		lv_class1 = (ListView) findViewById(R.id.lv_class_left);
		lv_class2 = (ListView) findViewById(R.id.lv_class_middle);
		lv_class3 = (ListView) findViewById(R.id.lv_class_right);
		B0_ClassLeftAdapter ca = new B0_ClassLeftAdapter(ClassifyActivity.this,
				str);
		lv_class1.setAdapter(ca);
		lv_class1.setOnItemClickListener(this);
		lv_class2.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		if (flag == 0 || flag == 2) {

			if (flag == 2) {
				lv_class3.setVisibility(View.GONE);
			}
			B0_ClassLeftAdapter ca = new B0_ClassLeftAdapter(
					ClassifyActivity.this, str1);
			lv_class2.setAdapter(ca);
			lv_class2.setVisibility(View.VISIBLE);
			lv_class1.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 4));
			lv_class2.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 2));
			flag = 1;

		} else if (flag == 1) {
			B0_ClassLeftAdapter ca = new B0_ClassLeftAdapter(
					ClassifyActivity.this, str2);
			lv_class3.setAdapter(ca);
			lv_class3.setVisibility(View.VISIBLE);
			lv_class1.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 3));
			lv_class2.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 3));
			lv_class3.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 2));
			flag = 2;
		}
	}

}
