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

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class HydrometerTemp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydrometer_temp);

        final EditText editTextTemp= (EditText)findViewById(R.id.hydrometer_editTextTemp);
        final EditText editTextSg= (EditText)findViewById(R.id.hydrometer_editTextSG);
        final TextView textViewNewSg= (TextView)findViewById(R.id.hydrometer_textViewNewSG);
        final EditText editTextCal= (EditText)findViewById(R.id.hydrometer_editTextCal);
        final Button btnCalc= (Button)findViewById(R.id.hydrometer_btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextSg.getWindowToken(), 0);
                DecimalFormat fmt= new DecimalFormat("###.####");
                double tc= Double.parseDouble(editTextCal.getText().toString());
                double tr= Double.parseDouble(editTextTemp.getText().toString());
                double sg= Double.parseDouble(editTextSg.getText().toString());
                sg= sg * ((1.00130346 - 0.000134722124 * tr + 0.00000204052596 * Math.pow(tr,2) - 0.00000000232820948 * Math.pow(tr,3) /
                        (1.00130346 - 0.000134722124 * tc + 0.00000204052596 * Math.pow(tc,2)- 0.00000000232820948 * Math.pow(tc,3))));


                textViewNewSg.setText("Revised Specific Gravity: ");
                textViewNewSg.append(fmt.format(sg));

                //1.313454 - 0.132674 x T + 2.057793 x 2.71828 -3 x T^2-2.627634 x 2.71828-6 x T^3
                //sg * ((1.00130346 - 0.000134722124 * tr + 0.00000204052596 * tr2 - 0.00000000232820948 * tr3) / (1.00130346 - 0.000134722124 * tc + 0.00000204052596 * tc2 - 0.00000000232820948 * tc3))
            }
        });
    }

}
