package com.example.phonegap_demo;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;


public class MainActivity extends DroidGap {

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        super.setStringProperty("errorUrl", "file:///android_asset/www/error.html");
        
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) { //縱向
            super.setIntegerProperty("splashscreen", R.drawable.splash);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 鎖定縱向
        } else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { //橫向
        	super.setIntegerProperty("splashscreen", R.drawable.landscape);
        	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 鎖定橫向 
        }
        this.setIntegerProperty("loadUrlTimeoutValue", 30000);
        super.loadUrl(Config.getStartUrl(),10000);
    }
}
