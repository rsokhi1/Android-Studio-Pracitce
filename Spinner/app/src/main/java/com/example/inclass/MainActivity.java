package com.example.inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inclass.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    //1 Define a data source
    // A fixed size array
    String[] fruitslist = {"Apple","Banana","Carrot","Donut","Eggplant"};
    String[] cities = {"Madrid","Nagpur","Pune","Toronto"};
    // Java's Dynamically sized array
    ArrayList<String> animalList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Cheetah");
        animalList.add("Bobcat");

        // 2 Create an adapter
        // The ArrayAdapter class needs:
        // - list of data
        // - template for what each row of the dropdown menu will look like
        // - The data source
        ArrayAdapter<String> fruitsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,fruitslist);

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this,R.layout.custom_dropdown_menu,cities);

//        ArrayAdapter<String> animalsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,animalList);
//        ArrayAdapter<String> animalsAdapter = new ArrayAdapter<String>(this, R.layout.custom_dropdown_menu,animalList);


        //3 Associate the ArrayAdapter to the spinner
        binding.spFruits.setAdapter(fruitsAdapter);
        binding.spCities.setAdapter(citiesAdapter);



        int selPos = binding.spCities.getSelectedItemPosition();

        binding.spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                binding.tvResult.setText("The position of the selected city is: " + i);
                binding.tvResult.setText("The selected city is: " + cities[i]);

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}