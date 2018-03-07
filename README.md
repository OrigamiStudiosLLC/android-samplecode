# Android Sample Code

Android sample code is build to start any new app with already configured commonly used libraries and network layer integration.


## Step 1

To start new android app just clone the android app skeleton project from following link
https://github.com/OrigamiStudiosLLC/android-samplecode.git


### Base URL

Add your api base URL in constants filed

```
\app\src\main\java\com\origamistudios\sample\utilities\Constants.java

//add your api URL
String kBaseUrl = "https://your_api_url/";

```

## Step 2

Add your api route for login,  add parameter as your api require and request type, GET, POST, PUT, DELETE

```
\app\src\main\java\com\origamistudios\sample\network\ApiInterface.java

// route name like  (login)
@FormUrlEncoded
@POST("login")
Call<LoginResponse> getLoginResponse(@Field("username") String username,
                                     @Field("password") String password,
                                     @Field("device_type") String deviceType,
                                     @Field("device_token") String deviceToken);
```

## Step 3

Call your api interface method from Login, Fragment or Activity

```
   Call<LoginResponse> call = AppController.getApiService().getLoginResponse("test12345678", "12345678", "abcdefghi", "token string");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               //success response
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
              //failure response
            }
        });
```
