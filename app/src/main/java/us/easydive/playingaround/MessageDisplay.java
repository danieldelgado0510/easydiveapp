/*
Created by: Daniel Delgado
Message display activity, presents messages after an activity has been completed (valve refills, no store, etc.)
9/14/2018
*/
package us.easydive.playingaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MessageDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(reFill.SEND_TEXT);
        TextView textView = findViewById(R.id.textView);
       textView.setText(message);


    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
