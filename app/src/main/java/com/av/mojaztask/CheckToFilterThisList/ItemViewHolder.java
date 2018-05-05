package com.av.mojaztask.CheckToFilterThisList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.av.mojaztask.R;

/**
 * Created by Aya on 5/5/2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView itemPhoto;
    TextView  itemTitle,itemAlbumId;
    CheckBox  itemCheck;


    public ItemViewHolder(View itemView) {
        super(itemView);
        itemPhoto   = itemView.findViewById(R.id.img_item);
        itemTitle   = itemView.findViewById(R.id.tv_title_item);
        itemAlbumId = itemView.findViewById(R.id.tv_album_id);
        itemCheck   = itemView.findViewById(R.id.checkbox_item);

    }
}
