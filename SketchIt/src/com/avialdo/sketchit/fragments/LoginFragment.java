package com.avialdo.sketchit.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchNetworkFragment;

public class LoginFragment extends SketchNetworkFragment {

	Button login;
	EditText user_email, password;

	Animation animation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void setupView(View layoutView) {
		// TODO Auto-generated method stub
		login = (Button) layoutView.findViewById(R.id.login);
		user_email = (EditText) layoutView.findViewById(R.id.user_email);
		password = (EditText) layoutView.findViewById(R.id.password);
	}

	public static LoginFragment init(int val) {
		LoginFragment fragment = new LoginFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutView = inflater.inflate(R.layout.login, container, false);
		setupView(layoutView);
		setupListner();
		this.getActivity()
				.getWindow()
				.setSoftInputMode(
						WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

		return layoutView;
	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor phones = LoginFragment.this
						.getActivity()
						.getContentResolver()
						.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
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
			if (login.getVisibility() == View.INVISIBLE) {
				login.setVisibility(View.VISIBLE);
				animation = AnimationUtils.loadAnimation(this.getActivity(),
						R.anim.fade_in);
				login.setAnimation(animation);
			}
		} else {
			if (login.getVisibility() == View.VISIBLE) {
				animation = AnimationUtils.loadAnimation(this.getActivity(),
						R.anim.fade_out);
				login.setAnimation(animation);
				login.setVisibility(View.INVISIBLE);
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

}
