package com.zykj.landous.fragment;

import com.zykj.landous.R;
import com.zykj.landous.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class D0_ShopingCartFragment extends Fragment {
	private FrameLayout shop_car_null;
	private View view;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
				view = inflater.inflate(R.layout.d0_shoping_cart_fragment, null);
				shop_car_null = (FrameLayout) view.findViewById(R.id.shop_car_null);
				shop_car_null.setVisibility(View.VISIBLE);
				return view;
				
	}
	
}
