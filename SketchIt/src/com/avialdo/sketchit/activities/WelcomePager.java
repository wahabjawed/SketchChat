package com.avialdo.sketchit.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.fragments.LoginFragment;
import com.avialdo.sketchit.fragments.SignupFragment;
import com.avialdo.sketchit.fragments.WelcomeFragment;

public class WelcomePager extends FragmentActivity {

	static final int ITEMS = 3;
	MyAdapter mAdapter;
	public static ViewPager mPager;
	public static int currentPage = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_pager);
		mAdapter = new MyAdapter(getSupportFragmentManager());
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		mPager.setCurrentItem(1);

	}

	@Override
	public void onBackPressed() {

		if (currentPage == 1) {
			super.onBackPressed();
		} else {
			mPager.setCurrentItem(1);
			currentPage = 1;
		}
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

			switch (position) {
			case 1: // Fragment # 0 - This will show image
				return WelcomeFragment.init(position);
			case 0: // Fragment # 1 - This will show image
				return SignupFragment.init(position);
			case 2:// Fragment # 2-9 - Will show list
				return LoginFragment.init(position);
			default:
				return WelcomeFragment.init(position);
			}
		}
	}

}
