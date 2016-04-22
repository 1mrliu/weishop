package com.example.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDAOImpl {

	private MyDatabaseHelper mydatabasehelper;

	// �������ݿ�
	public SQLiteDAOImpl(Context context) {
		this.mydatabasehelper = new MyDatabaseHelper(context, "weishop.db",
				null, 1);
	}

	// ��������
	public void insert(Fruit fruit) {
		SQLiteDatabase db = mydatabasehelper.getWritableDatabase();
		db.execSQL(
				"insert into Fruit(id,type_id,fruit_id,name,price,number) values(?,?,?,?,?,?)",
				new Object[] { fruit.getType_id(), fruit.getFruit_id(),
						fruit.getName(), fruit.getPrice(), fruit.getNumber() });
		db.close();
	}

	// ����ˮ����Ų���������Ϣ�����Խ��Ѿ�ѡ�е�������ʾ�ڹ��ﳵ��
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

	// �������ݿ��е�ȫ������
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

	// ָ��ID��������
	public void update() {

	}

	// ɾ������
	public void delete(Integer id) {

	}
}
