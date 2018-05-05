package com.av.mojaztask.CheckToFilterThisList.Filtered;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.av.mojaztask.CheckToFilterThisList.ItemData;
import com.av.mojaztask.CheckToFilterThisList.ItemListAdapter;
import com.av.mojaztask.R;
import com.av.mojaztask.databinding.ActivityFilteredBinding;

import java.util.ArrayList;

/*
  Display filter list of items that user has been selected it.
 */

public class FilteredActivity extends AppCompatActivity {

    private ActivityFilteredBinding activityFilteredBinding;

    private ArrayList<ItemData> itemDataArrayList;
    private ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_filtered);
        activityFilteredBinding = DataBindingUtil.setContentView(this,R.layout.activity_filtered);

        itemDataArrayList = (ArrayList<ItemData>) getIntent().getSerializableExtra("FilteredList");

        Setup_UI();

    }

    private void Setup_UI() {
        activityFilteredBinding.recyclerViewFiltered.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(activityFilteredBinding.recyclerViewFiltered.getContext(),
                DividerItemDecoration.VERTICAL);
        activityFilteredBinding.recyclerViewFiltered.addItemDecoration(dividerItemDecoration);

        Update_UI();
    }

    private void Update_UI() {
        itemListAdapter = new ItemListAdapter(this,itemDataArrayList,true);
        activityFilteredBinding.recyclerViewFiltered.setAdapter(itemListAdapter);
        itemListAdapter.notifyDataSetChanged();
    }
}
