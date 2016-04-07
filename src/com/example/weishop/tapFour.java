package com.example.weishop;



import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class tapFour extends Fragment {
	public String[] personal_data={"我的邮箱","我的积分","抽奖","登录","注册"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.tab04, container, false);
		
		TextView tv_dingdan=(TextView)view.findViewById(R.id.dingdan);
        tv_dingdan.setText(Html.fromHtml("<u>"+"我的订单"+"</u>"));
        
        TextView tv_shoucang=(TextView)view.findViewById(R.id.shoucang);
        tv_shoucang.setText(Html.fromHtml("<u>"+"我的收藏"+"</u>"));
		
		
		ListView lv=(ListView)view.findViewById(R.id.personal_center);
		 
		//详细界面适配器
				ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
				for(int i=0;i<5;i++)
				{
					HashMap<String,Object> map=new HashMap<String,Object>();
					map.put("image_personal", R.drawable.ic_launcher);
					map.put("function_info",personal_data[i]);
					map.put("image_personal_icon", R.drawable.arr_right);
					listItem.add(map);
				}
				SimpleAdapter mSimpleAdapter =  new SimpleAdapter(getActivity(),listItem,
						R.layout.list_item_personal_info,new String[]{"image_personal","function_info","image_personal_icon"},
						new int[]{R.id.image_personal,R.id.function_info,R.id.image_personal_icon});    	  
				lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器
		
		return view;
	}
}
