package com.avialdo.sketchit.zainu;

import com.avialdo.sketchit.util.*;

public class ZainuObj {

	// create an object of SingleObject
	private static ZainuObj Zainu = new ZainuObj();

	// make the constructor private so that this class cannot be
	// instantiated
	private ZainuObj() {
	}

	// Get the only object available
	public static ZainuObj getInstance() {
		return Zainu;
	}

	public NetworkManager getNetworkManager() {
		return NetworkManager;
	}

	public Notification getNotification() {
		return Notification;
	}

	public DateTime getDateTime() {
		return DateTime;
	}

	CameraUtil CameraUtil = new CameraUtil();

	NetworkManager NetworkManager = new NetworkManager();
	Notification Notification = new Notification();
	DateTime DateTime = new DateTime();

	public CameraUtil getCameraUtil() {
		return CameraUtil;
	}

}
