/*
Created by: Daniel Delgado
This activity creates a new valve to the corresponding store and sends an error if the valve already exists.
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

public class NewValve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_valve);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static String SEND_TEXT = "";

    public void createValve( View view ){
        EditText editText1 = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        String store = editText1.getText().toString();
        String valve = editText2.getText().toString();
        int index = MainActivity.findStore(store);

        if( !MainActivity.exists(store) ) {
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "The following store does not exist: \"" + store + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);    //Does not exist
        }

        else if(MainActivity.STORES.get(index).valveExists(valve) ){
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "The following valve do already exists: \"" + valve + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);//valve already exists
        }

        else if( MainActivity.exists(store) && !MainActivity.STORES.get(index).valveExists((valve))){
            Valve temp = new Valve(valve,0);
            MainActivity.STORES.get(index).VALVES.addElement(temp);
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String format = s.format(new Date());
            MainActivity.History += "Created new valve: " + valve + ", for store : " + store + ".\n" + format + "\n\n";
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "New valve created! : \"" + valve + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);
        }
    }
}
