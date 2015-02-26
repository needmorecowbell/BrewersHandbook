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

public class Evaporation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaporation);

        final EditText editTextPreBoilWort= (EditText)findViewById(R.id.evaporation_editTextPreBoilWort);
        final EditText editTextEvapTime= (EditText)findViewById(R.id.evaporation_editTextBoilingTime);
        final TextView textViewEvapRate=(TextView)findViewById(R.id.evaporation_textViewEvapRate);
        final TextView textViewEvapLoss=(TextView)findViewById(R.id.evaporation_textViewEvapLoss);
        Button btnCalc= (Button)findViewById(R.id.evaporation_btnCalculate);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextEvapTime.getWindowToken(), 0);
                DecimalFormat fmt= new DecimalFormat("###.##");
                double wort= Double.parseDouble(editTextPreBoilWort.getText().toString());
                double evapTime= Double.parseDouble(editTextEvapTime.getText().toString());
                double evapRate= wort*.10;
                double evapLoss= (evapRate/60)*evapTime;

                textViewEvapRate.setText("Evaporation Rate: ");
                textViewEvapLoss.setText("Evaporation Loss: ");
                textViewEvapLoss.append(fmt.format(evapLoss));
                textViewEvapRate.append(fmt.format(evapRate)+" vol/hr");
            }
        });

    }



}
