package com.avialdo.sketchit.request;

import android.content.Context;

import com.avialdo.sketchit.SketchApp;
import com.avialdo.sketchit.abstracts.SketchNetworkActivity;

public interface IRequestHandler {

	public Context context = SketchApp.getContext();
	// public String
	// networkAddress="http://fajjemobile.info/VidtureApp/WebService/";
	public String networkAddress = "http://54.183.77.229";

	public abstract void PerformTask(SketchNetworkActivity _activity);

}
