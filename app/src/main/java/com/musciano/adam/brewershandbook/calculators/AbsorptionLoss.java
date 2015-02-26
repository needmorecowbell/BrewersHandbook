package com.musciano.adam.brewershandbook.calculators;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;

import com.musciano.adam.brewershandbook.R;


public class AbsorptionLoss extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absorption_loss);

        final EditText editTxtGrainAmnt = (EditText)findViewById(R.id.absorption_editTxtGrain);
        final TextView answer = (TextView)findViewById(R.id.absorption_textViewAnswer);
        final Button btnCalculate= (Button)findViewById(R.id.absorption_btnCompute);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTxtGrainAmnt.getText().toString().isEmpty()){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTxtGrainAmnt.getWindowToken(), 0);
                    answer.setText("Absorption Loss: ");
                    Double grainAmnt = Double.parseDouble(editTxtGrainAmnt.getText().toString());
                    Double absorption= grainAmnt*.20;

                    answer.append(absorption.toString()+" gals");

                }


            }
        });

    }

}
