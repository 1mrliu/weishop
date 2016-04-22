package com.example.weishop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.data.MyDatabaseHelper;

public class Main extends FragmentActivity implements OnClickListener {
	MyDatabaseHelper databasehelper  = new MyDatabaseHelper(this, "weishop.db", null, 2);


	private LinearLayout mTabHome;
	private LinearLayout mTabSelect;
	private LinearLayout mTabCart;
	private LinearLayout mTabSetting;

	/*
	 * ͼƬ��ť
	 */
	private ImageButton mImgHome;
	private ImageButton mImgSelect;
	private ImageButton mImgCart;
	private ImageButton mImgSetting;

	/*
	 * Fragment����
	 */
	private Fragment mTab01;
	private Fragment mTab02;
	private Fragment mTab03;
	private Fragment mTab04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		initView();
		initEvent();
		setSelect(0);
	}

	/*
	 * ����¼�
	 */
	private void initEvent() {
		mTabHome.setOnClickListener(this);
		mTabSelect.setOnClickListener(this);
		mTabCart.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
	}

	/*
	 * ��ͼ����
	 */
	private void initView() {
		mTabHome = (LinearLayout) findViewById(R.id.id_tab_home);
		mTabSelect = (LinearLayout) findViewById(R.id.id_tab_select);
		mTabCart = (LinearLayout) findViewById(R.id.id_tab_cart);
		mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

		mImgHome = (ImageButton) findViewById(R.id.id_tab_home_img);
		mImgSelect = (ImageButton) findViewById(R.id.id_tab_select_img);
		mImgCart = (ImageButton) findViewById(R.id.id_tab_cart_img);
		mImgSetting = (ImageButton) findViewById(R.id.id_tab_settings_img);
	}

	/*
	 * ����ѡ�񴥷��¼�
	 */
	private void setSelect(int i) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		/*
		 * ��ͼƬ����Ϊ���� ������������
		 */
		switch (i) {
		case 0:
			if (mTab01 == null) {
				mTab01 = new tapOne();
				transaction.add(R.id.id_content, mTab01);
			} else {
				transaction.show(mTab01);
			}
			mImgHome.setImageResource(R.drawable.home_pressed);
			break;
		case 1:
			if (mTab02 == null) {
				mTab02 = new tapTwo();
				transaction.add(R.id.id_content, mTab02);
			} else {
				transaction.show(mTab02);

			}
			mImgSelect.setImageResource(R.drawable.select_pressed);
			break;
		case 2:
			if (mTab03 == null) {
				mTab03 = new tapThree();
				transaction.add(R.id.id_content, mTab03);
				
			} else {
				transaction.show(mTab03);
				
			}
			mImgCart.setImageResource(R.drawable.cart_pressed);
			break;
		case 3:
			if (mTab04 == null) {
				mTab04 = new tapFour();
				transaction.add(R.id.id_content, mTab04);
			} else {
				transaction.show(mTab04);
			}
			mImgSetting.setImageResource(R.drawable.setting_pressed);
			break;
		default:
			break;
		}

		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {
		if (mTab01 != null) {
			transaction.hide(mTab01);
		}
		if (mTab02 != null) {
			transaction.hide(mTab02);
		}
		if (mTab03 != null) {
			transaction.hide(mTab03);
		}
		if (mTab04 != null) {
			transaction.hide(mTab04);
		}
	}

	@Override
	public void onClick(View v) {
		resetImgs();
		switch (v.getId()) {
		case R.id.id_tab_home:
			setSelect(0);
			break;
		case R.id.id_tab_select:
			setSelect(1);
			break;
		case R.id.id_tab_cart:
			setSelect(2);
			databasehelper.getWritableDatabase();
			break;
		case R.id.id_tab_setting:
			setSelect(3);
			break;

		default:
			break;
		}
	}

	/**
	 * �л�ͼƬ����ɫ
	 */
	private void resetImgs() {
		mImgHome.setImageResource(R.drawable.home_normal);
		mImgSelect.setImageResource(R.drawable.select_normal);
		mImgCart.setImageResource(R.drawable.cart_normal);
		mImgSetting.setImageResource(R.drawable.setting_normal);
	}

}
