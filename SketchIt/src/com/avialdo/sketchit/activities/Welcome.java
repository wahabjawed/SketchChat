package com.avialdo.sketchit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchActivity;

public class Welcome extends SketchActivity {

	Button login, signup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		setupView();
		setupListner();

	}

	@Override
	public void setupView() {
		// TODO Auto-generated method stub

		login = (Button) findViewById(R.id.login);
		signup = (Button) findViewById(R.id.signup);

	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Welcome.this, Login.class));
			}
		});

		signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Welcome.this, Signup.class));
			}
		});

	}

}
