package com.musciano.adam.brewershandbook.calculators;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.musciano.adam.brewershandbook.R;

import java.text.DecimalFormat;

public class IBU extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibu);

        final EditText editTextAA= (EditText)findViewById(R.id.ibu_editTextAlphaAcids);
        final EditText editTextUtil= (EditText)findViewById(R.id.ibu_editTextUtil);
        final EditText editTextOZ= (EditText)findViewById(R.id.ibu_editTextOz);
        final Button btnCalc= (Button)findViewById(R.id.ibu_btnCalc);
        final TextView textViewIBU= (TextView)findViewById(R.id.ibu_textViewIBU);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextAA.getText().toString().isEmpty()&&editTextOZ.getText().toString().isEmpty()&&editTextUtil.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextOZ.getWindowToken(), 0);
                    double alpha= Double.parseDouble(editTextAA.getText().toString());
                    double util= Double.parseDouble(editTextUtil.getText().toString());
                    double oz= Double.parseDouble(editTextOZ.getText().toString());

                    double ibu= (alpha*oz*util)/7.25;

                    DecimalFormat fmt= new DecimalFormat("###.##");

                    textViewIBU.setText("IBU: ");
                    textViewIBU.append(fmt.format(ibu));
                }
            }
        });
    }



}
