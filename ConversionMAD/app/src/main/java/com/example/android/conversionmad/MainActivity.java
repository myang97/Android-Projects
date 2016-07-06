package com.example.android.conversionmad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText poundEditText;
    private TextView kiloTextView;
    private ListView listView;
    private ArrayList<String> data;
    private ArrayAdapter<String> adapter;

    final double KILO_CONVERSION_RATE = .453592;
    final double GRAMS_CONVERSION_RATE = 453.592;
    final double OUNCES_CONVERSION_RATE = 16;
    final double TONS_CONVERSION_RATE = 0.0005;
    final double BABY_ELEPHANT_CONVERSION_RATE = 0.0045;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poundEditText = (EditText) findViewById(R.id.pounds_edit_text);
        listView = (ListView) findViewById(R.id.list_view);
        data = new ArrayList<>();
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

    public void convert(View view) {
        String s = poundEditText.getText().toString();
        int pounds = Integer.parseInt(s);

        data.clear();
        double result = pounds * KILO_CONVERSION_RATE;
        data.add(pounds + " pounds");
        data.add(pounds * KILO_CONVERSION_RATE + " kg");
        data.add(pounds * GRAMS_CONVERSION_RATE + " grams");
        data.add(pounds * OUNCES_CONVERSION_RATE + " oz");
        data.add(pounds * TONS_CONVERSION_RATE + " tons");
        data.add(pounds * BABY_ELEPHANT_CONVERSION_RATE + " baby elephants");

        //context is something that android uses to determine what style
        //if activity is styled differently
        //colored something differently/font size is bigger (context stores that)
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_view_item, data);
        listView.setAdapter(adapter);
        poundEditText.setText("");
    }
}
