package com.musciano.adam.brewershandbook.calculators;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.musciano.adam.brewershandbook.R;

import java.text.DecimalFormat;


public class Attenuation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attenuation);

        final Switch switchRealApp = (Switch)findViewById(R.id.attenuation_switchRealApparent);
        final EditText editTextPlatoStart= (EditText)findViewById(R.id.attenuation_editTextPlatoStart);
        final EditText editTextPlatoFinal= (EditText)findViewById(R.id.attenuation_editTextPlatoFinal);
        final EditText editTextRealExt= (EditText)findViewById(R.id.attenuation_editTextRealExtract);
        final TextView textViewAtten= (TextView)findViewById(R.id.attenuation_textViewAttenuation);
        final Button btnCalc= (Button)findViewById(R.id.attenuation_btnCalc);

        editTextPlatoFinal.setEnabled(false);
        switchRealApp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){//Apparent
                    editTextPlatoFinal.setText("");
                    editTextPlatoStart.setText("");
                    editTextRealExt.setText("");
                    editTextPlatoFinal.setEnabled(true);
                    editTextRealExt.setEnabled(false);
                }else{//Real
                    editTextPlatoFinal.setText("");
                    editTextRealExt.setText("");
                    editTextPlatoStart.setText("");
                    editTextPlatoFinal.setEnabled(false);
                    editTextRealExt.setEnabled(true);
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat fmt= new DecimalFormat("###.##");



                if(switchRealApp.isChecked()&&!(editTextPlatoFinal.getText().toString().isEmpty()&&editTextPlatoStart.getText().toString().isEmpty())){//Apparent
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextPlatoFinal.getWindowToken(), 0);
                    double platoFinal= Double.parseDouble(editTextPlatoFinal.getText().toString());
                    double platoStart= Double.parseDouble(editTextPlatoStart.getText().toString());
                    double apparent= ((platoStart/platoFinal)-1)*100;
                    textViewAtten.setText("Attenuation: ");
                    textViewAtten.append("%"+fmt.format(apparent));
                }else if((!switchRealApp.isChecked())&&!(editTextPlatoStart.getText().toString().isEmpty()&&editTextRealExt.getText().toString().isEmpty())){
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextRealExt.getWindowToken(), 0);
                    double real= Double.parseDouble(editTextRealExt.getText().toString());
                    double platoStart= Double.parseDouble(editTextPlatoStart.getText().toString());
                    double realAtten=((real/platoStart)-1)*100;
                    textViewAtten.setText("Attenuation: ");
                    textViewAtten.append("%"+fmt.format(realAtten));

                }
            }
        });
    }
}
