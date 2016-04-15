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

	public String[] data = { "����ר��", "���ھ�Ʒ", "������ѡ", "ɭ�ָɹ�", "�������", "���ʹ�֭" };
	public List<Map<String, Object>> mListItem = new ArrayList<Map<String, Object>>();
	ListView mListView, lv_type;
	/*
	 * ��ȡ��Ʒ��ǰ�������ı����ֵĴ�С
	 */
	TextView count;
	public static final int SHOW_RESPONSE = 0;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.tab02, container, false);
		// ��Ʒ����
		lv_type = (ListView) view.findViewById(android.R.id.list);
		sendRequestWithHttpClient();
		ArrayAdapter<String> lv_type_adapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, data);
		lv_type.setAdapter(lv_type_adapter);

		// ��Ʒ��ϸ���չʾ
		mListView = (ListView) view.findViewById(R.id.cont1);
		count = (TextView) view.findViewById(R.id.list_buy_number);
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
				

				// ���ý���ѡ��������ʾ����Ʒ���棬�޸���������Ǽ���ȫ������Ϣ����
				mListView.setVisibility(View.INVISIBLE);
				

				// getActivityʹ������������������Fragment��
				ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(
						getActivity(), android.R.layout.simple_list_item_1,
						data);
				lv_type.setAdapter(typeAdapter);

				// ���������������ӵ���¼�
				lv_type.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

						// �Ե��λ�ý����жϣ�����¼�
						if (data[position].equals("����ר��")) {
							mListView.setVisibility(View.VISIBLE);
							
						}
						if (data[position].equals("���ھ�Ʒ")) {
							mListView.setVisibility(View.GONE);
							
						}
						if (data[position].equals("������ѡ")) {
							mListView.setVisibility(View.GONE);
							
						}
						if (data[position].equals("ɭ�ָɹ�")) {
							mListView.setVisibility(View.VISIBLE);
							
						}
						if (data[position].equals("�������")) {
							mListView.setVisibility(View.GONE);
							
						}
						if (data[position].equals("���ʹ�֭")) {
							mListView.setVisibility(View.VISIBLE);
							
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

	// ͼƬ����
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
