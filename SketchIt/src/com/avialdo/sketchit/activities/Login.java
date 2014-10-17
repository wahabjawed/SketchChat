package com.avialdo.sketchit.activities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.database.Cursor;
import android.database.DatabaseUtils.InsertHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchNetworkActivity;
import com.avialdo.sketchit.util.SQLHelper;

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

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor phones = getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, null, null, null);
				while (phones.moveToNext()) {

					if (phones
							.getString(
									phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER))
							.equals("1")) {
						String name = phones.getString(phones
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
						String phoneNumber = phones.getString(phones
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						Log.d("Phone data", name + "---" + phoneNumber + "---");
					}

				}
				phones.close();
			}
		});

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
		if (user_email.getText().length() > 0
				&& password.getText().length() > 0) {

			login.setVisibility(View.VISIBLE);
		} else {
			login.setVisibility(View.INVISIBLE);

		}
	}

}
