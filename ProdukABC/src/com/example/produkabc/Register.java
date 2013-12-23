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

public class Register extends Activity implements OnClickListener{

	private EditText txtUsername,txtPass;
	private Button daftar;
	
	private DBUserDAO dbUserDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		txtUsername = (EditText)findViewById(R.id.editTxtUserNameRegis);
		txtPass = (EditText)findViewById(R.id.editTxtPassRegis);
		daftar = (Button)findViewById(R.id.btnDaftarRegis);
		daftar.setOnClickListener(this);
		
		dbUserDAO = new DBUserDAO(this);
		dbUserDAO.open();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.btnDaftarRegis:
				String username = null;
				String pass = null;
				@SuppressWarnings("unused")
				 
				User user = null;
				if(txtUsername.getText() != null && txtPass.getText() != null){
					username = txtUsername.getText().toString();
					pass = txtPass.getText().toString();
					
					user = dbUserDAO.registerUser(username, pass);
					dbUserDAO.close();
					
					Toast.makeText(this, "Success !!!", Toast.LENGTH_SHORT).show();
					Intent login = new Intent(this, MainActivity.class);
					startActivity(login);
				}else{
					Toast.makeText(this, "Data kosong", Toast.LENGTH_SHORT).show();
				}
				
				break;
		}
	}
}
