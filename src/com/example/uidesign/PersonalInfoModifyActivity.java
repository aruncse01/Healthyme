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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class PersonalInfoModifyActivity extends Activity {

	public final static String EXTRA_Usernamefrompersonalinfomodify="null";
	public static HealthyMeDatabaseHelper healthymedb;
	User user1=new User();
	User user=new User();
    User userforcheck=new User();
    String temporaryusername="null";
    User u123=new User();
	public int numberofspinner=100,idx =100;
	String ulastname="null",ufirstname="null",uusername="null", uemail="null", udob="null", uprofession="null", upassword1="null", upassword2="null";
	int lnl=100,fnl=100,unl=100,el=100,dobl=100,pwd1l=100,pwd2l=100;
	String uradioSex=null,sps="null";
	String recordusername="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_info_modify);
		Spinner spinner = (Spinner) findViewById(R.id.ProfessionSpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		//open the database
		healthymedb=new HealthyMeDatabaseHelper(this);
		//get intent from personal info page
		Intent intent = getIntent();
		String username = intent.getStringExtra(PersonalInfoActivity.EXTRA_Usernamefrompersonalinfo);
		//System.out.println("username=="+username);
		user1=healthymedb.getUserDetails(username);
		temporaryusername=username;
		//find the corresponding sopts
		EditText text1lastname = (EditText) findViewById(R.id.lastname);
		EditText text2firstname = (EditText) findViewById(R.id.firstname);
		TextView text3username=(TextView) findViewById(R.id.username);
		//EditText text3username = (EditText) findViewById(R.id.username);
		EditText text4email = (EditText) findViewById(R.id.email);
		EditText text5dob = (EditText) findViewById(R.id.dob);
		EditText text7password1 = (EditText) findViewById(R.id.password1);
		EditText text7password2 = (EditText) findViewById(R.id.password2);
		//set the value into the corresponding spots
		text1lastname.setText(user1.getLastname());
		text2firstname.setText(user1.getFirstname());
		text3username.setText(user1.getUsername());
		text4email.setText(user1.getEmail());
		text5dob.setText(user1.getDateofbirth());
		if(user1.getProfession().equals("Doctor")) numberofspinner=1;
		if(user1.getProfession().equals("Gym Trainer")) numberofspinner=2;
		if(user1.getProfession().equals("Dietitian")) numberofspinner=3;
		if(user1.getProfession().equals("Others")) numberofspinner=4;
		spinner.setSelection(numberofspinner);
		text7password1.setText(user1.getPassword());
		text7password2.setText(user1.getPassword());
		//check the radio based on the data from the database
    	RadioGroup rg = (RadioGroup) findViewById(R.id.radioSex);
    	View o = rg.getChildAt(user1.getGender());
    	RadioButton radioBtn =  (RadioButton)o;
        radioBtn.setChecked(true);
  		recordusername=user1.getUsername();
        //button listener
  		Button submitbtn = (Button) findViewById(R.id.sbumit);
  		submitbtn.setOnClickListener(new View.OnClickListener() {
  	        @Override public void onClick(View view) {
  	        	Intent intent = new Intent(PersonalInfoModifyActivity.this, ProfileActivity.class);
  	  			
  	        	 /*
  	    		 * try to put the value into the xml page
  	    		 * 
  	    		 */
  	        	EditText lastname = (EditText) findViewById(R.id.lastname);
  	        	EditText firstname = (EditText) findViewById(R.id.firstname);
  	        	TextView username = (TextView) findViewById(R.id.username);
  	        	//EditText username = (EditText) findViewById(R.id.username);
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
  	        	    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
  	        	        Object item = parent.getItemAtPosition(pos);
  	        	    }
  	        	    public void onNothingSelected(AdapterView<?> parent) {
  	        	    }
  	        	});
  	        	//convert the values got from page to the string
  	        	ulastname = lastname.getText().toString();
  	        	ufirstname = firstname.getText().toString();
  	        	if(username.getText().length()==0) uusername="jkhjklhjkl;hjklhjkl";
  	        	else uusername = temporaryusername;//username.getText().toString();
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
  	        	//give the reminder when there is spot not filled in
  		    	if(lnl==0 || fnl==0|| unl==0|| el==0 || dobl==0 || sps.equals("Choose one:") || pwd1l==0 || pwd2l==0 || (idx!=0 && idx!=1) )
  		    	{
  		    		final Dialog dialog = new Dialog(PersonalInfoModifyActivity.this);
  			        dialog.setTitle("Please fill in every spot!");
  			        dialog.show();
  		    	}
  		    	//check the two passwords are match or not
  		    	else if(!upassword1.equals(upassword2)){
  		    		//System.out.println("2");
  		    		final Dialog dialog = new Dialog(PersonalInfoModifyActivity.this);
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
  		    		healthymedb.modifyUser(temporaryusername,user);
  		    		recordusername=uusername; 
  		    		intent.putExtra(EXTRA_Usernamefrompersonalinfomodify, uusername);
  		    		startActivity(intent);}
  			}
  			}
  		);
  		Button cancel = (Button) findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
  	        	Intent intent = new Intent(PersonalInfoModifyActivity.this, ProfileActivity.class);
  	        	
				intent.putExtra(EXTRA_Usernamefrompersonalinfomodify, recordusername);	
				startActivity(intent);
				} 
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_info_modify, menu);
		return true;
	}

}



//System.out.println("Integer.toString(user1.getUserid())==="+Integer.toString(user1.getUserid()));
//System.out.println("user1.getLastname()==="+user1.getLastname());
//System.out.println("user1.getFirstname()==="+user1.getFirstname());
//System.out.println("user1.getUsername()==="+user1.getUsername());
//System.out.println("user1.getEmail()==="+user1.getEmail());
//System.out.println("user1.getDateofbirth()==="+user1.getDateofbirth());
//System.out.println("user1.getProfession()==="+user1.getProfession());
//System.out.println("Integer.toString(user1.getGender())==="+Integer.toString(user1.getGender()));
//System.out.println("Integer.toString(user2.getUserinfoid())==="+Integer.toString(user2.getUserinfoid()));
//System.out.println("user2.getUserage()==="+user2.getUserage());
//System.out.println("user2.getUserweight()==="+user2.getUserweight());
//System.out.println("user2.getDisease()==="+user2.getDisease());
//System.out.println("user2.getDeficiency()==="+user2.getDeficiency());

/*
setContentView(R.layout.activity_personal_info);
// Create the text view
TextView suserid = new TextView(this);     TextView guserid = new TextView(this);
TextView slastname = new TextView(this);   TextView glastname = new TextView(this);
TextView sfirstname = new TextView(this);  TextView gfirstname = new TextView(this);
TextView susername= new TextView(this);    TextView gusername= new TextView(this);
TextView semail= new TextView(this);       TextView gemail = new TextView(this);
TextView sdateofbirth= new TextView(this); TextView gdateofbirth = new TextView(this);
TextView sprofession= new TextView(this);  TextView gprofession = new TextView(this);
TextView sgender= new TextView(this);      TextView ggender= new TextView(this);
TextView suserinfoid= new TextView(this);  TextView guserinfoid= new TextView(this);
TextView suserage= new TextView(this);     TextView guserage= new TextView(this);
TextView suserweight= new TextView(this);  TextView guserweight= new TextView(this);
TextView suserheight= new TextView(this);  TextView guserheight= new TextView(this);
TextView sdisease= new TextView(this);     TextView gdisease= new TextView(this);
TextView sdeficiency= new TextView(this);  TextView gdeficiency= new TextView(this);

suserid.setTextSize(20);                    guserid.setTextSize(20); 
slastname.setTextSize(20);					glastname.setTextSize(20); 
sfirstname.setTextSize(20);   				gfirstname.setTextSize(20); 
susername.setTextSize(20);					gusername.setTextSize(20); 
semail.setTextSize(20);						gemail.setTextSize(20); 
sdateofbirth.setTextSize(20);				gdateofbirth.setTextSize(20); 
sprofession.setTextSize(20);				gprofession.setTextSize(20); 
sgender.setTextSize(20);					ggender.setTextSize(20); 
suserinfoid.setTextSize(20);				guserinfoid.setTextSize(20); 
suserage.setTextSize(20);					guserage.setTextSize(20); 
suserweight.setTextSize(20);				guserweight.setTextSize(20); 
suserheight.setTextSize(20);				guserheight.setTextSize(20); 
sdisease.setTextSize(20);					gdisease.setTextSize(20); 
sdeficiency.setTextSize(20);				gdeficiency.setTextSize(20); 

suserid.setText(userid);					guserid.setText(Integer.toString(user1.getUserid())); 
slastname.setText(lastname);				glastname.setText(user1.getUsername());
sfirstname.setText(firstname);				gfirstname.setText(user1.getFirstname()); 
susername.setText(username);				gusername.setText(user1.getUsername());
semail.setText(email);						gemail.setText(user1.getEmail());
sdateofbirth.setText(dateofbirth);			gdateofbirth.setText(user1.getDateofbirth());
sprofession.setText(profession);			gprofession.setText(user1.getProfession());
sgender.setText(gender);					ggender.setText(Integer.toString(user1.getGender()));
suserinfoid.setText(userinfoid);			guserinfoid.setText(Integer.toString(user2.getUserinfoid()));
suserage.setText(userage);					guserage.setText(user2.getUserage()); 
suserweight.setText(userweight);			guserweight.setText(user2.getUserweight()); 
suserheight.setText(userheight);			guserheight.setText(user2.getUserheight());
sdisease.setText(disease);					gdisease.setText(user2.getDisease()); 
sdeficiency.setText(deficiency);			gdeficiency.setText(user2.getDeficiency());

LinearLayout linearlayout = (LinearLayout)findViewById(R.id.personalinfoviewlayout);
linearlayout.removeAllViews(); 


linearlayout.addView(suserid);			linearlayout.addView(guserid);
linearlayout.addView(slastname);		linearlayout.addView(glastname);
linearlayout.addView(sfirstname);		linearlayout.addView(gfirstname);
linearlayout.addView(susername);		linearlayout.addView(gusername);
linearlayout.addView(semail);			linearlayout.addView(gemail);
linearlayout.addView(sdateofbirth);		linearlayout.addView(gdateofbirth);
linearlayout.addView(sprofession);		linearlayout.addView(gprofession);
linearlayout.addView(sgender);			linearlayout.addView(ggender);
linearlayout.addView(suserinfoid);		linearlayout.addView(guserinfoid);
linearlayout.addView(suserage);			linearlayout.addView(guserage);
linearlayout.addView(suserweight);		linearlayout.addView(guserweight);
linearlayout.addView(suserheight);		linearlayout.addView(guserheight);
linearlayout.addView(sdisease);			linearlayout.addView(gdisease);
linearlayout.addView(sdeficiency);		linearlayout.addView(gdeficiency);

*/

