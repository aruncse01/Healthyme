package com.example.uidesign;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Physicalinfo extends Activity {

	public String username="null";
	public static HealthyMeDatabaseHelper healthymedb;
	final Context context = this; 
	public final static String EXTRA_Usernamefromphysicalinfo="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physicalinfo);
		Spinner spinner = (Spinner) findViewById(R.id.age);
		Spinner spinner1 = (Spinner) findViewById(R.id.Spinner01);
		Spinner spinner2 = (Spinner) findViewById(R.id.weight);
		Spinner spinner3 = (Spinner) findViewById(R.id.height);
		Spinner spinner4 = (Spinner) findViewById(R.id.deficiency);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.disease, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.weight, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.height, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,R.array.deficiency, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner1.setAdapter(adapter1);
		spinner2.setAdapter(adapter2);
		spinner3.setAdapter(adapter3);
		spinner4.setAdapter(adapter4);
		//open the database
		healthymedb=new HealthyMeDatabaseHelper(this);
		//user intent to get the value from previous activity
		Intent intent = getIntent();
		username = intent.getStringExtra(PersonalInfoActivity.EXTRA_Usernamefrompersonalinfo);
		Intent intentGetUsername = getIntent();
    	final String myUserName = (String)intentGetUsername.getSerializableExtra("username");

    	//listent the button 
		Button submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v)
			{
				Intent intentphysicalinfotopersonalinfo = new Intent(context , PlanHistoryActivity.class);
				
				Intent intentGetUsername = getIntent();
		    	String myUserName = (String)intentGetUsername.getSerializableExtra("username");
				if(username == null){
					username = myUserName;
				}
				System.out.println("In Physical"+ username);
				intentphysicalinfotopersonalinfo.putExtra(EXTRA_Usernamefromphysicalinfo, username);
				intentphysicalinfotopersonalinfo.putExtra("username", username);
		    	//get the value of age spinner
		    	Spinner spinner = (Spinner) findViewById(R.id.age);
		    	spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	//get the value of disease
		    	Spinner spinner1 = (Spinner) findViewById(R.id.Spinner01);
		    	spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	//get the value of age weight
		    	Spinner spinner2 = (Spinner) findViewById(R.id.weight);
		    	spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	//get the value of age height
		    	Spinner spinner3 = (Spinner) findViewById(R.id.height);
		    	spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	//get the value of age deficiency
		    	Spinner spinner4 = (Spinner) findViewById(R.id.deficiency);
		    	spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	        Object item = parent.getItemAtPosition(pos);
		    	    }
		    	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
		    	    }
		    	});
		    	String age = spinner.getSelectedItem().toString();
		    	String disease = spinner1.getSelectedItem().toString();
		    	String weight = spinner2.getSelectedItem().toString();
		    	String height = spinner3.getSelectedItem().toString();
		    	String deficiency = spinner4.getSelectedItem().toString();
		    	
		    	System.out.println("My disease value "+disease);
		    	if(age.equals("Choose one:") || weight.equals("Choose one:") || height.equals("Choose one:") ){
		    		final Dialog dialog = new Dialog(Physicalinfo.this);
			        dialog.setTitle("Please fill in every spot!");
			        dialog.show();
		    	}
		    	//|| disease.equals("Choose one:") 
		    	//|| deficiency.equals("Choose one:")
		    	else {
			    	User user1=new User();
			    	user1=healthymedb.findUserInfo(username);
			    	User user=new User();
			    	user.setUserweight(weight);
			    	user.setUserheight(height);
			    	user.setDisease(disease);
			    	user.setDeficiency(deficiency);
			    	user.setUsername(myUserName);
			    	user.setUserage(age);
			    	user.setGender(user1.getGender());
			    	System.out.println("User's details "+user.getUserheight()+myUserName);
			    	//get the info insert into the database
			    	healthymedb.insertUserInfo(user);
			    
			    	intentphysicalinfotopersonalinfo.putExtra("usernameNew", myUserName); 
			    	startActivity(intentphysicalinfotopersonalinfo);
		    	}
			} 
		});
		//listent the button 
		Button cancel = (Button) findViewById(R.id.button2);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
					Intent intent = new Intent(Physicalinfo.this, PlanHistoryActivity.class);
					intent.putExtra(EXTRA_Usernamefromphysicalinfo, username);
					
					Intent intentGetUsername = getIntent();
			    	String myUserName = (String)intentGetUsername.getSerializableExtra("username");
					if(username == null){
						username = myUserName;
					}
					System.out.println("In Physical"+ username);
					intent.putExtra(EXTRA_Usernamefromphysicalinfo, username);
					intent.putExtra("username", username);
					
					startActivity(intent);
				} 
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.physicalinfo, menu);
		return true;
	}

}
