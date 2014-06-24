package com.example.uidesign;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
public class ViewWorkOutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_work_out);
		
		Button cardio = (Button) findViewById(R.id.button1); 
		Button str = (Button) findViewById(R.id.button2); 
		Button flex = (Button) findViewById(R.id.button3);
		Button back = (Button) findViewById(R.id.button4);
	
		
		final Context context = this; 
		
		//listener for cardio button
		cardio.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentLogin = new Intent(context , ViewCardioActivity.class); 
				startActivity(intentLogin);	
				} 
			}
		);
		
		//listener for strength button
		str.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentForum = new Intent(context , ViewStrengthActivity.class); 
				startActivity(intentForum);				
				} 
			}
		);
		
		//listener for Flex button
		flex.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentSettings = new Intent(context , ViewFlexibilityActivity.class); 
				startActivity(intentSettings);				
				} 
			}
		);
		
		//listener for back button
		back.setOnClickListener(new View.OnClickListener() {			
		@Override public void onClick(View v) {
			// TODO Auto-generated method stub 
			//Intent intentForum = new Intent(context , ViewActivity.class); 
			//startActivity(intentForum);				
			finish();
		} 
			}
		);
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_work_out, menu);
		return true;
	}
}