package com.avialdo.sketchit.request;

import com.avialdo.sketchit.abstracts.SketchNetworkActivity;
import com.avialdo.sketchit.abstracts.SketchNetworkFragment;

public class IRequestHandler {

	public interface Activity {

		public abstract void PerformTask(SketchNetworkActivity _activity);
	}

	public interface Fragment {

		public abstract void PerformTask(SketchNetworkFragment _activity);
	}

}
