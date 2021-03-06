package com.avialdo.sketchit.request;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.avialdo.sketchit.abstracts.AbstractRequest;
import com.avialdo.sketchit.abstracts.SketchNetworkFragment;
import com.avialdo.sketchit.util.JSONParser;
import com.avialdo.sketchit.util.SQLHelper;

public class LoginRequest extends AbstractRequest implements
		IRequestHandler.Fragment {

	String password;
	String email;
	SketchNetworkFragment activity;

	public LoginRequest(String email, String password) {

		this.password = password;
		this.email = email;
	}

	class Task extends AsyncTask<Void, Void, JSONObject> {

		@Override
		protected void onPostExecute(JSONObject result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			try {
				if (result != null) {
					JSONObject json_data = result;

					int success = json_data.getInt("success");
					if (success == 1) {
						int ID = json_data.getInt("ID");
						String name = json_data.getString("name");
						SQLHelper.registerUser(ID, name, email, password);
						activity.postRequestExecute();
					} else {
						String text = json_data.getString("message");
						activity.showToast(text, Toast.LENGTH_LONG);
					}

				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		protected JSONObject doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			Log.d("SketchIt", "Start Login");
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("password", password));
			nameValuePairs.add(new BasicNameValuePair("email", email));

			JSONParser sendData = new JSONParser();
			JSONObject result = sendData.makeHttpRequest(networkAddress
					+ "login.php", "POST", nameValuePairs);
			Log.d("SketchIt", "finish sending login info");

			return result;

		}

	}

	@Override
	public void PerformTask(SketchNetworkFragment _activity) {
		// TODO Auto-generated method stub
		activity = _activity;
		new Task().execute();
	}

}