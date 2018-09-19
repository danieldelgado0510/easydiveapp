/*
Created by: Daniel Delgado
This code updates the currrent number of fills in a specific valve in its corresponding store.
9/14/2018
*/
package us.easydive.playingaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class reFill extends AppCompatActivity {

    public static String SEND_TEXT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_fill);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void fillUp(View view){
        EditText editText = findViewById( R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);

        String store = editText.getText().toString();
        String valve = editText2.getText().toString();
        String count = editText3.getText().toString();

        int finalValue = Integer.parseInt(count);
        int index = MainActivity.findStore(store);
        int valveIndex = MainActivity.STORES.get(index).valveLocation(valve);

        if( MainActivity.exists(store) && MainActivity.STORES.get(index).valveExists(valve) ){
       // MainActivity.reFillValve(store, valve, finalValue);
            MainActivity.STORES.get(index).VALVES.get(valveIndex).updateFills(finalValue);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String format = s.format(new Date());
        MainActivity.History += "Refilled Valve: " + valve + ". for Store: " + store + ".\n" + "# Fills: " + count + ".\n" + format + "\n\n";
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "Valve fills updated!\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);
        }

        else if(!MainActivity.exists(store)){
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "The following store does not exist: \"" + store + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);
        }

        else if( !MainActivity.STORES.get(index).valveExists(store) ){
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "The following valve does not exist: \"" + valve + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);
        }
    }
}
