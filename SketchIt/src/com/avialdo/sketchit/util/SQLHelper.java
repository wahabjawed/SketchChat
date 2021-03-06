package com.avialdo.sketchit.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.avialdo.sketchit.SketchApp;

public class SQLHelper {
	public static SQLiteDatabase db = SketchApp.db;

	public static void SetupDB() {
		db.execSQL("CREATE TABLE IF NOT EXISTS user(userid INTEGER, username TEXT,password TEXT, number TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Contact(ID INTEGER PRIMARY KEY, number TEXT,username TEXT, status TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Ref_Message(ID INTEGER PRIMARY KEY, message TEXT, refID INTEGER);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Tran_Message(ID INTEGER, ContactID INTEGER, MessageID INTEGER, Nofity INTEGER, Time TEXT, Day TEXT, Reminder TEXT);");
	}

	public static boolean isFirstTime() {
		Log.d("VidtureApp--SQLHelper", "isFirstTime--Checking!");
		if ((db.rawQuery("select * from Preference", null)).getCount() > 0) {
			Log.d("VidtureApp--SQLHelper", "isFirstTime--Dashboard");
			return false;
		} else {
			Log.d("VidtureApp--SQLHelper", "isFirstTime--Splash");
			return true;
		}
	}

	public static void setFirstTime() {

		ContentValues insertValues = new ContentValues();
		insertValues.put("isFirst", "1");

		db.insert("Preference", null, insertValues);
		Log.d("VidtureApp--SQLHelper", "Preference--Data inserted");
	}

	public static void clearData() {
		db.delete("Preference", null, null);
		Log.d(" VidtureApp--SQLHelper", "Menu Item--Data Deleted");

	}

	public static void DeleteContact(int id) {
		db.delete("Contact", "ID=" + id, null);
		Log.d(" VidtureApp--SQLHelper", "Dashboard List--Data Deleted");

	}

	public static Object getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Cursor getDashboardContactList() {
		// TODO Auto-generated method stub
		Log.d(" VidtureApp--SQLHelper", "Contact--Querying Data");
		return db.rawQuery("select * from Contact order by name", null);
	}

	public static Cursor getDashboardContactList(int ID) {
		// TODO Auto-generated method stub
		Log.d(" VidtureApp--SQLHelper", "Contact--Querying Data");
		return db.rawQuery("select * from Contact where ID = " + ID, null);
	}

	public static Cursor getWiFiList(int ID) {
		// TODO Auto-generated method stub
		Log.d(" VidtureApp--SQLHelper", "WiFi List--Querying Data");
		return db.rawQuery("select * from Ref_WiFi order by ssid", null);
	}

	public static void insertContact(String name, String no, byte[] pic) {
		Log.d("VidtureApp--SQLHelper", "Contact--Data" + name + " " + no);
		ContentValues insertValues = new ContentValues();
		insertValues.put("name", name);
		insertValues.put("number", no);
		insertValues.put("displayPic", pic);
		db.insert("Contact", null, insertValues);
		Log.d("VidtureApp--SQLHelper", "Contact--Data inserted");

	}

	public static void updateContact(int id, String name, String no, byte[] pic) {
		Log.d("VidtureApp--SQLHelper", "Contact--Data" + name + " " + no);
		ContentValues updateValues = new ContentValues();
		updateValues.put("name", name);
		updateValues.put("number", no);
		updateValues.put("displayPic", pic);
		db.update("Contact", updateValues, "ID= " + id, null);
		Log.d("VidtureApp--SQLHelper", "Contact--Data uptated");
	}

	public static void PopulateWiFiList(String[][] data) {

		Log.d("VidtureApp--SQLHelper", "Ref_WiFi---Truncate");
		db.delete("Ref_WiFi", null, null);
		Log.d("VidtureApp--SQLHelper", "Ref_WiFi---Inserting");

		ContentValues insertValues;
		for (int i = 0; i < data.length; i++) {
			insertValues = new ContentValues();
			insertValues.put("ssid", data[i][0]);
			insertValues.put("bssid", data[i][1]);

			Log.d("VidtureApp--SQLHelper", "Ref_WiFi--" + data[i][0]);
			db.insert("Ref_WiFi", null, insertValues);

		}
		Log.d("VidtureApp--SQLHelper", "Ref_WiFi--Data inserted");

	}

	public static void PopulateMessageList() {
		// TODO Auto-generated method stub
		String data[][] = { { "1", "hey babe, how was your day?" },
				{ "2", "Miss you :)" },
				{ "3", "Hi darl, how did you go today?" },
				{ "4", "Hey babe, what are you up to tonight?" },
				{ "5", "Hi! How was your day?" },
				{ "6", "See you tonight darl :)" } };
		Log.d("VidtureApp--SQLHelper", "Ref_Message---Truncate");
		db.delete("Ref_Message", null, null);
		Log.d("VidtureApp--SQLHelper", "Ref_Message---Inserting");

		ContentValues insertValues;
		for (int i = 0; i < data.length; i++) {
			insertValues = new ContentValues();
			insertValues.put("ID", Integer.parseInt(data[i][0]));
			insertValues.put("message", data[i][1]);
			insertValues.put("refID", -1);

			Log.d("VidtureApp--SQLHelper", "Ref_Message--" + data[i][1]);
			db.insert("Ref_Message", null, insertValues);

		}
		Log.d("VidtureApp--SQLHelper", "Ref_Message--Data inserted");

	}

	public static void registerUser(int ID, String name,String email,String password) {

		ContentValues insertValues = new ContentValues();
		insertValues.put("id", ID);
		insertValues.put("name", name);
		insertValues.put("email", email);
		insertValues.put("password", password);
		db.insert("user", null, insertValues);
		Log.d("VidtureApp--SQLHelper", "User Registered--" + email);

	}

	public static Cursor getMessageList(int ID) {
		// TODO Auto-generated method stub
		Log.d(" VidtureApp--SQLHelper", "Message--Querying Data");
		return db.rawQuery(
				"select * from Ref_Message where refID = -1 or refID=" + ID,
				null);
	}

	

	public static int getTranSequence() {

		Cursor c = db.rawQuery("select * from Tran_Message order by ID desc",
				null);
		if (c.moveToFirst()) {
			return c.getInt(c.getColumnIndex("ID")) + 1;
		} else {
			return 0;

		}

	}

	public static Cursor getLogMessageList(int iD) {
		// TODO Auto-generated method stub
		Log.d("VidtureApp--SQLHelper", "Tran_Message--Fetching Log Message");

		return db
				.rawQuery(
						"select * from Ref_Message where ID in (select MessageID from Tran_Message where ContactID="
								+ iD + ")", null);

	}

	public static void DeleteTran(int iD, String msgID) {
		// TODO Auto-generated method stub

		db.delete("Tran_WiFi",
				"ID in (select ID from Tran_Message where ContactID =" + iD
						+ " and MessageID = " + Integer.parseInt(msgID) + ")",
				null);

		db.delete("Tran_Message", "ContactID=" + iD + " and MessageID = "
				+ Integer.parseInt(msgID) + " ", null);

		Log.d(" VidtureApp--SQLHelper", "Log List--Data Deleted");
	}

}
