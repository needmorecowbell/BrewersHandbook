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


public class AbvAbw extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abv_abw);

        final EditText editTextSg= (EditText)findViewById(R.id.abvw_editTextSg);
        final EditText editTextFg= (EditText)findViewById(R.id.abvw_editTextFg);
        final TextView txtAbv= (TextView)findViewById(R.id.abvw_textViewABV);
        final TextView txtAbw= (TextView)findViewById(R.id.abvw_textViewABW);
        final Button btnCalc= (Button)findViewById(R.id.abvw_btnCalculate);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(editTextFg.getText().toString().isEmpty()&&editTextSg.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextFg.getWindowToken(), 0);
                    DecimalFormat fmt= new DecimalFormat("###.##");
                    double sg= Double.parseDouble(editTextSg.getText().toString());
                    double fg= Double.parseDouble(editTextFg.getText().toString());
                    double abv= (1.05*(sg-fg)/fg)/.79336*100;
                    double abw= abv*.79336;
                    txtAbv.setText("ABV: ");
                    txtAbw.setText("ABW: ");
                    txtAbv.append("%"+fmt.format(abv));
                    txtAbw.append("%"+fmt.format(abw));
                }

            }
        });
    }


}
