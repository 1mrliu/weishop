package com.example.weishop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends  ActionBarActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//��ȡ�������Ϣ
		EditText  ET_name=(EditText)findViewById(R.id.editText1);
		final String name=ET_name.getText().toString();
		EditText  ET_password=(EditText)findViewById(R.id.editText2);
		String password=ET_password.getText().toString();
		//��¼
        Button login_bt=(Button)findViewById(R.id.button1);
        //ע��
        TextView register_bt=(TextView)findViewById(R.id.sign_in);
        login_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(name==null){
					
					Toast.makeText(Login.this, "�������û���", Toast.LENGTH_SHORT).show();
				}else{
				Toast.makeText(Login.this, "�����½", Toast.LENGTH_SHORT).show();
				}
			}
		});
        register_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                if(name==null){
					
					Toast.makeText(Login.this, "����������", Toast.LENGTH_SHORT).show();
				}else{
				Toast.makeText(Login.this, "���ע��", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
}
