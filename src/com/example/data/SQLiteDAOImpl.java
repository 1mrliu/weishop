package com.example.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDAOImpl {

	private MyDatabaseHelper mydatabasehelper;

	// 创建数据库
	public SQLiteDAOImpl(Context context) {
		this.mydatabasehelper = new MyDatabaseHelper(context, "weishop.db",
				null, 1);
	}

	// 插入数据
	public void insert(Fruit fruit) {
		SQLiteDatabase db = mydatabasehelper.getWritableDatabase();
		db.execSQL(
				"insert into Fruit(id,type_id,fruit_id,name,price,number) values(?,?,?,?,?,?)",
				new Object[] { fruit.getType_id(), fruit.getFruit_id(),
						fruit.getName(), fruit.getPrice(), fruit.getNumber() });
		db.close();
	}

	// 根据水果编号查找数据信息，可以讲已经选中的数据显示在购物车中
	public Fruit find(Integer id) {
		Fruit fruit = null;
		SQLiteDatabase db = mydatabasehelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from Fruit where fruit_id=?",
				new String[] { id.toString() });
		if (cursor.moveToFirst()) {
			fruit = new Fruit();
			fruit.setId(cursor.getInt(cursor.getColumnIndex("id")));
			fruit.setType_id(cursor.getInt(cursor.getColumnIndex("type_id")));
			fruit.setFruit_id(cursor.getInt(cursor.getColumnIndex("fruit_id")));
			fruit.setName(cursor.getString(cursor.getColumnIndex("name")));
			fruit.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
			fruit.setNumber(cursor.getInt(cursor.getColumnIndex("number")));
		}
		db.close();
		return fruit;
	}

	// 查找数据库中的全部数据
	public List<Fruit> findAll() {
		List<Fruit> lists = new ArrayList<Fruit>();
		Fruit fruit = null;
		SQLiteDatabase db = mydatabasehelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from Fruit", null);
		while (cursor.moveToNext()) {
			fruit = new Fruit();
			fruit.setId(cursor.getInt(cursor.getColumnIndex("id")));
			fruit.setType_id(cursor.getInt(cursor.getColumnIndex("type_id")));
			fruit.setFruit_id(cursor.getInt(cursor.getColumnIndex("fruit_id")));
			fruit.setName(cursor.getString(cursor.getColumnIndex("name")));
			fruit.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
			fruit.setNumber(cursor.getInt(cursor.getColumnIndex("number")));
			lists.add(fruit);
		}
		db.close();
		return lists;
	}

	// 指定ID更新数据
	public void update() {

	}

	// 删除数据
	public void delete(Integer id) {

	}
}
