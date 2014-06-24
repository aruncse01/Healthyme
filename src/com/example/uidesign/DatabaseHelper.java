package com.example.uidesign;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public final static String user_id = "user_id";
	public final static String user_lastname = "user_lastname";
	public final static String user_firstname = "user_firstname";
	public final static String user_username = "user_name";
	public final static String user_email = "user_email";
	public final static String user_dateofbirth = "user_dob";
	public final static String user_profession = "user_profession";
	public final static String user_password = "user_password";
	public final static String user_gender = "user_gender";//0 means female and 1 means male
	public static DatabaseHelper mDbHelper;
	public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME="database";
    private static final String USER_TABLE_NAME = "userinfo";
    private static final String USER_TABLE_CREATE =" CREATE TABLE " + USER_TABLE_NAME 
    		+ " ( " + user_id + " integer primary key autoincrement, " 
    				+ user_lastname + " TEXT not null, " 
    				+ user_firstname + " TEXT not null, " 
    				+ user_username + " TEXT not null, " 
    				+ user_email + " TEXT not null, " 
    				+ user_dateofbirth + " TEXT not null, " 
    				+ user_profession + " TEXT not null, " 
    				+ user_password + " TEXT not null, " 
    				+ user_gender + " TEXT not null); ";
	
    
	public DatabaseHelper(Context context) 
    {  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }  
    @Override 
    public void onCreate(SQLiteDatabase db) 
    {
        db.execSQL(USER_TABLE_CREATE);
    }
    @Override 
    //when the version # is changed, the system with automatically revoke this function
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	
    	// TODO Auto-generated method stub
        db.execSQL(" DROP TABLE " + USER_TABLE_NAME);
        onCreate(db);

    }  
    @Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
