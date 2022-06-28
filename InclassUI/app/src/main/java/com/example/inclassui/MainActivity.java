package com.example.inclassui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.inclassui.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements MyDialogBox.MyDialogBoxListener{

    //binding
    private ActivityMainBinding binding;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.setText("Toast Button was pressed");

                // Create a toast, using built in Android sdk function
                Toast myToast = Toast.makeText(getApplicationContext(),"Here is a toast!",Toast.LENGTH_SHORT);
                myToast.show() ;
            }
        });

        binding.btnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.setText("SnackBar Button was pressed");

                Snackbar mySnackbar = Snackbar.make(binding.getRoot(),"Here is a snackbar",Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });

        binding.btnBasicDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.setText("BasicDialog button was pressed");

                // Create an instance of a dialog box
                MyDialogBox myDialog = new MyDialogBox();

                myDialog.show(getSupportFragmentManager(),"My Dialog");
            }
        });

        binding.btnCustomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.setText("Custom Layout button was pressed");
            }
        });
    }

    @Override
    public void onDialogYesPressed() {
        Log.d("ABC","Yes button pressed on dialog");
        counter++;
        binding.tvResult.setText("Current count: " + counter);
    }

    @Override
    public void onDialogNoPressed(int numberToStartWith) {
        Log.d("ABC","No button pressed on dialog");
        counter = numberToStartWith;
        binding.tvResult.setText("Resetting the number to: " + counter);
    }
}