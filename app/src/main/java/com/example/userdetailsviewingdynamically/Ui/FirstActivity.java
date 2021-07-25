package com.example.userdetailsviewingdynamically.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userdetailsviewingdynamically.Adapters.RecyclerViewAdapter;
import com.example.userdetailsviewingdynamically.Model.MainModel;
import com.example.userdetailsviewingdynamically.Network.RetrofitInstance;
import com.example.userdetailsviewingdynamically.R;

import java.util.ArrayList;
import java.util.List;


public class FirstActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    boolean horizontalClick;
    boolean verticalClick;
    public static List<MainModel> list=new ArrayList<>();

    Button nextPage;


    Button horizontalButton,verticalButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_layout);

        nextPage=findViewById(R.id.next_page_button);
        recyclerView=findViewById(R.id.recycler_view_id);
        horizontalButton=findViewById(R.id.button_id_for_horizontal_view);
        verticalButton=findViewById(R.id.button_id_for_vertical_view);


        RetrofitInstance.getDataFromApi();
        handleHorizontalButtonClick();
        handleVerticalButtonClick();
        handleNextPageButtonClick();
    }

    private void handleNextPageButtonClick() {
        nextPage.setOnClickListener(v -> {
            Intent intent=new Intent(FirstActivity.this, DynamicViewActivity.class);
            startActivity(intent);
        });
    }

    private void handleVerticalButtonClick() {
        verticalButton.setOnClickListener(v -> {
            if(!horizontalClick) {
                horizontalClick=true;
                verticalClick=false;
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(FirstActivity.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerViewAdapter = new RecyclerViewAdapter(FirstActivity.this, list);
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });
    }

    private void handleHorizontalButtonClick() {
        horizontalButton.setOnClickListener(v -> {
            if(!verticalClick){
                verticalClick=true;
                horizontalClick=false;
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager=new LinearLayoutManager(FirstActivity.this);
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);

            recyclerViewAdapter=new RecyclerViewAdapter(FirstActivity.this,list);
            recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }
}