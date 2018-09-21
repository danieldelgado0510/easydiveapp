/*
Created by: Daniel Delgado
This activity creates a new store using user inputs and sends an error if store already exists.
9/14/2018
*/
package us.easydive.playingaround;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewStore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_store);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static String SEND_TEXT = "";

    public void create(View view){
        EditText editText = (EditText) findViewById(R.id.storeCreate);
        String message = editText.getText().toString();

        if ( MainActivity.exists(message) ){
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "The following store already exists: \"" + message + "\".\n";
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);  // store exists
        }
        else {//Store does not exist
            Store temp = new Store(message);
            MainActivity.STORES.addElement(temp);
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String format = s.format(new Date());
            MainActivity.History += "Created new store: " + message + "\n" + format + "\n\n";
            Intent intent = new Intent(this, MessageDisplay.class);
            String error = "New store created! : \"" + message + "\".\n";
            MainActivity.stringList.add(temp.getStoreID());
            intent.putExtra(SEND_TEXT, error);
            startActivity(intent);
        }
    }
    //this segfaults. useful lesson to learn here.
    /*  boolean hey = MainActivity.STORES.get(1).addValve("asda");  */
}
