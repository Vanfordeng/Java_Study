package com.study_mars.Practice_Mars.logic;

import com.study_mars.Practice_Mars.io.UserInputIO;
import com.study_mars.Practice_Mars.ui.UserAdminUI;
import com.study_mars.Practice_Mars.validitycheck.UserInputCheck;

/**
 * Created by Doctor on 2016/9/14.
 */
public class MainLopper {
    private boolean flag = true;
    public UserInputIO userInputIO;
    private UserAdminUI userAdminUI;
    private UserInputCheck userInputCheck;

    public MainLopper() {
        userInputIO = new UserInputIO();
        userInputCheck = new UserInputCheck();
        userAdminUI = new UserAdminUI();
    }
    public void loop(){
        while (flag){
            String input = userInputIO.getInputLine();
            userAdminUI.tipsForUser(userInputCheck.getUserChooseID(input));
        }
    }
}
