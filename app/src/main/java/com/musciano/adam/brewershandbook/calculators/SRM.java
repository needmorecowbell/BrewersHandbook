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

public class SRM extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srm);

        final EditText editTextGrain= (EditText)findViewById(R.id.srm_editTextGrain);
        final EditText editTextVol= (EditText)findViewById(R.id.srm_editTextBrewVol);
        final EditText editTextLovibond= (EditText)findViewById(R.id.srm_editTextLovibond);
        Button btnCalc= (Button)findViewById(R.id.srm_btnCalc);
        final TextView textViewSrm= (TextView)findViewById(R.id.srm_textViewSRM);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextGrain.getText().toString().isEmpty()&&editTextLovibond.getText().toString().isEmpty()&& editTextVol.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextVol.getWindowToken(), 0);

                    double grain= Double.parseDouble(editTextGrain.getText().toString());
                    double vol= Double.parseDouble(editTextVol.getText().toString());
                    double lovibond= Double.parseDouble(editTextLovibond.getText().toString());
                    double srm= (grain*lovibond)/vol;
                    DecimalFormat fmt= new DecimalFormat("###.##");

                    textViewSrm.setText("SRM: ");
                    textViewSrm.append(fmt.format(srm));
                }
            }
        });
    }

}
