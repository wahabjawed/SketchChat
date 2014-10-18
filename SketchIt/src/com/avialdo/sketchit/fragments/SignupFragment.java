package com.avialdo.sketchit.fragments;

import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchNetworkFragment;

public class SignupFragment extends SketchNetworkFragment {

	Button signup;
	EditText user_email, password;
	Animation animation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	public static SignupFragment init(int val) {
		SignupFragment fragment = new SignupFragment();
		// Supply val input as an argument.
		// Bundle args = new Bundle();
		// args.putInt("val", val);
		// truitonFrag.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutView = inflater.inflate(R.layout.signup, container, false);
		setupView(layoutView);
		setupListner();
		getAccountEmail();
		this.getActivity()
				.getWindow()
				.setSoftInputMode(
						WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

		return layoutView;
	}

	private void getAccountEmail() {
		Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
		Account[] accounts = AccountManager.get(this.getActivity())
				.getAccounts();

		for (Account account : accounts) {
			if (emailPattern.matcher(account.name).matches()) {
				user_email.setText(account.name);
				password.requestFocus();
				InputMethodManager imm = (InputMethodManager) this
						.getActivity().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
				break;

			}
		}
	}

	@Override
	public void setupView(View layoutFragment) {
		// TODO Auto-generated method stub
		signup = (Button) layoutFragment.findViewById(R.id.signup);
		user_email = (EditText) layoutFragment.findViewById(R.id.user_email);
		password = (EditText) layoutFragment.findViewById(R.id.password);

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

		signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					new 
			}
		});
	}

	private void changeButtonVisibility() {
		if (user_email.getText().length() > 0
				&& password.getText().length() > 0) {
			if (signup.getVisibility() == View.INVISIBLE) {
				signup.setVisibility(View.VISIBLE);
				animation = AnimationUtils.loadAnimation(this.getActivity(),
						R.anim.fade_in);
				signup.startAnimation(animation);
			}
		} else {
			if (signup.getVisibility() == View.VISIBLE) {
				animation = AnimationUtils.loadAnimation(this.getActivity(),
						R.anim.fade_out);
				signup.startAnimation(animation);
				signup.setVisibility(View.INVISIBLE);
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
