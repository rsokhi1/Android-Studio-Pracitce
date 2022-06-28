package com.example.manipulatingcustomobj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.manipulatingcustomobj.databinding.CustomRowLayoutBinding;

import java.util.List;

public class CountryObjectAdapter extends ArrayAdapter {

    private List<Country> countriesList;

    public CountryObjectAdapter(@NonNull Context context, List<Country> countriesList)
    {
        super(context, 0);
        this.countriesList = countriesList;
    }

    @Override
    public int getCount() {
        return countriesList.size();
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row_layout, parent, false);
        }

        Country currCountry = countriesList.get(position);

        CustomRowLayoutBinding binding = CustomRowLayoutBinding.bind(convertView);

        // @TODO: code to update the ui
        binding.tvCountryName.setText(currCountry.getName());
        binding.tvCountryCapital.setText(currCountry.getCapitalCity());
        binding.tvCountryPopulation.setText(String.valueOf(currCountry.getPopulation()));



        // Return the completed view to render on screen
        return convertView;
    }

}