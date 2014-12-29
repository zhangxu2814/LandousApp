package com.zykj.landous.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zykj.landous.R;

public class E0_ProfileFragment  extends Fragment implements OnClickListener{

	private View view;
	private View headView;
	private ListView listView;
	
	private ImageView setting;
	private ImageView camera;
	
	private TextView name;
	private FrameLayout payment;
	private TextView payment_num;
	private FrameLayout ship;
	private TextView ship_num;
	private FrameLayout receipt;
	private TextView receipt_num;
	private FrameLayout history;
	private TextView history_num;
	private TextView collect_num;
	
	private LinearLayout collect;
	private LinearLayout notify;
	private LinearLayout address_manage;

    private LinearLayout memberLevelLayout;
    private TextView     memberLevelName;
    private ImageView    memberLevelIcon;

    private LinearLayout help;
	
	
	private SharedPreferences shared;
	private SharedPreferences.Editor editor;
	
	private ImageView image;
	private String uid;
	public static boolean isRefresh = false;

    protected Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.e0_profile, null);
		
		mContext = getActivity();
		
		shared = getActivity().getSharedPreferences("userInfo", 0); 
		editor = shared.edit();

        headView = LayoutInflater.from(getActivity()).inflate(R.layout.e0_profile_fragment, null);

        image = (ImageView) view.findViewById(R.id.profile_setting);
        image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
//				Intent intent = new Intent(getActivity(), G0_SettingActivity.class);
//				startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.push_right_in,
//                        R.anim.push_right_out);
			}
		});
        listView = (ListView) view.findViewById(R.id.profile_list);
        listView.addHeaderView(headView);

		listView.setAdapter(null);
		
        memberLevelLayout = (LinearLayout)headView.findViewById(R.id.member_level_layout);
        memberLevelName   = (TextView)headView.findViewById(R.id.member_level);
        memberLevelIcon   = (ImageView)headView.findViewById(R.id.member_level_icon);

		setting  = (ImageView) headView.findViewById(R.id.profile_head_setting);

//		camera = (ImageView) headView.findViewById(R.id.profile_head_camera);
		name = (TextView) headView.findViewById(R.id.profile_head_name);
		
		payment = (FrameLayout) headView.findViewById(R.id.profile_head_payment);
		payment_num = (TextView) headView.findViewById(R.id.profile_head_payment_num);
		
		ship = (FrameLayout) headView.findViewById(R.id.profile_head_ship);
		ship_num = (TextView) headView.findViewById(R.id.profile_head_ship_num);
		
		receipt = (FrameLayout) headView.findViewById(R.id.profile_head_receipt);
		receipt_num = (TextView) headView.findViewById(R.id.profile_head_receipt_num);
		
		history = (FrameLayout) headView.findViewById(R.id.profile_head_history);
		history_num = (TextView) headView.findViewById(R.id.profile_head_history_num);
		
		collect = (LinearLayout) headView.findViewById(R.id.profile_head_collect);
		notify = (LinearLayout) headView.findViewById(R.id.profile_head_notify);
		address_manage = (LinearLayout) headView.findViewById(R.id.profile_head_address_manage);
		collect_num = (TextView) headView.findViewById(R.id.profile_head_collect_num);
        help = (LinearLayout)headView.findViewById(R.id.profile_help);
		
		setting.setOnClickListener(this);
//		camera.setOnClickListener(this);
		payment.setOnClickListener(this);
		ship.setOnClickListener(this);
		receipt.setOnClickListener(this);
		history.setOnClickListener(this);
		collect.setOnClickListener(this);
		notify.setOnClickListener(this);
		address_manage.setOnClickListener(this);
		name.setOnClickListener(this);
        help.setOnClickListener(this);

//		if (uid.equals("")) {
//			Resources resource = mContext.getResources();
//            String click=resource.getString(R.string.click_to_login);
//			name.setText(click);
//			camera.setVisibility(View.GONE);
//            memberLevelLayout.setVisibility(View.GONE);
//		} else {
//			camera.setVisibility(View.VISIBLE);
//            memberLevelLayout.setVisibility(View.VISIBLE);
//		}
		
		return view;

	}

	@Override
	public void onClick(View v) {
		
		
	}
}
