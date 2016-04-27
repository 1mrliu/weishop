package com.example.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	private static final int VERSION = 1;// 定义数据库版本号
	private static final String DBNAME = "weishop.db";// 定义数据库名
	
	public MyDatabaseHelper(Context context) {
		super(context, DBNAME, null, VERSION);

	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table fruit ("
				+ "id integer primary key autoincrement, " 
				+ "type_id integer , " 
				+ "fruit_id integer , " 
				+ "name text, "
				+ "price double, "  
				+ "number integer)");	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table Fruit if exists Fruit");
		onCreate(db);
	}

}
