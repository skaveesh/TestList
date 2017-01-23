package com.example.samintha.myapplicationlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,recyclerView2;
    MyCustomeAdapter adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        adapter = new MyCustomeAdapter(this, Data.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView2 = (RecyclerView) findViewById(R.id.recycleView2);
        adapter2 = new MyCustomeAdapter(this, Data.getData());
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this,2));
    }
}
