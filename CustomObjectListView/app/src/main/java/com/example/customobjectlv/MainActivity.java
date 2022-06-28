package com.example.customobjectlv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.customobjectlv.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    // 1 Define a data source
    ArrayList<Country> countriesList = new ArrayList<Country>();
    ArrayList<Employee> employeesList = new ArrayList<Employee>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // populate array list
        countriesList.add(new Country("Japan",12500000,"Tokyo"));
        countriesList.add(new Country("India",35500000,"Delhi"));
        countriesList.add(new Country("Pakistan",45500000,"Karachi"));

        employeesList.add(new Employee("Rajbeer","rajbeer@gmail.com"));
        employeesList.add(new Employee("Falgun","falgun@gmail.com"));
        employeesList.add(new Employee("Gurtej","gurtej@gmail.com"));

//        CountryObjectAdapter countryAdapter = new CountryObjectAdapter(this,countriesList);

        EmployeeObjectAdapter employeeAdapter = new EmployeeObjectAdapter(this,employeesList);



        binding.lvCountries.setAdapter(employeeAdapter);

        binding.lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.tvResult.setText("Selected country is " + employeesList.get(i).getName());
            }
        });
    }
}