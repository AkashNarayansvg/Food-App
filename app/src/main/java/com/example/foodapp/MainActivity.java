package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodapp.adapters.MainAdapter;
import com.example.foodapp.databinding.ActivityMainBinding;
import com.example.foodapp.models.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //getting activity main recycler view
        setContentView(binding.getRoot());

        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(R.drawable.download1,"Burger","5","burger with cheese fried"));
        list.add(new MainModel(R.drawable.download2,"Pizza","5","burger with cheese fried"));
        list.add(new MainModel(R.drawable.download3,"HotDog","5","burger with cheese fried"));
        list.add(new MainModel(R.drawable.download1,"Burger","5","burger with cheese fried"));
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this , orderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}