package com.example.manipulationlv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.manipulationlv.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    String[] citiesList = {"Chicago","New York City","Washington DC"};

    ArrayList<String> citiesList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Populate the array list
        citiesList.add("Chicago");
        citiesList.add("New York City");
        citiesList.add("Washington DC");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,citiesList);

        binding.lvCities.setAdapter(citiesAdapter);

        binding.lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.tvResult.setText("Selected item is: " + citiesList.get(i));

                citiesList.remove(i);
                citiesAdapter.notifyDataSetChanged();
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 Get the city from the Edit text
                String cityToAdd = binding.etName.getText().toString();
                if(!cityToAdd.isEmpty()){
                    citiesList.add(cityToAdd);
                    // 2 Update the data source (citiesList) with the new city
                    citiesAdapter.notifyDataSetChanged();
                }

                binding.etName.setText("");
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 Clear the data source
                citiesList.clear();
                citiesAdapter.notifyDataSetChanged();
            }
        });
    }
}