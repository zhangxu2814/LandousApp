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
import com.zykj.landous.adapter.B0_ClassLeftAdapter;
import com.zykj.landous.adapter.B0_ClassMiddle_Adapter;
import com.zykj.landous.adapter.B0_ClassRightAdapter;
import com.zykj.landous.classify.LeftViewAdapter;
import com.zykj.landous.classify.MiddleAdapter;

public class B0_Classify extends Fragment implements OnClickListener {
	private ListView lv_class_left = null;
	private ListView lv_class_middle = null;
	private ListView lv_class_right = null;
	String str_class_two[][] = new String[][] {
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
	String str_class_one[] = new String[] { "休闲食品", "个人洗护", "酒水饮料", "油粮调味",
			"家庭清洁", "生活日用", "家用电器", "办公礼品" };
	String str_class_three[][][] = new String[][][] { str_class_two,
			str_class_two, str_class_two, str_class_two, str_class_two };
	private int one, two;
	B0_ClassLeftAdapter class_ada_one;
	B0_ClassMiddle_Adapter class_ada_two;
	B0_ClassRightAdapter class_ada_three;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.b0_classify, null);
		lv_class_left = (ListView) view.findViewById(R.id.lv_class_left);
		lv_class_middle = (ListView) view.findViewById(R.id.lv_class_middle);
		lv_class_right = (ListView) view.findViewById(R.id.lv_class_right);
		class_ada_one = new B0_ClassLeftAdapter(getActivity(), str_class_one);
		lv_class_left.setAdapter(class_ada_one);
		lv_class_left.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				class_ada_two = new B0_ClassMiddle_Adapter(getActivity(),
						str_class_two[arg2%str_class_two.length]);
				one = arg2;
				class_ada_one.setItem(one);
				class_ada_one.notifyDataSetChanged();
				lv_class_middle.setAdapter(class_ada_two);
				lv_class_middle.setVisibility(View.VISIBLE);
				lv_class_right.setVisibility(View.GONE);
				lv_class_left.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 2));
				lv_class_middle.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
			}
		});
		lv_class_middle.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				two = arg2;
				class_ada_two.setItem(two);
				class_ada_two.notifyDataSetChanged();
				B0_ClassRightAdapter class_ada_three = new B0_ClassRightAdapter(
						getActivity(), str_class_three[one%str_class_three.length][two%str_class_three.length]);
				lv_class_right.setAdapter(class_ada_three);
				lv_class_right.setVisibility(View.VISIBLE);
				lv_class_left.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
				lv_class_middle.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));
				lv_class_right.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT, 1));

			}
		});
		lv_class_right.setOnItemClickListener(new OnItemClickListener() {

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
