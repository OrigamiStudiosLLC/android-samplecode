package com.origamistudios.sample.presentation.account;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.origamistudios.sample.AppController;
import com.origamistudios.sample.R;
import com.origamistudios.sample.model.apiresponse.LoginResponse;
import com.origamistudios.sample.utilities.Log;
import com.origamistudios.sample.utilities.Constants;
import com.origamistudios.sample.utilities.StatusCode;
import com.origamistudios.sample.utilities.StatusMessage;
import com.origamistudios.sample.utilities.Util;
import com.origamistudios.sample.widgets.CustomButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, Constants {

    private CustomButton btnSignUp, btnLogin;
    private String mFirstName, mLastName, mGender, mUserName, mEmail, mPassword;
    private Dialog progressBar;
    private String deviceToken = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialize();
        initClickListeners();
    }

    // Initialize views
    private void initialize() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = Util.loadingDialog(this);
    }

    // Initialize click listeners
    private void initClickListeners() {
        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSignUp) {
            if (validateFields()) {
                Util.showToastMsg(getApplicationContext(), getString(R.string.strMsgAccountCreated));
                //hitCreateAccountRequest();
            }
        } else if (v == btnLogin) {
            Util.showToastMsg(getApplicationContext(), getString(R.string.strMsgLogin));
            //hitLoginRequest();
        }
    }

    // Validate & assign values
    private boolean validateFields() {
        mFirstName = "test";
        mLastName = "test";
        mUserName = "test12345678";
        mEmail = "test@test1.com";
        mPassword = "test12345678";
        mGender = "Male";
        return true;
    }

    // Initialize create account request
    private void hitCreateAccountRequest() {
        if (!Util.isConnectingToInternet(this)) {
            Util.showToastMsg(this, Constants.kStringNetworkConnectivityError);
            return;
        }

        progressBar.show();
        deviceToken = "token";

        // Creating api request
        Call<LoginResponse> call = AppController.getApiService().getRegistrationResponse(mFirstName, mLastName, mUserName, mPassword, mGender, mEmail, deviceToken);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                progressBar.dismiss();
                try {
                    //noinspection ConstantConditions
                    if (response.body().getResponseCode() == StatusCode.SUCCESS) {
                        //noinspection ConstantConditions
                        Util.showToastMsg(getApplicationContext(), response.body().getMessage());
                    } else {
                        //noinspection ConstantConditions
                        Util.showToastMsg(getApplicationContext(), response.body().getMessage());
                    }
                } catch (Exception e) {
                    Util.showToastMsg(getApplicationContext(), StatusMessage.EXCEPTION_MESSAGE);
                    Log.e(Constants.EXCEPTION, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressBar.dismiss();
                Log.e(Constants.EXCEPTION, t.getMessage());
                Util.showToastMsg(getApplicationContext(), StatusMessage.SERVER_EXCEPTION_MESSAGE);
            }
        });

    }

    // Initialize login request
    private void hitLoginRequest() {
        if (!Util.isConnectingToInternet(this)) {
            Util.showToastMsg(this, Constants.kStringNetworkConnectivityError);
            return;
        }

        progressBar.show();
        deviceToken = "token";

        Call<LoginResponse> call = AppController.getApiService().getLoginResponse(deviceToken);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                progressBar.dismiss();
                try {
                    //noinspection ConstantConditions
                    if (response.body().getResponseCode() == StatusCode.SUCCESS) {
                        //noinspection ConstantConditions
                        Util.showToastMsg(getApplicationContext(), response.body().getMessage());
                    } else {
                        //noinspection ConstantConditions
                        Util.showToastMsg(getApplicationContext(), response.body().getMessage());
                    }
                } catch (Exception e) {
                    Util.showToastMsg(getApplicationContext(), StatusMessage.EXCEPTION_MESSAGE);
                    Log.e(Constants.EXCEPTION, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressBar.dismiss();
                Log.e(Constants.EXCEPTION, t.getMessage());
                Util.showToastMsg(getApplicationContext(), StatusMessage.SERVER_EXCEPTION_MESSAGE);
            }
        });
    }
}
