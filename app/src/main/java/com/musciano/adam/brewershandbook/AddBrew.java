package com.musciano.adam.brewershandbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class AddBrew extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_brew);

        final EditText editTextName = (EditText) findViewById(R.id.addBrew_editTextName);
        final EditText editTextType = (EditText) findViewById(R.id.addBrew_editTextType);
        final EditText editTextOG = (EditText) findViewById(R.id.addBrew_editTextOG);
        final EditText editTextFG = (EditText) findViewById(R.id.addBrew_editTextFG);
        final EditText editTextDateStart = (EditText) findViewById(R.id.addBrew_editTextDateStart);
        final EditText editTextDateEnd = (EditText) findViewById(R.id.addBrew_editTextDateEnd);
        final EditText editTextVolume = (EditText) findViewById(R.id.addBrew_editTextVolume);
        Button btnAdd = (Button) findViewById(R.id.addBrew_btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextVolume.getWindowToken(), 0);

                String name, type, dateStart, dateEnd;
                Double og, fg, volume;

                name = editTextName.getText().toString();
                type = editTextType.getText().toString();
                dateStart = editTextDateStart.getText().toString();
                dateEnd = editTextDateEnd.getText().toString();
                og = Double.parseDouble(editTextOG.getText().toString());
                fg = Double.parseDouble(editTextFG.getText().toString());
                volume = Double.parseDouble(editTextVolume.getText().toString());

                Brew brew = new Brew(name, type, "" + og, "" + fg, dateStart, dateEnd, "" + volume);
                Intent passingIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("brew", brew.toString());

                passingIntent.putExtras(bundle);
                setResult(RESULT_OK, passingIntent);
                finish();

            }
        });


    }
}
