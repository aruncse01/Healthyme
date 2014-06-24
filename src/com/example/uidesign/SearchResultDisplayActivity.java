package com.example.uidesign;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultDisplayActivity extends Activity {

	String diseasesname="null";
	public static HealthyMeDatabaseHelper healthymedb;
	Disease disease=new Disease();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result_display);
		//open the database
		healthymedb=new HealthyMeDatabaseHelper(this);
		//get the Extra from the previous 
		Intent intent = getIntent();
		diseasesname = intent.getStringExtra(SearchActivity.EXTRA_Usernamefromsearchactivity);
		disease=healthymedb.getSearchContentDetails(diseasesname);
//		System.out.println("disease.getDiseaseName()==="+disease.getDiseaseName());
//		System.out.println("disease.getDiseaseDefination()==="+disease.getDiseaseDefination());
//		System.out.println("disease.getSymptom()==="+disease.getSymptom());
//		System.out.println("disease.getHospital()==="+disease.getHospital());
//		System.out.println("disease.getDoctor()==="+disease.getDoctor());
		//find the corresponding sopts
		TextView text1diseasename = (TextView) findViewById(R.id.name);
		TextView text2diseasedescription = (TextView) findViewById(R.id.description);
		TextView text3symptomdescription=(TextView) findViewById(R.id.symptomsdescription);
		TextView text4hospitaldescription = (TextView) findViewById(R.id.hospitalsdecription);
		//TextView text5doctordecription= (TextView) findViewById(R.id.doctorsdescription);
		//set the value into the corresponding spots
		text1diseasename.setText(disease.getDiseaseName());
		text2diseasedescription.setText(disease.getDiseaseDefination());
		text3symptomdescription.setText(disease.getSymptom());
		text4hospitaldescription.setText(disease.getHospital());
		//text5doctordecription.setText(disease.getDoctor());

		//button listener
		Button back = (Button) findViewById(R.id.button1);
		back.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				finish();
				} 
			}
		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result_display, menu);
		return true;
	}

}
