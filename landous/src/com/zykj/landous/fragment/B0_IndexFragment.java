package com.zykj.landous.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.baidu.mobstat.f;
import com.zykj.landous.R;
import com.zykj.landous.Tools.Share;
import com.zykj.landous.Tools.ToastView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class B0_IndexFragment extends Fragment implements OnClickListener {
	// 轮播图 start
	private ImageView[] imageViews;
	private List<View> pageViews;
	private ImageView imageView;
	private AdPageAdapter adapter;
	ImageView[] img;
	private LinearLayout pagerLayout;
	private ViewPager adViewPager;
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	private boolean isContinue = true;
	/*
	 * 每隔固定时间切换广告栏图片
	 */
	private final Handler viewHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			adViewPager.setCurrentItem(msg.what);
			super.handleMessage(msg);

		}

	};

	// 轮播图 end
	/**
	 * 休闲食品
	 */
	private ImageView iv_leisurefood;
	/**
	 * 家庭清洁
	 */
	private ImageView iv_homecleaners;
	/**
	 * 个人洗护
	 */
	private ImageView iv_personalcare;
	/**
	 * 生活用品
	 */
	private ImageView iv_supplies;
	/**
	 * 酒水饮料
	 */
	private ImageView iv_beverages;
	/**
	 * 家用电器
	 */
	private ImageView iv_appliance;
	/**
	 * 粮油调味
	 */
	private ImageView iv_condiment;
	/**
	 * 办公礼品
	 */
	private ImageView iv_officegifts;
//	/**
//	 * 分享按钮 
//	 */
//	private ImageView iv_share;
	
/**
 * 分享
 */
	private LinearLayout ll_share;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index, null);
		init(view);
		return view;
	}

	private void init(View view) {
		iv_leisurefood = (ImageView) view.findViewById(R.id.iv_leisurefood);
		iv_leisurefood.setOnClickListener(this);
		iv_homecleaners = (ImageView) view.findViewById(R.id.iv_homecleaners);
		iv_homecleaners.setOnClickListener(this);
		iv_personalcare = (ImageView) view.findViewById(R.id.iv_personalcare);
		iv_personalcare.setOnClickListener(this);
		iv_supplies = (ImageView) view.findViewById(R.id.iv_supplies);
		iv_supplies.setOnClickListener(this);
		iv_beverages = (ImageView) view.findViewById(R.id.iv_beverages);
		iv_beverages.setOnClickListener(this);
		iv_appliance = (ImageView) view.findViewById(R.id.iv_appliance);
		iv_appliance.setOnClickListener(this);
		iv_condiment = (ImageView) view.findViewById(R.id.iv_condiment);
		iv_condiment.setOnClickListener(this);
		iv_officegifts = (ImageView) view.findViewById(R.id.iv_officegifts);
		iv_officegifts.setOnClickListener(this);
//		iv_share=(ImageView)view.findViewById(R.id.iv_share);
//		iv_share.setOnClickListener(this);
		ll_share=(LinearLayout)view.findViewById(R.id.ll_share);
		ll_share.setOnClickListener(this);

		// 从布局文件中获取ViewPager父容器
		pagerLayout = (LinearLayout) view.findViewById(R.id.view_pager_content);
		// 创建ViewPager
		adViewPager = new ViewPager(getActivity());

		// 获取屏幕像素相关信息
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		// 根据屏幕信息设置ViewPager广告容器的宽高
		adViewPager.setLayoutParams(new LayoutParams(dm.widthPixels,
				dm.heightPixels * 2 / 9));

		// 将ViewPager容器设置到布局文件父容器中
		pagerLayout.addView(adViewPager);
		initPageAdapter();
		initCirclePoint(view);
		adViewPager.setAdapter(adapter);
		adViewPager.setOnPageChangeListener(new AdPageChangeListener());
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (isContinue) {
						viewHandler.sendEmptyMessage(atomicInteger.get());
						atomicOption();

					}
				}
			}
		}).start();

	}

	protected void atomicOption() {
		atomicInteger.incrementAndGet();
		if (atomicInteger.get() > imageViews.length - 1) {
			atomicInteger.getAndAdd(-5);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * ViewPager 页面改变监听器
	 */
	private final class AdPageChangeListener implements OnPageChangeListener {

		/**
		 * 页面滚动状态发生改变的时候触发
		 */
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		/**
		 * 页面滚动的时候触发
		 */
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		/**
		 * 页面选中的时候触发
		 */
		@Override
		public void onPageSelected(int arg0) {
			// 获取当前显示的页面是哪个页面
			atomicInteger.getAndSet(arg0);
			// 重新设置原点布局集合
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.drawable.point_focused);
				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.drawable.point_unfocused);
				}
			}
		}
	}

	private void initCirclePoint(View view) {
		ViewGroup group = (ViewGroup) view.findViewById(R.id.viewGroup);
		imageViews = new ImageView[pageViews.size()];
		for (int i = 0; i < pageViews.size(); i++) {
			// 创建一个ImageView, 并设置宽高. 将该对象放入到数组中
			imageView = new ImageView(getActivity());
			imageView.setLayoutParams(new LayoutParams(10, 10));
			imageViews[i] = imageView;

			// 初始值, 默认第0个选中
			if (i == 0) {
				imageViews[i].setBackgroundResource(R.drawable.point_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.point_unfocused);
			}
			// 将小圆点放入到布局中
			group.addView(imageViews[i]);
		}

	}

	private void initPageAdapter() {
		// TODO Auto-generated method stub
		pageViews = new ArrayList<View>();
		img = new ImageView[3];
		img[0] = new ImageView(getActivity());
		img[0].setImageResource(R.drawable.ad1);
		img[1] = new ImageView(getActivity());
		img[1].setImageResource(R.drawable.ad3);
		img[2] = new ImageView(getActivity());
		img[2].setImageResource(R.drawable.ad0);

		img[0].setScaleType(ScaleType.FIT_XY);
		img[1].setScaleType(ScaleType.FIT_XY);
		img[2].setScaleType(ScaleType.FIT_XY);
		pageViews.add(img[2]);
		pageViews.add(img[0]);
		pageViews.add(img[1]);

		adapter = new AdPageAdapter(pageViews);

	}

	private final class AdPageAdapter extends PagerAdapter {
		private List<View> views = null;

		/**
		 * 初始化数据源, 即View数组
		 */
		public AdPageAdapter(List<View> views) {
			this.views = views;
		}

		/**
		 * 从ViewPager中删除集合中对应索引的View对象
		 */
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}

		/**
		 * 获取ViewPager的个数
		 */
		@Override
		public int getCount() {
			return views.size();
		}

		/**
		 * 从View集合中获取对应索引的元素, 并添加到ViewPager中
		 */
		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(views.get(position), 0);
			return views.get(position);
		}

		/**
		 * 是否将显示的ViewPager页面与instantiateItem返回的对象进行关联 这个方法是必须实现的
		 */
		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_leisurefood:
			Toast.makeText(getActivity(), "休闲食品", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_homecleaners:
			Toast.makeText(getActivity(), "家庭清洁", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_personalcare:
			Toast.makeText(getActivity(), "个人洗护", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_supplies:
			Toast.makeText(getActivity(), "生活用品", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_beverages:
			Toast.makeText(getActivity(), "酒水饮料", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_appliance:
			Toast.makeText(getActivity(), "家用电器", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_condiment:
			Toast.makeText(getActivity(), "粮油调味", Toast.LENGTH_LONG).show();
			break;
		case R.id.iv_officegifts:
			Toast.makeText(getActivity(), "办公礼品", Toast.LENGTH_LONG).show();
			break;
		case R.id.ll_share:
			Share mShare=new Share(getActivity());
			mShare.show();
			break;
		default:
			break;
		}
	}
}
