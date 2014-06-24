package com.example.uidesign;

import java.util.GregorianCalendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

@SuppressLint("NewApi")
public class CalendarApplicationActivity extends Activity
{  

	public static final String[] EVENT_PROJECTION = new String[] 
			{  
		Calendars._ID, // 0  
		Calendars.ACCOUNT_NAME, // 1  
		Calendars.CALENDAR_DISPLAY_NAME // 2  
			};  


	@Override 
	public void onCreate(Bundle savedInstanceState)
	{  
		super.onCreate(savedInstanceState);  
		//setContentView(R.layout.activity_calendar_application);  
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
	}  
}