package com.musciano.adam.brewershandbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//USE SHARED PREFERENCES

public class LoggingMenu extends ActionBarActivity {
    final String DEFAULT="N/A";
    ArrayList<Brew> brews = null;
    ListView listViewBrews = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_menu);
        brews = getBrews();
        populateListBox();


        listViewBrews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//NEED TO FINISH
                TextView selectedView= (TextView)view;

                if(selectedView.getText().toString().equalsIgnoreCase("Tap to add new Brew")){
                    Intent addBrewIntent = new Intent(getApplicationContext(), AddBrew.class);
                    startActivityForResult(addBrewIntent, 0);
                } else {
                    Brew selected = brews.get((int) id - 1);
                    Intent descriptionIntent = new Intent(getApplicationContext(), BrewDescription.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("brew", selected.toString());
                    descriptionIntent.putExtras(bundle);
                    startActivity(descriptionIntent);
                }

            }
        });


    }

    private void populateListBox() {
        ArrayList<String> brewNames = new ArrayList<String>();
        brewNames.add("Tap to Add New Brew");
        for (int x = 0; x < brews.size(); x++) {
            brewNames.add(brews.get(x).getName());
        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_template, brewNames);
        listViewBrews = (ListView) findViewById(R.id.logging_listview);
        listViewBrews.setAdapter(adapter);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String brewString = bundle.getString("brew");
            Brew brew = getBrewFromString(brewString);

            brews.add(brew);
            Toast.makeText(getApplicationContext(), brewString, Toast.LENGTH_SHORT).show();

            fillFile(brews);
            populateListBox();


        }
    }

    private Brew getBrewFromString(String s){
        String elements[]= s.split(";");
       return new Brew(elements[0],elements[1],elements[2],elements[3],elements[4],elements[5],elements[6]);
    }

    private void fillFile(ArrayList<Brew> brews) {
        SharedPreferences brewLogs= getSharedPreferences("brewLogs",MODE_PRIVATE);
        SharedPreferences.Editor edit= brewLogs.edit();
        int y = 0;
        Toast.makeText(getApplicationContext(), "filling File", Toast.LENGTH_SHORT).show();
        //edit.putString("default","Tap to Add New Brew");
        for(int x=0;x<brews.size();x++){
            edit.putString("brew"+x,brews.get(x).toString());
            y = x;
        }
        edit.putInt("max", y);

        /*for(int x=0;x<y;x++){
            edit.remove("brew"+x);//REMOVES ALL BREWS IN FILE
        }*/
        edit.commit();

    }
}
