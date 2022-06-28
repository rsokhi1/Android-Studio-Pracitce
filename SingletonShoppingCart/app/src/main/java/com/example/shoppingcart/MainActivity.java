package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.shoppingcart.databinding.ActivityMainBinding;
import com.example.shoppingcart.db.ProductsManagerSingleton;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ProductsManagerSingleton productsManager = ProductsManagerSingleton.getInstance();
        //Populate the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,productsManager.getProductNames());

        binding.spItem.setAdapter(adapter);

        //click Handler
        binding.spItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.tvQTY.setText("Quantity Remaining:" + productsManager.getQuantityByProductId(i +1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = binding.spItem.getSelectedItemPosition() + 1;

                Intent intent = new Intent(MainActivity.this,DetailsScreen.class);
                intent.putExtra("EXTRA_ID",id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        int id = binding.spItem.getSelectedItemPosition() + 1;
        ProductsManagerSingleton productsManager = ProductsManagerSingleton.getInstance();
        binding.tvQTY.setText("Quantity Remaining:" + productsManager.getQuantityByProductId(id));
    }
}