package com.avialdo.sketchit.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.avialdo.sketchit.SketchApp;

public class HelperUtil {

	private static Context context = SketchApp.getContext();

	public static String fetchSIMNumber() {
		TelephonyManager telemamanger = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		// String getSimSerialNumber = telemamanger.getSimSerialNumber();
		return telemamanger.getLine1Number();

	}

	
}
