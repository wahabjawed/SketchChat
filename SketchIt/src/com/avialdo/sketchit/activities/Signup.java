package com.avialdo.sketchit.activities;

import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchNetworkActivity;

public class Signup extends SketchNetworkActivity {

	Button signup;
	EditText user_email, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.signup);
		setupView();
		setupListner();
		getAccountEmail();

	}

	private void getAccountEmail() {
		Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
		Account[] accounts = AccountManager.get(this).getAccounts();

		for (Account account : accounts) {
			if (emailPattern.matcher(account.name).matches()) {
				user_email.setText(account.name);
				password.requestFocus();
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
				break;

			}
		}
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
		signup = (Button) findViewById(R.id.signup);
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
		if (user_email.getText().length() > 0
				&& password.getText().length() > 0) {

			signup.setVisibility(View.VISIBLE);
		} else {
			signup.setVisibility(View.INVISIBLE);

		}
	}

}
