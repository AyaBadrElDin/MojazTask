package com.av.mojaztask.CheckToFilterThisList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.av.mojaztask.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Aya on 5/5/2018.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    Activity activity;
    ArrayList<ItemData> itemDataArrayList;
    public static ArrayList<ItemData> itemFilterList = new ArrayList<>();
    boolean isFiltered;


    public ItemListAdapter(Activity activity ,ArrayList<ItemData>itemDataArrayList,boolean isFiltered) {
        this.activity           =  activity;
        this.itemDataArrayList  = itemDataArrayList;
        this.isFiltered         = isFiltered;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {

        final ItemData itemData = itemDataArrayList.get(position);


        if(isFiltered)
         holder.itemCheck.setVisibility(View.INVISIBLE);
        else
        holder.itemCheck.setVisibility(View.VISIBLE);


        Glide.with(activity)
               .applyDefaultRequestOptions(new RequestOptions()
               .placeholder(R.mipmap.ic_launcher)
               .transform(new RoundedCorners(30))
             )
             .load(itemData.getThumbnailURL() )
             .into(holder.itemPhoto);


        boolean isChecked = itemData.isChecked();
        if(isChecked)
        holder.itemCheck.setChecked(true);
        else
        holder.itemCheck.setChecked(false);

        holder.itemTitle.setText(itemData.getTitle());

        holder.itemAlbumId.setText(String.valueOf(itemData.getAlbumID()));

        holder.itemCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = holder.itemCheck.isChecked();

                if(isChecked){
                    itemFilterList.add(itemData);
                    itemData.setChecked(true);
                }else{
                    itemFilterList.remove(itemData);
                    itemData.setChecked(false);

                }


            }
        });


    }



    @Override
    public int getItemCount() {
        return itemDataArrayList.size();
    }

}
