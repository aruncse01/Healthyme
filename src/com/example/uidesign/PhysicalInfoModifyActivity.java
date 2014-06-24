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

public class PhysicalInfoModifyActivity extends Activity {

	public static HealthyMeDatabaseHelper healthymedb;
	public String username="null",namename="null";
	User user=new User();
	public final static String EXTRA_UsernamefromphysicalinfoModify="null";
	int numberofage=100, numberofheight=100, numberofweight=100, numberofdiseases=100, numberofdeficiency=100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physical_info_modify);
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
		//get intent from database
		Intent intent = getIntent();
		username = intent.getStringExtra(PersonalInfoActivity.EXTRA_Usernamefrompersonalinfo);
		user=healthymedb.getUserInfoDetails(username);
		namename=username;
		
		if(user.getUserage().equals("15_to_25")) numberofage=1;
		if(user.getUserage().equals("26_to_35")) numberofage=2;
		if(user.getUserage().equals("36_to_45")) numberofage=3;
		if(user.getUserage().equals("46_to_55")) numberofage=4;
		if(user.getUserage().equals("56_to_65")) numberofage=5;
		spinner.setSelection(numberofage);
		
		if(user.getDisease().equals("Cancer")) numberofdiseases=1;
		if(user.getDisease().equals("Obsity")) numberofdiseases=2;
		if(user.getDisease().equals("Heart Problem")) numberofdiseases=3;
		if(user.getDisease().equals("High Cholesterol")) numberofdiseases=4;
		if(user.getDisease().equals("High Blood Pressure")) numberofdiseases=5;
		if(user.getDisease().equals("Diabetes")) numberofdiseases=6;
		spinner1.setSelection(numberofdiseases);
		
		if(user.getUserweight().equals("120#_to_150#")) numberofweight=1;
		if(user.getUserweight().equals("151#_to_180#")) numberofweight=2;
		if(user.getUserweight().equals("181#_to_210#")) numberofweight=3;
		if(user.getUserweight().equals("211#+")) numberofweight=4;
		spinner2.setSelection(numberofweight);

		if(user.getUserheight().equals("4'5\"-5'0\"")) numberofheight=1;
		if(user.getUserheight().equals("5'1\"-5'5\"")) numberofheight=2;
		if(user.getUserheight().equals("5'6\"-6'0\"")) numberofheight=3;
		if(user.getUserheight().equals("6'1\"-6'5\"")) numberofheight=4;
		spinner3.setSelection(numberofheight);

		if(user.getDeficiency().equals("Vitamin A")) numberofdeficiency=1;
		if(user.getDeficiency().equals("Vitamin B12")) numberofdeficiency=2;
		if(user.getDeficiency().equals("Vitamin C")) numberofdeficiency=3;
		if(user.getDeficiency().equals("Vitamin D3")) numberofdeficiency=4;
		if(user.getDeficiency().equals("Vitamin K")) numberofdeficiency=5;
		if(user.getDeficiency().equals("Iodine")) numberofdeficiency=6;
		if(user.getDeficiency().equals("Calcium")) numberofdeficiency=7;
		if(user.getDeficiency().equals("Magnesium")) numberofdeficiency=8;
		if(user.getDeficiency().equals("Selenium")) numberofdeficiency=9;
		spinner4.setSelection(numberofdeficiency);
		
		Button submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v)
			{
				Intent intentphysicalinfotopersonalinfo = new Intent(PhysicalInfoModifyActivity.this , PersonalInfoActivity.class);
				intentphysicalinfotopersonalinfo.putExtra(EXTRA_UsernamefromphysicalinfoModify, username);
				// TODO Auto-generated method stub 
				Intent intent = new Intent(PhysicalInfoModifyActivity.this, PersonalInfoActivity.class);
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
		    	//get the value of desease
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
//		    	System.out.println("age==="+age);
//		    	System.out.println("disease==="+disease);
//		    	System.out.println("weight==="+weight);
//		    	System.out.println("height==="+height);
//		    	System.out.println("deficiency==="+deficiency);
		    	
		    	
		    	if(age.equals("Chose one:") || disease.equals("Chose one:") || weight.equals("Chose one:") || height.equals("Chose one:") || deficiency.equals("Chose one:")){
		    		final Dialog dialog = new Dialog(PhysicalInfoModifyActivity.this);
			        dialog.setTitle("Please fill in every spot!");
			        dialog.show();
		    	}
		    	else {
			    	User user1=new User();
			    	user1=healthymedb.findUserInfo(username);
			    	User user=new User();
			    	user.setUserweight(weight);
			    	user.setUserheight(height);
			    	user.setDisease(disease);
			    	user.setDeficiency(deficiency);
			    	user.setUsername(username);
			    	user.setUserage(age);
			    	user.setGender(user1.getGender());
			    	//get the info insert into the database
			    	healthymedb.modifyUserInfo(user);
			    	startActivity(intentphysicalinfotopersonalinfo);
		    	}
			} 
		});
		Button cancel = (Button) findViewById(R.id.button2);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
  	        	Intent intent = new Intent(PhysicalInfoModifyActivity.this, PersonalInfoActivity.class);
  	        	
  	        	intent.putExtra(EXTRA_UsernamefromphysicalinfoModify, namename);
				startActivity(intent);
				} 
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.physical_info_modify, menu);
		return true;
	}

}
