package com.example.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.weishop.R;
import com.example.weishop.tapTwo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
	public List<Map<String, Object>> mListItem = new ArrayList<Map<String, Object>>();
	public final class ViewHolder {
		TextView titleTextView;
		TextView descTextView;
		ImageView imageView_delete;
		TextView list_buy_number;
		ImageView imageView_add;
	}

	private LayoutInflater mInflater;

	int num=1;
	public MyAdapter(Context context) {
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mListItem.size();
	}

	@Override
	public Object getItem(int position) {
		return mListItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View convertView,ViewGroup parent) {
		 Map<String, Object> item = new HashMap<String, Object>();
		item = mListItem.get(position);// 获得所有数据
		 ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder.titleTextView = (TextView) convertView
					.findViewById(R.id.titleTextView);

			holder.descTextView = (TextView) convertView
					.findViewById(R.id.descTextView);

			holder.imageView_delete = (ImageView) convertView
					.findViewById(R.id.imageView_delete);

			holder.list_buy_number = (TextView) convertView
					.findViewById(R.id.list_buy_number);

			
			holder.imageView_add = (ImageView) convertView
					.findViewById(R.id.imageView_add);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.titleTextView.setText(item.get("titleTextView").toString());
		holder.descTextView.setText(item.get("descTextView").toString());
		
		holder.list_buy_number.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
		holder.list_buy_number.setText(String.valueOf(num));
		
		
		// 点击添加和减少商品的图标

		holder.imageView_delete
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//Toast.makeText(getActivity(tapTwo.this), "delete user",Toast.LENGTH_SHORT).show();
						Log.d("position", "" + position);// 获得点击当前的item的position
					}
				});

		holder.imageView_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(tapTwo.this, "add user",Toast.LENGTH_SHORT).show();

				Log.d("position", "" + position);// 获得点击当前的item的position
				//判断获得的position的值和mListView中item的位置是否相同，相同则使当前item中的number加1
					
				}
			
		});
		return convertView;
	}
	}
	
	
