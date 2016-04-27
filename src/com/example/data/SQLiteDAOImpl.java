package com.example.data;

import java.util.ArrayList;
import java.util.List;
import com.example.data.MyDatabaseHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDAOImpl {


   private MyDatabaseHelper mydatabasehelper;
   private SQLiteDatabase db;
   
   public SQLiteDAOImpl(Context context) {
	   mydatabasehelper=new MyDatabaseHelper(context);
	}
	// 插入数据
	public void insert(Fruit fruit) {
		db = mydatabasehelper.getReadableDatabase();
		db.execSQL(
				"insert into fruit(id,type_id,fruit_id,name,price,number) values(?,?,?,?,?,?)",
				new Object[] { fruit.getType_id(), fruit.getFruit_id(),
						fruit.getName(), fruit.getPrice(), fruit.getNumber() });
		db.close();
	}

	// 将存储在数据库中的数据显示在购物车界面中
	

	// 查找数据库中的全部数据
	public List<Fruit> findAll() {
		List<Fruit> lists = new ArrayList<Fruit>();
	    db = mydatabasehelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from fruit", null);
		while (cursor.moveToNext()) {
			int id=cursor.getInt(cursor.getColumnIndex("id"));
			int type_id=cursor.getInt(cursor.getColumnIndex("type_id"));
			int fruit_id=cursor.getInt(cursor.getColumnIndex("fruit_id"));
			String name=cursor.getString(cursor.getColumnIndex("name"));
			double price=cursor.getDouble(cursor.getColumnIndex("price"));
			int number=cursor.getInt(cursor.getColumnIndex("number"));
			Fruit fruit =new Fruit(id,type_id,fruit_id,name,price,number);
			lists.add(fruit);
		}
		db.close();
		return lists;
	}
	// 根据ID更新商品数量信息
	public void update(Fruit fruit) {
		db = mydatabasehelper.getReadableDatabase();
		db.execSQL("update table fruit set number=? where fruit_id=?",
				new Object[]{fruit.getNumber(),fruit.getFruit_id()});
		db.close();
	}
	// 删除数据
	public void delete(Integer id) {

	}
}
