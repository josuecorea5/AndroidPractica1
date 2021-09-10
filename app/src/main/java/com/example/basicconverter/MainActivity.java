package com.example.basicconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    String[] options = {"Kilometers to Meters","Meters to Kilometers","Meters to Centimeters",
    "Centimeters to Meters","Meters to Feet","Feet to Meters"};
    Spinner objSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         objSpinner = (Spinner) findViewById(R.id.listConversion);
        ArrayAdapter<String> theAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,options);
        objSpinner.setAdapter(theAdapter);

        Button theBotton = (Button)findViewById(R.id.btnCalculate);
        theBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOption;
                selectedOption = objSpinner.getSelectedItemPosition();
                EditText objAmount = (EditText)findViewById(R.id.txtAmount);
                TextView objLabel = (TextView)findViewById(R.id.lblResults);
                Double amount = 0.0, result = 0.0;
                amount = Double.parseDouble(objAmount.getText().toString());
                String abbreviation = "";
                final int KILOMETERS_TO_METERS = 1000;
                final int METERS_TO_CENTIMETERS = 100;
                final Double METERS_TO_FEET = 3.281;
                switch (selectedOption) {
                    case 0:
                        result = amount * KILOMETERS_TO_METERS;
                        abbreviation = " MTS";
                        break;
                    case 1:
                        result = amount / KILOMETERS_TO_METERS;
                        abbreviation = " KMS";
                        break;
                    case 2:
                        result = amount * METERS_TO_CENTIMETERS;
                        abbreviation = " CMS";
                        break;
                    case 3:
                        result = amount / METERS_TO_CENTIMETERS;
                        abbreviation = " MTS";
                        break;
                    case 4:
                        result = amount * METERS_TO_FEET;
                        abbreviation = " FTS";
                        break;
                    case 5:
                        result = amount / METERS_TO_FEET;
                        abbreviation = " MTS";
                        break;
                }
                objLabel.setText("Result is: " + result.toString() + abbreviation);
            }
        });


    }
}