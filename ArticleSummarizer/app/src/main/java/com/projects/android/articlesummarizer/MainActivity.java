package com.projects.android.articlesummarizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String[] WEBSITES = new String[] {
            "www.weather.com", "www.cnn.com", "www.foxnews.com", "www.huffingtonpost.com", "www.abcnews.go.com",
            "www.nytimes.com", "www.news.yahoo.com", "www.drudgereport.com", "www.usatoday.com", "www.nbcnews.com",
            "www.washingtonpost.com", "www.cbsnews.com", "www.latimes.com", "www.news.google.com", "www.nydailynews.com",
            "www.chicagotribune.com", "www.nypost.com", "www.sfgate.com", "www.npr.org", "www.bslocal.com",
            "www.espn.go.com", "www.wsj.com", "www.forbes.com", "www.bbc.com"
    };

    private static final String NAME = "save";
    private static final String URL_LINK = "url";
    private static final String SUMMARY = "summary";

    private ProgressBar progressBar;
    private TextView askingForURL;
    private EditText URLInput;
    private EditText sentencesInput;
    private Button sendLink;
    private TextView resultLink;
    private TextView URLHyperlink;

    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        askingForURL = (TextView) findViewById(R.id.askingForURL);
        URLInput = (EditText) findViewById(R.id.URLInput);
        sentencesInput = (EditText) findViewById(R.id.sentencesInput);
        URLHyperlink = (TextView) findViewById(R.id.URLHyperlink);
        sendLink = (Button) findViewById(R.id.sendLink);
        resultLink = (TextView) findViewById(R.id.resultLink);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.URLInput);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, WEBSITES);
        textView.setAdapter(adapter);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        final SharedPreferences sharedPreferences = getSharedPreferences(NAME, MODE_PRIVATE);
        String initialURL = sharedPreferences.getString(URL_LINK, "");
        String initialSummary = sharedPreferences.getString(SUMMARY, "");

        URLHyperlink.setText("Hyperlink to Article: " + initialURL);
        resultLink.setText("Response is: " + initialSummary);

        onClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                progressBar.setVisibility(View.VISIBLE);

                String inputText = URLInput.getText().toString();

                if (inputText.length() == 0 || sentencesInput.getText().toString().length() == 0) {
                    resultLink.setText("Enter a valid number and link.");
                    URLHyperlink.setText("Hyperlink to Article: ");
                    progressBar.setVisibility(View.GONE);
                } else {
                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    String url = "http://api.intellexer.com/summarize?apikey=c579c9d6-4dd1-4b85-8230-52f32d402245&url=" + inputText + "&summaryRestriction=" + sentencesInput.getText().toString() + "&returnedTopicsCount=1";

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    String total = "";
                                    com.projects.android.articlesummarizer.response.Response changedResponse = new Gson().fromJson(response, com.projects.android.articlesummarizer.response.Response.class);

                                    for (int i = 0; i < changedResponse.getItems().length; i++) {
                                        total += changedResponse.getItems()[i].getText() + " ";
                                    }

                                    URLHyperlink.setText("Hyperlink to Article: " + URLInput.getText().toString());
                                    resultLink.setText("Response is: " + total);

                                    SharedPreferences.Editor adder = sharedPreferences.edit();
                                    adder.clear();
                                    adder.putString(URL_LINK, URLInput.getText().toString());
                                    adder.putString(SUMMARY, total);
                                    adder.commit();

                                    progressBar.setVisibility(View.GONE);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            URLHyperlink.setText("Hyperlink to Article: ");
                            resultLink.setText("That didn't work!");
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }
            }
        };

        sendLink.setOnClickListener(onClickListener);


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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String stateSaved = savedInstanceState.getString("save_state");
        //String stateSaved2 = savedInstanceState.getString("save_state2");

        if(stateSaved == null || stateSaved == null){
        }
        else{
            URLHyperlink.setText(stateSaved);
            //resultLink.setText(stateSaved2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String stateToSave = URLHyperlink.getText().toString();
        //String stateToSave2 = resultLink.getText().toString();
        outState.putString("saved_state", stateToSave);
        //outState.putString("saved_state2", stateToSave2);
    }

    public void resetting(View view) {
        URLHyperlink.setText("Hyperlink to Article: ");
        resultLink.setText("Response is: ");
        URLInput.setText("");
        sentencesInput.setText("");
        URLInput.setHint("Enter URL Here: ");
        sentencesInput.setHint("Enter Number of Sentences Here: ");
    }

}
