package com.av.mojaztask.CheckToFilterThisList;

import com.av.mojaztask.NetworkUtilities.ApiClient;
import com.av.mojaztask.NetworkUtilities.ApiInterface;

import org.json.JSONArray;

import java.net.UnknownHostException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Aya on 5/5/2018.
 */

public class ItemDataModel  {

    public static ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

    public  static void AllListOfItem (final GetCallBack.AllListOfItemsCallBack callback){
        Call<ArrayList<ItemData>> allListOfItemsCall =apiInterface.GetAllListOfItems();
        allListOfItemsCall.enqueue(new Callback<ArrayList<ItemData>>() {
            @Override
            public void onResponse(Call<ArrayList<ItemData>> call, Response<ArrayList<ItemData>> response) {
                 if(response.isSuccessful()){
                     callback.onSuccess(response.body());
                 }
            }

            @Override
            public void onFailure(Call<ArrayList<ItemData>> call, Throwable t) {
                if(t instanceof UnknownHostException){
                    callback.onNetworkFailure();
                }else{
                    callback.onFailure();
                }
            }

        });

    }

}
