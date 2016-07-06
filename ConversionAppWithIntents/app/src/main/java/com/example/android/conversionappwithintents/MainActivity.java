package com.example.android.conversionappwithintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> conversions;
    private ArrayList<Double> rates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        textView = (TextView) findViewById(R.id.text_view);

        conversions = new ArrayList<String>();
        conversions.add("Kilograms");
        conversions.add("Grams");
        conversions.add("Ounces");
        conversions.add("Tons");
        conversions.add("Baby Elephants");

        rates = new ArrayList<Double>();
        rates.add(.453592);
        rates.add(453.592);
        rates.add(16.0);
        rates.add(0.0005);
        rates.add(0.0045);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, R.id.item_text_view, conversions);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = conversions.get(position);
                double rate = rates.get(position);

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("unit", s);
                i.putExtra("rate", rate);
                startActivity(i);
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
