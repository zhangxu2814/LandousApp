package com.zykj.landous.fragment;

import com.zykj.landous.R;

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

	ImageView tab_onebg;
	ImageView tab_twobg;
	ImageView tab_threebg;
	ImageView tab_fourbg;
	ImageView tab_fivebg;

	private static TextView shopping_cart_num;
	private static LinearLayout shopping_cart_num_bg;

	private SharedPreferences shared;
	private SharedPreferences.Editor editor;
	B0_IndexFragment homeFragment;
	TestFragment searchFragment;
	TestFragment shoppingCartFragment;
	TestFragment profileFragment;

	public MainTabsFrament() {
	}

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

		shared = getActivity().getSharedPreferences("userInfo", 0);
		editor = shared.edit();

		return mainView;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		setRetainInstance(true);
	}

	void init(View mainView) {

		this.shopping_cart_num = (TextView) mainView
				.findViewById(R.id.shopping_cart_num);
		this.shopping_cart_num_bg = (LinearLayout) mainView
				.findViewById(R.id.shopping_cart_num_bg);

		this.tab_one = (ImageView) mainView.findViewById(R.id.toolbar_tabone);
		this.tab_onebg = (ImageView) mainView
				.findViewById(R.id.toolbar_tabonebg);
		this.tab_one.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_one");
			}
		});

		this.tab_two = (ImageView) mainView.findViewById(R.id.toolbar_tabtwo);
		this.tab_twobg = (ImageView) mainView
				.findViewById(R.id.toolbar_tabtwobg);
		this.tab_two.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_two");
			}
		});

		this.tab_three = (ImageView) mainView
				.findViewById(R.id.toolbar_tabthree);
		this.tab_threebg = (ImageView) mainView
				.findViewById(R.id.toolbar_tabthreebg);
		this.tab_three.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_three");
			}
		});

		this.tab_four = (ImageView) mainView.findViewById(R.id.toolbar_tabfour);
		this.tab_fourbg = (ImageView) mainView
				.findViewById(R.id.toolbar_tabfourbg);
		this.tab_four.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OnTabSelected("tab_four");
			}
		});
		this.tab_five = (ImageView) mainView.findViewById(R.id.toolbar_tabfive);
		this.tab_fivebg = (ImageView) mainView
				.findViewById(R.id.toolbar_tabfivebg);
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

			if (null == homeFragment) {
				homeFragment = new B0_IndexFragment();
			}

			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					homeFragment, "tab_one");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_active_icon);
			this.tab_two.setImageResource(R.drawable.footer_search_icon);
			this.tab_three
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_four.setImageResource(R.drawable.footer_user_icon);

			this.tab_onebg.setVisibility(View.VISIBLE);
			this.tab_twobg.setVisibility(View.INVISIBLE);
			this.tab_threebg.setVisibility(View.INVISIBLE);
			this.tab_fourbg.setVisibility(View.INVISIBLE);

		} else if (tabName == "tab_two") {

			searchFragment = new TestFragment();

			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					searchFragment, "tab_two");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_search_active_icon);
			this.tab_three
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_four.setImageResource(R.drawable.footer_user_icon);

			this.tab_onebg.setVisibility(View.INVISIBLE);
			this.tab_twobg.setVisibility(View.VISIBLE);
			this.tab_threebg.setVisibility(View.INVISIBLE);
			this.tab_fourbg.setVisibility(View.INVISIBLE);
		} else if (tabName == "tab_three") {
			shoppingCartFragment = new TestFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					shoppingCartFragment, "tab_three");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_search_icon);
			this.tab_three
					.setImageResource(R.drawable.footer_shopping_cart_active_icon);
			this.tab_four.setImageResource(R.drawable.footer_user_icon);

			this.tab_onebg.setVisibility(View.INVISIBLE);
			this.tab_twobg.setVisibility(View.INVISIBLE);
			this.tab_threebg.setVisibility(View.VISIBLE);
			this.tab_fourbg.setVisibility(View.INVISIBLE);
		} else if (tabName == "tab_four") {

			profileFragment = new TestFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					profileFragment, "tab_four");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_search_icon);
			this.tab_three
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_four.setImageResource(R.drawable.footer_user_active_icon);

			this.tab_onebg.setVisibility(View.INVISIBLE);
			this.tab_twobg.setVisibility(View.INVISIBLE);
			this.tab_threebg.setVisibility(View.INVISIBLE);
			this.tab_fourbg.setVisibility(View.VISIBLE);

		} else if (tabName == "tab_five") {
			profileFragment = new TestFragment();
			FragmentTransaction localFragmentTransaction = getFragmentManager()
					.beginTransaction();
			localFragmentTransaction.replace(R.id.fragment_container,
					profileFragment, "tab_five");
			localFragmentTransaction.commit();

			this.tab_one.setImageResource(R.drawable.footer_home_icon);
			this.tab_two.setImageResource(R.drawable.footer_search_icon);
			this.tab_three
					.setImageResource(R.drawable.footer_shopping_cart_icon);
			this.tab_four.setImageResource(R.drawable.footer_user_icon);
			this.tab_five.setImageResource(R.drawable.footer_user_active_icon);
			this.tab_onebg.setVisibility(View.INVISIBLE);
			this.tab_twobg.setVisibility(View.INVISIBLE);
			this.tab_threebg.setVisibility(View.INVISIBLE);
			this.tab_fourbg.setVisibility(View.INVISIBLE);
			this.tab_fivebg.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		// 登录成功返回到个人主页
		if (requestCode == 1) {
			if (data != null) {
				if (null == profileFragment) {
					profileFragment = new TestFragment();
				}

				FragmentTransaction localFragmentTransaction = getFragmentManager()
						.beginTransaction();
				localFragmentTransaction.replace(R.id.fragment_container,
						profileFragment, "tab_four");
				localFragmentTransaction.commit();

				this.tab_one.setImageResource(R.drawable.footer_home_icon);
				this.tab_two.setImageResource(R.drawable.footer_search_icon);
				this.tab_three
						.setImageResource(R.drawable.footer_shopping_cart_icon);
				this.tab_four
						.setImageResource(R.drawable.footer_user_active_icon);

				this.tab_onebg.setVisibility(View.INVISIBLE);
				this.tab_twobg.setVisibility(View.INVISIBLE);
				this.tab_threebg.setVisibility(View.INVISIBLE);
				this.tab_fourbg.setVisibility(View.VISIBLE);
			}
		} else if (requestCode == 2) {
			if (null != data) {
				if (null == shoppingCartFragment) {
					shoppingCartFragment = new TestFragment();
				}

				FragmentTransaction localFragmentTransaction = getFragmentManager()
						.beginTransaction();
				localFragmentTransaction.replace(R.id.fragment_container,
						shoppingCartFragment, "tab_three");
				localFragmentTransaction.commit();

				this.tab_one.setImageResource(R.drawable.footer_home_icon);
				this.tab_two.setImageResource(R.drawable.footer_search_icon);
				this.tab_three
						.setImageResource(R.drawable.footer_shopping_cart_active_icon);
				this.tab_four.setImageResource(R.drawable.footer_user_icon);

				this.tab_onebg.setVisibility(View.INVISIBLE);
				this.tab_twobg.setVisibility(View.INVISIBLE);
				this.tab_threebg.setVisibility(View.VISIBLE);
				this.tab_fourbg.setVisibility(View.INVISIBLE);
			}

		}
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