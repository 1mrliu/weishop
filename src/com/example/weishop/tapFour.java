package com.example.weishop;



import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class tapFour extends Fragment {
	public String[] personal_data={"我的邮箱","我的积分","抽奖","登录"};
	public  int[]  image_icon={R.drawable.mail,R.drawable.integral,
			R.drawable.lottery,R.drawable.login};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.tab04, container, false);
		
		//我的订单
		TextView tv_dingdan=(TextView)view.findViewById(R.id.dingdan);
        tv_dingdan.setText(Html.fromHtml("<u>"+"我的订单"+"</u>"));
        
        //我的收藏
        TextView tv_shoucang=(TextView)view.findViewById(R.id.shoucang);
        tv_shoucang.setText(Html.fromHtml("<u>"+"我的收藏"+"</u>"));
        
        //个人中心
		ListView lv=(ListView)view.findViewById(R.id.personal_center);
		 
		//详细界面适配器
				ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
				for(int i=0;i<4;i++)
				{
					HashMap<String,Object> map=new HashMap<String,Object>();
					map.put("image_personal", image_icon[i]);
					map.put("function_info",personal_data[i]);
					map.put("image_personal_icon", R.drawable.arr_right);
					listItem.add(map);
				}
				SimpleAdapter mSimpleAdapter =  new SimpleAdapter(getActivity(),listItem,
						R.layout.list_item_personal_info,new String[]{"image_personal","function_info","image_personal_icon"},
						new int[]{R.id.image_personal,R.id.function_info,R.id.image_personal_icon});    	  
				lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						if(position==3){
							Intent intent=new Intent();
							intent.setClass(getActivity(), Login.class);
							startActivity(intent);
							
						}
						
					}
				});
		
		return view;
	}
}
