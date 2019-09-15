package com.example.shakil.androidsendmessageadmin.Remote;

import com.example.shakil.androidsendmessageadmin.Model.MyResponse;
import com.example.shakil.androidsendmessageadmin.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAhP2_9K0:APA91bEmsu0H-0g9s_-oDamXrESVt0rVTvWE-mo5fiDFxu2pPW5PeZc9R3VrU4JJT0CHTNFP-pp0jXDh_iBpiDm-GUhUELaMvtV3LtAgMGqo8qkG9Q0AwhJ4T-AtyXMrd2VNdBAvh-Ik"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);

}
