package com.example.uidesign;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HealthyMeDatabaseHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 12;
	private static final String DATABASE_NAME = "healthyMe.db";
	private static final String TABLE_GENERAL_INFO = "generalInfo";
	private static final String COLUMN_GENERAL_INFO_ID = "_infoId";
	private static final String COLUMN_GENERAL_INFO_AGE = "age";
	private static final String COLUMN_GENERAL_INFO_WEIGHT = "weight";
	private static final String COLUMN_GENERAL_INFO_HEIGHT = "height";
	private static final String COLUMN_GENERAL_INFO_GENDER = "gender";

	private static final String TABLE_FOOD_SUGGESTIONS = "foodSuggestions";
	private static final String COLUMN_FOOD_SUGGESTIONS_INFO_ID = "foodSuggestionInfoId";
	private static final String COLUMN_FOOD_SUGGESTIONS_GRAINS = "grains";
	private static final String COLUMN_FOOD_SUGGESTIONS_VEGETABLES = "vegetables";
	private static final String COLUMN_FOOD_SUGGESTIONS_FRUITS = "fruits";
	private static final String COLUMN_FOOD_SUGGESTIONS_DAIRY = "dairy";
	private static final String COLUMN_FOOD_SUGGESTIONS_PROTEIN = "protein";

	private static final String TABLE_GRAINS = "grains";
	private static final String COLUMN_GRAIN_ID = "_grainId";
	private static final String COLUMN_GRAIN_TYPE = "grainType";
	private static final String COLUMN_GRAIN_NAME = "grainName"; 

	private static final String TABLE_VEGETABLES = "vegetables"; 
	private static final String COLUMN_VEG_ID = "_vegId"; 
	private static final String COLUMN_VEG_TYPE = "vegType"; 
	private static final String COLUMN_VEG_NAME = "vegName";

	private static final String TABLE_FRUITS = "fruits"; 
	private static final String COLUMN_FRUIT_ID = "_fruitId"; 
	private static final String COLUMN_FRUIT_TYPE = "fruitType"; 
	private static final String COLUMN_FRUIT_NAME = "fruitName";

	private static final String TABLE_DAIRY = "dairy"; 
	private static final String COLUMN_DAIRY_ID = "_dairyId"; 
	private static final String COLUMN_DAIRY_TYPE = "dairyType"; 
	private static final String COLUMN_DAIRY_NAME = "dairyName";

	private static final String TABLE_PROTEIN = "protein"; 
	private static final String COLUMN_PROTEIN_ID = "_proteinId"; 
	private static final String COLUMN_PROTEIN_TYPE = "proteinType"; 
	private static final String COLUMN_PROTEIN_NAME = "proteinName";

	private static final String TABLE_DISEASE = "disease"; 
	private static final String COLUMN_DISEASE_ID = "_diseaseId"; 
	private static final String COLUMN_DISEASE_NAME = "diseaseName"; 
	private static final String COLUMN_DISEASE_GRAINS = "grains"; 
	private static final String COLUMN_DISEASE_VEGETABLES = "vegetables";
	private static final String COLUMN_DISEASE_FRUITS = "fruits";
	private static final String COLUMN_DISEASE_DAIRY = "dairy";
	private static final String COLUMN_DISEASE_PROTEIN = "protein";
	private static final String COLUMN_DISEASE_SUGGESTIONS = "suggestions";

	private static final String TABLE_DEFICIENCY = "deficiency"; 
	private static final String COLUMN_DEFICIENCY_ID = "_deficiencyId"; 
	private static final String COLUMN_DEFICIENCY_NAME = "deficiencyName"; 
	private static final String COLUMN_DEFICIENCY_GRAINS = "grains"; 
	private static final String COLUMN_DEFICIENCY_VEGETABLES = "vegetables";
	private static final String COLUMN_DEFICIENCY_FRUITS = "fruits";
	private static final String COLUMN_DEFICIENCY_DAIRY = "dairy";
	private static final String COLUMN_DEFICIENCY_PROTEIN = "protein";
	private static final String COLUMN_DEFICIENCY_SUGGESTIONS = "suggestions";

	private static final String TABLE_WORKOUT = "workout"; 
	private static final String COLUMN_WORKOUT_ID = "_workOutId"; 
	private static final String COLUMN_DISEASE = "diseaseId"; 
	private static final String COLUMN_DEFICIENCY = "DeficiencyId";
	private static final String COLUMN_WORKOUT_SUGGESTIONS = "workOutSuggestions";

	private static final String TABLE_SUGGESTIONS = "suggestions";
	private static final String COLUMN_SUGGESTION_ID = "_suggestionId";
	private static final String COLUMN_SUGGESTION = "suggestion";

	private static final String TABLE_USER = "user";
	private static final String COLUMN_USER_ID = "_id";
	private static final String COLUMN_LASTNAME = "user_lastname";
	private static final String COLUMN_FIRSTNAME = "user_firstname";
	private static final String COLUMN_USERNAME = "user_name";
	private static final String COLUMN_EMAIL = "user_email";
	private static final String COLUMN_DOB = "user_dob";
	private static final String COLUMN_PROFESSION = "user_profession";
	private static final String COLUMN_PWD = "user_password";
	private static final String COLUMN_GENDER = "user_gender";

	private static final String TABLE_USERINFO = "userInfo"; 
	private static final String COLUMN_USERINFO_ID = "_userInfoId"; 
	private static final String COLUMN_USER_NAME = "user_name";
	private static final String COLUMN_USER_AGE = "age"; 
	private static final String COLUMN_USER_WEIGHT ="weight";
	private static final String COLUMN_USER_HEIGHT = "height";
	private static final String COLUMN_USER_GENDER = "gender";
	private static final String COLUMN_USER_DISEASE = "disease";
	private static final String COLUMN_USER_DEFICIENCY = "deficiency";
	//public static HealthyMeDatabaseHelper mDbHelper;

	private static final String TABLE_SEARCH = "searchC"; 
	private static final String COLUMN_SEARCH_ID = "searchId"; 
	private static final String COLUMN_DISEASES_NAME = "diseaseName";
	private static final String COLUMN_DISEASES_DEFINATION = "diseaseDefination";
	private static final String COLUMN_HOSPITAL = "hospital"; 
	private static final String COLUMN_DOCTOR ="doctor";
	private static final String COLUMN_SYMPTOM = "symptom";



	public HealthyMeDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_USER + "("
				+ COLUMN_USER_ID + " integer primary key autoincrement, "
				+ COLUMN_LASTNAME + " text, "
				+ COLUMN_FIRSTNAME + " text, "
				+ COLUMN_USERNAME + " text, "
				+ COLUMN_EMAIL + " text, "
				+ COLUMN_DOB + " text, "
				+ COLUMN_PROFESSION + " text, "
				+ COLUMN_PWD + " text, "
				+ COLUMN_GENDER + " integer)");
		db.execSQL("create table " + TABLE_GENERAL_INFO + "("
				+ COLUMN_GENERAL_INFO_ID + " integer primary key autoincrement, "
				+ COLUMN_GENERAL_INFO_AGE + " text, "
				+ COLUMN_GENERAL_INFO_WEIGHT + " text, "
				+ COLUMN_GENERAL_INFO_HEIGHT + " text, "
				+ COLUMN_GENERAL_INFO_GENDER + " text)");
		db.execSQL("create table " + TABLE_FOOD_SUGGESTIONS + "("
				+ COLUMN_FOOD_SUGGESTIONS_INFO_ID + " integer primary key autoincrement, "
				+ COLUMN_FOOD_SUGGESTIONS_GRAINS + " text, "
				+ COLUMN_FOOD_SUGGESTIONS_VEGETABLES + " text, "
				+ COLUMN_FOOD_SUGGESTIONS_FRUITS + " text, "
				+ COLUMN_FOOD_SUGGESTIONS_PROTEIN + " text, "
				+ COLUMN_FOOD_SUGGESTIONS_DAIRY + " text)");
		db.execSQL("create table " + TABLE_GRAINS + "("
				+ COLUMN_GRAIN_ID + " integer primary key autoincrement, "
				+ COLUMN_GRAIN_TYPE + " text, "
				+ COLUMN_GRAIN_NAME + " text)");
		db.execSQL("create table "+ TABLE_VEGETABLES + " ( "
				+ COLUMN_VEG_ID + " integer primary key autoincrement, "
				+ COLUMN_VEG_TYPE + " text, "
				+ COLUMN_VEG_NAME + " text);"
				);
		db.execSQL("create table "+ TABLE_FRUITS + " ( "
				+ COLUMN_FRUIT_ID + " integer primary key autoincrement, "
				+ COLUMN_FRUIT_TYPE + " text, "
				+ COLUMN_FRUIT_NAME + " text);"
				);
		db.execSQL("create table "+ TABLE_DAIRY + " ( "
				+ COLUMN_DAIRY_ID + " integer primary key autoincrement, "
				+ COLUMN_DAIRY_TYPE + " text, "
				+ COLUMN_DAIRY_NAME + " text);"
				);
		db.execSQL("create table "+ TABLE_PROTEIN + " ( "
				+ COLUMN_PROTEIN_ID + " integer primary key autoincrement, "
				+ COLUMN_PROTEIN_TYPE + " text, "
				+ COLUMN_PROTEIN_NAME + " text);"
				);
		db.execSQL("create table "+ TABLE_DISEASE + " ( "
				+ COLUMN_DISEASE_ID + " integer primary key autoincrement, "
				+ COLUMN_DISEASE_NAME + " text, "
				+ COLUMN_DISEASE_GRAINS + " text, "
				+ COLUMN_DISEASE_VEGETABLES + " text, "
				+ COLUMN_DISEASE_FRUITS + " text, "
				+ COLUMN_DISEASE_DAIRY + " text, "
				+ COLUMN_DISEASE_PROTEIN + " text, "
				+ COLUMN_DISEASE_SUGGESTIONS + " text);"
				);
		db.execSQL("create table "+ TABLE_DEFICIENCY + " ( "
				+ COLUMN_DEFICIENCY_ID + " integer primary key autoincrement, "
				+ COLUMN_DEFICIENCY_NAME + " text, "
				+ COLUMN_DEFICIENCY_GRAINS + " text, "
				+ COLUMN_DEFICIENCY_VEGETABLES + " text, "
				+ COLUMN_DEFICIENCY_FRUITS + " text, "
				+ COLUMN_DEFICIENCY_DAIRY + " text, "
				+ COLUMN_DEFICIENCY_PROTEIN + " text, "
				+ COLUMN_DEFICIENCY_SUGGESTIONS + " text);"
				);
		db.execSQL("create table "+ TABLE_WORKOUT + " ( "
				+ COLUMN_WORKOUT_ID + " integer primary key autoincrement, "
				+ COLUMN_DISEASE + " integer references disease(_diseaseId), "
				+ COLUMN_DEFICIENCY + " integer references deficiency(_deficiencyId), "
				+ COLUMN_WORKOUT_SUGGESTIONS + " text);"
				);
		db.execSQL("create table "+ TABLE_SUGGESTIONS + " ( "
				+ COLUMN_SUGGESTION_ID + " integer primary key autoincrement, "
				+ COLUMN_SUGGESTION + " text);"
				);
		db.execSQL("create table "+ TABLE_USERINFO + " ( "
				+ COLUMN_USERINFO_ID + " integer primary key autoincrement, "
				+ COLUMN_USER_NAME + " text, "
				+ COLUMN_USER_AGE + " text, "
				+ COLUMN_USER_WEIGHT + " text, "
				+ COLUMN_USER_HEIGHT + " text, "
				+ COLUMN_USER_GENDER + " integer, "
				+ COLUMN_USER_DISEASE + " text, "
				+ COLUMN_USER_DEFICIENCY + " text);"
				);
		db.execSQL("create table "+ TABLE_SEARCH + " ( "
				+ COLUMN_SEARCH_ID + " integer primary key autoincrement, "
				+ COLUMN_DISEASES_NAME + " text, "
				+ COLUMN_DISEASES_DEFINATION + " text, "
				+ COLUMN_HOSPITAL + " text, "
				+ COLUMN_DOCTOR + " text, "
				+ COLUMN_SYMPTOM + " text);"
				);

	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERINFO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENERAL_INFO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_SUGGESTIONS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRAINS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_VEGETABLES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRUITS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAIRY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROTEIN);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISEASE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEFICIENCY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUGGESTIONS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEARCH);
		onCreate(db);
	}


	public long insertSearchContent(Disease disease) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DISEASES_NAME, disease.getDiseaseName());
		cv.put(COLUMN_DISEASES_DEFINATION, disease.getDiseaseDefination());
		cv.put(COLUMN_HOSPITAL, disease.getHospital());
		cv.put(COLUMN_DOCTOR, disease.getDoctor());
		cv.put(COLUMN_SYMPTOM, disease.getSymptom());
		return getWritableDatabase().insert(TABLE_SEARCH, null, cv);
	}

	public Disease getSearchContentDetails(String diseasename) 
	{
		String sql=" select * from " + TABLE_SEARCH + " where " + COLUMN_DISEASES_NAME  + " = '" + diseasename + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);
		Disease disease=new Disease();
		c.moveToFirst();
		while (!c.isAfterLast()) {
			disease.setSearchId(c.getInt(0));
			disease.setDiseaseName(c.getString(1));
			disease.setDiseaseDefination(c.getString(2));
			disease.setHospital(c.getString(3));
			disease.setDoctor(c.getString(4));
			disease.setSymptom(c.getString(5));
			c.moveToNext();
		}
		// make sure to close the cursor
		c.close();
		return disease;
	}



	public void deleteData(){
		getWritableDatabase().delete(TABLE_GENERAL_INFO, null, null);
		getWritableDatabase().delete(TABLE_FOOD_SUGGESTIONS, null, null);
		getWritableDatabase().delete(TABLE_DISEASE, null, null);
		getWritableDatabase().delete(TABLE_DEFICIENCY, null, null);
	}

	public long insertGeneralInfo(String age, String weight, String height, String gender) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_GENERAL_INFO_AGE, age);
		cv.put(COLUMN_GENERAL_INFO_WEIGHT, weight);
		cv.put(COLUMN_GENERAL_INFO_HEIGHT, height);
		cv.put(COLUMN_GENERAL_INFO_GENDER, gender);
		// return id of new trip
		return getWritableDatabase().insert(TABLE_GENERAL_INFO, null, cv);
	}

	public long insertFoodSuggestions(String grains, String vegetables, String fruits, String dairy, String protein) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_FOOD_SUGGESTIONS_GRAINS, grains);
		cv.put(COLUMN_FOOD_SUGGESTIONS_VEGETABLES, vegetables);
		cv.put(COLUMN_FOOD_SUGGESTIONS_FRUITS, fruits);
		cv.put(COLUMN_FOOD_SUGGESTIONS_DAIRY, dairy);
		cv.put(COLUMN_FOOD_SUGGESTIONS_PROTEIN, protein);
		return getWritableDatabase().insert(TABLE_FOOD_SUGGESTIONS, null, cv);
	}

	
	
	
	public long insertDiseaseSuggestions(String name, String grains, String vegetables, String fruits, String dairy, String protein, String Suggestions) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DISEASE_NAME, name);
		cv.put(COLUMN_DISEASE_GRAINS, grains);
		cv.put(COLUMN_DISEASE_VEGETABLES, vegetables);
		cv.put(COLUMN_DISEASE_FRUITS, fruits);
		cv.put(COLUMN_DISEASE_DAIRY, dairy);
		cv.put(COLUMN_DISEASE_PROTEIN, protein);
		cv.put(COLUMN_DISEASE_SUGGESTIONS, Suggestions);
		return getWritableDatabase().insert(TABLE_DISEASE, null, cv);
	}
	
	public long insertDeficiencySuggestions(String name, String grains, String vegetables, String fruits, String dairy, String protein, String Suggestions) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DEFICIENCY_NAME, name);
		cv.put(COLUMN_DEFICIENCY_GRAINS, grains);
		cv.put(COLUMN_DEFICIENCY_VEGETABLES, vegetables);
		cv.put(COLUMN_DEFICIENCY_FRUITS, fruits);
		cv.put(COLUMN_DEFICIENCY_DAIRY, dairy);
		cv.put(COLUMN_DEFICIENCY_PROTEIN, protein);
		cv.put(COLUMN_DEFICIENCY_SUGGESTIONS, Suggestions);
		return getWritableDatabase().insert(TABLE_DEFICIENCY, null, cv);
	}
	
	
	public long insertGrains(String grainType, String grainName) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_GRAIN_TYPE, grainType);
		cv.put(COLUMN_GRAIN_NAME, grainName);
		return getWritableDatabase().insert(TABLE_GRAINS, null, cv);
	}

	public long insertVegetables(String vegType, String vegName) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_VEG_TYPE, vegType);
		cv.put(COLUMN_VEG_NAME, vegName);
		return getWritableDatabase().insert(TABLE_VEGETABLES, null, cv);
	}

	public long insertFruits(String fruitType, String fruitName) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_FRUIT_TYPE, fruitType);
		cv.put(COLUMN_FRUIT_NAME, fruitName);
		return getWritableDatabase().insert(TABLE_FRUITS, null, cv);
	}

	public long insertDairy(String dairyType, String dairyName) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DAIRY_TYPE, dairyType);
		cv.put(COLUMN_DAIRY_NAME, dairyName);
		return getWritableDatabase().insert(TABLE_DAIRY, null, cv);
	}

	public long insertProtein(String proteinType, String proteinName) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DAIRY_TYPE, proteinType);
		cv.put(COLUMN_DAIRY_NAME, proteinName);
		return getWritableDatabase().insert(TABLE_PROTEIN, null, cv);
	}

	public long insertUser(User user) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_LASTNAME, user.getLastname());
		cv.put(COLUMN_FIRSTNAME, user.getFirstname());
		cv.put(COLUMN_USERNAME, user.getUsername());
		cv.put(COLUMN_EMAIL, user.getEmail());
		cv.put(COLUMN_DOB, user.getDateofbirth());
		cv.put(COLUMN_PROFESSION, user.getProfession());
		cv.put(COLUMN_PWD, user.getPassword());
		cv.put(COLUMN_GENDER, user.getGender());
		return getWritableDatabase().insert(TABLE_USER, null, cv);
	}

	public long modifyUser(String oldusername, User user) {
		//first delete the data in the database with the same username
		String sql=" delete from " + TABLE_USER + " where " + COLUMN_USERNAME  + " = '" + oldusername + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		db.rawQuery(sql, null);
		//insert the modified data into the database
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_LASTNAME, user.getLastname());
		cv.put(COLUMN_FIRSTNAME, user.getFirstname());
		cv.put(COLUMN_USERNAME, user.getUsername());
		cv.put(COLUMN_EMAIL, user.getEmail());
		cv.put(COLUMN_DOB, user.getDateofbirth());
		cv.put(COLUMN_PROFESSION, user.getProfession());
		cv.put(COLUMN_PWD, user.getPassword());
		cv.put(COLUMN_GENDER, user.getGender());
		return getWritableDatabase().insert(TABLE_USER, null, cv);
	}





	public long modifyUserInfo(User user) {
		//first delete the data in the database with the same username
		String sql=" delete from " + TABLE_USERINFO + " where " + COLUMN_USER_NAME  + " = '" + user.getUsername() + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		db.rawQuery(sql, null);
		//insert the modified data into the database
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_USER_NAME, user.getUsername());
		cv.put(COLUMN_USER_AGE, user.getUserage());
		cv.put(COLUMN_USER_WEIGHT, user.getUserweight());
		cv.put(COLUMN_USER_HEIGHT, user.getUserheight());
		cv.put(COLUMN_USER_GENDER, user.getGender());
		cv.put(COLUMN_USER_DISEASE, user.getDisease());
		cv.put(COLUMN_USER_DEFICIENCY, user.getDeficiency());
		return getWritableDatabase().insert(TABLE_USERINFO, null, cv);
	}



	public long insertDisease(String grain, String vegetable, String fruit, String dairy, String protein, String suggestion) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DISEASE_GRAINS, grain);
		cv.put(COLUMN_DISEASE_VEGETABLES, vegetable);
		cv.put(COLUMN_DISEASE_FRUITS, fruit);
		cv.put(COLUMN_DISEASE_DAIRY, dairy);
		cv.put(COLUMN_DISEASE_PROTEIN, protein);
		cv.put(COLUMN_DISEASE_SUGGESTIONS, suggestion);
		return getWritableDatabase().insert(TABLE_DISEASE, null, cv);
	}

	public long insertWorkOut(int diseaseId, int deficiencyId, int suggestionId){
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DISEASE, diseaseId);
		cv.put(COLUMN_DEFICIENCY, deficiencyId);
		cv.put(COLUMN_WORKOUT_SUGGESTIONS, suggestionId);
		//return id of new location
		return getWritableDatabase().insert(TABLE_WORKOUT, null, cv);
	}
	//insert for suggestion table
	public long insertSuggestion(String suggestion){
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_SUGGESTION, suggestion);
		//return id of new location
		return getWritableDatabase().insert(TABLE_SUGGESTIONS, null, cv);
	}

	public long insertDeficiency(String grain, String vegetable, String fruit, String dairy, String protein, String suggestion) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DEFICIENCY_GRAINS, grain);
		cv.put(COLUMN_DEFICIENCY_VEGETABLES, vegetable);
		cv.put(COLUMN_DEFICIENCY_FRUITS, fruit);
		cv.put(COLUMN_DEFICIENCY_DAIRY, dairy);
		cv.put(COLUMN_DEFICIENCY_PROTEIN, protein);
		cv.put(COLUMN_DEFICIENCY_SUGGESTIONS, suggestion);
		return getWritableDatabase().insert(TABLE_DEFICIENCY, null, cv);
	}
	public long insertUserInfo(User user) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_USER_NAME, user.getUsername());
		cv.put(COLUMN_USER_AGE, user.getUserage());
		cv.put(COLUMN_USER_WEIGHT, user.getUserweight());
		cv.put(COLUMN_USER_HEIGHT, user.getUserheight());
		cv.put(COLUMN_USER_GENDER, user.getGender());
		cv.put(COLUMN_USER_DISEASE, user.getDisease());
		cv.put(COLUMN_USER_DEFICIENCY, user.getDeficiency());
		System.out.println("M here" + user.getUserheight());
		return getWritableDatabase().insert(TABLE_USERINFO, null, cv);
	}

	/**
	 * @function
	 *check whether the username is exist in the table or not
	 */
	public User getUserDetails(String name) 
	{
		String sql=" select * from " + TABLE_USER + " where " + COLUMN_USERNAME  + " = '" + name + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);
		User user=new User();
		c.moveToFirst();
		while (!c.isAfterLast()) {
			user.setUserid(c.getInt(0));
			user.setLastname(c.getString(1));
			user.setFirstname(c.getString(2));
			user.setUsername(c.getString(3));
			user.setEmail(c.getString(4));
			user.setDateofbirth(c.getString(5));
			user.setProfession(c.getString(6));
			user.setPassword(c.getString(7));
			user.setGender(c.getInt(8));
			c.moveToNext();
		}
		// make sure to close the cursor
		c.close();
		//	    System.out.println("user.getLastname()==="+user.getLastname());
		//	    System.out.println("user.getEmail()==="+user.getEmail());
		//	    System.out.println("user.getDateofbirth()==="+user.getDateofbirth());
		//	    System.out.println("user.getPassword()==="+user.getPassword());
		return user;
	}

	public User getUserInfoDetails(String name) 
	{
		String sql=" select * from " + TABLE_USERINFO + " where " + COLUMN_USER_NAME  + " = '" + name + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);
		User user=new User();
		c.moveToFirst();
		while (!c.isAfterLast()) {

			user.setUserinfoid(c.getInt(0));
			user.setUsername(c.getString(1));
			user.setUserage(c.getString(2));
			user.setUserweight(c.getString(3));
			user.setUserheight(c.getString(4));
			user.setGender(c.getInt(5));
			user.setDisease(c.getString(6));
			user.setDeficiency(c.getString(7));
			c.moveToNext();
		}
		// make sure to close the cursor
		c.close();
		return user;
	}

	/**
	 * @function
	 *check the user is exist in the table or not
	 */
	public User checkUser(String name, String pass) 
	{
		String sql=" select * from " + TABLE_USER + " where " + COLUMN_USERNAME  + " = '" + name + "' and " + COLUMN_PWD +" = '" + pass + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);

		User user=new User();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			user.setUserid(c.getInt(0));
			user.setLastname(c.getString(1));
			user.setFirstname(c.getString(2));
			user.setUsername(c.getString(3));
			user.setEmail(c.getString(4));
			user.setDateofbirth(c.getString(5));
			user.setProfession(c.getString(6));
			user.setPassword(c.getString(7));
			user.setGender(c.getInt(8));
		}
		return user;
	}
	/**
	 * @function
	 * get user info from user table
	 */
	public User findUserInfo(String name) 
	{
		//System.out.println("get into the finduserinfo");
		String sql=" select * from " + TABLE_USER + " where " + COLUMN_USERNAME  + " = '" + name + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);

		User user=new User();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			user.setUserid(c.getInt(0));
			user.setLastname(c.getString(1));
			user.setFirstname(c.getString(2));
			user.setUsername(c.getString(3));
			user.setEmail(c.getString(4));
			user.setDateofbirth(c.getString(5));
			user.setProfession(c.getString(6));
			user.setPassword(c.getString(7));
			user.setGender(c.getInt(8));
		}
		return user;
	}
	/**
	 * @function
	 * get the user info from userinfo table
	 */
	public User findUserInfo1(String name) 
	{
		String sql=" select * from " + TABLE_USERINFO + " where " + COLUMN_USER_NAME  + " = '" + name + "' ";
		//System.out.println("sql==="+ sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(sql, null);

		User user=new User();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			user.setUserinfoid(c.getInt(0));
			user.setUsername(c.getString(1));
			user.setUserage(c.getString(2));
			user.setUserweight(c.getString(3));
			user.setUserheight(c.getString(4));
			user.setGender(c.getInt(5));
			user.setDisease(c.getString(6));
			user.setDeficiency(c.getString(7));
		}
		return user;
	}

	public void populateData(){
		//1 means male, 0 means female
		//Insert statements for General info
		//First field is age, second weight, third height, and fourth gender
		deleteData();
		insertGeneralInfo("15-25", "120-150", "4.5-5.0", "1");
		insertGeneralInfo("15-25", "151-180", "4.5-5.0", "1");
		insertGeneralInfo("15-25", "181-210", "4.5-5.0", "1");
		insertGeneralInfo("15-25", "211+", "4.5-5.0", "1");
		insertGeneralInfo("15-25", "120-150", "5.1-5.5", "1");
		insertGeneralInfo("15-25", "151-180", "5.1-5.5", "1");
		insertGeneralInfo("15-25", "181-210", "5.1-5.5", "1");
		insertGeneralInfo("15-25", "211+", "5.1-5.5", "1");
		insertGeneralInfo("15-25", "120-150", "5.6-6.0", "1");
		insertGeneralInfo("15-25", "151-180", "5.6-6.0", "1");
		insertGeneralInfo("15-25", "181-210", "5.6-6.0", "1");
		insertGeneralInfo("15-25", "211+", "5.6-6.0", "1");
		insertGeneralInfo("15-25", "120-150", "6.1-6.5", "1");
		insertGeneralInfo("15-25", "151-180", "6.1-6.5", "1");
		insertGeneralInfo("15-25", "181-210", "6.1-6.5", "1");
		insertGeneralInfo("15-25", "211+", "6.1-6.5", "1");

		insertGeneralInfo("26-35", "120-150", "4.5-5.0", "1");
		insertGeneralInfo("26-35", "151-180", "4.5-5.0", "1");
		insertGeneralInfo("26-35", "181-210", "4.5-5.0", "1");
		insertGeneralInfo("26-35", "211+", "4.5-5.0", "1");
		insertGeneralInfo("26-35", "120-150", "5.1-5.5", "1");
		insertGeneralInfo("26-35", "151-180", "5.1-5.5", "1");
		insertGeneralInfo("26-35", "181-210", "5.1-5.5", "1");
		insertGeneralInfo("26-35", "211+", "5.1-5.5", "1");
		insertGeneralInfo("26-35", "120-150", "5.6-6.0", "1");
		insertGeneralInfo("26-35", "151-180", "5.6-6.0", "1");
		insertGeneralInfo("26-35", "181-210", "5.6-6.0", "1");
		insertGeneralInfo("26-35", "211+", "5.6-6.0", "1");
		insertGeneralInfo("26-35", "120-150", "6.1-6.5", "1");
		insertGeneralInfo("26-35", "151-180", "6.1-6.5", "1");
		insertGeneralInfo("26-35", "181-210", "6.1-6.5", "1");
		insertGeneralInfo("26-35", "211+", "6.1-6.5", "1");

		insertGeneralInfo("36-45", "120-150", "4.5-5.0", "1");
		insertGeneralInfo("36-45", "151-180", "4.5-5.0", "1");
		insertGeneralInfo("36-45", "181-210", "4.5-5.0", "1");
		insertGeneralInfo("36-45", "211+", "4.5-5.0", "1");
		insertGeneralInfo("36-45", "120-150", "5.1-5.5", "1");
		insertGeneralInfo("36-45", "151-180", "5.1-5.5", "1");
		insertGeneralInfo("36-45", "181-210", "5.1-5.5", "1");
		insertGeneralInfo("36-45", "211+", "5.1-5.5", "1");
		insertGeneralInfo("36-45", "120-150", "5.6-6.0", "1");
		insertGeneralInfo("36-45", "151-180", "5.6-6.0", "1");
		insertGeneralInfo("36-45", "181-210", "5.6-6.0", "1");
		insertGeneralInfo("36-45", "211+", "5.6-6.0", "1");
		insertGeneralInfo("36-45", "120-150", "6.1-6.5", "1");
		insertGeneralInfo("36-45", "151-180", "6.1-6.5", "1");
		insertGeneralInfo("36-45", "181-210", "6.1-6.5", "1");
		insertGeneralInfo("36-45", "211+", "6.1-6.5", "1");

		insertGeneralInfo("46-55", "120-150", "4.5-5.0", "1");
		insertGeneralInfo("46-55", "151-180", "4.5-5.0", "1");
		insertGeneralInfo("46-55", "181-210", "4.5-5.0", "1");
		insertGeneralInfo("46-55", "211+", "4.5-5.0", "1");
		insertGeneralInfo("46-55", "120-150", "5.1-5.5", "1");
		insertGeneralInfo("46-55", "151-180", "5.1-5.5", "1");
		insertGeneralInfo("46-55", "181-210", "5.1-5.5", "1");
		insertGeneralInfo("46-55", "211+", "5.1-5.5", "1");
		insertGeneralInfo("46-55", "120-150", "5.6-6.0", "1");
		insertGeneralInfo("46-55", "151-180", "5.6-6.0", "1");
		insertGeneralInfo("46-55", "181-210", "5.6-6.0", "1");
		insertGeneralInfo("46-55", "211+", "5.6-6.0", "1");
		insertGeneralInfo("46-55", "120-150", "6.1-6.5", "1");
		insertGeneralInfo("46-55", "151-180", "6.1-6.5", "1");
		insertGeneralInfo("46-55", "181-210", "6.1-6.5", "1");
		insertGeneralInfo("46-55", "211+", "6.1-6.5", "1");

		insertGeneralInfo("56-65", "120-150", "4.5-5.0", "1");
		insertGeneralInfo("56-65", "151-180", "4.5-5.0", "1");
		insertGeneralInfo("56-65", "181-210", "4.5-5.0", "1");
		insertGeneralInfo("56-65", "211+", "4.5-5.0", "1");
		insertGeneralInfo("56-65", "120-150", "5.1-5.5", "1");
		insertGeneralInfo("56-65", "151-180", "5.1-5.5", "1");
		insertGeneralInfo("56-65", "181-210", "5.1-5.5", "1");
		insertGeneralInfo("56-65", "211+", "5.1-5.5", "1");
		insertGeneralInfo("56-65", "120-150", "5.6-6.0", "1");
		insertGeneralInfo("56-65", "151-180", "5.6-6.0", "1");
		insertGeneralInfo("56-65", "181-210", "5.6-6.0", "1");
		insertGeneralInfo("56-65", "211+", "5.6-6.0", "1");
		insertGeneralInfo("56-65", "120-150", "6.1-6.5", "1");
		insertGeneralInfo("56-65", "151-180", "6.1-6.5", "1");
		insertGeneralInfo("56-65", "181-210", "6.1-6.5", "1");
		insertGeneralInfo("56-65", "211+", "6.1-6.5", "1");

		//female

		insertGeneralInfo("15-25", "120-150", "4.5-5.0", "0");
		insertGeneralInfo("15-25", "151-180", "4.5-5.0", "0");
		insertGeneralInfo("15-25", "181-210", "4.5-5.0", "0");
		insertGeneralInfo("15-25", "211+", "4.5-5.0", "0");
		insertGeneralInfo("15-25", "120-150", "5.1-5.5", "0");
		insertGeneralInfo("15-25", "151-180", "5.1-5.5", "0");
		insertGeneralInfo("15-25", "181-210", "5.1-5.5", "0");
		insertGeneralInfo("15-25", "211+", "5.1-5.5", "0");
		insertGeneralInfo("15-25", "120-150", "5.6-6.0", "0");
		insertGeneralInfo("15-25", "151-180", "5.6-6.0", "0");
		insertGeneralInfo("15-25", "181-210", "5.6-6.0", "0");
		insertGeneralInfo("15-25", "211+", "5.6-6.0", "0");
		insertGeneralInfo("15-25", "120-150", "6.1-6.5", "0");
		insertGeneralInfo("15-25", "151-180", "6.1-6.5", "0");
		insertGeneralInfo("15-25", "181-210", "6.1-6.5", "0");
		insertGeneralInfo("15-25", "211+", "6.1-6.5", "0");

		insertGeneralInfo("26-35", "120-150", "4.5-5.0", "0");
		insertGeneralInfo("26-35", "151-180", "4.5-5.0", "0");
		insertGeneralInfo("26-35", "181-210", "4.5-5.0", "0");
		insertGeneralInfo("26-35", "211+", "4.5-5.0", "0");
		insertGeneralInfo("26-35", "120-150", "5.1-5.5", "0");
		insertGeneralInfo("26-35", "151-180", "5.1-5.5", "0");
		insertGeneralInfo("26-35", "181-210", "5.1-5.5", "0");
		insertGeneralInfo("26-35", "211+", "5.1-5.5", "0");
		insertGeneralInfo("26-35", "120-150", "5.6-6.0", "0");
		insertGeneralInfo("26-35", "151-180", "5.6-6.0", "0");
		insertGeneralInfo("26-35", "181-210", "5.6-6.0", "0");
		insertGeneralInfo("26-35", "211+", "5.6-6.0", "0");
		insertGeneralInfo("26-35", "120-150", "6.1-6.5", "0");
		insertGeneralInfo("26-35", "151-180", "6.1-6.5", "0");
		insertGeneralInfo("26-35", "181-210", "6.1-6.5", "0");
		insertGeneralInfo("26-35", "211+", "6.1-6.5", "0");

		insertGeneralInfo("36-45", "120-150", "4.5-5.0", "0");
		insertGeneralInfo("36-45", "151-180", "4.5-5.0", "0");
		insertGeneralInfo("36-45", "181-210", "4.5-5.0", "0");
		insertGeneralInfo("36-45", "211+", "4.5-5.0", "0");
		insertGeneralInfo("36-45", "120-150", "5.1-5.5", "0");
		insertGeneralInfo("36-45", "151-180", "5.1-5.5", "0");
		insertGeneralInfo("36-45", "181-210", "5.1-5.5", "0");
		insertGeneralInfo("36-45", "211+", "5.1-5.5", "0");
		insertGeneralInfo("36-45", "120-150", "5.6-6.0", "0");
		insertGeneralInfo("36-45", "151-180", "5.6-6.0", "0");
		insertGeneralInfo("36-45", "181-210", "5.6-6.0", "0");
		insertGeneralInfo("36-45", "211+", "5.6-6.0", "0");
		insertGeneralInfo("36-45", "120-150", "6.1-6.5", "0");
		insertGeneralInfo("36-45", "151-180", "6.1-6.5", "0");
		insertGeneralInfo("36-45", "181-210", "6.1-6.5", "0");
		insertGeneralInfo("36-45", "211+", "6.1-6.5", "0");

		insertGeneralInfo("46-55", "120-150", "4.5-5.0", "0");
		insertGeneralInfo("46-55", "151-180", "4.5-5.0", "0");
		insertGeneralInfo("46-55", "181-210", "4.5-5.0", "0");
		insertGeneralInfo("46-55", "211+", "4.5-5.0", "0");
		insertGeneralInfo("46-55", "120-150", "5.1-5.5", "0");
		insertGeneralInfo("46-55", "151-180", "5.1-5.5", "0");
		insertGeneralInfo("46-55", "181-210", "5.1-5.5", "0");
		insertGeneralInfo("46-55", "211+", "5.1-5.5", "0");
		insertGeneralInfo("46-55", "120-150", "5.6-6.0", "0");
		insertGeneralInfo("46-55", "151-180", "5.6-6.0", "0");
		insertGeneralInfo("46-55", "181-210", "5.6-6.0", "0");
		insertGeneralInfo("46-55", "211+", "5.6-6.0", "0");
		insertGeneralInfo("46-55", "120-150", "6.1-6.5", "0");
		insertGeneralInfo("46-55", "151-180", "6.1-6.5", "0");
		insertGeneralInfo("46-55", "181-210", "6.1-6.5", "0");
		insertGeneralInfo("46-55", "211+", "6.1-6.5", "0");

		insertGeneralInfo("56-65", "120-150", "4.5-5.0", "0");
		insertGeneralInfo("56-65", "151-180", "4.5-5.0", "0");
		insertGeneralInfo("56-65", "181-210", "4.5-5.0", "0");
		insertGeneralInfo("56-65", "211+", "4.5-5.0", "0");
		insertGeneralInfo("56-65", "120-150", "5.1-5.5", "0");
		insertGeneralInfo("56-65", "151-180", "5.1-5.5", "0");
		insertGeneralInfo("56-65", "181-210", "5.1-5.5", "0");
		insertGeneralInfo("56-65", "211+", "5.1-5.5", "0");
		insertGeneralInfo("56-65", "120-150", "5.6-6.0", "0");
		insertGeneralInfo("56-65", "151-180", "5.6-6.0", "0");
		insertGeneralInfo("56-65", "181-210", "5.6-6.0", "0");
		insertGeneralInfo("56-65", "211+", "5.6-6.0", "0");
		insertGeneralInfo("56-65", "120-150", "6.1-6.5", "0");
		insertGeneralInfo("56-65", "151-180", "6.1-6.5", "0");
		insertGeneralInfo("56-65", "181-210", "6.1-6.5", "0");
		insertGeneralInfo("56-65", "211+", "6.1-6.5", "0");

		//insert for food suggestions
		//insert(grains, vegetables, fruits, dairy, protein);


		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");


		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");


		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");


		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("6 ounces", "2.5 cups", "2 cups", "3 cups", "5.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");
		insertFoodSuggestions("9 ounces", "3.5 cups", "3 cups", "3 cups", "6.5 ounces");

		insertDiseaseSuggestions("Cancer","Oatmeal , Brown Rice","Brocolli , Tomatoes","Raspberries , Blueberries","Frozen Yogurt , Ice Milk","Lentils , Split Beans",null);
		insertDiseaseSuggestions("Obesity","Oatmeal , Whole Wheat Cereal Flakes","Carrot , Pumpkin","Apple , Oranges","Skim Milk , Low Fat","White Beans , Soy Beans",null);
		insertDiseaseSuggestions("Cardiac Arrest","Brown Rice, Oatmeal","Avacado , Eggplant","Plums , Raisin","Skim Milk , Lactose-Reduced Milk","Seasame , Veal",null);
		insertDiseaseSuggestions("High Cholesterol","Brown Rice , Oatmeal","Onion , Tomatoes","Peaces , Plums","Low Fat , Skim Milk","Veal , Lentils",null);
		insertDiseaseSuggestions("High Blood Pressure","Whole Wheat Cereal Flakes , Cornbread","Asparagus , Avacado","Grapefruit , Apple","Reduced Fat , Low-Fat","Almonds , Split Beans",null);
		insertDiseaseSuggestions("Diabetes","Whole Wheat Cereal Flakes , Brown Rice","Romaine Lettuce , Brocolli","Honeydew , Cantaloupe","Lactose-Reduced Milk , Ice Milk","White Beans , Soy Beans",null);
		
		insertDeficiencySuggestions("Vitamin A","Flour Tortiallas , Oatmeal","Green Peas , Sweet Potatoes","Peaces,A","Reduced Fat , Low-Fat","White Beans , Soy Beans",null);
		insertDeficiencySuggestions("Vitamin B12","Brown Rice , Oatmeal","Kidney Beans, Asparagus","Bananas , Honeydew","Skim Milk , Lactose-Reduced Milk","Seasame , Veal",null);
		insertDeficiencySuggestions("Vitamin C","Brown Rice , Whole Wheat Cereal Flakes","Avacado , Soy Beans","Straberries , Plums","Frozen Yogurt , Ice Milk","Almonds , Split Beans",null);
		insertDeficiencySuggestions("Vitamin D3","Oatmeal , Flour Tortiallas","Tomatoes , Cauliflower","Bananas , Grapefruit","Low Fat , Skim Milk","Walnut , Soy Beans",null);
		insertDeficiencySuggestions("Vitamin K","Whole Wheat Cereal Flakes , Brown Rice","Green Beans , Eggplant","Oranges , Peaches","Frozen Yogurt , Ice Milk","White Beans , Soy Beans",null);
		insertDeficiencySuggestions("Iodine","Whole Wheat Cereal Flakes , Oatmeal","Onion , Mushrooms","Grapefruit , Apple","Low Fat , Skim Milk","White Beans , Soy Beans",null);
		insertDeficiencySuggestions("Calcium","Oatmeal , Whole Wheat Cereal Flakes","Water Chestnut , Pumpkin","Raisin , Plums","Skim Milk , Lactose-Reduced Milk","Seasame , Veal",null);
		insertDeficiencySuggestions("Magnesium","Flour Tortiallas , Brown Rice","Corn , Soy Beans","Apple , Grapes","Low Fat , Skim Milk","Almonds , Split Beans",null);
		insertDeficiencySuggestions("Selenium","Oatmeal , Whole Wheat Cereal Flakes","Iceberg Lettuce , Tomatoes","Cantaloupe , Raspberries","Skim Milk , Lactose-Reduced Milk","Almonds , Split Beans",null);
		
		

	}
	
	
	public ArrayList<ArrayList<String>> getAllUserPlans(String userName) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = 
				db.rawQuery("select U._userInfoId, U.age, U.weight, U.height, U.gender, U.disease, U.deficiency"
						+ " from "+TABLE_USERINFO+" U where U.user_name like \""+userName+"\" order by U._userInfoId desc", null);
		ArrayList<ArrayList<String>> userInfo = new ArrayList<ArrayList<String>>();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			System.out.println("Data values"+cursor.getString(0));
			ArrayList<String> userInfoIndiv = new ArrayList<String>();
			userInfoIndiv.add(cursor.getString(0));
			userInfoIndiv.add(cursor.getString(1));
			userInfoIndiv.add(cursor.getString(2));
			userInfoIndiv.add(cursor.getString(3));
			userInfoIndiv.add(cursor.getString(4));
			userInfoIndiv.add(cursor.getString(5));
			userInfoIndiv.add(cursor.getString(6));
			userInfo.add(userInfoIndiv);
		}

		return userInfo;			
	}

	
	public ArrayList<String> getDisease(String diseaseName){
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String>diseaseSugg = new ArrayList<String>();
		String query = "select Di.grains, Di.vegetables, Di.fruits, Di.dairy, Di.protein"
				+ " from "+TABLE_DISEASE+" Di where Di.diseaseName like \""+diseaseName+"\"";
		System.out.println("My Query "+query);
		Cursor cursor = db.rawQuery(query, null);
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			diseaseSugg.add(cursor.getString(0));
			diseaseSugg.add(cursor.getString(1));
			diseaseSugg.add(cursor.getString(2));
			diseaseSugg.add(cursor.getString(3));
			diseaseSugg.add(cursor.getString(4));
			System.out.println("Did I come here");
		}
		return diseaseSugg;
	}
	
	public ArrayList<String> getDeficiency(String deficiencyName){
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String>deficiencySugg = new ArrayList<String>();
		String query = "select Di.grains, Di.vegetables, Di.fruits, Di.dairy, Di.protein"
				+ " from "+TABLE_DEFICIENCY+" Di where Di.deficiencyName like \""+deficiencyName+"\"";
		System.out.println("My Query "+query);
		Cursor cursor = db.rawQuery(query, null);
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			deficiencySugg.add(cursor.getString(0));
			deficiencySugg.add(cursor.getString(1));
			deficiencySugg.add(cursor.getString(2));
			deficiencySugg.add(cursor.getString(3));
			deficiencySugg.add(cursor.getString(4));
		}
		return deficiencySugg;
	}
	
	public ArrayList<String> getFoodSuggestions(ArrayList<String> info) {
		SQLiteDatabase db = this.getReadableDatabase();
		String age = info.get(1);
		String weight = info.get(2);
		String height = info.get(3);
		String gender = info.get(4);
		String query = "select F.grains, F.vegetables, F.fruits, F.dairy, F.protein"
				+ " from "+TABLE_GENERAL_INFO+" G join "+TABLE_FOOD_SUGGESTIONS+" F on G._infoId = F.foodSuggestionInfoId " +
				"where G.age like \""+age+"\" and G.weight like \""+weight+"\" and G.height like \""+height+"\" and G.gender like \""+gender+"\" " +
				"order by G._infoId desc";
		System.out.println("My Query "+query);
		Cursor cursor = 
				db.rawQuery(query, null);
		ArrayList<String>foodSugg = new ArrayList<String>();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			foodSugg.add(cursor.getString(0));
			foodSugg.add(cursor.getString(1));
			foodSugg.add(cursor.getString(2));
			foodSugg.add(cursor.getString(3));
			foodSugg.add(cursor.getString(4));
		}
		System.out.println("My foodsugg "+foodSugg.size());
		return foodSugg;			
	}
}
