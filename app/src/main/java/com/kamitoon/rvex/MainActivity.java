package com.kamitoon.rvex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        serviceData();
    }

    private void serviceData() {
        Call<List<Users>> call = HttpManager.getInstance().getService().getUsersData();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful()){
                    List<Users> list = response.body();
                    Log.d("serviceData", "onResponse: " + list.size());
                    RvAdapter adapter = new RvAdapter(list);
                    recyclerView.setAdapter(adapter);
                }else{
                    try {
                        Log.d("serviceData", "else :: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("serviceData", "onFailure :: " + t);
            }
        });
    }
}
