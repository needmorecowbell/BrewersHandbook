package com.musciano.adam.brewershandbook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//USE SHARED PREFERENCES

public class LoggingMenu extends ActionBarActivity {
    final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_menu);

        final ArrayList<Brew>brews= getBrews();
        ArrayList<String>brewNames= new ArrayList<String>();


        for(int x=0;x<brews.size();x++){
            brewNames.add(brews.get(x).getName());
        }
        brews.add(new Brew("Tap to Add New Brew"));


        ArrayAdapter adapter= new ArrayAdapter<String>(this,R.layout.listview_template,brewNames);
        ListView listViewBrews =  (ListView)findViewById(R.id.logging_listview);
        listViewBrews.setAdapter(adapter);


        listViewBrews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//NEED TO FINISH
                TextView selectedView= (TextView)view;

                if(selectedView.getText().toString().equalsIgnoreCase("Tap to add new Brew")){
                    //ADD BREW CODE

                    fillFile(brews);
                }

            }
        });

    }
   private ArrayList<Brew>getBrews(){
        ArrayList <Brew> brews= new ArrayList<Brew>();
       SharedPreferences brewLogs= getSharedPreferences("brewLogs",MODE_PRIVATE);

        int x=0;
       String curLine= brewLogs.getString("brew"+x,DEFAULT);
       while(!curLine.equals(DEFAULT)){
           brews.add(getBrewFromString(curLine));
           x++;
           curLine=brewLogs.getString("brew"+x,DEFAULT);
       }
        return brews;
    }

    private Brew getBrewFromString(String s){
        String elements[]= s.split(";");
       return new Brew(elements[0],elements[1],elements[2],elements[3],elements[4],elements[5],elements[6]);
    }

    private void fillFile(ArrayList<Brew> brews){
        SharedPreferences brewLogs= getSharedPreferences("brewLogs",MODE_PRIVATE);
        SharedPreferences.Editor edit= brewLogs.edit();

        for(int x=0;x<brews.size();x++){
            edit.putString("brew"+x,brews.get(x).toString());
        }
        edit.commit();

    }
}
