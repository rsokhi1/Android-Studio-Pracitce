package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferences.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // 1. Declare a shared preferences class property
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Initialize that shared preferences property
        this.sp = getSharedPreferences("MY_SP", Context.MODE_PRIVATE);

        //click handler for save button
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write code to save a value to SP

                // 1. Activate "editing" mode in SP
                SharedPreferences.Editor spEditor = sp.edit();

                // 2. Specify the data you want to save in SP(key, value)
                spEditor.putString("KEY_CAR_MODEL","Tesla Model X");
                spEditor.putInt("KEY_YEAR",2022);
                spEditor.putBoolean("KEY_IS_ELECTRIC",true);
                spEditor.putString("KEY_COLOR","Black");

                // 3. Commit the changes to SP
                spEditor.apply();

                Snackbar.make(binding.getRoot(),"Data saved!",Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Retrieve data using it's key
                String model = sp.getString("KEY_CAR_MODEL","N/A");
                int year = sp.getInt("KEY_YEAR",-1);
                String color = sp.getString("KEY_COLOR","N/A");

                binding.tvResult.setText("Name: " + model + "\nYear: " + year + "\nColor: " + color);
            }
        });

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor spEditor = sp.edit();

                // 2. Specify the data you want to save in SP(key, value)
                spEditor.putInt("KEY_YEAR",2025);

                if(sp.contains("KEY_COLOR") == true){
                    spEditor.putString("KEY_COLOR","White");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot update color",Toast.LENGTH_LONG).show();
                }
                // 3. Commit the changes to SP
                spEditor.apply();

                Snackbar.make(binding.getRoot(),"Data updated!",Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.btnDeleteAKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Activate "editing" mode in SP
                SharedPreferences.Editor spEditor = sp.edit();
                // 2. Specify the change
                spEditor.remove("KEY_COLOR");
                // 3. Commit Changes
                spEditor.commit();
                Snackbar.make(binding.getRoot(),"Key deleted!",Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.btnDeleteALl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Activate "editing" mode in SP
                SharedPreferences.Editor spEditor = sp.edit();
                // 2. Specify the change
                spEditor.clear();
                // 3. Commit Changes
                spEditor.commit();
                Snackbar.make(binding.getRoot(),"Everything is gone!",Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.btnSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                startActivity(intent);
            }
        });
    }
}