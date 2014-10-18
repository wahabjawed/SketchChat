package com.avialdo.sketchit.request;

import android.content.Context;

import com.avialdo.sketchit.SketchApp;
import com.avialdo.sketchit.abstracts.SketchNetworkActivity;
import com.avialdo.sketchit.abstracts.SketchNetworkFragment;

public class IRequestHandler {

	public interface Activity {

		public Context context = SketchApp.getContext();
		// public String
		// networkAddress="http://fajjemobile.info/VidtureApp/WebService/";
		public String networkAddress = "http://54.183.77.229";

		public abstract void PerformTask(SketchNetworkActivity _activity);
	}

	public interface Fragment {

		public Context context = SketchApp.getContext();
		// public String
		// networkAddress="http://fajjemobile.info/VidtureApp/WebService/";
		public String networkAddress = "http://54.183.77.229";

		public abstract void PerformTask(SketchNetworkFragment _activity);
	}

}
