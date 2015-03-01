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

public class InfusionWater extends ActionBarActivity {

    /*Wa = (T2 - T1)(0.2G + Wm)/(Tw - T2)
Wa = The amount of infusion water to add
Wm = The total amount of water in the mash
T1 = The initial mash temperature
T2 = The target mash temperature
Tw = the actual temperature of the infusion water
G = The amount of grain in the mash
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infusion_water);

        final EditText editTextGrain= (EditText)findViewById(R.id.infusion_editTextGrainAmnt);
        final EditText editTextMashTemp= (EditText)findViewById(R.id.infusion_editTextMashTemp);
        final EditText editTextTargetTemp=(EditText)findViewById(R.id.infusion_editTextTargetTemp);
        final EditText editTextInfusionTemp= (EditText)findViewById(R.id.infusion_editTextInfusionTemp);
        final EditText editTextWaterInMash= (EditText)findViewById(R.id.infusion_editTextWaterInMash);
        Button btnCalc= (Button)findViewById(R.id.infusion_btnCalc);
        final TextView textViewInfusion=(TextView)findViewById(R.id.infusion_textViewInfusion);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextGrain.getText().toString().isEmpty()&&
                   editTextInfusionTemp.getText().toString().isEmpty()&&
                   editTextMashTemp.getText().toString().isEmpty()&&
                   editTextTargetTemp.getText().toString().isEmpty()&&
                   editTextWaterInMash.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextInfusionTemp.getWindowToken(), 0);
                    double grain= Double.parseDouble(editTextGrain.getText().toString());
                    double mashTemp= Double.parseDouble(editTextMashTemp.getText().toString());
                    double targetTemp= Double.parseDouble(editTextTargetTemp.getText().toString());
                    double waterInMash= Double.parseDouble(editTextWaterInMash.getText().toString());
                    double infusionTemp= Double.parseDouble(editTextInfusionTemp.getText().toString());

                    double infusion= (targetTemp-mashTemp)*(.2*grain+waterInMash)/(infusionTemp-targetTemp);
                    DecimalFormat fmt= new DecimalFormat("###.##");
                    textViewInfusion.setText("Infusion: ");
                    textViewInfusion.append(fmt.format(infusion));
                }
            }
        });
    }



}
