package com.example.produkabc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBUserDAO {
	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = {
			DBHelper.COLUMN_IDUSER,
			DBHelper.COLUMN_USERNAME,
			DBHelper.COLUMN_PASSWORD
	};
	
	public DBUserDAO(Context context){
		dbHelper = new DBHelper(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public User registerUser(String username, String password){
		ContentValues values = new ContentValues();
		values.put(DBHelper.COLUMN_USERNAME, username);
		values.put(DBHelper.COLUMN_PASSWORD, password);
		
		long insertId = database.insert(DBHelper.TABLE_NAME_USER, null, values);
		
		Cursor cursor = database.query(DBHelper.TABLE_NAME_USER, allColumns, DBHelper.COLUMN_IDUSER + " = "+insertId,
									   null,null,null,null);
		
		cursor.moveToFirst();
		User newUser = cursorToUser(cursor);
		cursor.close();
		
		return newUser;
	}

	private User cursorToUser(Cursor cursor) {
		User user = new User();
		user.setId_user(cursor.getInt(0));
		user.setUsername(cursor.getString(1));
		user.setPassword(cursor.getString(2));
		return user;
	}
	
	public boolean getUser(String username, String password){
		String name = null;
		boolean ada = false;
		Cursor cursor = database.rawQuery("select * from user where username ='"+username+"' and password='"+password+"'", null);
		cursor.moveToFirst();
		if(cursor.getCount() > 0){
			name = cursor.getString(cursor.getColumnIndex("username"));
			ada = true;
		}
		return ada;
	}
}
