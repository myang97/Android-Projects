package com.example.android.currencyconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView conversionTextView;
    private TextView outputTextView;
    private EditText answerEditText;
    private Button conversionButton;

    private View.OnClickListener onClickListener;

    private Firebase madReference;

    private double conversionRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversionTextView = (TextView) findViewById(R.id.rate);
        outputTextView = (TextView) findViewById(R.id.output);
        answerEditText = (EditText) findViewById(R.id.answer);
        conversionButton = (Button) findViewById(R.id.convert);

        onClickListener = new View.OnClickListener(){
            public void onClick(View v){
                //do some stuff later
                String s = answerEditText.getText().toString();
                double dollarsToConvert = Double.parseDouble(s);

                double frankDollars = dollarsToConvert/conversionRate;

                outputTextView.setText("That's worth " + frankDollars);
            }
        };
        conversionButton.setOnClickListener(onClickListener);
        Firebase.setAndroidContext(this);
        Firebase madReference = new Firebase("https://madcc.firebaseio.com/");
        madReference.child("conversion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conversionRate = (double) dataSnapshot.getValue();
                conversionTextView.setText("$ to Frank$ rate is" + conversionRate);
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
