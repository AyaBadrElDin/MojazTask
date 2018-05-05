package com.av.mojaztask.NetworkUtilities;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

import com.av.mojaztask.CheckToFilterThisList.ItemData;


/**
 * Created by Aya on 5/5/2018.
 */

public interface ApiInterface {

    @GET("photos")
    Call<ArrayList<ItemData>> GetAllListOfItems();

}
