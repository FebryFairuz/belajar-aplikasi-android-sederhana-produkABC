package com.example.produkabc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBProdukDAO {
	private SQLiteDatabase database;
	private DBHelper dbHelper;
	
	private String[] allCollumns = {
		DBHelper.COLUMN_IDPRODUK,
		DBHelper.COLUMN_NAMAPRODUK,
		DBHelper.COLUMN_MERKPRODUK,
		DBHelper.COLUMN_HARGAPRODUK
	};
	
	public DBProdukDAO(Context context){
		dbHelper = new DBHelper(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public Produk belanjaanGw(String produk, String merk, long harga){
		ContentValues values = new ContentValues();
		values.put(DBHelper.COLUMN_NAMAPRODUK, produk);
		values.put(DBHelper.COLUMN_MERKPRODUK, merk);
		values.put(DBHelper.COLUMN_HARGAPRODUK, harga);
		
		long insertId = database.insert(DBHelper.TABLE_NAME_PRODUK, null, values);
		
		Cursor cursor = database.query(DBHelper.TABLE_NAME_PRODUK,
									   allCollumns, DBHelper.COLUMN_IDPRODUK+" = "+insertId,
									   null,null,null,null);
		cursor.moveToFirst();
		
		Produk newProduk = cursorToProduk(cursor);
		cursor.close();
		
		return newProduk;
	}

	private Produk cursorToProduk(Cursor cursor) {
		Produk produk = new Produk();
		produk.setId_produk(cursor.getInt(0));
		produk.setNama_barang(cursor.getString(1));
		produk.setMerk_barang(cursor.getString(2));
		produk.setHarga(cursor.getLong(3));
		
		return produk;
	}
}
