package com.avialdo.sketchit.util;

import android.util.Log;

public class Logs {

	final static String TAG = "Sketch It";

	public static void d(String msg) {
		Log.d(TAG, msg);
	}

	public static void e(String msg) {
		Log.e(TAG, msg);
	}

	public static void i(String msg) {
		Log.i(TAG, msg);
	}
}
