package com.origamistudios.sample.model.modeldata;


import com.origamistudios.sample.model.appmodels.User;
import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("user")
    private User user;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
