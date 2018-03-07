package com.origamistudios.sample.model.apiresponse;

import com.origamistudios.sample.model.modeldata.DataLogin;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("responseCode")
    private int responseCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataLogin dataLogin;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLogin getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }
}
