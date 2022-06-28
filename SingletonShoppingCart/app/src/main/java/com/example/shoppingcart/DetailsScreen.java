package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shoppingcart.databinding.ActivityDetailsScreenBinding;
import com.example.shoppingcart.db.ProductsManagerSingleton;
import com.example.shoppingcart.models.Product;
import com.google.android.material.snackbar.Snackbar;

public class DetailsScreen extends AppCompatActivity {

    private ActivityDetailsScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if(intent != null){
            int id = intent.getIntExtra("EXTRA_ID",-1);

            ProductsManagerSingleton productsManager = ProductsManagerSingleton.getInstance();

            Product currProduct = productsManager.getProductbyId(id);

            binding.tvResult.setText("Name: " + currProduct.getName() + "\nDesc: " + currProduct.getDesc() + "\n");
            binding.tvQTY.setText("Quantity Available: " +currProduct.getQuantityRemaining());

            binding.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currProduct.getQuantityRemaining() == 0){
                        Snackbar.make(binding.getRoot(),"Sorry, the item is out of stock",Snackbar.LENGTH_SHORT).show();
                        return;
                    }
    //                reduce the quantity for the current product
                    currProduct.setQuantityRemaining(currProduct.getQuantityRemaining() - 1);
                    binding.tvQTY.setText("Quantity Available: " +currProduct.getQuantityRemaining());
                }
            });
        }
    }
}