package com.example.multiscreen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multiscreen1.databinding.ActivityMainBinding;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameUI = binding.etName.getText().toString();
                String ageUI = binding.etAge.getText().toString();
                int age = Integer.parseInt(ageUI);


                // 1 Create an explicit intent
                // The starting screen and the destination screen
                Intent intent = new Intent(getApplicationContext(),Screen2Activity.class);

                intent.putExtra("EXTRA_NAME",nameUI);
                intent.putExtra("EXTRA_AGE",age);

                //double
                intent.putExtra("EXTRA_HEIGHT",182.91);

                //boolean
                intent.putExtra("EXTRA_HAS_PET",true);

                // array
                String[] friendsList = {"Falgun","Gurtej","Anuraj"};
                intent.putExtra("EXTRA_FRIENDS",friendsList);

                // Custom Object
                Car c1 = new Car(2011, "Toyota Corolla", "Blue",false);

                intent.putExtra("EXTRA_CAR",c1);

                //
                Dog d1 = new Dog("Whisky","Labrador");
                intent.putExtra("EXTRA_DOG",d1);

                //Array list of custom objects
                ArrayList<Dog> dogList = new ArrayList<Dog>();
                dogList.add(new Dog("Rover","Boxer"));
                dogList.add(new Dog("Cookie","Collie"));
                dogList.add(new Dog("Francois","Poodle"));

                intent.putExtra("EXTRA_DOGS_LIST",dogList);

                // 2 Use the startActivity()
                startActivity(intent);

            }
        });

        binding.btnScreen3main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Screen3Activity.class);

                startActivity(intent);
            }
        });
    }
}