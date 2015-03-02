package com.musciano.adam.brewershandbook;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class BrewDescription extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brew_description);

        final TextView textViewName = (TextView) findViewById(R.id.bredesc_textViewName);
        final TextView textViewType = (TextView) findViewById(R.id.bredesc_textViewType);
        final TextView textViewOG = (TextView) findViewById(R.id.bredesc_textViewOG);
        final TextView textViewFG = (TextView) findViewById(R.id.bredesc_textViewFG);
        final TextView textViewDateStart = (TextView) findViewById(R.id.bredesc_textViewDateStart);
        final TextView textViewDateEnd = (TextView) findViewById(R.id.bredesc_textViewDateEnd);
        final TextView textViewVolume = (TextView) findViewById(R.id.bredesc_textViewVol);

        Bundle bundle = this.getIntent().getExtras();
        String s = bundle.getString("brew");
        String elements[] = s.split(";");
        textViewName.append(elements[0]);
        textViewType.append(elements[1]);
        textViewOG.append(elements[2]);
        textViewFG.append(elements[3]);
        textViewDateStart.append(elements[4]);
        textViewDateEnd.append(elements[5]);
        textViewVolume.append(elements[6] + " gals");


    }
}
