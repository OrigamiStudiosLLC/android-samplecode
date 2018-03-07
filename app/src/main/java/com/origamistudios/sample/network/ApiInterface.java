package com.origamistudios.sample.network;

import com.origamistudios.sample.model.apiresponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<LoginResponse> getRegistrationResponse(@Field("first_name") String firstName,
                                                @Field("last_name") String lastName,
                                                @Field("username") String username,
                                                @Field("password") String password,
                                                @Field("gender") String gender,
                                                @Field("email") String email,
                                                @Field("device_token") String deviceToken);

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> getLoginResponse(@Field("device_token") String deviceToken);

}
