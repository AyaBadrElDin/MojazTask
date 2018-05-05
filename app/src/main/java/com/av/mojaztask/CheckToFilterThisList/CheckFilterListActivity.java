package com.av.mojaztask.CheckToFilterThisList;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.av.mojaztask.CheckToFilterThisList.Filtered.FilteredActivity;
import com.av.mojaztask.R;
import com.av.mojaztask.databinding.ActivityCheckFilterListBinding;

import java.util.ArrayList;

import static com.av.mojaztask.CheckToFilterThisList.ItemListAdapter.itemFilterList;

public class CheckFilterListActivity extends AppCompatActivity {

    private ActivityCheckFilterListBinding checkFilterListBinding;
    ArrayList<ItemData> getItemDataList;
    private ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_check_filter_list);
        checkFilterListBinding = DataBindingUtil.setContentView(this,R.layout.activity_check_filter_list);

        Setup_UI();

    }

    private void Setup_UI() {

        showProgressbar();

        checkFilterListBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(checkFilterListBinding.recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        checkFilterListBinding.recyclerView.addItemDecoration(dividerItemDecoration);

        GetAllItems();


    }

    private void GetAllItems(){
      ItemDataModel.AllListOfItem(new GetCallBack.AllListOfItemsCallBack() {
          @Override
          public void onSuccess(ArrayList<ItemData> itemDataArrayList) {
              getItemDataList = itemDataArrayList;
              hideProgressbar();
              Update_UI();
          }

          @Override
          public void onFailure() {
              hideProgressbar();
              checkFilterListBinding.tvError.setVisibility(View.VISIBLE);
              checkFilterListBinding.tvError.setText(getResources().getString(R.string.error_loading));

          }

          @Override
          public void onNetworkFailure() {
               hideProgressbar();
              checkFilterListBinding.tvError.setVisibility(View.VISIBLE);
              checkFilterListBinding.tvError.setText(getResources().getString(R.string.error_network));
          }
      });
    }

    private void Update_UI() {
        itemListAdapter = new ItemListAdapter(this,getItemDataList,false);
        checkFilterListBinding.recyclerView.setAdapter(itemListAdapter);
        itemListAdapter.notifyDataSetChanged();
    }

    public void onButtonFilterDoneClicked(View view) {
         if(itemFilterList.size()==0)return;

         if(itemFilterList.size()<=10){

           //  Toast.makeText(this, ""+itemFilterList.size(), Toast.LENGTH_SHORT).show();
              Intent  filteredIntent = new Intent(this, FilteredActivity.class);
              filteredIntent.putExtra("FilteredList",itemFilterList);
              startActivity(filteredIntent);


         }

    }

    private void showProgressbar(){
                      checkFilterListBinding.pbLoading.setVisibility(View.VISIBLE);
    }
    private void hideProgressbar(){checkFilterListBinding.pbLoading.setVisibility(View.INVISIBLE);
    }

}
