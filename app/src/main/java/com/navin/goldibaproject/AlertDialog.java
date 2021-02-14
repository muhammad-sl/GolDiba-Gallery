package com.navin.goldibaproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class AlertDialog {
    Activity  activity;

    public AlertDialog(Activity activity){
        this.activity = activity;
    }

    public void exit_dialog(){

        androidx.appcompat.app.AlertDialog alertDialog =
                new androidx.appcompat.app.AlertDialog.Builder(activity).create();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.custom_dialog,null);
        alertDialog.setView(view);

        AppCompatButton btn_no,btn_yes;
        btn_no = view.findViewById(R.id.no_btn);
        btn_yes = view.findViewById(R.id.yes_btn);

        btn_no.setOnClickListener(v -> alertDialog.cancel());

        btn_yes.setOnClickListener(v -> activity.finish());

        alertDialog.show();
    }
}
