package com.example.sournary.retrofitstackoverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.sournary.retrofitstackoverflow.api.Service;
import com.example.sournary.retrofitstackoverflow.model.Item;
import com.example.sournary.retrofitstackoverflow.model.Stackexchange;
import com.example.sournary.retrofitstackoverflow.view.StackexchangeAdapter;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private StackexchangeAdapter mStackexchangeAdapter;
    private RecyclerView mRecyclerView;
    private List<Item> itemList;

    private void findViewByIds() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    private void initComponents() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        itemList = new ArrayList<>();
        mStackexchangeAdapter = new StackexchangeAdapter(this, itemList);
        mRecyclerView.setAdapter(mStackexchangeAdapter);
        loadItems();
    }


    private void setEvents() {

    }

    private void loadItems() {
        Service.getStackexchangeAPI().getAnswers()
                .enqueue(new Callback<Stackexchange>() {
                    @Override
                    public void onResponse(Call<Stackexchange> call, Response<Stackexchange> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            itemList = response.body().getItems();
                            mStackexchangeAdapter.updateData(itemList);
                        } else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Stackexchange> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
        initComponents();
        setEvents();
    }




}
