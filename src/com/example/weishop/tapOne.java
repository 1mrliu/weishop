package com.example.weishop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class tapOne extends Fragment  {
	

	private boolean statu=true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		   View view = inflater.inflate(R.layout.tab01, container, false);
           TextView tv_notice=(TextView)view.findViewById(R.id.notice);
           tv_notice.setText(Html.fromHtml("<u>"+"公告"+"</u>"));
           final TextView tv_notice_info=(TextView)view.findViewById(R.id.notice_info);
           final TextView tv_shop=(TextView)view.findViewById(R.id.shop);
           tv_shop.setText(Html.fromHtml("<u>"+"商铺信息"+"</u>"));
           final TextView tv_shop_info=(TextView)view.findViewById(R.id.shop_info);
           tv_notice.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Toast.makeText(getActivity(), "通知信息", Toast.LENGTH_SHORT).show();
		if(statu==true)
		{
			LayoutParams  p=tv_notice_info.getLayoutParams();
			 p.height=50;		 
			 tv_notice_info.setLayoutParams(p);
		tv_notice_info.setVisibility(View.VISIBLE);
		statu=false;
		}else
		{
			LayoutParams  p=tv_notice_info.getLayoutParams();
			 p.height=0;		 
			 tv_notice_info.setLayoutParams(p);
		 tv_notice_info.setVisibility(View.INVISIBLE);
		 
		 statu=true;
		}
	}
   });
    tv_shop.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Toast.makeText(getActivity(), "店铺信息", Toast.LENGTH_SHORT).show();
			if(statu==true)
			{LayoutParams  p=tv_shop_info.getLayoutParams();
			 p.height=50;
			 tv_shop_info.setLayoutParams(p);
			tv_shop_info.setVisibility(View.VISIBLE);
			statu=false;
			}else
			{
				LayoutParams  p=tv_shop_info.getLayoutParams();
				 p.height=0;
				 tv_shop_info.setLayoutParams(p);
			 tv_shop_info.setVisibility(View.INVISIBLE);
			 
			 statu=true;
			}
		}
	});
		return view;
	}
}
