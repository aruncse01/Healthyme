package com.example.uidesign;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ViewVegetablesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_vegetables);
		
		
		Button back = (Button) findViewById(R.id.button1);
		Button storeLocator = (Button) findViewById(R.id.button2);
	
		
		final Context context = this; 
		
		//listener for back button
		back.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				//Intent intentLogin = new Intent(context , ViewPlanActivity.class); 
				//startActivity(intentLogin);	
				finish();
				} 
			}
		);
		
		//listener for storeLocator button
		storeLocator.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , StoreActivity.class); 
				startActivity(intentForum);				
				} 
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_grain, menu);
		return true;
	}

}
