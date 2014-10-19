package com.avialdo.sketchit.abstracts;

import android.content.Context;
import android.widget.Toast;

import com.avialdo.sketchit.SketchApp;
import com.avialdo.sketchit.util.SQLHelper;
import com.avialdo.sketchit.zainu.ZainuObj;

public class AbstractRequest {

	protected SQLHelper db;
	protected ZainuObj Zainu = ZainuObj.getInstance();
	public Context context = SketchApp.getContext();
	// public String
	// networkAddress="http://fajjemobile.info/VidtureApp/WebService/";
	public String networkAddress = "http://54.183.77.229";

	public void showToast(String text, int duration) {

		Toast.makeText(SketchApp.getContext(), text, duration).show();
	}
}
