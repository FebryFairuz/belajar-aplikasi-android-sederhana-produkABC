package com.example.produkabc;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailProduk extends Activity {

	private String produk,merk;
	private long harga;
	private ImageView imgProduk;
	private TextView txtNamaProduk,txtMerkProduk,txtHargaProduk;
	private int foto; 
	
	private DBProdukDAO dbProdukDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_produk);
		
		Bundle b = this.getIntent().getExtras();
		foto = b.getInt("foto");
		produk = b.getString("produk");
		merk = b.getString("merk");
		harga = b.getLong("harga");
		
		imgProduk = (ImageView)findViewById(R.id.imgProduk);
		txtNamaProduk = (TextView)findViewById(R.id.txtNamaProduk);
		txtMerkProduk = (TextView)findViewById(R.id.txtMerk);
		txtHargaProduk = (TextView)findViewById(R.id.txtHargaProduk);
		
		dbProdukDAO = new DBProdukDAO(this);
		dbProdukDAO.open();
		
		txtNamaProduk.setText(produk);
		txtMerkProduk.setText(merk);
		txtHargaProduk.setText("Rp "+harga);
		imgProduk.setImageResource(foto);   
	}
	
	public void beliHandler(View v){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Confirmasi");
		builder.setMessage("Anda memesan : \n"
						  +produk+" Merk "+merk+" Rp"+harga+"\n"
						  +"--------\n Terima Kasih Telah Berbelanja Di Toko ABC")
		.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Produk prdk = null;
				prdk = dbProdukDAO.belanjaanGw(produk, merk, harga);
				dbProdukDAO.close();  
				dialog.cancel();
			}
		});
		
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

}
