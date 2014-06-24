package com.example.uidesign;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PlanHistoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plan_history);
		/* Get the Username from session */
		Intent intent = getIntent();
		String userName = intent.getStringExtra(Physicalinfo.EXTRA_Usernamefromphysicalinfo);
		Intent intentGetUsername = getIntent();
    	final String myUserName = (String)intentGetUsername.getSerializableExtra("username");
    	System.out.println("myUserName is "+myUserName);
    	Intent intentUsername = getIntent();
    	final String myUsername = (String)intentGetUsername.getSerializableExtra("usernameNew");
		final String userNameFinal = myUserName == null ? myUsername : myUserName ;
		System.out.println("userNameFinal is "+userNameFinal);
		final Context contextDB = this;
		HealthyMeDatabaseHelper healthyMeDatabaseHelper = new HealthyMeDatabaseHelper(contextDB);
		
		ArrayList<ArrayList<String>> userInfo = healthyMeDatabaseHelper.getAllUserPlans(userNameFinal);
		LinearLayout rootLayout = (LinearLayout)findViewById(R.id.plan_history_layout);
		LinearLayout.LayoutParams rootLayoutParam = new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

		Button createPlan = (Button) findViewById(R.id.button1); 
		final Context context = this; 
		createPlan.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
			
				Intent intentLogin = new Intent(context , Physicalinfo.class); 
				intentLogin.putExtra("username", userNameFinal);
				startActivity(intentLogin);	
				} 
			}
		);
		
		Button back = (Button) findViewById(R.id.button2); 
		//final Context context = this; 
		back.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
			
				Intent intentLogin = new Intent(context , ProfileActivity.class); 
				String myUserName = (String)intentLogin.getSerializableExtra("username");
				System.out.println("Plan History userNameFinal and myUserName"+userNameFinal+" "+myUserName);
				if(userNameFinal == null){
					intentLogin.putExtra("userNameFinal", myUserName);
					intentLogin.putExtra("username", myUserName);
					System.out.println("1");
				}else{
					intentLogin.putExtra("userNameFinal", userNameFinal);
					intentLogin.putExtra("username", userNameFinal);
					System.out.println("2");
				}
				startActivity(intentLogin);	
				} 
			}
		);
		
		
		int cnt = 0;
		for (final ArrayList<String> entry : userInfo) {
			cnt++;
			Button planBtn=new Button(this);
			rootLayoutParam.width = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
			planBtn.setLayoutParams(rootLayoutParam);
			planBtn.setTextColor(Color.parseColor("#000000"));
			planBtn.setText("Plan "+cnt);
			rootLayout.addView(planBtn);
			
			planBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent plan = new Intent(context , ViewPlanActivity.class);
					String myUserName = (String)plan.getSerializableExtra("username");
					System.out.println("Plan History Indivs"+userNameFinal+" "+myUserName);
					if(userNameFinal == null){
						plan.putExtra("userNameFinal", myUserName);
						plan.putExtra("username", myUserName);
						System.out.println("11");
					}else{
						plan.putExtra("userNameFinal", userNameFinal);
						plan.putExtra("username", userNameFinal);
						System.out.println("22");
					}
					
					plan.putExtra("Plan", entry);
					startActivity(plan);
				}
			});

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plan_history, menu);
		return true;
	}

}
