package com.example.uidesign;

import java.util.List;

import org.json.JSONException;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManger {

	public final static String user_id = "user_id";
	public final static String user_lastname = "user_lastname";
	public final static String user_firstname = "user_firstname";
	public final static String user_username = "user_name";
	public final static String user_email = "user_email";
	public final static String user_dateofbirth = "user_dob";
	public final static String user_profession = "user_profession";
	public final static String user_password = "user_password";
	public final static String user_gender = "user_gender";//0 means female and 1 means male
    private static final String USER_TABLE_NAME = "userinfo";
    String[] cols = { user_id,user_lastname,user_firstname,user_username,user_email,user_dateofbirth,user_profession,user_password,user_gender};
	public static DatabaseHelper mDbHelper;
	public static SQLiteDatabase db;
	//construction function
	public DBManger(Context context)
	{
		mDbHelper= new DatabaseHelper(context);
	}
	//openning the database function
    public void open() throws SQLException
    {
    	db=mDbHelper.getWritableDatabase();
    }
    //closing the database function
    public void close()
    {
    	mDbHelper.close();
    }
    //inserting the data that got from user into the local database
	public void insertData(User user) {
//    	ContentValues values = new ContentValues();
//    	values.put(key_name, tripname);
//    	values.put(key_time, triptime);
//    	values.put(key_location, triplocation);
//    	values.put(key_people, trippeople);
//    	values.put(key_url, trippeople);
//        db.insert(TRIP_TABLE_NAME, null,values);
    }
	//getting all of the trips from database and give it to viewtrip page
	public List<User> getAllTripDest() {
//	    List<Tripinfo> trips = new ArrayList<Tripinfo>();
//
//	    Cursor cursor = db.query(TRIP_TABLE_NAME,
//	    		cols, null, null, null, null, null);
//
//	    cursor.moveToFirst();
//	    while (!cursor.isAfterLast()) {
//	      Tripinfo trip = cursorToTrip(cursor);
//	      trips.add(trip);
//	      cursor.moveToNext();
//	    }
//	    // make sure to close the cursor
//	    cursor.close();
//	    return trips;
		return null;
	  }
    //getting the every part of the trip and send them to 'getAllTripDest()' funtion
	private User cursorToTrip(Cursor cursor) 
	{
//		Tripinfo trip = new Tripinfo();
//		trip.setTripid(cursor.getInt(0));
//		//System.out.println("cursor.getInt(0)===="+cursor.getInt(0));
//		trip.setTripname(cursor.getString(1));//tripname--1
//		trip.setTriptime(cursor.getString(2));//url--2
//		trip.setTriplocation(cursor.getString(3));//date--3
//		trip.setTrippeople(cursor.getString(4));//time--4
//		//trip.setPeople(cursor.getString(5));//people--5
//		return trip;
		return null;
	}
	
	 public static String conversion(User trip) throws JSONException 
	 {
//		 JSONObject json=new JSONObject();
//		 String createtrip="CREATE_TRIP";
//		 json.put("location", trip.getTriplocation());
//		 json.put("datetime", trip.getTriptime());
//		 json.put("people", trip.getTrippeople());
//		 json.put("command", createtrip);
//		 String jsonstr=json.toString();
//		 return jsonstr;
		 return null;
	 }
	
	
	public User queryAll(String tripname) {
        
//		String sql=" select * from " + TRIP_TABLE_NAME + " where " + key_name  + " = '" + tripname + "'";
//		System.out.println("sql==="+ sql);
//        Cursor c = db.rawQuery(sql, null);
//        System.out.println("name=======");
//
//        Tripinfo trip=new Tripinfo();;
//        System.out.println("id=======" + c.getString(1));
//
//            System.out.println("name=======" + c.getString(1));
//            trip.setTripname(c.getString(1));
//            trip.setTriptime(c.getString(2));
//            trip.setTriplocation(c.getString(3));
//            trip.setTrippeople(c.getString(4));
//        return trip;
		return null;

    }
	

	public User  getData(int id) {
//		
//		System.out.println("enter getData");
//		System.out.println("id===="+id);
//		String sql="select * from " + TRIP_TABLE_NAME + " where trip_id = " + id;
//		//System.out.println("sql=="+sql);
//        Cursor c = db.rawQuery(sql, null);
//        System.out.println("c.getString(1)==="+c.getString(1));
//        System.out.println("c.getString(2)==="+c.getString(2));
//        System.out.println("c.getString(3)==="+c.getString(3));
//        System.out.println("c.getString(4)==="+c.getString(4));
//        Tripinfo trip=new Tripinfo();
//        trip.setTripname(c.getString(1));
//        trip.setTriptime(c.getString(2));
//        trip.setTriplocation(c.getString(3));
//        trip.setTrippeople(c.getString(4));
//        return trip;
		return null;
	}
	/*
	 * List<Person> personList = new ArrayList<Person>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from " + TABLE_PERSON + " where trip_id = " + tripId, null);
//		loop through all query results
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			Person person = new Person();
			
			person.setName(cursor.getString(1));
			personList.add(person);
		}

	 * */
}
