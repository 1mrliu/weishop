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
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class tapTwo extends Fragment {
	
	public String[] data = { "����ר��", "���ھ�Ʒ", "������ѡ", "ɭ�ָɹ�", "�������", "���ʹ�֭" };
	private List<Map<String, Object>> mListItem;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.tab02, container, false);
		// ��Ʒ����
		final ListView lv_type = (ListView) view.findViewById(android.R.id.list);

		ArrayAdapter<String>  lv_type_adapter=new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,data);
		lv_type.setAdapter(lv_type_adapter);
		
		// ��Ʒ��ϸ���չʾ
		final ListView mListView = (ListView) view.findViewById(R.id.cont1);
		final ListView mListView_1 = (ListView) view.findViewById(R.id.cont2);
		mListItem = getData();
		MyAdapter adapter = new MyAdapter(getActivity());
		mListView.setAdapter(adapter);
		mListView_1.setAdapter(adapter);
		// ���ý���ѡ��������ʾ����Ʒ���棬�޸���������Ǽ���ȫ������Ϣ����
		mListView.setVisibility(View.INVISIBLE);
		mListView_1.setVisibility(View.INVISIBLE);
		// getActivityʹ������������������Fragment��s
		ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>
		(getActivity(), android.R.layout.simple_list_item_1, data);
		lv_type.setAdapter(typeAdapter);
		// ���������������ӵ���¼�
		lv_type.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// �Ե��λ�ý����жϣ�����¼�
				if (data[position].equals("����ר��")) {
					mListView.setVisibility(View.VISIBLE);
					mListView_1.setVisibility(View.GONE);
				}
				if (data[position].equals("���ھ�Ʒ")) {
					mListView.setVisibility(View.GONE);
					mListView_1.setVisibility(View.VISIBLE);
				}
				if (data[position].equals("������ѡ")) {
					mListView.setVisibility(View.GONE);
					mListView_1.setVisibility(View.GONE);
				}
				if (data[position].equals("ɭ�ָɹ�")) {
					mListView.setVisibility(View.VISIBLE);
					mListView_1.setVisibility(View.GONE);
				}
				if (data[position].equals("�������")) {
					mListView.setVisibility(View.GONE);
					mListView_1.setVisibility(View.GONE);
				}
				if (data[position].equals("���ʹ�֭")) {
					mListView.setVisibility(View.VISIBLE);
					mListView_1.setVisibility(View.GONE);
				}
				
			}
		});
		return view;
		}
		
		private List<Map<String, Object>> getData() {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 10; i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("titleTextView", "����"+i);
				map.put("descTextView", "����"+i);
				map.put("imageView_delete", R.drawable.delete);
				map.put("list_buy_number", i);
				map.put("imageView_add", R.drawable.add);
				list.add(map);
			}
			return list;
		}
	
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
				// TODO Auto-generated method stub
				return mListItem.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}			
		/*	public Bitmap getImageByURL(String url) {
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
*/
			@SuppressLint("InflateParams") @Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				Map<String, Object> item = new HashMap<String, Object>();
			       item = getData().get(position);//��õ������� ����
			

				ViewHolder holder = null;
			   
				if (convertView == null) {
					holder = new ViewHolder();
					convertView = mInflater.inflate(R.layout.list_item, null);
					holder.titleTextView = (TextView) convertView
							.findViewById(R.id.titleTextView);
					holder.titleTextView.setText(item.get("titleTextView").toString());					
					holder.descTextView = (TextView) convertView
							.findViewById(R.id.descTextView);
					holder.descTextView.setText(item.get("descTextView").toString());
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
				//�����Ӻͼ�����Ʒ��ͼ��
				
				holder.imageView_delete.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), "delete user", Toast.LENGTH_SHORT).show();
					}

				});
				holder.imageView_add.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), "add user", Toast.LENGTH_SHORT).show();
					}

				});
				return convertView;			
			}
	}
		}
	


