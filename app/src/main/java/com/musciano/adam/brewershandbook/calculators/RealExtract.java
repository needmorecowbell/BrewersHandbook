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

public class RealExtract extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_extract);

        final EditText editTextPlatoOrig= (EditText)findViewById(R.id.real_editTextPlatoOrig);
        final EditText editTextPlatoFinal= (EditText)findViewById(R.id.strike_editTextGrainTemp);
        Button btnCalc= (Button)findViewById(R.id.strike_btnCalc);
        final TextView textViewReal=(TextView)findViewById(R.id.strike_textViewStrike);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextPlatoFinal.getText().toString().isEmpty()&&editTextPlatoOrig.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextPlatoFinal.getWindowToken(), 0);

                    double init= Double.parseDouble(editTextPlatoOrig.getText().toString());
                    double end= Double.parseDouble(editTextPlatoFinal.getText().toString());
                    double real= (0.1808 *init) + (0.8192 *end);
                    DecimalFormat fmt= new DecimalFormat("###.##");

                    textViewReal.setText("Real Extract: ");
                    textViewReal.append(fmt.format(real));
                }
            }
        });
    }


}
