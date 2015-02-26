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

public class Calories extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        final EditText editTextRealExt= (EditText)findViewById(R.id.calories_editTextRealExt);
        final EditText editTextFG= (EditText)findViewById(R.id.calories_editTextFG);
        final EditText editTextABW= (EditText)findViewById(R.id.calories_editTextABW);
        final EditText editTextOz= (EditText)findViewById(R.id.calories_editTextOz);
        final Button btnCalculate=(Button)findViewById(R.id.calories_btnCalculate);
        final TextView textViewCalories= (TextView)findViewById(R.id.calories_textViewCalories);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextRealExt.getText().toString().isEmpty()&&
                     editTextFG.getText().toString().isEmpty()&&
                     editTextABW.getText().toString().isEmpty()&&
                     editTextOz.getText().toString().isEmpty())){

                    DecimalFormat fmt= new DecimalFormat("###.#");
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextFG.getWindowToken(), 0);

                    double realExt= Double.parseDouble(editTextRealExt.getText().toString());
                    double fg= Double.parseDouble(editTextFG.getText().toString());
                    double abw= Double.parseDouble(editTextABW.getText().toString());
                    double oz= Double.parseDouble(editTextOz.getText().toString());

                    //Calories per bottle = ((6.9 x ABW) + 4.0 x (Real Extract - 0.1)) x Final Gravity   x 29.573 / 100 * (Bottle size in oz)

                    double calories= ((6.9*abw)+4.0 *(realExt-0.1))* fg *29.573/100*oz;

                    textViewCalories.setText("Calories Per Bottle: ");
                    textViewCalories.append(fmt.format(calories));
                }
            }
        });
    }


}
