package com.avialdo.sketchit.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchActivity;

public class MainActivity extends SketchActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setupView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

	}
}
