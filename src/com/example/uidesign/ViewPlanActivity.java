package com.example.uidesign;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPlanActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_plan);
		Intent tripDetail = getIntent();
		final ArrayList<String> userInfo = (ArrayList<String>) tripDetail.getSerializableExtra("Plan");
		final Context contextDB = this;
		HealthyMeDatabaseHelper healthyMeDatabaseHelper = new HealthyMeDatabaseHelper(contextDB);
		final ArrayList<String> foodInfo = healthyMeDatabaseHelper.getFoodSuggestions(userInfo);

		TextView grains = (TextView) findViewById(R.id.textView4); 
		TextView protein = (TextView) findViewById(R.id.textView8); 
		TextView veg = (TextView) findViewById(R.id.textView6); 
		TextView fruit = (TextView) findViewById(R.id.textView10); 
		TextView dairy = (TextView) findViewById(R.id.textView12); 

		System.out.println("My size " + foodInfo.size());
		System.out.println("My userinfo size " + userInfo.size());
		grains.setText(foodInfo.get(0));
		protein.setText(foodInfo.get(4));
		veg.setText(foodInfo.get(1));
		fruit.setText(foodInfo.get(2));
		dairy.setText(foodInfo.get(3));
		final Context context = this; 
		Button moreInfo1 = (Button) findViewById(R.id.button1); 
		Button moreInfo2 = (Button) findViewById(R.id.Button01); 
		Button moreInfo3 = (Button) findViewById(R.id.button4); 
		Button moreInfo4 = (Button) findViewById(R.id.button5); 
		Button moreInfo5 = (Button) findViewById(R.id.button3); 
		Button back = (Button) findViewById(R.id.button7);
		Button calendar = (Button) findViewById(R.id.button6);
		Button workOut = (Button) findViewById(R.id.button2);

		Button disease = (Button) findViewById(R.id.button8);
		Button deficiency = (Button) findViewById(R.id.button9);


		//listener for grain button
		disease.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 

				if(userInfo.get(5) == null || userInfo.get(5).equals("Choose one:")){
					final Dialog dialog = new Dialog(ViewPlanActivity.this);
					dialog.setTitle("No Disease was entered!");
					dialog.show();
				}
				else{
					Intent diseaseSuggestion = new Intent(context , DiseaseSuggestionActivity.class); 
					diseaseSuggestion.putExtra("DiseaseName", userInfo.get(5));
					startActivity(diseaseSuggestion);	
				} 
			}
		}
				);

		deficiency.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				if(userInfo.get(6) == null || userInfo.get(6).equals("Choose one:")){
					final Dialog dialog = new Dialog(ViewPlanActivity.this);
					dialog.setTitle("No Deficiency was entered!");
					dialog.show();
				}
				else{
					System.out.println("My deficiency "+userInfo.get(6));
					Intent deficiencySuggestion = new Intent(context , DeficiencySuggestionActivity.class); 
					deficiencySuggestion.putExtra("DeficiencyName", userInfo.get(6));
					startActivity(deficiencySuggestion);	
				}
			} 
		}
				);




		//listener for grain button
		moreInfo1.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentLogin = new Intent(context , ViewGrainActivity.class); 
				startActivity(intentLogin);	
			} 
		}
				);

		//listener for Veggies button
		moreInfo2.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , ViewVegetablesActivity.class); 
				startActivity(intentForum);				
			} 
		}
				);

		//listener for fruits button
		moreInfo3.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentSettings = new Intent(context , ViewFruitsActivity.class); 
				startActivity(intentSettings);				
			} 
		}
				);

		//listener for dairy button
		moreInfo4.setOnClickListener(new View.OnClickListener() {			
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , ViewDairyActivity.class); 
				startActivity(intentForum);				
			} 
		}
				);

		//listener for protein button
		moreInfo5.setOnClickListener(new View.OnClickListener() {			
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , ViewProteinActivity.class); 
				startActivity(intentForum);				
			} 
		}			
				);


		//listener for backToPlans button
		back.setOnClickListener(new View.OnClickListener() {			
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , PlanHistoryActivity.class); 
				Intent intentGetUsername = getIntent();
				String myUserName = (String)intentGetUsername.getSerializableExtra("username");
				intentForum.putExtra("username", myUserName);
				startActivity(intentForum);				
			} 
		}			
				);

		//listener for Calendar button
		calendar.setOnClickListener(new View.OnClickListener() {			
			@SuppressLint("NewApi")
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intent = new Intent(Intent.ACTION_INSERT);  
				intent.setData(CalendarContract.Events.CONTENT_URI);
				intent.setType("vnd.android.cursor.item/event");  
				intent.putExtra(Events.TITLE, "My Diet Chart");  
				intent.putExtra(Events.EVENT_LOCATION, "Home");  
				intent.putExtra(Events.DESCRIPTION, "My Supplements for the day");  
				GregorianCalendar calDate = new GregorianCalendar(2013, 12, 06);  
				intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,  
						calDate.getTimeInMillis());  
				intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,  
						calDate.getTimeInMillis());  
				intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);  
				intent.putExtra(Events.ACCESS_LEVEL, Events.ACCESS_PRIVATE);  
				intent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY);  
				startActivity(intent);  
				
				//Intent intentForum = new Intent(context , CalendarApplicationActivity.class); 
				//startActivity(intentForum);				
			} 
		}			
				);

		//listener for WorkOut button
		workOut.setOnClickListener(new View.OnClickListener() {			
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , ViewWorkOutActivity.class); 
				startActivity(intentForum);				
			} 
		}			
				);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_plan, menu);
		return true;
	}

}
