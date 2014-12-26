package com.zykj.landous.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zykj.landous.MainActivity;
import com.zykj.landous.R;
import com.zykj.landous.activity.B1_GoodListActivity;
import com.zykj.landous.adapter.ClassAdapter;
import com.zykj.landous.classify.LeftViewAdapter;
import com.zykj.landous.classify.MiddleAdapter;

public class B0_Classify extends Fragment implements OnClickListener {
	public ListView rightList;

	private ListView lv_class1 = null;
	private ListView lv_class2 = null;
	private ListView lv_class3 = null;
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
	String food[] = new String[] { "休闲食品", "个人洗护", "酒水饮料", "油粮调味", "家庭清洁",
			"生活日用", "家用电器", "办公礼品" };
	String str3[][][] = new String[][][] { cities, cities, cities, cities,
			cities };
	private int one, two;
	private ClassAdapter ca1;
	ClassAdapter ca2;
	ClassAdapter ca3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_classify, null);
		lv_class1 = (ListView) view.findViewById(R.id.lv_classs1);
		lv_class2 = (ListView) view.findViewById(R.id.lv_classs2);
		lv_class3 = (ListView) view.findViewById(R.id.lv_classs3);
		ca1 = new ClassAdapter(getActivity(), food);
		lv_class1.setAdapter(ca1);
		lv_class1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				ca2 = new ClassAdapter(getActivity(), cities[arg2]);
				one = arg2;
				ca1.setItem(one);
				ca1.notifyDataSetChanged();
				lv_class2.setAdapter(ca2);
				lv_class2.setVisibility(View.VISIBLE);
				lv_class3.setVisibility(View.GONE);
				lv_class1.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 2));
				lv_class2.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
			}
		});
		lv_class2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				two = arg2;
				ca2.setItem(two);
				ca2.notifyDataSetChanged();
				ClassAdapter ca3 = new ClassAdapter(getActivity(),
						str3[one][two]);
				lv_class3.setAdapter(ca3);
				lv_class3.setVisibility(View.VISIBLE);
				lv_class1.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
				lv_class2.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
				lv_class3.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));

			}
		});
		lv_class3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent it = new Intent(getActivity(), B1_GoodListActivity.class);
				startActivity(it);
			}
		});
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
