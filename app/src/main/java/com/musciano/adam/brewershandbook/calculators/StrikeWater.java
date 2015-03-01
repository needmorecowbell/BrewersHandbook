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

public class StrikeWater extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strike_water);

        final EditText editTextTemp= (EditText)findViewById(R.id.strike_editTextGrainTemp);
        final EditText editTextTargetTemp=(EditText)findViewById(R.id.strike_editTextTarget);
        final EditText editTextRatio= (EditText)findViewById(R.id.strike_editTextRatio);
        Button btnCalc= (Button)findViewById(R.id.strike_btnCalc);
        final TextView textViewStrike= (TextView)findViewById(R.id.strike_textViewStrike);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextRatio.getText().toString().isEmpty()&&editTextTargetTemp.getText().toString().isEmpty()&&editTextTemp.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextTargetTemp.getWindowToken(), 0);

                    double target= Double.parseDouble(editTextTargetTemp.getText().toString());
                    double ratio= Double.parseDouble(editTextRatio.getText().toString());
                    double temp= Double.parseDouble(editTextTemp.getText().toString());
                    double strike= (.2/ratio)* (target-temp)+target;
                    DecimalFormat fmt= new DecimalFormat("###.##");

                    textViewStrike.setText("Strike Water: ");
                    textViewStrike.append(fmt.format(strike));
                }
            }
        });
    }
}
