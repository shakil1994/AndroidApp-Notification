package com.example.shakil.androidsendmessageadmin.Common;

import com.example.shakil.androidsendmessageadmin.Remote.APIService;
import com.example.shakil.androidsendmessageadmin.Remote.FCMRetrofitClient;

public class Common {
    public static String topicName = "News";
    private static final String fcmUrl = "https://fcm.googleapis.com/";

    public static APIService getFCMClient(){
        return FCMRetrofitClient.getClient(fcmUrl).create(APIService.class);
    }
}
