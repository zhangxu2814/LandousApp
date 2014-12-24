package com.zykj.landous.fragment;

import com.zykj.landous.R;
import com.zykj.landous.activity.ClassifyActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainTabsFrament extends Fragment {

	ImageView tab_one;
	ImageView tab_two;
	ImageView tab_three;
	ImageView tab_four;
	ImageView tab_five;

	private static TextView shopping_cart_num;
	private static LinearLayout shopping_cart_num_bg;

	B0_IndexFragment homeFragment;
	B0_Classify classifyFragment;

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mainView = inflater.inflate(R.layout.tool_bar, container, false);
		init(mainView);

		return mainView;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		// setRetainInstance(true);
	}

	void init(View mainView) {

		this.shopping_cart_num = (TextView) mainView
				.findViewById(R.id.shopping_cart_num);
		this.shopping_cart_num_bg = (LinearLayout) mainView
				.findViewById(R.id.shopping_cart_num_bg);

		this.tab_one = (ImageView) mainView.findViewById(R.id.toolbar_tabone);
		this.tab_one.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_one");
			}
		});

		this.tab_two = (ImageView) mainView.findViewById(R.id.toolbar_tabtwo);
		this.tab_two.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_two");
			}
		});

		this.tab_three = (ImageView) mainView
				.findViewById(R.id.toolbar_tabthree);
		this.tab_three.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_three");
			}
		});

		this.tab_four = (ImageView) mainView.findViewById(R.id.toolbar_tabfour);
		this.tab_four.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_four");
			}
		});
		this.tab_five = (ImageView) mainView.findViewById(R.id.toolbar_tabfive);
		this.tab_five.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_five");
			}
		});

		OnTabSelected("tab_one");
	}

	void OnTabSelected(String tabName) {
		if (tabName == "tab_one") {
			homeFragment = null;
			if (null == homeFragment) {
				homeFragment = new B0_IndexFragment();
			}

			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					homeFragment, "tab_one");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_active_icon);
			this.tab_two.setImageResource(R.drawable.footer_sort_icon);
			this.tab_three.setImageResource(R.drawable.footer_shop_icon);
			this.tab_four
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_five.setImageResource(R.drawable.footer_user_icon);

		} else if (tabName == "tab_two") {
//			Intent it = new Intent(getActivity(), ClassifyActivity.class);
//			startActivity(it);

			 classifyFragment = new B0_Classify();
			
			 FragmentTransaction localFragmentTransaction =
			 getFragmentManager()
			 .beginTransaction();
			 localFragmentTransaction.replace(R.id.fragment_container,
			 classifyFragment, "tab_two");
			 localFragmentTransaction.commit();
			
			 this.tab_one.setImageResource(R.drawable.footer_home_icon);
			 this.tab_two.setImageResource(R.drawable.footer_sort_activity_icon);
			 this.tab_three.setImageResource(R.drawable.footer_shop_icon);
			 this.tab_four
			 .setImageResource(R.drawable.footer_shopping_cart_icon);
			 this.tab_five.setImageResource(R.drawable.footer_user_icon);

		} else if (tabName == "tab_three") {
			homeFragment = new B0_IndexFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					homeFragment, "tab_three");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_sort_icon);
			this.tab_three.setImageResource(R.drawable.footer_shop_active_icon);
			this.tab_four
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_five.setImageResource(R.drawable.footer_user_icon);
		} else if (tabName == "tab_four") {

			homeFragment = new B0_IndexFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					homeFragment, "tab_four");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_sort_icon);
			this.tab_three.setImageResource(R.drawable.footer_shop_icon);
			this.tab_four
					.setImageResource(R.drawable.footer_shopping_cart_active_icon);
			this.tab_five.setImageResource(R.drawable.footer_user_icon);

		} else if (tabName == "tab_five") {
			homeFragment = new B0_IndexFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					homeFragment, "tab_five");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_sort_icon);
			this.tab_three.setImageResource(R.drawable.footer_shop_icon);
			this.tab_four
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_five.setImageResource(R.drawable.footer_user_active_icon);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		// if (requestCode == 1) {
		// if (data != null) {
		// if (null == homeFragment) {
		// homeFragment = new B0_IndexFragment();
		// }
		//
		// FragmentTransaction localFragmentTransaction = getFragmentManager()
		// .beginTransaction();
		// localFragmentTransaction.replace(R.id.fragment_container,
		// homeFragment, "tab_four");
		// localFragmentTransaction.commit();
		//
		// this.tab_one.setImageResource(R.drawable.footer_home_icon);
		// this.tab_two.setImageResource(R.drawable.footer_sort_icon);
		// this.tab_three
		// .setImageResource(R.drawable.footer_shopping_cart_icon);
		// this.tab_four
		// .setImageResource(R.drawable.footer_user_active_icon);
		//
		// }
		// } else if (requestCode == 2) {
		// if (null != data) {
		// if (null == homeFragment) {
		// homeFragment = new B0_IndexFragment();
		// }
		//
		// FragmentTransaction localFragmentTransaction = getFragmentManager()
		// .beginTransaction();
		// localFragmentTransaction.replace(R.id.fragment_container,
		// homeFragment, "tab_three");
		// localFragmentTransaction.commit();
		//
		// this.tab_one.setImageResource(R.drawable.footer_home_icon);
		// this.tab_two.setImageResource(R.drawable.footer_sort_icon);
		// this.tab_three
		// .setImageResource(R.drawable.footer_shopping_cart_active_icon);
		// this.tab_four.setImageResource(R.drawable.footer_user_icon);
		//
		// }
		//
		// }
	}

	@Override
	public void onResume() {

		super.onResume();
		// setShoppingcartNum();
	}

	// public static void setShoppingcartNum() {
	// if(ShoppingCartModel.getInstance().goods_num == 0) {
	// shopping_cart_num_bg.setVisibility(View.GONE);
	// } else {
	// shopping_cart_num_bg.setVisibility(View.VISIBLE);
	// shopping_cart_num.setText(ShoppingCartModel.getInstance().goods_num+"");
	// }
	// }

}