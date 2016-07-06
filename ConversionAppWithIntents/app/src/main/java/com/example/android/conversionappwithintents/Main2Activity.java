package com.example.android.conversionappwithintents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText editText;
    private TextView poundsTextView;
    private TextView conversionTextView;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        editText = (EditText) findViewById(R.id.edit_text);
        poundsTextView = (TextView) findViewById(R.id.text_view);
        conversionTextView = (TextView) findViewById(R.id.text_view2);
        convertButton = (Button) findViewById(R.id.button);
    }

    public void doConversion(View view){
        String unit = getIntent().getStringExtra("unit");
        double rate = getIntent().getDoubleExtra("rate", 0.0);

        String value = editText.getText().toString();
        Double input = Double.parseDouble(value);

        poundsTextView.setText(input + " pounds");
        conversionTextView.setText((input * rate) + " " + unit);
        editText.setText("");
    }

    public void goBack(View view){
        finish();
    }
}
