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

public class Main extends FragmentActivity implements OnClickListener {
	


	private LinearLayout mTabHome;
	private LinearLayout mTabSelect;
	private LinearLayout mTabCart;
	private LinearLayout mTabSetting;

	/*
	 * 图片按钮
	 */
	private ImageButton mImgHome;
	private ImageButton mImgSelect;
	private ImageButton mImgCart;
	private ImageButton mImgSetting;

	/*
	 * Fragment设置
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
	 * 点击事件
	 */
	private void initEvent() {
		mTabHome.setOnClickListener(this);
		mTabSelect.setOnClickListener(this);
		mTabCart.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
	}

	/*
	 * 视图设置
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
	 * 设置选择触发事件
	 */
	private void setSelect(int i) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		/*
		 * 把图片设置为亮的 设置内容区域
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
			
			break;
		case R.id.id_tab_setting:
			setSelect(3);
			break;

		default:
			break;
		}
	}

	/**
	 * 切换图片至暗色
	 */
	private void resetImgs() {
		mImgHome.setImageResource(R.drawable.home_normal);
		mImgSelect.setImageResource(R.drawable.select_normal);
		mImgCart.setImageResource(R.drawable.cart_normal);
		mImgSetting.setImageResource(R.drawable.setting_normal);
	}

}
