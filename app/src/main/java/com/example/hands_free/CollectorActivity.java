package com.example.hands_free;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hands_free.databinding.ActivityCollectorBinding;

public class CollectorActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCollectorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector);
    }

    public void onClickShortestPath(View view){
        Intent intent = new Intent(CollectorActivity.this, ShortestPathActivity.class);
        startActivity(intent);
    }

}