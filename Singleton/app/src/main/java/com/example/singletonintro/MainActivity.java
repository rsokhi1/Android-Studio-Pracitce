package com.example.singletonintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.singletonintro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Employee myEmployee = new Employee();
        EmployeeSingleton myEmployee = EmployeeSingleton.getInstance();
        myEmployee.setName("Michelle");
        myEmployee.setHourlyRate(25.00);

        Log.d("Screen1",myEmployee.getName() + "'s hourly wage is $" + myEmployee.getHourlyRate());

        binding.btnScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                //intent.putExtra("EXTRA_EMP",myEmployee);
                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        EmployeeSingleton myEmployee = EmployeeSingleton.getInstance();
        Log.d("Screen1",myEmployee.getName() + "'s hourly wage is $" + myEmployee.getHourlyRate());
    }

}