package com.example.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public Context mContext;
	public static final String CREATE_Fruit = "create table Fruit ("
			+ "id integer primary key autoincrement, " 
			+ "type_id integer , " 
			+ "fruit_id integer , " 
			+ "name text, "
			+ "price real, "  
			+ "number integer)";
	
	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		mContext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_Fruit);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists Fruit");
		onCreate(db);
	}

}
