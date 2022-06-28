package com.example.singletonintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.singletonintro.databinding.ActivitySecondScreenBinding;

public class SecondScreen extends AppCompatActivity {

    private ActivitySecondScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Intent intent = getIntent();
//        if(intent != null){
//            Employee empFromScreen1 = (Employee) intent.getSerializableExtra("EXTRA_EMP");
//            Log.d("Screen2",empFromScreen1.getName() + "'s hourly wage is $" + empFromScreen1.getHourlyRate());
//
//            empFromScreen1.setHourlyRate(30);
//            Log.d("Screen2",empFromScreen1.getName() + "'s hourly wage is $" + empFromScreen1.getHourlyRate());
//
//        }

        EmployeeSingleton myEmployee = EmployeeSingleton.getInstance();
        Log.d("Screen2",myEmployee.getName() + "'s hourly wage is $" + myEmployee.getHourlyRate());

        myEmployee.setHourlyRate(30);

        binding.btnScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}