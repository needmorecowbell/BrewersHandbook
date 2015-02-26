package com.musciano.adam.brewershandbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateMainListBox();
        registerListViewClicks();

    }

    private void populateMainListBox(){
        String titles[]= {"Calculators","Logs","General","Wine Guides","Beer Guides","References","About This App"};

        ArrayAdapter adapterMain= new ArrayAdapter<String>(this,R.layout.listview_template,titles);

        ListView list =  (ListView)findViewById(R.id.listMain);
        list.setAdapter(adapterMain);
    }

    private void registerListViewClicks(){
        ListView list=(ListView)findViewById(R.id.listMain);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView selectedTextView= (TextView)view;
               // Toast.makeText(getApplicationContext(),"Pressed"+selectedTextView.getText(),Toast.LENGTH_SHORT).show();

                switch(selectedTextView.getText().toString()){
                    case "Calculators":
                        Intent calcIntent = new Intent(getApplicationContext(),CalculatorMenu.class);
                        startActivity(calcIntent);
                        break;
                    case "Logs":
                        Intent logIntent = new Intent (getApplicationContext(),LoggingMenu.class);
                        startActivity(logIntent);
                        break;
                    case "General":
                        Intent genIntent = new Intent(getApplicationContext(),GeneralMenu.class);
                        startActivity(genIntent);
                        break;
                    case "Wine Guides":
                        Intent wineIntent= new Intent(getApplicationContext(),WineGuideMenu.class);
                        startActivity(wineIntent);
                        break;
                    case "Beer Guides":
                        Intent beerIntent = new Intent(getApplicationContext(),BeerGuideMenu.class);
                        startActivity(beerIntent);
                        break;
                    case "References":
                        Intent refIntent = new Intent(getApplicationContext(),References.class);
                        startActivity(refIntent);
                        break;
                    case "About This App":
                        Intent aboutIntent= new Intent(getApplicationContext(),About.class);
                        startActivity(aboutIntent);
                        break;

                }
            }
        });

    }

}
