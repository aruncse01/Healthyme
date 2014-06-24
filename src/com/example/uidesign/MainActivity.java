package com.example.uidesign;

import com.quickblox.core.QBSettings;
import com.quickblox.module.videochat.core.service.QBVideoChatService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Context contextDB = this;
		HealthyMeDatabaseHelper healthyMeDatabaseHelper = new HealthyMeDatabaseHelper(contextDB);
		healthyMeDatabaseHelper.populateData();
		
		
		ImageButton login = (ImageButton) findViewById(R.id.imageButton1); 
		ImageButton forum = (ImageButton) findViewById(R.id.imageButton2); 
		ImageButton settings = (ImageButton) findViewById(R.id.imageButton3); 
		ImageButton aboutUs = (ImageButton) findViewById(R.id.imageButton4); 
		//Starting videochat service
		startService(new Intent(this, QBVideoChatService.class));
		//QBSettings.getInstance().fastConfigInit("5005", "mp8-7T2y3fsksnx", "tdAjrrgGVjbLsW6");
		final Context context = this; 
		
		//listener for login button
		login.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentLogin = new Intent(context , Login.class); 
				startActivity(intentLogin);	
				} 
			}
		);
		
		//listener for forum button
		forum.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , Login.class); 
				startActivity(intentForum);				
				} 
			}
		);
		
		//listener for settings button
		settings.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentSettings = new Intent(context , SettingsActivity.class); 
				startActivity(intentSettings);				
				} 
			}
		);
		
		//listener for aboutus button
		aboutUs.setOnClickListener(new View.OnClickListener() {			
		@Override public void onClick(View v) {
			// TODO Auto-generated method stub 
			Intent intentForum = new Intent(context , AboutUsActivity.class); 
			startActivity(intentForum);				
				} 
			}
		);
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
