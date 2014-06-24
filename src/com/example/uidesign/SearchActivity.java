package com.example.uidesign;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SearchActivity extends Activity {

	public static HealthyMeDatabaseHelper healthymedb;
	public final static String EXTRA_Usernamefromsearchactivity="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		Spinner spinner = (Spinner) findViewById(R.id.Spinner01);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.disease, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		//open the database
		healthymedb=new HealthyMeDatabaseHelper(this);
		Button submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v){
				//get the value of desease
		    	Spinner spinner1 = (Spinner) findViewById(R.id.Spinner01);
		    	spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	String disease = spinner1.getSelectedItem().toString();
		    	if(disease.equals("Chose one:")){
		    		final Dialog dialog = new Dialog(SearchActivity.this);
			        dialog.setTitle("Please chose one!");
			        dialog.show();
		    	}
		    	else {
		    		Intent searchintent = new Intent(SearchActivity.this , SearchResultDisplayActivity.class);
		    		searchintent.putExtra(EXTRA_Usernamefromsearchactivity, disease);
			    	startActivity(searchintent);
		    	}
		    	
				}
			}
		);
		Button cancel = (Button) findViewById(R.id.button2);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
					Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
					startActivity(intent);
				} 
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
