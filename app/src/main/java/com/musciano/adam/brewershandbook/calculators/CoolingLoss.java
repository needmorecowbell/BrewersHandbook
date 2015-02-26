package com.musciano.adam.brewershandbook.calculators;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.musciano.adam.brewershandbook.R;

import java.text.DecimalFormat;

public class CoolingLoss extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooling_loss);

        final EditText editTextWort= (EditText)findViewById(R.id.cooling_editTextWort);
        final EditText editTextEvap= (EditText)findViewById(R.id.cooling_editTextEvap);
        Button btnCalc= (Button)findViewById(R.id.cooling_btnCalc);
        final TextView textViewCooling= (TextView)findViewById(R.id.cooling_textViewCooling);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextEvap.getText().toString().isEmpty()&&editTextWort.getText().toString().isEmpty())){
                    DecimalFormat fmt= new DecimalFormat("###.##");
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextEvap.getWindowToken(), 0);
                    double wort= Double.parseDouble(editTextWort.getText().toString());
                    double evap= Double.parseDouble(editTextEvap.getText().toString());
                    double cooling= (wort-evap)*.04;

                    textViewCooling.setText("Cooling Loss: ");
                    textViewCooling.append(fmt.format(cooling));
                }
            }
        });
    }


}
