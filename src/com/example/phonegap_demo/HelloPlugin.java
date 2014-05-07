package com.example.phonegap_demo;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.ActivityInfo;
import android.util.Log;

public class HelloPlugin extends CordovaPlugin {
	
	public static final String NATIVE_ACTION_STRING="nativeAction"; 
	public static final String SUCCESS_PARAMETER="success";
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (NATIVE_ACTION_STRING.equals(action)) { 
            String resultType = null; 
            try { 
                  resultType = data.getString(0); 
            } 
            catch (Exception ex) { 
                  Log.d("HelloPlugin", ex.toString()); 
            } 
            if (resultType.equals(SUCCESS_PARAMETER)) {
            	this.cordova.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            	callbackContext.success();
            	return true;
            } 
            else { 
            	callbackContext.error("Invalid action");
            	return false;
            } 
      } 
      return false;
	}
}
