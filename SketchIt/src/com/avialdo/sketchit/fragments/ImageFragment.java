package com.avialdo.sketchit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchFragment;

public class ImageFragment extends SketchFragment {

	public static ImageFragment init(int val) {
		ImageFragment fragment = new ImageFragment();
		// Supply val input as an argument.
		Bundle args = new Bundle();
		args.putInt("val", val);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutView = inflater.inflate(R.layout.image_fragment, container,
				false);
		setupView(layoutView);
		setupListner();

		return layoutView;
	}

	@Override
	public void setupView(View layoutView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupListner() {
		// TODO Auto-generated method stub

	}

}
