package com.study_mars.Practice.src.org.marsdroid.useradmin;

import org.marsdroid.useradmin.logic.MainLooper;
import org.marsdroid.useradmin.ui.UserAdminUI;

public class Main {
	public static void main(String[] args) {
		UserAdminUI userAdminUI = new UserAdminUI();
		userAdminUI.loadUI();
		
		MainLooper mainLooper = new MainLooper();
		mainLooper.loop();
	}
}
