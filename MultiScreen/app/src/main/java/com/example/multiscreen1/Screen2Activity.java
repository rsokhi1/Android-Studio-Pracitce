package com.example.multiscreen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.multiscreen1.databinding.ActivityMainBinding;
import com.example.multiscreen1.databinding.ActivityScreen2Binding;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Screen2Activity extends AppCompatActivity {
    private ActivityScreen2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if(intent != null){
            String nameFromScreen1 = intent.getStringExtra("EXTRA_NAME");
            int ageFromScreen1 = intent.getIntExtra("EXTRA_AGE",0);

            double heightFromScreen1 = intent.getDoubleExtra("EXTRA_HEIGHT",0);

            boolean petFromScreen1 = intent.getBooleanExtra("EXTRA_HAS_PET",false);

            String[] arrayFromScreen1 = intent.getStringArrayExtra("EXTRA_FRIENDS");

            Serializable serializableCar =  intent.getSerializableExtra("EXTRA_CAR");
            Car carFromScreen1 = (Car) serializableCar;



            Dog dogFromScreen1 =(Dog) intent.getSerializableExtra("EXTRA_DOG");

            ArrayList<Dog> dogListFromScreen1 = (ArrayList<Dog>) intent.getSerializableExtra("EXTRA_DOGS_LIST");


            binding.tvResult.setText(nameFromScreen1 + " is " + ageFromScreen1 + " years old");
            Log.d("ABC","Name is " + nameFromScreen1);
            Log.d("ABC","Age is " + ageFromScreen1);
            Log.d("ABC","Height is " + heightFromScreen1);
            Log.d("ABC","Has pet? " + petFromScreen1);
            Log.d("ABC","Number of friends: " + arrayFromScreen1.length);
            Log.d("ABC","Car: " + carFromScreen1.toString());
            Log.d("ABC","Dog: " + dogFromScreen1.toString());
            Log.d("ABC","Number of Dogs: " + dogListFromScreen1.size());

            for(Dog d : dogListFromScreen1 ){
                Log.d("ABC",d.toString());
            }
        }


        binding.btnScreen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Screen3Activity.class);

                startActivity(intent);
            }
        });
    }
}