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

public class PrimingSugar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priming_sugar);

        final EditText editTextBrewVol= (EditText)findViewById(R.id.priming_editTextBrewVol);
        final EditText editTextBrewTemp= (EditText)findViewById(R.id.priming_editTextBrewTemp);
        final EditText editTextCO2= (EditText)findViewById(R.id.priming_editTextCO2);
        Button btnCalc= (Button)findViewById(R.id.priming_btnCalc);
        final TextView textViewPriming= (TextView)findViewById(R.id.priming_textViewPrimingSugar);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextBrewTemp.getText().toString().isEmpty()&&editTextBrewVol.getText().toString().isEmpty()&&editTextCO2.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextBrewTemp.getWindowToken(), 0);

                    double temp= Double.parseDouble(editTextBrewTemp.getText().toString());
                    double volume= Double.parseDouble(editTextBrewVol.getText().toString());
                    double co2= Double.parseDouble(editTextCO2.getText().toString());
                    double priming= 15.195* volume *(co2 - 3.0378 + .050062 *temp - .00026555 * Math.pow(temp,2));
                    DecimalFormat fmt= new DecimalFormat("###.##");
                    textViewPriming.setText("Priming Sugar: ");
                    textViewPriming.append(fmt.format(priming)+" grams");

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_priming_sugar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
