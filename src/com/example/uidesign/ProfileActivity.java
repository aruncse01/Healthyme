package com.example.uidesign;



import com.example.chat.DataHolder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends Activity {
	private Button chatButton;
	public final static String EXTRA_Usernamefromprofile = "null";
	public String username="null";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Intent intent = getIntent();
		//get the username from Login page
		username = intent.getStringExtra(Login.EXTRA_Username);
		System.out.println("M here" + username);
		if(username == null || username.equals("null")) username=intent.getStringExtra(PersonalInfoActivity.EXTRA_Usernamefrompersonalinfo);
		if(username == null || username.equals("null")) username=Physicalinfo.EXTRA_Usernamefromphysicalinfo;
    	//System.out.println("username==="+username);
		//listener for persoanlinfo button 
		System.out.println("Username is before"+username);
		if(username == null || username.equals("null")){
			Intent intentUsername = getIntent();
			username = (String)intentUsername.getSerializableExtra("userNameFinal");
			System.out.println("Did i come here");
		}
		System.out.println("Username is "+username);
		final Context context = this; 
		Button personalinfo = (Button) findViewById(R.id.button1);
		personalinfo.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentPersonalInfo = new Intent(context , PersonalInfoModifyActivity.class); 
				intentPersonalInfo.putExtra(EXTRA_Usernamefromprofile, username);
				startActivity(intentPersonalInfo);	
				} 
			}
		);
		
		//Chat Button On click Listener
		chatButton=(Button)findViewById(R.id.button4);
		chatButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentbacktologin = new Intent(context , ActivityChatLogin.class); 
				startActivity(intentbacktologin);	
				/*Intent intent = new Intent(context, ActivityCallUser.class);
		        intent.putExtra("userId", DataHolder.getInstance().getCurrentQbUser().getId());
		        intent.putExtra("userName", DataHolder.getInstance().getCurrentQbUser().getFullName());
		        startActivity(intent);
		        finish();*/
				} 
			}
		);
		Button gobacktologin = (Button) findViewById(R.id.gotologin);
		gobacktologin.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentbacktologin = new Intent(context , Login.class); 
				//intentPersonalInfo.putExtra(EXTRA_Usernamefromprofile, username);
				startActivity(intentbacktologin);	
				} 
			}
		);
		Button plan = (Button) findViewById(R.id.button2);
		plan.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentGetUsername = getIntent();
		    	String myUserName = (String)intentGetUsername.getSerializableExtra("username");
		    	System.out.println("Username is  2"+username);
		    	if(myUserName == null){
					myUserName = username;
				}
		    	System.out.println("Username is  3"+myUserName);
				Intent intentPersonalInfo = new Intent(context , PlanHistoryActivity.class); 
				intentPersonalInfo.putExtra(EXTRA_Usernamefromprofile, username);
				intentPersonalInfo.putExtra("username", myUserName);
				startActivity(intentPersonalInfo);	
				} 
			}
		);
		Button search = (Button) findViewById(R.id.button5);
		search.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentGetUsername = getIntent();
		 /*   	String myUserName = (String)intentGetUsername.getSerializableExtra("username");
		    	System.out.println("Username is  2"+username);
		    	if(myUserName == null){
					myUserName = username;
				}
		    	System.out.println("Username is  3"+myUserName);*/
				Intent intentPersonalInfo = new Intent(context , SearchActivity.class); 
			/*	intentPersonalInfo.putExtra(EXTRA_Usernamefromprofile, username);
				intentPersonalInfo.putExtra("username", myUserName);*/
				startActivity(intentPersonalInfo);	
				} 
			}
		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
