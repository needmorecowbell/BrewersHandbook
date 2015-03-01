package com.musciano.adam.brewershandbook;

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
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("brewLog.txt")));
            String curLine;
           while((curLine=reader.readLine())!= null){
               brews.add(getBrewFromString(curLine));
           }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"uh oh, file input went Wrong!",Toast.LENGTH_SHORT).show();
        }finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }catch (Exception e){
            }
        }

        return brews;
    }

    private Brew getBrewFromString(String s){
        return null;
    }
    private void fillFile(ArrayList<Brew> brews){
        for(int x=0;x<brews.size();x++){

        }

    }
}
