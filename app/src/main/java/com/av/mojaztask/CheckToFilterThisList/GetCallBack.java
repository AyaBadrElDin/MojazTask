package com.av.mojaztask.CheckToFilterThisList;

import java.util.ArrayList;

/**
 * Created by Aya on 5/5/2018.
 */

public interface GetCallBack {

    interface  AllListOfItemsCallBack{
        void  onSuccess(ArrayList<ItemData> success);
        void  onFailure();
        void  onNetworkFailure();

    }

}
