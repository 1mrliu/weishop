package com.example.util;

import java.util.List;

import com.example.weishop.R;


import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MmDdapter extends BaseAdapter {

	private Context context;
	private List<String> list;
	public MmDdapter(Context context,List<String> list){
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
  	  
  	  
        ViewHolder holder = null;
        if (convertView == null) {
          holder = new ViewHolder();	
//        convertView = mInflater.inflate(R.layout.list_item, null);
          convertView=View.inflate(context,R.layout.list_item, null);
          //View vi = super.getView( position,convertView,parent);
          holder.imageView = (ImageView) convertView
               .findViewById(R.id.imageView);
          holder.textView_title = (TextView) convertView
                    .findViewById(R.id.titleTextView);
          holder.textView_desc = (TextView) convertView
                    .findViewById(R.id.descTextView);
          holder.imageView_delete = (ImageView) convertView
                   .findViewById(R.id.imageView_delete);
          holder.textView_number = (TextView) convertView
                    .findViewById(R.id.list_buy_number);
          holder.imageView_add = (ImageView) convertView.findViewById(R.id.imageView_add);
            
          holder.imageView_add.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {
          	
        	  Toast.makeText(context, "belkaja", 0).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("dialog");
                    builder.setTitle("title");
                    builder.create();
                    builder.show();	                   
        }
    });
           convertView.setTag(holder);
       } else {
           convertView.getTag();
       }

       return convertView;
   }

	class ViewHolder {  
        public ImageView imageView_delete;
    public TextView  textView;
    public ImageView imageView_add;
	public TextView  textView_title;
	public TextView  textView_number;
	public ImageView imageView;
	public TextView  textView_desc;
  }
}
