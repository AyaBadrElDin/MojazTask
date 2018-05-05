package com.av.mojaztask.NetworkUtilities;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aya on 5/5/2018.
 */

public class ApiClient {

    public static final String BASE_URL   = "https://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit==null)
        {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS).build();

            retrofit=new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
