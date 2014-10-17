package com.avialdo.sketchit.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchNetworkActivity;

public class Login extends SketchNetworkActivity {

	Button login;
	EditText user_email, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		setupView();
		setupListner();

	}

	@Override
	public void postRequestExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void preRequestExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void progressUpdate(String update) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		login = (Button) findViewById(R.id.login);
		user_email = (EditText) findViewById(R.id.user_email);
		password = (EditText) findViewById(R.id.password);
	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

	user_email.addTextChangedListener(new TextWatcher() {
		

		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			changeButtonVisibility();
		}
	});
	
	password.addTextChangedListener(new TextWatcher() {
		

		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			changeButtonVisibility();
		}
	});
	}

	private void changeButtonVisibility() {
		if (user_email.getText().length()>0 && password.getText().length()>0) {

			login.setVisibility(View.VISIBLE);
		} else {
			login.setVisibility(View.INVISIBLE);

		}
	}

}
