package com.example.uidesign;

import com.example.chat.DataHolder;
import com.quickblox.core.QBCallbackImpl;
import com.quickblox.core.result.Result;
import com.quickblox.module.auth.QBAuth;
import com.quickblox.module.auth.result.QBSessionResult;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	public final static String EXTRA_Username = "null";
	// private final String FIRST_USER_PASSWORD = "arunvivek";
	//    private final String FIRST_USER_LOGIN = "arun1";
	public static HealthyMeDatabaseHelper healthymedb;
	User user=new User();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		healthymedb=new HealthyMeDatabaseHelper(this);
		
		
		System.out.println("start");

		Disease disease=new Disease();

		disease.setDiseaseName("Obesity");

		disease.setDiseaseDefination("Obesity is a medical condition in which excess body fat has accumulated to the extent that it may have an adverse effect on health, leading to reduced life expectancy and/or increased health problems.");

		disease.setDoctor("Mary Schopenhauer, Greg Macnaughton, Nikita Dumornay, Rick Myerson, Sean Longworth");

		disease.setHospital("Lenox Hill Hospital, Bellevue Hospital Center, Roosevelt Hospital,etc.");

		disease.setSymptom("People are considered obese when their body mass index (BMI), a measurement obtained by dividing a person's weight in kilograms by the square of the person's height in metres, exceeds 30 kg/m2.");

		healthymedb.insertSearchContent(disease);

		Disease disease1=new Disease();

		disease1.setDiseaseName("Cancer");

		disease1.setDiseaseDefination("Cancer Listeni/ˈkænsər/, known medically as a malignant neoplasm, is a broad group of diseases involving unregulated cell growth.");

		disease1.setDoctor("Mary Schopenhauer, Greg Macnaughton, Nikita Dumornay, Rick Myerson, Sean Longworth");

		disease1.setHospital("Memorial Sloan-Kettering Cancer Center: Integrative Medicine Center,Memorial Hospital For Cancer: Zelenetz Andrew D MD, NYU Clinical Cancer Center,etc.");

		disease1.setSymptom("The presence of an unusual lump in the body,Changes in a mole on the skin, A persistent cough or hoarseness,A change in bowel habits, such as unusual diarrhea or constipation, etc.");

		healthymedb.insertSearchContent(disease1);

		Disease disease2=new Disease();

		disease2.setDiseaseName("Cardiac Arrest");

		disease2.setDiseaseDefination("Heart problem is a name including different kinds of diseases on heart, like Cardiovascular disease, Myocardial infarction, etc");

		disease2.setDoctor("null");

		disease2.setHospital("New York Cardiac Diagnostic Center, Mount Sinai Hospital, Lenox Hill Heart and Vascular Institute of New York, etc.");

		disease2.setSymptom("The typical symptoms of coronary artery disease are chest pain associated with shortness of breath.");

		healthymedb.insertSearchContent(disease2);

		Disease disease3=new Disease();

		disease3.setDiseaseName("High Cholesterol");

		disease3.setDiseaseDefination("High cholesterol may develop fatty deposits in your blood vessels and make it difficult for enough blood to flow through your arteries.");

		disease3.setDoctor("null");

		disease3.setHospital("Winchester Hospital,Logan Regional Hospital,Henry Ford Hospital,etc.");

		disease3.setSymptom("High cholesterol doesn't make you feel sick. By the time you find out you have it, it may already be clogging your arteries. So it is very important to start treatment even though you may feel fine.");

		healthymedb.insertSearchContent(disease3);

		Disease disease4=new Disease();

		disease4.setDiseaseName("High Blood Pressure");

		disease4.setDiseaseDefination("High blood pressure (HBP) is a serious condition that can lead to coronary heart disease, heart failure, stroke, kidney failureexternal link icon, and other health problems.");

		disease4.setDoctor("null");

		disease4.setHospital("Cleveland Clinic, Mayo Clinic, New York-Presbyterian University Hospital of Columbia and Cornell,etc.");

		disease4.setSymptom("People has high blood pressure will experience symptoms such as nervousness, sweating, difficulty sleeping or facial flushing. ");

		healthymedb.insertSearchContent(disease4);

		Disease disease5=new Disease();

		disease5.setDiseaseName("Diabetes");

		disease5.setDiseaseDefination("Diabetes, often referred to by doctors as diabetes mellitus, describes a group of metabolic diseases in which the person has high blood glucose (blood sugar).");

		disease5.setDoctor("null");

		disease5.setHospital("Mayo Clinic, Cleveland Clinic, Massachusetts General Hospital,etc.");

		disease5.setSymptom("Urinating often, Feeling very thirsty, Feeling very hungry - even though you are eating, Extreme fatigue, etc. ");

		healthymedb.insertSearchContent(disease5);

		System.out.println("end");
		
		Button login = (Button) findViewById(R.id.button1);
		final Context context = this; 
		//listener for login button
		login.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				EditText personName = (EditText) findViewById(R.id.PersonName);
		    	EditText password = (EditText) findViewById(R.id.password);
		    	String upersonName = personName.getText().toString();
		    	String upassword = password.getText().toString();
		    	user=healthymedb.checkUser(upersonName,upassword);
		    	
		    	if(user.getLastname()==null) //do some thing
		    	{
		    		final Dialog dialog = new Dialog(Login.this);
			        //dialog.setContentView(R.layout.reminder); 
			        dialog.setTitle("Please try again!");
			        dialog.show();
//		    		Intent intentLogin = new Intent(context , Login.class);
//		    		startActivity(intentLogin);	
		    		//System.out.println("the return is null");
		    	}
		    	else 
		    	{
		    		/*QBAuth.createSession(FIRST_USER_LOGIN, FIRST_USER_PASSWORD, new QBCallbackImpl() {
		                @Override
		                public void onComplete(Result result) {
		                    if (result.isSuccess()) {
		                        // save current user
		                        DataHolder.getInstance().setCurrentQbUser(((QBSessionResult) result).getSession().getUserId(), FIRST_USER_PASSWORD);

		                        // show next activity
		                       
		                    }
		                }
		            });*/
		    		Intent intentLogin = new Intent(context , ProfileActivity.class);
		    		intentLogin.putExtra(EXTRA_Username, user.getUsername());
		    		intentLogin.putExtra("username", upersonName);
		    		startActivity(intentLogin);	
		    		
		    		
		    		
		    	}

				} 
			}
		);
		
		//listener for SignUp button 
		Button signup = (Button) findViewById(R.id.button2);
		signup.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent intentSignUp = new Intent(context , RegisterActivity.class); 
				startActivity(intentSignUp);	
				} 
			}
		);
		//listener for Home button
		Button home = (Button) findViewById(R.id.button3);
		home.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent mainactivity = new Intent(context , MainActivity.class); 
				startActivity(mainactivity);	
				} 
			}
		);
		healthymedb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
