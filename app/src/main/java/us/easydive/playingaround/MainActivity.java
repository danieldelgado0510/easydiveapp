/*
Created by: Daniel Delgado
Main activity of the app, handles all data allocation and menu interaction. Parent activity.
9/14/2018
*/
package us.easydive.playingaround;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.*;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {


    public static String History = "\n --- Begin History --- \n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    //Vector of valves in a vector of stores.
    public static Vector<Store> STORES = new Vector(0);

    protected Vector<Store> getStore(){
        return STORES;
    }

    public static final String EXTRA_MESSAGE = "";

    public static int findStore(String input){
        int index = 0;
        for( Store j : STORES )
        {
            if( input.equals( j.getStoreID()) )
                return index;
            index++;
        }
        index = -1;
        return index;
    }

    public static boolean newValve( String store, String valve ){
        int index = findStore(store);
        if(index == -1)
            return false;
        return STORES.get(index).addValve(valve);
    }

    public static String SHOW_HISTORY = "";

    public void showHistory(View view){
        Intent intent = new Intent(this, valveHistory.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(SHOW_HISTORY, message);
        startActivity(intent);
    }

    public static boolean reFillValve(String store, String valve, int count){
        int index = findStore(store);
        if(index == -1)
            return false;
       return STORES.get(index).reFill(valve, count);
    }



    public static boolean exists(String input){
        return !( findStore(input) == -1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch( id ){
            case R.id.action_newStore:
                Intent intent = new Intent(this, NewStore.class);
                startActivity(intent);
                return true;
            case R.id.action_updateFills:
                Intent intent2 = new Intent(this, reFill.class);
                startActivity(intent2);
                return true;
            case R.id.action_history:
                Intent intent3 = new Intent(this,History.class);
                startActivity(intent3);
                return true;
            case R.id.action_newValve:
                Intent intent4 = new Intent(this, NewValve.class);
                startActivity(intent4);
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
