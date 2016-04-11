package com.example.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weishop.R;

public class Audition1 extends Activity {
 
	     private ListView listView;
	
	     @Override
	    public void onCreate(Bundle savedInstanceState) {
	          super.onCreate(savedInstanceState);
	          setContentView(R.layout.tab02);
	          initComponents();
	  
	      }
	  
	      private void initComponents() {
	          listView = (ListView)findViewById(R.id.cont1);
	          listView.setAdapter(new MyAdapter(this));
//	          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//	  
//             @Override
//	              public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//	                      long arg3) {
//	                  Toast.makeText(getApplicationContext(), "item", 300).show();
//	  
//	              }
//	          });
	      }
	  
	      /*@Override
	      public boolean onCreateOptionsMenu(Menu menu) {
	          getMenuInflater().inflate(R.menu.activity_audition1, menu);
	          return true;
	      }*/
	
	      public final class ViewHolder {  
	        public ImageView imageView_delete;
	        public TextView  textView;
	        public ImageView imageView_add;
			public TextView  textView_title;
			public TextView  textView_number;
			public ImageView imageView;
			public TextView  textView_desc;
	      }
	  
	      public class MyAdapter extends BaseAdapter {
	  
	          private LayoutInflater mInflater;
	  
	          public MyAdapter(Context context) {
	              this.mInflater = LayoutInflater.from(context);
	          }
	  
	          @Override
	          public int getCount() {
	              return 4;
	          }
	  
	          @Override
	          public Object getItem(int position) {
	             return null;
	          }
	 
	          @Override
	          public long getItemId(int position) {
	              return position;
	         }
	  
	          @Override
	          public View getView(int position, View convertView, ViewGroup parent) {
	        	  
	        	  
	              ViewHolder holder = null;
	              if (convertView == null) {
	                holder = new ViewHolder();	
	                convertView = mInflater.inflate(R.layout.list_item, null);
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
	             
	                 convertView.setTag(holder);
	             } else {
	            	 holder=(ViewHolder)convertView.getTag();
	             }
	              	
	              Toast.makeText(Audition1.this, "beidianjile", 0).show();
	                holder.imageView_add.setOnClickListener(new View.OnClickListener() {
	  
	                @Override
	                public void onClick(View v) {
	                	Toast.makeText(Audition1.this, "beidianjile", 0).show();
	                          AlertDialog.Builder builder = new AlertDialog.Builder(Audition1.this);
	                          builder.setMessage("dialog");
	                          builder.setTitle("title");
	                          builder.create();
	                          builder.show();     
                   }
               });
	             return convertView;
	         }
	 
	     }
	 
	 }