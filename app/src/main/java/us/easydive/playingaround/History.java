/*
Created by: Daniel Delgado
This activity displays the activity which shows all user actions that change data on the app (new store/valve/fills)
9/14/2018//
*/
package us.easydive.playingaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.viewHistory);
        textView.setText(MainActivity.History);

    }

}
