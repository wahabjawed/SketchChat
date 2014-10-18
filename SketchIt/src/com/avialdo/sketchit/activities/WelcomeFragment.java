package com.avialdo.sketchit.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchFragment;

public class WelcomeFragment extends SketchFragment {

	Button login, signup;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	static WelcomeFragment init(int val) {
		WelcomeFragment fragment = new WelcomeFragment();
		// Supply val input as an argument.
		// Bundle args = new Bundle();
		// args.putInt("val", val);
		// truitonFrag.setArguments(args);
		return fragment;
	}

	@Override
	public void setupView(View layoutView) {
		// TODO Auto-generated method stub

		login = (Button) layoutView.findViewById(R.id.login);
		signup = (Button) layoutView.findViewById(R.id.signup);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutView = inflater.inflate(R.layout.welcome, container, false);
		setupView(layoutView);
		setupListner();

		return layoutView;
	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new Intent(Welcome.this, Login.class));
				WelcomePagerAdapter.currentPage = 2;
				WelcomePagerAdapter.mPager.setCurrentItem(2);
			}
		});

		signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new Intent(Welcome.this, Signup.class));
				WelcomePagerAdapter.currentPage = 1;
				WelcomePagerAdapter.mPager.setCurrentItem(1);
			}
		});

	}

}
