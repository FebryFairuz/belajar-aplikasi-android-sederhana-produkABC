package com.example.produkabc;

import com.example.produkabc.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button daftar,login;
	private String username,password;
	private DBUserDAO dbUserDAO;
	private EditText txtUserName,txtPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtUserName = (EditText)findViewById(R.id.editTxtUserNameLogin);
		txtPass = (EditText)findViewById(R.id.editTxtPassLogin);
		
		daftar = (Button) findViewById(R.id.btnDaftar);
		daftar.setOnClickListener(this);
		
		login = (Button)findViewById(R.id.btnLogin);
		login.setOnClickListener(this);
		
		dbUserDAO = new DBUserDAO(this);
		dbUserDAO.open();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.btnDaftar:
				Intent formDaftar = new Intent(this, Register.class);
				startActivity(formDaftar);
				break;
			case R.id.btnLogin:
				username = null;
				password = null;
				boolean ada = false;
				if(txtUserName.getText() != null && txtPass.getText() != null){
					username = txtUserName.getText().toString();
					password = txtPass.getText().toString();
					ada = dbUserDAO.getUser(username,password);
					if(ada == true){
						Toast.makeText(this, "Selamat Datang. Silakan Berbelanja", Toast.LENGTH_SHORT).show();
						Intent produk = new Intent(this, ProdukABC.class);
						startActivity(produk);
					}else{
						Toast.makeText(this, "Kamu Bukan Member", Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
				}				
				
				break;
		}
	}
}
