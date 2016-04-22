package com.example.weishop;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
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
import com.example.util.MyAdapter;
import com.example.weishop.R.integer;

public class tapTwo extends Fragment {

	public String[] data = { "热卖专区", "进口精品", "国产优选", "森林干果", "礼盒整箱", "新鲜果汁" };
	public List<Map<String, Object>> mListItem = new ArrayList<Map<String, Object>>();
	ListView mListView, lv_type, listView1, listView2, listView3,listView4,listView5,listView6;
	/*
	 * 获取商品当前数量并改变数字的大小
	 */
	TextView count;
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
		// mListView = (ListView) view.findViewById(R.id.cont1);

		listView1 = (ListView) view.findViewById(R.id.cont1);
		listView2 = (ListView) view.findViewById(R.id.cont2);
		listView3 = (ListView) view.findViewById(R.id.cont3);
		listView4 = (ListView) view.findViewById(R.id.cont4);
		listView5 = (ListView) view.findViewById(R.id.cont5);
		listView6 = (ListView) view.findViewById(R.id.cont6);
		// 生成动态数组
		ArrayList<HashMap<String, Object>> listitem1 = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemimage", R.drawable.fruit); // 图像资源的ID
			map.put("itemtitle", "热卖专区" + i);
			map.put("price", "￥5");
			map.put("number", 0);
			listitem1.add(map);
		}
		// 调用MyAdapter方法，用来放置item中的元素
		MyAdapter listItemAdapter1 = new MyAdapter(getActivity(), listitem1,
				R.layout.list_item, new String[] { "itemimage", "itemtitle",
						"price", "btadd", "btcut", "number" }, new int[] {
						R.id.itemimage, R.id.itemtitle, R.id.price,
						R.id.itemadd, R.id.itemcut, R.id.number });
		listView1.setAdapter(listItemAdapter1);

		// 生成动态数组
		ArrayList<HashMap<String, Object>> listitem2 = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemimage", R.drawable.fruit); // 图像资源的ID
			map.put("itemtitle", "进口精品" + i);
			map.put("price", "￥5");
			map.put("number", 0);
			listitem2.add(map);
		}
		// 调用MyAdapter方法，用来放置item中的元素
		MyAdapter listItemAdapter2 = new MyAdapter(getActivity(), listitem2,
				R.layout.list_item, new String[] { "itemimage", "itemtitle",
						"price", "btadd", "btcut", "number" }, new int[] {
						R.id.itemimage, R.id.itemtitle, R.id.price,
						R.id.itemadd, R.id.itemcut, R.id.number });
		listView2.setAdapter(listItemAdapter2);

		// 生成动态数组
		ArrayList<HashMap<String, Object>> listitem3 = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemimage", R.drawable.fruit); // 图像资源的ID
			map.put("itemtitle", "国产优选" + i);
			map.put("price", "￥5");
			map.put("number", 0);
			listitem3.add(map);
		}
		// 调用MyAdapter方法，用来放置item中的元素
		MyAdapter listItemAdapter3 = new MyAdapter(getActivity(), listitem3,
				R.layout.list_item, new String[] { "itemimage", "itemtitle",
						"price", "btadd", "btcut", "number" }, new int[] {
						R.id.itemimage, R.id.itemtitle, R.id.price,
						R.id.itemadd, R.id.itemcut, R.id.number });
		listView3.setAdapter(listItemAdapter3);
		
		// 生成动态数组
				ArrayList<HashMap<String, Object>> listitem4 = new ArrayList<HashMap<String, Object>>();
				for (int i = 0; i < 10; i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("itemimage", R.drawable.fruit); // 图像资源的ID
					map.put("itemtitle", "森林干果" + i);
					map.put("price", "￥5");
					map.put("number", 0);
					listitem4.add(map);
				}
				// 调用MyAdapter方法，用来放置item中的元素
				MyAdapter listItemAdapter4 = new MyAdapter(getActivity(), listitem4,
						R.layout.list_item, new String[] { "itemimage", "itemtitle",
								"price", "btadd", "btcut", "number" }, new int[] {
								R.id.itemimage, R.id.itemtitle, R.id.price,
								R.id.itemadd, R.id.itemcut, R.id.number });
				listView4.setAdapter(listItemAdapter4);
				
				// 生成动态数组
				ArrayList<HashMap<String, Object>> listitem5 = new ArrayList<HashMap<String, Object>>();
				for (int i = 0; i < 10; i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("itemimage", R.drawable.fruit); // 图像资源的ID
					map.put("itemtitle", "礼盒整箱" + i);
					map.put("price", "￥5");
					map.put("number", 0);
					listitem5.add(map);
				}
				// 调用MyAdapter方法，用来放置item中的元素
				MyAdapter listItemAdapter5 = new MyAdapter(getActivity(), listitem5,
						R.layout.list_item, new String[] { "itemimage", "itemtitle",
								"price", "btadd", "btcut", "number" }, new int[] {
								R.id.itemimage, R.id.itemtitle, R.id.price,
								R.id.itemadd, R.id.itemcut, R.id.number });
				listView5.setAdapter(listItemAdapter5);
				
				
				// 生成动态数组
				ArrayList<HashMap<String, Object>> listitem6 = new ArrayList<HashMap<String, Object>>();
				for (int i = 0; i < 10; i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("itemimage", R.drawable.fruit); // 图像资源的ID
					map.put("itemtitle", "新鲜果汁" + i);
					map.put("price", "￥5");
					map.put("number", 0);
					listitem6.add(map);
				}
				// 调用MyAdapter方法，用来放置item中的元素
				MyAdapter listItemAdapter6 = new MyAdapter(getActivity(), listitem6,
						R.layout.list_item, new String[] { "itemimage", "itemtitle",
								"price", "btadd", "btcut", "number" }, new int[] {
								R.id.itemimage, R.id.itemtitle, R.id.price,
								R.id.itemadd, R.id.itemcut, R.id.number });
				listView6.setAdapter(listItemAdapter6);

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
				// MyAdapter adapter = new MyAdapter(
				// context,applist,resources,from,to);
				// mListView.setAdapter(adapter);
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
							listView1.setVisibility(View.VISIBLE);
							listView2.setVisibility(View.GONE);
							listView3.setVisibility(View.GONE);
							listView4.setVisibility(View.GONE);
							listView5.setVisibility(View.GONE);
							listView6.setVisibility(View.GONE);
							
						}
						if (data[position].equals("进口精品")) {
							listView1.setVisibility(View.GONE);
							listView2.setVisibility(View.VISIBLE);
							listView3.setVisibility(View.GONE);
							listView4.setVisibility(View.GONE);
							listView5.setVisibility(View.GONE);
							listView6.setVisibility(View.GONE);
						}
						if (data[position].equals("国产优选")) {
							listView1.setVisibility(View.GONE);
							listView2.setVisibility(View.GONE);
							listView3.setVisibility(View.VISIBLE);
							listView4.setVisibility(View.GONE);
							listView5.setVisibility(View.GONE);
							listView6.setVisibility(View.GONE);
						}
						if (data[position].equals("森林干果")) {
							listView1.setVisibility(View.GONE);
							listView2.setVisibility(View.GONE);
							listView3.setVisibility(View.GONE);
							listView4.setVisibility(View.VISIBLE);
							listView5.setVisibility(View.GONE);
							listView6.setVisibility(View.GONE);
						}
						if (data[position].equals("礼盒整箱")) {
							listView1.setVisibility(View.GONE);
							listView2.setVisibility(View.GONE);
							listView3.setVisibility(View.GONE);
							listView4.setVisibility(View.GONE);
							listView5.setVisibility(View.VISIBLE);
							listView6.setVisibility(View.GONE);
						}
						if (data[position].equals("新鲜果汁")) {
							listView1.setVisibility(View.GONE);
							listView2.setVisibility(View.GONE);
							listView3.setVisibility(View.GONE);
							listView4.setVisibility(View.GONE);
							listView5.setVisibility(View.GONE);
							listView6.setVisibility(View.VISIBLE);
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
				map.put("itemtitle", id);
				map.put("price", name);
				mListItem.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 图片加载
	public Bitmap getImageByURL(String url) {
		try {
			URL imgURL = new URL(url);
			URLConnection conn = imgURL.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			Bitmap bm = BitmapFactory.decodeStream(bis);
			bis.close();
			is.close();
			if (bm == null) {
				Log.e("MO", "httperror");
			}
			return bm;
		} catch (Exception e) {
			return null;
		}
	}

}
