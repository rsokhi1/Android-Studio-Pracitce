package com.example.customobjectlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.customobjectlv.databinding.CustomRowLayoutBinding;
import com.example.customobjectlv.databinding.EmployeeRowLayoutBinding;

import java.util.List;

public class EmployeeObjectAdapter extends ArrayAdapter {

    private List<Employee> employeesList;

    public EmployeeObjectAdapter(@NonNull Context context, List<Employee> employeesList)
    {
        super(context, 0);
        this.employeesList = employeesList;
    }

    @Override
    public int getCount() {
        return employeesList.size();
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.employee_row_layout, parent, false);
        }

        Employee currEmployee = employeesList.get(position);

        EmployeeRowLayoutBinding binding = EmployeeRowLayoutBinding.bind(convertView);

        // @TODO: code to update the ui
        binding.tvEmployeeName.setText(currEmployee.getName());
        binding.tvEmployeeEmail.setText(currEmployee.getEmail());
//        binding.tvCountryPopulation.setText("This is great");



        // Return the completed view to render on screen
        return convertView;
    }

}
