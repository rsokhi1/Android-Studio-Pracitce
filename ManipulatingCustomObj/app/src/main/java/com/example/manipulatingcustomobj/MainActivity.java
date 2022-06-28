package com.example.manipulatingcustomobj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.manipulatingcustomobj.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    // 1 Define a data source
    ArrayList<Country> countriesList = new ArrayList<Country>();
//    ArrayList<Employee> employeesList = new ArrayList<Employee>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // populate array list
        countriesList.add(new Country("Japan",12500000,"Tokyo"));
        countriesList.add(new Country("India",35500000,"Delhi"));
        countriesList.add(new Country("Pakistan",45500000,"Karachi"));

//        employeesList.add(new Employee("Rajbeer","rajbeer@gmail.com"));
//        employeesList.add(new Employee("Falgun","falgun@gmail.com"));
//        employeesList.add(new Employee("Gurtej","gurtej@gmail.com"));

        CountryObjectAdapter countryAdapter = new CountryObjectAdapter(this,countriesList);

//        EmployeeObjectAdapter employeeAdapter = new EmployeeObjectAdapter(this,employeesList);



        binding.lvCountries.setAdapter(countryAdapter);

        binding.lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                binding.tvResult.setText("Selected country is " + countriesList.get(i).toString());
                countriesList.remove(i);
                countryAdapter.notifyDataSetChanged();
            }

        });


        binding.btnAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 Get the name, population and capital from UI
                String nameUI = binding.etName.getText().toString();
                String capitalUI = binding.etCapital.getText().toString();
                String populationUI = binding.etPopulation.getText().toString();

               if(!nameUI.isEmpty()) {
                double population = Double.parseDouble(populationUI);

                // 2 Create a new country object
                Country newCountry = new Country(nameUI,population,capitalUI);

                // 3 Update the data source with my country object
                   countriesList.add(newCountry);

                   // 4 Update the adapter
                   countryAdapter.notifyDataSetChanged();
               }
                binding.etName.setText("");
                binding.etCapital.setText("");
                binding.etPopulation.setText("");
            }
        });

        binding.btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countriesList.clear();
                countryAdapter.notifyDataSetChanged();
            }
        });
    }
}