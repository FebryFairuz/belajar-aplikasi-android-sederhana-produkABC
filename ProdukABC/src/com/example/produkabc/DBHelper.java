package com.example.produkabc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	public static final String TABLE_NAME_USER = "user";
	public static final String COLUMN_IDUSER = "id_user";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_PASSWORD = "password";
	
	public static final String TABLE_NAME_PRODUK = "produk";
	public static final String COLUMN_IDPRODUK = "id_produk";
	public static final String COLUMN_NAMAPRODUK = "nama_produk";
	public static final String COLUMN_MERKPRODUK = "merk_produk";
	public static final String COLUMN_HARGAPRODUK = "harga_produk";
	
	private static final String db_name = "produkABC.db";
	private static final int db_version = 1;
	
	private static final String db_create_user ="create table "
												+ TABLE_NAME_USER +"("
												+ COLUMN_IDUSER +" integer primary key autoincrement, "
												+ COLUMN_USERNAME +" varchar(50) not null, "
												+ COLUMN_PASSWORD +" varchar(50) not null);";
	private static final String db_create_produk = "create table "
												+ TABLE_NAME_PRODUK +"("
												+ COLUMN_IDPRODUK +" integer primary key autoincrement, "
												+ COLUMN_NAMAPRODUK +" varchar(100) not null, "
												+ COLUMN_MERKPRODUK +" varchar(100) not null,"
												+ COLUMN_HARGAPRODUK + " double );";
	
	public DBHelper(Context context) {
		super(context, db_name, null, db_version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(db_create_user);
		db.execSQL(db_create_produk);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBHelper.class.getName(), "Upgrate versi database" + oldVersion + " ke "+ newVersion+ ", data lama akan dihapus");
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_PRODUK);
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_USER);
		onCreate(db);
	}

}
