package us.easydive.playingaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Vector;

public class valveHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valve_history);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.SHOW_HISTORY);
        TextView textView = findViewById(R.id.textView);
         if( !MainActivity.exists(message) ){
        textView.setText("The following Store does not exist. Please add store before checking history.");
         }

         else{
            int index = MainActivity.findStore(message);
            Vector<Valve> temp = MainActivity.STORES.get(index).VALVES;
            String display = "\n Store ID: " + MainActivity.STORES.get(index).getStoreID() + ".\n\n";

             if( MainActivity.STORES.get(index).VALVES.size() == 0 )
                textView.setText( "This store has no assigned valves.\n" + MainActivity.STORES.get(index).getStoreID() );

             else{
            for( Valve v : temp ){
                display += "Valve ID: " + v.getValveID() + " / # of Fills: " + v.getValveFills() + ".\n";
                }
                textView.setText(display);
             }
        }
    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
