package com.avialdo.sketchit.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchFragment;
import com.avialdo.sketchit.activities.WelcomePager;

public class WelcomeFragment extends SketchFragment {

	Button login, signup;
	static final int ITEMS = 3;
	MyAdapter mAdapter;

	public static WelcomeFragment init(int val) {
		WelcomeFragment fragment = new WelcomeFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

		ViewPager pager = (ViewPager) layoutView.findViewById(R.id.pager);
		mAdapter = new MyAdapter(getChildFragmentManager());
		pager.setAdapter(mAdapter);
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
				WelcomePager.currentPage = 2;
				WelcomePager.mPager.setCurrentItem(2);
			}
		});

		signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new Intent(Welcome.this, Signup.class));
				WelcomePager.currentPage = 0;
				WelcomePager.mPager.setCurrentItem(0);
			}
		});

	}

	public static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public int getCount() {
			return ITEMS;
		}

		@Override
		public Fragment getItem(int position) {

			return ImageFragment.init(position);
		}
	}

}
