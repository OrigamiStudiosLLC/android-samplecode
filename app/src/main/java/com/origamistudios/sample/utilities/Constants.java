package com.origamistudios.sample.utilities;

public interface Constants {
    int minTime = 1000;
    int maxTime = 9000;
    int SPLASH_DELAY_TIME = 3000;

    // Add API URL here
    String kBaseUrl = "https://your_api_url/"; // API URL

    // Toast & Alert Messages
    String kStringNetworkConnectivityError = "Please make sure your device is connected with internet.";
    String kStringTitlePermission = "Permission necessary";
    String kStringExternalStoragePermission = "External storage permission is necessary";


    // Shared Preferences
    String PREF_IS_SKIP = "onBoardSkip";

    // Arguments
    String EXCEPTION = "Exception";

}
