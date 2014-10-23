package com.avialdo.sketchit.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.avialdo.sketchit.R;
import com.avialdo.sketchit.abstracts.SketchFragment;
import com.avialdo.sketchit.activities.Canvas;

public class TopRatedFragment extends SketchFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_top_rated,
				container, false);
		Button b = (Button) rootView.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TopRatedFragment.this.getActivity(),
						Canvas.class));
			}
		});

		return rootView;
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
