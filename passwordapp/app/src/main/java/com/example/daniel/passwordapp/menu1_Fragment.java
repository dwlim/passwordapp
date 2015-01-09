package com.example.daniel.passwordapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class menu1_Fragment extends Fragment implements View.OnClickListener {
    View rootview = null;
    @Nullable
    Button btn;
    private String favColor = "";
    private String favFood = "";
    private String favPet = "";

    static private int specialChar;
    static private int numberChar;
    static private int capitalChar;

    private TextView textout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        btn = (Button) rootview.findViewById(R.id.generatePW);
        btn.setOnClickListener(this);
        return rootview;
    }


    public void onClick(View v){
        String output = "";
        textout = (TextView) getView().findViewById(R.id.txtOutput);
        EditText color = (EditText) getView().findViewById(R.id.favColor);
        EditText food = (EditText) getView().findViewById(R.id.favFood);
        EditText pet = (EditText) getView().findViewById(R.id.favPet);

        EditText capital = (EditText) getView().findViewById(R.id.capitalCount);
        EditText special = (EditText) getView().findViewById(R.id.specialCount);

        favColor = color.getText().toString().toLowerCase();
        favFood = food.getText().toString().toLowerCase();
        favPet = pet.getText().toString().toLowerCase();
        capitalChar = Integer.parseInt(capital.getText().toString());
        specialChar = Integer.parseInt(special.getText().toString());

        manipulateString edit = new manipulateString();
        output = edit.mergeStrings(favColor, favFood, favPet);
        output = edit.replaceSpecialChar(output, specialChar);
        output = edit.replaceCapital(output, capitalChar);
        textout.setText(output);
    }
}
