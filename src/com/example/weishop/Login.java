package com.example.weishop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends  ActionBarActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//返回按键
		ImageView imageView_back=(ImageView)findViewById(R.id.top_left_image);
		imageView_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Login.this,Main.class);
				startActivity(intent);
			}
		});
		
		//获取输入的信息
		EditText  ET_name=(EditText)findViewById(R.id.editText1);
		final String name=ET_name.getText().toString();
		EditText  ET_password=(EditText)findViewById(R.id.editText2);
		final String password=ET_password.getText().toString();
		//登录
        Button login_bt=(Button)findViewById(R.id.button1);
        //注册
        TextView register_bt=(TextView)findViewById(R.id.sign_in);
        login_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if((name.equals("admin"))&&(password.equals("123456"))){
					Intent intent=new Intent(Login.this,Main.class);
					startActivity(intent);
					
				}else{
					Toast.makeText(Login.this, "请输入用户名", Toast.LENGTH_SHORT).show();
				}
			}
		});
        register_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                if(name==null){
					
					Toast.makeText(Login.this, "请输入密码", Toast.LENGTH_SHORT).show();
				}else{
				Toast.makeText(Login.this, "点击注册", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
}
