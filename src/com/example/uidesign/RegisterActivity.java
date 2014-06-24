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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class RegisterActivity extends Activity {

	public final static String EXTRA_lastname = "lastname";
	public final static String EXTRA_firstname = "firstname";
	public final static String EXTRA_username = "username";
	public final static String EXTRA_email = "email";
	public final static String EXTRA_password1 = "password1";
	public final static String EXTRA_password2 = "password2";
	public final static String EXTRA_radioSex = "radioSex";
	String ulastname="null",ufirstname="null",uusername="null", uemail="null", udob="null", uprofession="null", upassword1="null", upassword2="null";
	int idx =100;
	public static HealthyMeDatabaseHelper healthymedb;
	String uradioSex=null;
    User user=new User();
    User userforcheck=new User();
	int lnl=100,fnl=100,unl=100,el=100,dobl=100,pwd1l=100,pwd2l=100;
	String sps="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//System.out.println("get into the registeractivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		Spinner spinner = (Spinner) findViewById(R.id.ProfessionSpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		//open the database
		healthymedb=new HealthyMeDatabaseHelper(this);
		//get the value from the page
		
		//button listener
		Button submitbtn = (Button) findViewById(R.id.sbumit);
		submitbtn.setOnClickListener(new View.OnClickListener() {
			Intent intent = new Intent(RegisterActivity.this, Login.class);
	        @Override public void onClick(View view) {
	        	 /*
	    		 * try to get the value from the xml page
	    		 * 
	    		 */
	        	EditText lastname = (EditText) findViewById(R.id.lastname);
	        	EditText firstname = (EditText) findViewById(R.id.firstname);
	        	EditText username = (EditText) findViewById(R.id.username);
	        	EditText email = (EditText) findViewById(R.id.email);
	        	EditText dob = (EditText) findViewById(R.id.dob);
	        	EditText password1 = (EditText) findViewById(R.id.password1);
	        	EditText password2 = (EditText) findViewById(R.id.password2);
	        	//get the value of which radio did the user selected
	        	RadioGroup rg = (RadioGroup) findViewById(R.id.radioSex);
	        	int checked = rg.getCheckedRadioButtonId();
	        	View radioButton = rg.findViewById(checked);
	        	idx = rg.indexOfChild(radioButton);
	        	//get the value of spinner
	        	Spinner spinner = (Spinner) findViewById(R.id.ProfessionSpinner);
	        	spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	        	    @Override
					public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
	        	        Object item = parent.getItemAtPosition(pos);
	        	    }
	        	    @Override
					public void onNothingSelected(AdapterView<?> parent) {
	        	    }
	        	});
	        	//convert the values got from page to the string
	        	ulastname = lastname.getText().toString();
	        	ufirstname = firstname.getText().toString();
	        	if(username.getText().length()==0) uusername="jkhjklhjkl;hjklhjkl";
	        	else uusername = username.getText().toString();
	        	uemail = email.getText().toString();
	        	udob = dob.getText().toString();
	        	uprofession = spinner.getSelectedItem().toString();
	        	upassword1 = password1.getText().toString();
	        	upassword2 = password2.getText().toString();
	        	if(idx==0) uradioSex= "female"; 
	        	else if(idx==1) uradioSex="male";
	        	//get the length of the strings
	        	lnl=lastname.getText().length();
	        	fnl=firstname.getText().length();
	        	unl=username.getText().length();
	        	el=email.getText().length();
	        	dobl=dob.getText().length();
	        	sps=spinner.getSelectedItem().toString();
	        	pwd1l=password1.getText().length();
	        	pwd2l=password2.getText().length();
	    	    /*
	             * for testing the value 
	             */
//	        	if(lastname.getText().length()==0){System.out.println("ulastname===null");}
//	        	System.out.println("ulastname==="+ulastname);
//	        	System.out.println("ufirstname==="+ufirstname);
//	        	System.out.println("uusername==="+uusername);
//	        	System.out.println("uemail==="+uemail);
//	        	System.out.println("udob==="+udob);
//	        	System.out.println("uprofession==="+uprofession);
//	        	System.out.println("upassword1==="+upassword1);
//	        	System.out.println("upassword2==="+upassword2);
//	        	System.out.println("uradioSex==="+uradioSex);
	        	
	        	//check whether the user has already registered before based on whether we can get the information from database or not
		    	userforcheck=healthymedb.getUserDetails(uusername);
		    	//System.out.println("userforcheck.getLastname()==="+userforcheck.getLastname());
		    	//make sure that the user fill in every spot
		    	if(lnl==0 || fnl==0|| unl==0|| el==0 || dobl==0 || sps.equals("Chose one:") || pwd1l==0 || pwd2l==0 || (idx!=0 && idx!=1) ){
		    		//System.out.println("3");
		    		final Dialog dialog = new Dialog(RegisterActivity.this);
			        dialog.setTitle("Please fill in every spot!");
			        dialog.show();
		    	}
		    	//check user is exist in database or not
		    	else if (userforcheck.getLastname()!=null){//.length()!=0) {
		    		//System.out.println("1");
		    		final Dialog dialog = new Dialog(RegisterActivity.this);
			        //dialog.setContentView(R.layout.reminder); 
			        dialog.setTitle("Username exists!");
			        dialog.show();
		    	}
		    	//check the two passwords are match or not
		    	else if(!upassword1.equals(upassword2)){
		    		//System.out.println("2");
		    		final Dialog dialog = new Dialog(RegisterActivity.this);
			        dialog.setTitle("Passwords don't match!");
			        dialog.show();
		    	}
		    	//if everything is fine, then the values that we just got from page will be insert into the database
		    	else {
		    		//System.out.println("4"); 
		        	user.setLastname(ulastname);
		        	user.setFirstname(ufirstname);
		        	user.setUsername(uusername); 
		        	user.setEmail(uemail);
		        	user.setDateofbirth(udob);
		        	user.setProfession(uprofession);
		        	user.setPassword(upassword2);
		        	user.setGender(idx);
		        	//insert the data into the databse and close the database
		    		healthymedb.insertUser(user);
		    		startActivity(intent);}
			}
			}
		);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	//the function for the Cancel button to navigate the user back to the main page
	public void back_to_login(View view) 
    {
		Intent intent = new Intent(this, Login.class);	
		startActivity(intent);
    }
	

    
}
