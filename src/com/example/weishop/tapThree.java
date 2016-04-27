package com.example.weishop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.data.Fruit;
import com.example.data.SQLiteDAOImpl;
import com.example.util.MyAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class tapThree extends Fragment {

	private ListView listview;


	SQLiteDAOImpl sqlDAO=new SQLiteDAOImpl(getActivity());

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab03, container, false);
		listview=(ListView)view.findViewById(R.id.cart_info);
		HashMap<String, Object> map=new HashMap<String, Object>();
		ArrayList<HashMap<String,Object>>  list=new ArrayList<HashMap<String,Object>>();
	
		List<Fruit> listitem = new ArrayList<Fruit>();
		//��ȡ���ݿ��е���Ϣ
		try {
			listitem=sqlDAO.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int i = 0; i <listitem.size(); i++) {	
			map = new HashMap<String, Object>();
			map.put("itemimage", R.drawable.fruit); 
			map.put("itemtitle", listitem.get(i).getName());
			map.put("price", "��5");
			map.put("btadd", R.id.itemadd);
			map.put("btcut", R.id.itemcut);
			map.put("number",listitem.get(i).getPrice());
			list.add(map);
		}
		// ����MyAdapter��������������item�е�Ԫ��
		MyAdapter listItemAdapter = new MyAdapter(getActivity(), list,
				R.layout.cart_list_item, new String[] { "itemimage", "itemtitle",
						"price", "btadd", "btcut", "number" }, new int[] {
						R.id.itemimage, R.id.itemtitle, R.id.price,
						R.id.itemadd, R.id.itemcut, R.id.number });
		listview.setAdapter(listItemAdapter);

		return view;
	}
}
