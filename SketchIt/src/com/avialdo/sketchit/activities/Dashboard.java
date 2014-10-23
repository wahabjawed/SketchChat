package com.avialdo.sketchit.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.fragments.TopRatedFragment;

public class Dashboard extends ActionBarActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	
	private String[] tabs = { "Top Rated", "Games", "Movies" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getSupportActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabUnselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	public class TabsPagerAdapter extends FragmentPagerAdapter {

		public TabsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int index) {

			switch (index) {
			case 0:
				// Top Rated fragment activity
				return new TopRatedFragment();
			case 1:
				// Games fragment activity
				return new TopRatedFragment();
			case 2:
				// Movies fragment activity
				return new TopRatedFragment();
			}

			return null;
		}

		@Override
		public int getCount() {
			// get item count - equal to number of tabs
			return 3;
		}

	}

}
