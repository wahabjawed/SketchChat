package com.avialdo.sketchit.abstracts;

import android.os.Bundle;

import com.avialdo.sketchit.networks.INetwork;

public abstract class SketchNetworkActivity extends AbstractActivity
		implements INetwork,IActivityCallBack {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

	}

}
