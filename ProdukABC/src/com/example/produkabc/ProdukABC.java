package com.example.produkabc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ProdukABC extends Activity implements OnClickListener{

	private ImageView p1,p2,p3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produk_abc);
		
		p1 = (ImageView)findViewById(R.id.imgP1);
		p2 = (ImageView)findViewById(R.id.imgP2);
		p3 = (ImageView)findViewById(R.id.imgP3);
		
		p1.setOnClickListener(this);
		p2.setOnClickListener(this);
		p3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.imgP1:
				Intent dp1 = new Intent(this, DetailProduk.class);
				Bundle b = new Bundle();
				int img = R.drawable.produk1;
				b.putInt("foto", img);
				b.putString("produk", "Boneka Minion Batman");
				b.putString("merk", "Ledge");
				b.putLong("harga", 170000);
				dp1.putExtras(b);
				startActivity(dp1);
				break;
			case R.id.imgP2:
				Intent dp2 = new Intent(this, DetailProduk.class);
				Bundle b2 = new Bundle();
				int img2 = R.drawable.produk2;
				b2.putInt("foto", img2);
				b2.putString("produk", "Boneka Minion Shena");
				b2.putString("merk", "Rovio");
				b2.putLong("harga", 190000);
				dp2.putExtras(b2);
				startActivity(dp2);
				break;
			case R.id.imgP3:
				Intent dp3 = new Intent(this, DetailProduk.class);
				Bundle b3 = new Bundle();
				int img3 = R.drawable.produk3;
				b3.putInt("foto", img3);
				b3.putString("produk", "Boneka Minion Robin");
				b3.putString("merk", "Awak");
				b3.putLong("harga", 270000);
				dp3.putExtras(b3);
				startActivity(dp3);
				break;				
		}
	}

}
