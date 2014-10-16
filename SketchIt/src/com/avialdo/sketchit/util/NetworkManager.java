package com.avialdo.sketchit.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.avialdo.sketchit.SketchApp;

public class NetworkManager {

	// static Context context;
	static ConnectivityManager connManager;

	static NetworkInfo mobile;
	static NetworkInfo mWifi;
	static Context context = SketchApp.getContext();
	static NetworkInfo activeNetworkInfo;

	public  void Setup() {
		connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		mobile = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		activeNetworkInfo = connManager.getActiveNetworkInfo();
	}

	public  boolean IsConnected() {
		// boolean isConnect = false;
		Setup();
		if ((mWifi.isConnected() || mobile.isConnected())
				&& activeNetworkInfo != null) {
			return true;
		}
		return false;
	}

}
