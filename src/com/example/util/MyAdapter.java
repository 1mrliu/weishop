package com.example.util;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weishop.R;
import com.example.weishop.tapTwo;

public class MyAdapter extends BaseAdapter {
	
	private ArrayList<HashMap<String, Object>> mAppList;
	 ArrayList<HashMap<String, Object>> CartList=new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> map=new HashMap<String,Object>();
 
	SharedPreferences.Editor editor;
	
	private LayoutInflater mInflater;
	private Context mContext;
	private String[] keystring;
	private int[] valueViewId;
	private buttonViewHolder holder;
	
	private class buttonViewHolder {
		ImageView itemIcon;
		TextView itemTitle;
		TextView price;
		EditText number;
		Button btAdd;
		Button btCut;
		
	}

	//适配一个listView中的item元素
	public MyAdapter(Context context,
			ArrayList<HashMap<String, Object>> applist, int resources,
			String[] from, int[] to) {
		mAppList = applist;
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		keystring = new String[from.length];
		valueViewId = new int[to.length];
		System.arraycopy(from, 0, keystring, 0, from.length);
		System.arraycopy(to, 0, valueViewId, 0, to.length);
	}

	@Override
	public int getCount() {
		return mAppList.size();
	}

	@Override
	public Object getItem(int position) {
		return mAppList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void removeItem(int position) {
		mAppList.remove(position);
		this.notifyDataSetChanged();
	}

	@Override
	// 获取listview中每个item中的控件，及设置每个控件中的元素
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView != null) {
			holder = (buttonViewHolder) convertView.getTag();
		} else {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new buttonViewHolder();
			holder.itemIcon = (ImageView) convertView.findViewById(valueViewId[0]);
			holder.itemTitle = (TextView) convertView.findViewById(valueViewId[1]);
			holder.price = (TextView) convertView.findViewById(valueViewId[2]);
			holder.btAdd = (Button) convertView.findViewById(valueViewId[3]);
			holder.btCut = (Button) convertView.findViewById(valueViewId[4]);
			holder.number = (EditText) convertView.findViewById(valueViewId[5]);
			convertView.setTag(holder);
		}
		HashMap<String, Object> appInfo = mAppList.get(position);
		if (appInfo != null) {
			
			int mid = (Integer) appInfo.get(keystring[0]);
			String aname =  appInfo.get(keystring[1]).toString();
			String price = (String) appInfo.get(keystring[2]);
			String number = String.valueOf(appInfo.get(keystring[5]));
			holder.itemTitle.setText(aname);
			holder.itemIcon.setImageDrawable(holder.itemIcon.getResources().getDrawable(mid));
			holder.number.setText(number);
			holder.price.setText(price);
			holder.btAdd.setOnClickListener(new lvButtonListener(position));
			holder.btCut.setOnClickListener(new lvButtonListener(position));
			
		}
		return convertView;
	}

	// 增加edittext控件中的数据
	public void addNum(int position) {
	/*
	 * 首次选购商品时，商品信息插入数据库，如果商品已存在数据库中，则UPDATE数据库，使数量加1
	 */
		int num = (Integer) mAppList.get(position).get(keystring[5]);
		num++;
		
		this.notifyDataSetChanged();
	    
	}

	// 减少edittext中的数据
	public void cutNum(int position) {
		// 获取一个item里面edittext中的数据源
	/*
	 * 减少商品的数量时先判断商品的商品是否还存在在数据库中，如果商品数量为0，则从数据库中删除
	 */
		int num = (Integer) mAppList.get(position).get(keystring[5]);
		if (num > 0) {
			num--;
		}
		
		
		
		
		// 重新刷新页面
		this.notifyDataSetChanged();
				
		
	}

	// 按钮监听事件，实现view中的监听事件
	class lvButtonListener implements View.OnClickListener {
		private int position;

		lvButtonListener(int pos) {
			position = pos;
		}

		@Override
		// 复写onClick方法用来监听按钮
		public void onClick(View v) {
			int vid = v.getId();
			if (vid == holder.btAdd.getId()) 
				// 将添加的商品的信息加入数据库表fruit
				
			{
				addNum(position);
				
				
				
			} else if (vid == holder.btCut.getId()) {
				cutNum(position);
			}

		}
	}
}