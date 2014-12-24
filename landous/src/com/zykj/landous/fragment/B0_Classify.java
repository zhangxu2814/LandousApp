package com.zykj.landous.fragment;

import com.zykj.landous.R;
import com.zykj.landous.activity.ClassifyActivity;
import com.zykj.landous.classify.AnimationSildingLayout;
import com.zykj.landous.classify.LeftViewAdapter;
import com.zykj.landous.classify.RightListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class B0_Classify extends Fragment implements OnClickListener {
	public ListView rightList;

	ListView leftList;
	RightListAdapter bb;
	LeftViewAdapter aa;
	public int foodpoition;
	public String leixingName;

	private int last_item = -1;
	private TextView oldView;
	String cities[][] = new String[][] {
			new String[] { "全部美食", "本帮江浙菜", "川菜", "粤菜", "湘菜", "东北菜", "台湾菜",
					"新疆/清真", "素菜", "火锅", "自助餐", "小吃快餐", "日本", "韩国料理", "东南亚菜",
					"西餐", "面包甜点", "其他" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部购物", "综合商场", "服饰鞋包", "运动户外", "珠宝饰品", "化妆品",
					"数码家电", "亲子购物", "家居建材", "书店", "书店", "眼镜店", "特色集市",
					"更多购物场所", "食品茶酒", "超市/便利店", "药店" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全", "咖啡厅", "酒吧", "茶馆", "KTV", "游乐游艺", "公园",
					"景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆", "桌面游戏",
					"更多休闲娱乐" },
			new String[] { "全部", "咖啡厅", "酒吧", "茶馆", "电影院", "游乐游艺", "公园",
					"景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆", "桌面游戏",
					"更多休闲娱乐" },
			new String[] { "全部休", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲娱", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲aaa", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏" }, };
	String food[] = new String[] { "全部频道", "美食", "休闲娱乐", "购物", "酒店", "丽人",
			"运动健身", "结婚", "亲子", "爱车", "生活服务", "美食", "休闲娱乐", "购物", "酒店", "丽人",
			"运动健身", "结婚", "亲子", "爱车", "生活服务" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.food, null);
		leftList = (ListView) view.findViewById(R.id.list);
		rightList = (ListView) view.findViewById(R.id.list1);
		final AnimationSildingLayout layout = (AnimationSildingLayout) view
				.findViewById(R.id.main_slayout);
		layout.initLayout(leftList, rightList);
		layout.setOnSildingFinishListener(new AnimationSildingLayout.OnSildingFinishListener() {
			@Override
			public void onSildingFinish() {
				// todo 处理rightview 移出界面的逻辑
			}
		});

		aa = new LeftViewAdapter(getActivity(), food, null, last_item);

		leftList.setAdapter(aa);
		leftList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				foodpoition = position;
				aa.setSelectedPosition(position);
				aa.notifyDataSetInvalidated();
				bb = new RightListAdapter(getActivity(), cities, foodpoition);

				rightList.setDivider(null);
				rightList.setAdapter(bb);

				layout.startSildingInAnimation(position);
			}
		});
		rightList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity(),
						cities[foodpoition % 10][position], Toast.LENGTH_LONG)
						.show();

			}
		});
		// update();

		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
