package com.example.weishop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class tapTwo extends Fragment {

	public String[] data = { "热卖专区", "进口精品", "国产优选", "森林干果", "礼盒整箱", "新鲜果汁" };
	public List<Map<String, Object>> mListItem = new ArrayList<Map<String, Object>>();
	ListView mListView, mListView_1, lv_type;
	/*
	 * 获取商品当前数量并改变数字的大小
	 */
	EditText count;
	public static final int SHOW_RESPONSE = 0;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.tab02, container, false);
		// 商品分类
		lv_type = (ListView) view.findViewById(android.R.id.list);
		sendRequestWithHttpClient();
		ArrayAdapter<String> lv_type_adapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, data);
		lv_type.setAdapter(lv_type_adapter);

		// 商品详细情况展示
		mListView = (ListView) view.findViewById(R.id.cont1);
		mListView_1 = (ListView) view.findViewById(R.id.cont2);
		count = (EditText) view.findViewById(R.id.list_buy_number);
		return view;
	}

	//
	private Handler handler = new Handler() {

		@SuppressLint("HandlerLeak")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:

				String response = (String) msg.obj;
				parseJSONWithJSONObject(response);
				MyAdapter adapter = new MyAdapter(getActivity());

				mListView.setAdapter(adapter);
				mListView_1.setAdapter(adapter);

				// 设置进入选购中心显示的商品界面，修复进入界面是加载全部的信息问题
				mListView.setVisibility(View.INVISIBLE);
				mListView_1.setVisibility(View.INVISIBLE);

				// getActivity使用在适配器中适用于Fragment中
				ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(
						getActivity(), android.R.layout.simple_list_item_1,
						data);
				lv_type.setAdapter(typeAdapter);

				// 分类适配器类别添加点击事件
				lv_type.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

						// 对点击位置进行判断，添加事件
						if (data[position].equals("热卖专区")) {
							mListView.setVisibility(View.VISIBLE);
							mListView_1.setVisibility(View.GONE);
						}
						if (data[position].equals("进口精品")) {
							mListView.setVisibility(View.GONE);
							mListView_1.setVisibility(View.VISIBLE);
						}
						if (data[position].equals("国产优选")) {
							mListView.setVisibility(View.GONE);
							mListView_1.setVisibility(View.GONE);
						}
						if (data[position].equals("森林干果")) {
							mListView.setVisibility(View.VISIBLE);
							mListView_1.setVisibility(View.GONE);
						}
						if (data[position].equals("礼盒整箱")) {
							mListView.setVisibility(View.GONE);
							mListView_1.setVisibility(View.GONE);
						}
						if (data[position].equals("新鲜果汁")) {
							mListView.setVisibility(View.VISIBLE);
							mListView_1.setVisibility(View.GONE);
						}
					}
				});
				break;
			}
		}
	};

	private void sendRequestWithHttpClient() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpClient = new DefaultHttpClient();

					HttpGet httpGet = new HttpGet(
							"http://www.xxxjqt.cn/amallphone/index.php/Home/Mobile/");
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");
						Message message = new Message();
						message.what = 1;
						message.obj = response.toString();
						handler.sendMessage(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void parseJSONWithJSONObject(String jsonData) {
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			Map<String, Object> map;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				map = new HashMap<String, Object>();
				String id = jsonObject.getString("gid");
				String name = jsonObject.getString("price");
				// String version = jsonObject.getString("original_price");
				map.put("titleTextView", id);
				map.put("descTextView", name);
				mListItem.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ListView适配器进行设置，加载数据，使用ViewHolder进行优化
	public final class ViewHolder {
		TextView titleTextView;
		TextView descTextView;
		ImageView imageView_delete;
		TextView list_buy_number;
		ImageView imageView_add;
	}

	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

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

		@SuppressLint("InflateParams") @Override
			public View getView(int position, View convertView, ViewGroup parent) {
				 Map<String, Object> item = new HashMap<String, Object>();
			    item = mListItem.get(position);//获得所有数据
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
				
				//点击添加和减少商品的图标
				  		        
				
				holder.imageView_delete.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), "reduce number", Toast.LENGTH_SHORT).show();  
						
					}

				});
				holder.imageView_add.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub						
						Toast.makeText(getActivity(), "add  number", Toast.LENGTH_SHORT).show();
					    int location=mListView.getCheckedItemPosition();
					    String l=String.valueOf(location+2);
						Log.d("position", l);
						for(int i=0;i<mListView.getChildCount();i++){
							//LinearLayout layout=(LinearLayout)mListView.getChildAt(i);
							
						
							RelativeLayout layout=(RelativeLayout)mListView.getChildAt(location+1);
							// 从layout中获得控件,根据其id
							TextView et = (TextView) layout.findViewById(R.id.list_buy_number);
						    et.setText(et.getText().toString()+1);
						
							}
						
						//count.setText(10);
					}
				});
				return convertView;			
			}
	}
}
