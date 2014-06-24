package com.example.uidesign;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiseaseSuggestionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_disease_suggestion);
		final Context context = this; 
		Intent diseaseSuggestion = getIntent();
		String diseaseName  = (String) diseaseSuggestion.getSerializableExtra("DiseaseName");
		HealthyMeDatabaseHelper healthyMeDatabaseHelper = new HealthyMeDatabaseHelper(context);
		ArrayList<String> diseaseSuggestionInfo = healthyMeDatabaseHelper.getDisease(diseaseName);
		
		TextView grains = (TextView) findViewById(R.id.textView7); 
		TextView vegetables = (TextView) findViewById(R.id.textView8); 
		TextView fruits = (TextView) findViewById(R.id.textView9); 
		TextView dairy = (TextView) findViewById(R.id.textView11); 
		TextView protein = (TextView) findViewById(R.id.textView10); 
	
		System.out.println("My diseaseSuggestionInfo size " + diseaseSuggestionInfo.size());
		grains.setText(diseaseSuggestionInfo.get(0));
		vegetables.setText(diseaseSuggestionInfo.get(1));
		fruits.setText(diseaseSuggestionInfo.get(2));
		dairy.setText(diseaseSuggestionInfo.get(3));
		protein.setText(diseaseSuggestionInfo.get(4));
		
		Button back = (Button) findViewById(R.id.button1);
		
		
		//listener for back button
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
		getMenuInflater().inflate(R.menu.disease_suggestion, menu);
		return true;
	}

}
