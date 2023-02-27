package com.example.mytiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Adapter;

import com.example.mytiktok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Model> modelArrayList= new ArrayList<>();
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getTheme().applyStyle(R.style.Fullscreen,false);
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.college, R.drawable.profile,"Vishal"));
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.name_long, R.drawable.profile,"kashish"));
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.universe, R.drawable.profile,"Raj"));
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vegan, R.drawable.profile,"Shell"));
        adapter = new CustomAdapter(modelArrayList, MainActivity.this);
        binding.vpg2.setAdapter(adapter);
    }
}