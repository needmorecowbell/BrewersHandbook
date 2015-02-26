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

public class DegreesPlato extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degrees_plato);

        final EditText editTextOG= (EditText)findViewById(R.id.plato_editTextOG);
        Button btnCalc= (Button)findViewById(R.id.plato_btnCalc);
        final TextView textViewPlato= (TextView)findViewById(R.id.plato_textViewPlato);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextOG.getWindowToken(), 0);
                if(!editTextOG.getText().toString().isEmpty()){
                    double og= Double.parseDouble(editTextOG.getText().toString());
                    DecimalFormat fmt= new DecimalFormat("###.##");
                    double plato= (-463.37) + (668.72*og) - (205.35 * (Math.pow(og,2)));

                    textViewPlato.setText("Degrees Plato: ");
                    textViewPlato.append(fmt.format(plato));
                }
            }
        });
    }



}
