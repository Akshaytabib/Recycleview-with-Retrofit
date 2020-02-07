package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Post> arrayList;
    private JsonHolderApi apiInterface;
    String url="https://jsonplaceholder.typicode.com/posts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        callApi();

    }

    private void init() {
        //recyleview
        recyclerView=findViewById(R.id.recyleview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void callApi() {

        apiInterface=ApiClient.getApiClient().create(JsonHolderApi.class);

        Call<List<Post>> call=apiInterface.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                arrayList=new ArrayList<>(response.body());
                ModelAdapter modelAdapter=new ModelAdapter(MainActivity.this,arrayList);
                recyclerView.setAdapter(modelAdapter);
                Toast.makeText(MainActivity.this, "Sucessful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
