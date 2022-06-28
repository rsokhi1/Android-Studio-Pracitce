package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedpreferences.databinding.ActivitySecondScreenBinding;

public class SecondScreen extends AppCompatActivity {

    private ActivitySecondScreenBinding binding;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.sp = getSharedPreferences("MY_SP", Context.MODE_PRIVATE);

        binding.btnAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.setText("Name: " + sp.getString("KEY_CAR_MODEL","N/A"));


            }
        });
    }
}