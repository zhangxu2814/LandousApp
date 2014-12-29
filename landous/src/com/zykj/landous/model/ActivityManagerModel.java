package com.zykj.landous.model;

import java.util.ArrayList;

import com.BeeFramework.activity.BaseActivity;

import android.content.Context;


public class ActivityManagerModel {
	public static ArrayList<BaseActivity> liveActivityList = new ArrayList<BaseActivity>();
	public static ArrayList<BaseActivity> visibleActivityList = new ArrayList<BaseActivity>();
	public static ArrayList<BaseActivity> foregroundActivityList = new ArrayList<BaseActivity>();

	public ActivityManagerModel(Context context) {
		super();
	}

	public static void addLiveActivity(BaseActivity baseActivity) {
		if (!liveActivityList.contains(baseActivity)) {
			liveActivityList.add(baseActivity);
		}
	}

	public static void removeLiveActivity(BaseActivity baseActivity) {
		liveActivityList.remove(baseActivity);
		visibleActivityList.remove(baseActivity);
		foregroundActivityList.remove(baseActivity);
	}

	public static void addVisibleActivity(BaseActivity baseActivity) {
		if (!visibleActivityList.contains(baseActivity)) {
			visibleActivityList.add(baseActivity);
		}
	}

	public static void removeVisibleActivity(BaseActivity baseActivity) {
		visibleActivityList.remove(baseActivity);
	}

	public static void addForegroundActivity(BaseActivity baseActivity) {
		if (!foregroundActivityList.contains(baseActivity)) {
			foregroundActivityList.add(baseActivity);
		}
	}

	public static void removeForegroundActivity(BaseActivity baseActivity) {
		foregroundActivityList.remove(baseActivity);
	}

}
