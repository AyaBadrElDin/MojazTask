package com.av.mojaztask.CheckToFilterThisList;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.av.mojaztask.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by Aya on 5/5/2018.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    Activity activity;
    ArrayList<ItemData> itemDataArrayList;
    public static ArrayList<ItemData> itemFilterList = new ArrayList<>();


    public ItemListAdapter(Activity activity ,ArrayList<ItemData>itemDataArrayList) {
        this.activity = activity;
        this.itemDataArrayList = itemDataArrayList;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {

        final ItemData itemData = itemDataArrayList.get(position);

        Glide.with(activity)
             .applyDefaultRequestOptions(new RequestOptions()
                     .placeholder(R.mipmap.ic_launcher)
                     .transform(new RoundedCorners(30)))
             .load(itemData.getThumbnailURL())
             .into(holder.itemPhoto);

        holder.itemTitle.setText(itemData.getTitle());
        holder.itemAlbumId.setText(String.valueOf(itemData.getAlbumID()));
        holder.itemCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = holder.itemCheck.isChecked();

                if(isChecked)
                    itemFilterList.add(itemData);
                else
                    itemFilterList.remove(itemData);

            }
        });


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemDataArrayList.size();
    }

}
