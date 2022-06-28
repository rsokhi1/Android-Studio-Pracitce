package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // 1 Define a data source
    String[] citiesList = {"Chicago", "New York City", "Toronto", "Washington DC"};

    ArrayList<String> places = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        places.add("CN Tower");
        places.add("Eiffel Tower");
        places.add("Pyramids");
        places.add("Zero Mile");


        // 2 Create an adapter (ArrayAdapter)
//        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,citiesList);

//        ArrayAdapter<String> placesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,places);

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this, R.layout.custom_row_layout,citiesList);

        // 3 Configure the ListView to use the Adapter
        binding.lvCities.setAdapter(citiesAdapter);
//        binding.lvCities.setAdapter(placesAdapter);

        // 4 Detect when the user clicks on the row in the list view
        binding.lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.tvResult.setText("Selected city is " + citiesList[i]);
            }
        });
    }
}