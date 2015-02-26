package com.musciano.adam.brewershandbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.musciano.adam.brewershandbook.calculators.AbsorptionLoss;
import com.musciano.adam.brewershandbook.calculators.AbvAbw;
import com.musciano.adam.brewershandbook.calculators.Attenuation;
import com.musciano.adam.brewershandbook.calculators.Calories;
import com.musciano.adam.brewershandbook.calculators.CoolingLoss;
import com.musciano.adam.brewershandbook.calculators.DegreesPlato;
import com.musciano.adam.brewershandbook.calculators.Evaporation;
import com.musciano.adam.brewershandbook.calculators.HydrometerTemp;
import com.musciano.adam.brewershandbook.calculators.IBU;
import com.musciano.adam.brewershandbook.calculators.InfusionWater;
import com.musciano.adam.brewershandbook.calculators.PrimingSugar;
import com.musciano.adam.brewershandbook.calculators.RealExtract;
import com.musciano.adam.brewershandbook.calculators.SRM;
import com.musciano.adam.brewershandbook.calculators.StrikeWater;


public class CalculatorMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_menu);
        populateList();
        registerListClicks();
    }

    private void populateList(){

        //ALPHABETIZE
        String [] titles = {"Absorption Loss Calculator","ABV/ABW Calculator","Apparent/Real Attenuation Calculator","Calories Calculator", "Cooling Loss Calculator",
                "Degrees Plato Calculator","Evaporation Loss/Rate Calculator", "Hydrometer Temperature Correction", "IBU Calculator",
                "Infusion Water Calculator", "Priming Sugar Calculator","Real Extract Calculator","SRM Calculator","Strike Water Calculator"};

        ArrayAdapter adapter= new ArrayAdapter(this,R.layout.listview_template,titles);
        ListView list= (ListView)findViewById(R.id.list_calculators);
        list.setAdapter(adapter);
    }

    private void registerListClicks(){
        ListView list= (ListView)findViewById(R.id.list_calculators);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtViewSelected= (TextView) view;
                switch(txtViewSelected.getText().toString()){
                    case "Absorption Loss Calculator":
                        Intent absLossIntent= new Intent(getApplicationContext(),AbsorptionLoss.class);
                        startActivity(absLossIntent);
                        break;
                    case "ABV/ABW Calculator":
                        Intent abvwIntent = new Intent(getApplicationContext(),AbvAbw.class);
                        startActivity(abvwIntent);
                        break;
                    case "Apparent/Real Attenuation Calculator":
                        Intent attenIntent= new Intent(getApplicationContext(), Attenuation.class);
                        startActivity(attenIntent);
                        break;
                    case "Calories Calculator":
                        Intent calIntent= new Intent(getApplicationContext(), Calories.class);
                        startActivity(calIntent);
                        break;
                    case "Cooling Loss Calculator":
                        Intent coolIntent = new Intent(getApplicationContext(), CoolingLoss.class);
                        startActivity(coolIntent);
                        break;
                    case "Degrees Plato Calculator":
                        Intent degPlatIntent= new Intent(getApplicationContext(), DegreesPlato.class);
                        startActivity(degPlatIntent);
                        break;
                    case "Evaporation Loss/Rate Calculator":
                        Intent evapIntent= new Intent(getApplicationContext(), Evaporation.class);
                        startActivity(evapIntent);
                        break;
                    case "Hydrometer Temperature Correction":
                        Intent hydroTempIntent = new Intent(getApplicationContext(), HydrometerTemp.class);
                        startActivity(hydroTempIntent);
                        break;
                    case "IBU Calculator":
                        Intent ibuIntent= new Intent(getApplicationContext(),IBU.class);
                        startActivity(ibuIntent);
                        break;
                    case "Infusion Water Calculator":
                        Intent infIntent= new Intent(getApplicationContext(), InfusionWater.class);
                        startActivity(infIntent);
                        break;
                    case "Priming Sugar Calculator":
                        Intent primeSugarIntent= new Intent(getApplicationContext(), PrimingSugar.class);
                        startActivity(primeSugarIntent);
                        break;
                    case"Real Extract Calculator":
                        Intent realExtractIntent= new Intent(getApplicationContext(),RealExtract.class);
                        startActivity(realExtractIntent);
                        break;
                    case "SRM Calculator":
                        Intent srmIntent= new Intent(getApplicationContext(),SRM.class);
                        startActivity(srmIntent);
                        break;
                    case "Strike Water Calculator":
                        Intent strikeWaterIntent = new Intent(getApplicationContext(), StrikeWater.class);
                        startActivity(strikeWaterIntent);
                        break;





                }
            }
        });

    }


}
