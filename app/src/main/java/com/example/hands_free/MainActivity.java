package com.example.hands_free;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.hands_free.databinding.ActivityMainBinding;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCollector(View view){
        Intent intent = new Intent(MainActivity.this, CollectorActivity.class);
        startActivity(intent);
    }

    public void onClickShoper(View view){
        Intent intent = new Intent(MainActivity.this, ShoperActivity.class);
        startActivity(intent);
    }

}

