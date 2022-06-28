package com.example.inclassui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogBox extends DialogFragment {
    private MyDialogBoxListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //1. Begin constructing our alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //2. Configure the look and feel of the Alert Dialog
        // -Specify the message
        // -buttons
        builder.setMessage("Here is a dialog box");

        //3. Configure the behaviour of the alert dialog
        // - What happens when buttons are pressed

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogYesPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogNoPressed(99);
            }
        });
        //4. Return an instance of the alert Dialog
        return builder.create();
    }

    public interface MyDialogBoxListener{
        public void onDialogYesPressed();
        public void onDialogNoPressed(int numberToStartWith);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        try{
            listener = (MyDialogBoxListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement the dialog box listener");
        }

    }

}
