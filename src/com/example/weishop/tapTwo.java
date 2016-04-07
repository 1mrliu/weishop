package com.example.weishop;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class tapTwo extends Fragment {
	public String[] data = { "热卖专区", "进口精品", "国产优选", "森林干果", "礼盒整箱", "新鲜果汁" };

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab02, container, false);

		// 商品分类
		final ListView lv_type = (ListView) view
				.findViewById(android.R.id.list);

		// 商品详细情况展示
		final ListView lv_1 = (ListView) view.findViewById(R.id.cont1);
		final ListView lv_2 = (ListView) view.findViewById(R.id.cont2);
		final ListView lv_3 = (ListView) view.findViewById(R.id.cont3);
		final ListView lv_4 = (ListView) view.findViewById(R.id.cont1);
		final ListView lv_5 = (ListView) view.findViewById(R.id.cont2);
		final ListView lv_6 = (ListView) view.findViewById(R.id.cont3);

		// getActivity使用在适配器中适用于Fragment中s
		ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, data);

		lv_type.setAdapter(typeAdapter);// 为ListView绑定适配器

		// 分类适配器类别添加点击事件
		lv_type.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// 获取当前的位置的文本内容
				// String text= (String) lv_type.getItemAtPosition(position);
				// Toast.makeText(MainActivity.this, text,
				// Toast.LENGTH_SHORT).show();

				if (data[position].equals("热卖专区")) 
				{
					lv_1.setVisibility(View.VISIBLE);
					lv_2.setVisibility(View.INVISIBLE);
				
					lv_3.setVisibility(View.INVISIBLE);
					lv_4.setVisibility(View.INVISIBLE);
					lv_5.setVisibility(View.INVISIBLE);
					lv_6.setVisibility(View.INVISIBLE);

				}
				if (data[position].equals("进口精品")) 
				{
					lv_1.setVisibility(View.INVISIBLE);
					lv_2.setVisibility(View.VISIBLE);
					lv_3.setVisibility(View.INVISIBLE);
					lv_4.setVisibility(View.INVISIBLE);
					lv_5.setVisibility(View.INVISIBLE);
					lv_6.setVisibility(View.INVISIBLE);
				}
				if (data[position].equals("国产优选")) 
				{
					lv_1.setVisibility(View.INVISIBLE);
					lv_2.setVisibility(View.INVISIBLE);
					lv_3.setVisibility(View.VISIBLE);
					lv_4.setVisibility(View.INVISIBLE);
					lv_5.setVisibility(View.INVISIBLE);
					lv_6.setVisibility(View.INVISIBLE);
				}
				if (data[position].equals("森林干果")) 
				{
					lv_1.setVisibility(View.INVISIBLE);
					lv_2.setVisibility(View.INVISIBLE);
					lv_3.setVisibility(View.INVISIBLE);
					lv_4.setVisibility(View.VISIBLE);
					lv_5.setVisibility(View.INVISIBLE);
					lv_6.setVisibility(View.INVISIBLE);
				}
				if (data[position].equals("礼盒整箱")) 
				{
					lv_1.setVisibility(View.INVISIBLE);
					lv_2.setVisibility(View.INVISIBLE);
					lv_3.setVisibility(View.INVISIBLE);
					lv_4.setVisibility(View.INVISIBLE);
					lv_5.setVisibility(View.VISIBLE);
					lv_6.setVisibility(View.INVISIBLE);
				}
				if (data[position].equals("新鲜果汁")) 
				{
					lv_1.setVisibility(View.INVISIBLE);
					lv_2.setVisibility(View.INVISIBLE);
					lv_3.setVisibility(View.INVISIBLE);
					lv_4.setVisibility(View.INVISIBLE);
					lv_5.setVisibility(View.INVISIBLE);
					lv_6.setVisibility(View.VISIBLE);
				}

			}
		});
		// 详细界面适配器
		// 热卖专区界面
		ArrayList<HashMap<String, Object>> listItem_1 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "热卖专区");
			map.put("descTextView", "第" + i + "行");
			listItem_1.add(map);
		}
		SimpleAdapter mSimpleAdapter_1 = new SimpleAdapter(getActivity(),
				listItem_1, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_1.setAdapter(mSimpleAdapter_1);// 为ListView绑定适配器
		/*
		 * lv.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { // TODO Auto-generated method stub } });
		 */
		// 进口精品界面
		ArrayList<HashMap<String, Object>> listItem_2 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "进口精品");
			map.put("descTextView", "第" + i + "行");
			listItem_2.add(map);
		}
		SimpleAdapter mSimpleAdapter_2 = new SimpleAdapter(getActivity(),
				listItem_2, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_2.setAdapter(mSimpleAdapter_2);// 为ListView绑定适配器
		
		// 国产优选界面
		ArrayList<HashMap<String, Object>> listItem_3 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "热卖专区");
			map.put("descTextView", "第" + i + "行");
			listItem_3.add(map);
		}
		SimpleAdapter mSimpleAdapter_3 = new SimpleAdapter(getActivity(),
				listItem_3, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_3.setAdapter(mSimpleAdapter_3);// 为ListView绑定适配器
		
		// 森林干果界面
		ArrayList<HashMap<String, Object>> listItem_4 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 6; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "森林干果");
			map.put("descTextView", "第" + i + "行");
			listItem_4.add(map);
		}
		SimpleAdapter mSimpleAdapter_4 = new SimpleAdapter(getActivity(),
				listItem_4, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_4.setAdapter(mSimpleAdapter_4);// 为ListView绑定适配器
		
		// 礼盒整箱界面
		ArrayList<HashMap<String, Object>> listItem_5 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "礼盒整箱");
			map.put("descTextView", "第" + i + "行");
			listItem_5.add(map);
		}
		SimpleAdapter mSimpleAdapter_5 = new SimpleAdapter(getActivity(),
				listItem_5, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_5.setAdapter(mSimpleAdapter_5);// 为ListView绑定适配器
		
		// 新鲜果汁界面
		ArrayList<HashMap<String, Object>> listItem_6 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "新鲜果汁");
			map.put("descTextView", "第" + i + "行");
			listItem_6.add(map);
		}
		SimpleAdapter mSimpleAdapter_6 = new SimpleAdapter(getActivity(),
				listItem_6, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_6.setAdapter(mSimpleAdapter_6);// 为ListView绑定适配器
		return view;

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

}
