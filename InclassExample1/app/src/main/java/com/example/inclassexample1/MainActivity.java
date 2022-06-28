package com.example.inclassexample1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inclassexample1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // binding variable- this variable will be used to programatically access
    // ui elements on this page
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Intialize the binding variable
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create an event listener for the button

        Button mybutton = binding.btnCheck;

        //Attach a event listener to the button

        mybutton.setOnClickListener(new View.OnClickListener() {
            // When the person clicks on the button. Execute the code.
            @Override
            public void onClick(View view) {
//                Log.d("ABC","I pressed the button");
                EditText nameInput = binding.etName;
                String name = nameInput.getText().toString();
//                Log.d("ABC","Name from UI is " + name);

                EditText ageInput = binding.etAge;
                String ageStr = ageInput.getText().toString();
                int age = Integer.parseInt(ageStr);
//                Log.d("ABC","Age from UI is " + age);

                if (age >= 18) {
                    TextView result = binding.tvResults;
                    result.setText(name + " you are eligible to vote");
                } else {
                    binding.tvResults.setText(name + " you must wait " + (18 - age) + " more years to vote");
                }

            }
        });
    }
}