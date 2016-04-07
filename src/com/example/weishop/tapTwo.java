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
	public String[] data = { "����ר��", "���ھ�Ʒ", "������ѡ", "ɭ�ָɹ�", "�������", "���ʹ�֭" };

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab02, container, false);

		// ��Ʒ����
		final ListView lv_type = (ListView) view
				.findViewById(android.R.id.list);

		// ��Ʒ��ϸ���չʾ
		final ListView lv_1 = (ListView) view.findViewById(R.id.cont1);
		final ListView lv_2 = (ListView) view.findViewById(R.id.cont2);
		final ListView lv_3 = (ListView) view.findViewById(R.id.cont3);
		final ListView lv_4 = (ListView) view.findViewById(R.id.cont4);
		final ListView lv_5 = (ListView) view.findViewById(R.id.cont5);
		final ListView lv_6 = (ListView) view.findViewById(R.id.cont6);

		// getActivityʹ������������������Fragment��s
		ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, data);

		lv_type.setAdapter(typeAdapter);// ΪListView��������

		// ���������������ӵ���¼�
		lv_type.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// ��ȡ��ǰ��λ�õ��ı�����
				// String text= (String) lv_type.getItemAtPosition(position);
				// Toast.makeText(MainActivity.this, text,
				// Toast.LENGTH_SHORT).show();

				if (data[position].equals("����ר��")) 
				{
					lv_1.setVisibility(View.VISIBLE);
					lv_2.setVisibility(View.GONE);
					lv_3.setVisibility(View.GONE);
					lv_4.setVisibility(View.GONE);
					lv_5.setVisibility(View.GONE);
					lv_6.setVisibility(View.GONE);

				}
				if (data[position].equals("���ھ�Ʒ")) 
				{
					lv_1.setVisibility(View.GONE);
					lv_2.setVisibility(View.VISIBLE);
					lv_3.setVisibility(View.GONE);
					lv_4.setVisibility(View.GONE);
					lv_5.setVisibility(View.GONE);
					lv_6.setVisibility(View.GONE);
				}
				if (data[position].equals("������ѡ")) 
				{
					lv_1.setVisibility(View.GONE);
					lv_2.setVisibility(View.GONE);
					lv_3.setVisibility(View.VISIBLE);
					lv_4.setVisibility(View.GONE);
					lv_5.setVisibility(View.GONE);
					lv_6.setVisibility(View.GONE);
				}
				if (data[position].equals("ɭ�ָɹ�")) 
				{
					lv_1.setVisibility(View.GONE);
					lv_2.setVisibility(View.GONE);
					lv_3.setVisibility(View.GONE);
					lv_4.setVisibility(View.VISIBLE);
					lv_5.setVisibility(View.GONE);
					lv_6.setVisibility(View.GONE);
				}
				if (data[position].equals("�������")) 
				{
					lv_1.setVisibility(View.GONE);
					lv_2.setVisibility(View.GONE);
					lv_3.setVisibility(View.GONE);
					lv_4.setVisibility(View.GONE);
					lv_5.setVisibility(View.VISIBLE);
					lv_6.setVisibility(View.GONE);
				}
				if (data[position].equals("���ʹ�֭")) 
				{
					lv_1.setVisibility(View.GONE);
					lv_2.setVisibility(View.GONE);
					lv_3.setVisibility(View.GONE);
					lv_4.setVisibility(View.GONE);
					lv_5.setVisibility(View.GONE);
					lv_6.setVisibility(View.VISIBLE);
				}

			}
		});
		// ��ϸ����������
		// ����ר������
		ArrayList<HashMap<String, Object>> listItem_1 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "����ר��");
			map.put("descTextView", "��" + i + "��");
			listItem_1.add(map);
		}
		SimpleAdapter mSimpleAdapter_1 = new SimpleAdapter(getActivity(),
				listItem_1, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_1.setAdapter(mSimpleAdapter_1);// ΪListView��������
		/*
		 * lv.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { // TODO Auto-generated method stub } });
		 */
		// ���ھ�Ʒ����
		ArrayList<HashMap<String, Object>> listItem_2 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "���ھ�Ʒ");
			map.put("descTextView", "��" + i + "��");
			listItem_2.add(map);
		}
		SimpleAdapter mSimpleAdapter_2 = new SimpleAdapter(getActivity(),
				listItem_2, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_2.setAdapter(mSimpleAdapter_2);// ΪListView��������
		
		// ������ѡ����
		ArrayList<HashMap<String, Object>> listItem_3 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "����ר��");
			map.put("descTextView", "��" + i + "��");
			listItem_3.add(map);
		}
		SimpleAdapter mSimpleAdapter_3 = new SimpleAdapter(getActivity(),
				listItem_3, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_3.setAdapter(mSimpleAdapter_3);// ΪListView��������
		
		// ɭ�ָɹ�����
		ArrayList<HashMap<String, Object>> listItem_4 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "ɭ�ָɹ�");
			map.put("descTextView", "��" + i + "��");
			listItem_4.add(map);
		}
		SimpleAdapter mSimpleAdapter_4 = new SimpleAdapter(getActivity(),
				listItem_4, R.layout.list_item, new String[] { "imageView",
				"titleTextView", "descTextView" }, new int[] {
				R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_4.setAdapter(mSimpleAdapter_4);// ΪListView��������
		
		// ����������
		ArrayList<HashMap<String, Object>> listItem_5 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "�������");
			map.put("descTextView", "��" + i + "��");
			listItem_5.add(map);
		}
		SimpleAdapter mSimpleAdapter_5 = new SimpleAdapter(getActivity(),
				listItem_5, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_5.setAdapter(mSimpleAdapter_5);// ΪListView��������
		
		// ���ʹ�֭����
		ArrayList<HashMap<String, Object>> listItem_6 = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 5; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", R.drawable.ic_launcher);
			map.put("titleTextView", "���ʹ�֭");
			map.put("descTextView", "��" + i + "��");
			listItem_6.add(map);
		}
		SimpleAdapter mSimpleAdapter_6 = new SimpleAdapter(getActivity(),
				listItem_6, R.layout.list_item, new String[] { "imageView",
						"titleTextView", "descTextView" }, new int[] {
						R.id.imageView, R.id.titleTextView, R.id.descTextView });
		lv_6.setAdapter(mSimpleAdapter_6);// ΪListView��������
		return view;

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

}
