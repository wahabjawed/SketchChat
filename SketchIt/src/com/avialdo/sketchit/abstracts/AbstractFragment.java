package com.avialdo.sketchit.abstracts;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.avialdo.sketchit.util.SQLHelper;
import com.avialdo.sketchit.zainu.ZainuObj;

public abstract class AbstractFragment extends Fragment {

	protected SQLHelper db;
	protected ZainuObj Zainu = ZainuObj.getInstance();

	public void showToast(String text, int duration) {

		Toast.makeText(this.getActivity(), text, duration).show();
	}
}
