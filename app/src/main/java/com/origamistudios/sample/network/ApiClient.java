package com.origamistudios.sample.network;


import com.origamistudios.sample.utilities.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements Constants {
    // base url for the API Client
    private static final String BASE_URL = kBaseUrl;
    // Retrofit client instance
    private static Retrofit retrofit = null;
    // Singleton initialization of Retrofit client instance
    public static Retrofit getClient() {
        if (retrofit == null) {
            // OkHTTPClient Client initialization
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    // Connection timeout 40 seconds
                    .connectTimeout(40, TimeUnit.SECONDS)
                    // Socket Read timeout 40 seconds
                    .readTimeout(40, TimeUnit.SECONDS)
                    // Add HTTP logging interceptor at body level
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
            retrofit = new Retrofit.Builder()
                    // Add GSON parser
                    .addConverterFactory(GsonConverterFactory.create())
                    // Set base url
                    .baseUrl(BASE_URL)
                    // set httpClient OkHTTPClient.
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }
}