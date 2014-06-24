package com.example.uidesign;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class PersonalInfoActivity extends Activity {

	String userid="UserId:";
	String lastname="Lastname:";
	String firstname="Firstname:";
	String username="Username";
	String email="Email";
	String dateofbirth="Dateofbirth";
	String profession="Profession:";
	String gender="Gender:";	//0 means female and 1 means male
	String userinfoid="Userinfoid:";
	String userage="Userage:";
	String userweight="Userweight:";
	String userheight="Userheight:";
	String disease="Disease:";
	String deficiency="Deficiency:";
	public final static String EXTRA_Usernamefrompersonalinfo="null";
	public String usernamefromprofile="null";
	public String usernamefromphysicalinfo="null";
	public String usernamefrompersonalinfomodify="null";
	public String usernamefromphysicalinfomodify="null";
	String temporary="null";
	public static HealthyMeDatabaseHelper healthymedb;
	User user1=new User();
	User user2=new User();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_personal_info);
		Intent intent = getIntent();
		final Context context = this; 
		healthymedb=new HealthyMeDatabaseHelper(this);
		usernamefromprofile = intent.getStringExtra(ProfileActivity.EXTRA_Usernamefromprofile);
		usernamefromphysicalinfo=intent.getStringExtra(Physicalinfo.EXTRA_Usernamefromphysicalinfo);
		usernamefrompersonalinfomodify=intent.getStringExtra(PersonalInfoModifyActivity.EXTRA_Usernamefrompersonalinfomodify);
		usernamefromphysicalinfomodify=intent.getStringExtra(PhysicalInfoModifyActivity.EXTRA_UsernamefromphysicalinfoModify);
//		System.out.println("usernamefromprofile==="+usernamefromprofile);
//		if(usernamefromphysicalinfo==null) System.out.println("==null");
//		if(usernamefromphysicalinfo=="jj") System.out.println("=='jj'");
//		if(usernamefromphysicalinfo.equals("jj")) System.out.println("equals('jj')");
//		else System.out.println("none of them");
//		System.out.println("111usernamefromprofile==="+usernamefromprofile);
//		System.out.println("111usernamefromphysicalinfo==="+usernamefromphysicalinfo);
		if(!usernamefromprofile.equals("null") && usernamefromphysicalinfo.equals("null") && usernamefrompersonalinfomodify.equals("null") && usernamefromphysicalinfomodify.equals("null")){
			user1=healthymedb.findUserInfo(usernamefromprofile);
	    	user2=healthymedb.findUserInfo1(usernamefromprofile);
	    	temporary=usernamefromprofile;
		}
		else if(usernamefromprofile.equals("null") && !usernamefromphysicalinfo.equals("null") && usernamefrompersonalinfomodify.equals("null") && usernamefromphysicalinfomodify.equals("null")){
	    	user1=healthymedb.findUserInfo(usernamefromphysicalinfo);
	    	user2=healthymedb.findUserInfo1(usernamefromphysicalinfo);
	    	temporary=usernamefromphysicalinfo;
		}
		else if(usernamefromprofile.equals("null") && usernamefromphysicalinfo.equals("null") && !usernamefrompersonalinfomodify.equals("null") && usernamefromphysicalinfomodify.equals("null")){
	    	user1=healthymedb.findUserInfo(usernamefrompersonalinfomodify);
	    	user2=healthymedb.findUserInfo1(usernamefrompersonalinfomodify);
	    	temporary=usernamefrompersonalinfomodify;
		}
		else if(usernamefromprofile.equals("null") && usernamefromphysicalinfo.equals("null") && usernamefrompersonalinfomodify.equals("null") && !usernamefromphysicalinfomodify.equals("null")){
	    	user1=healthymedb.findUserInfo(usernamefromphysicalinfomodify);
	    	user2=healthymedb.findUserInfo1(usernamefromphysicalinfomodify);
	    	temporary=usernamefromphysicalinfomodify;
		}
		else 
		{
			user1=healthymedb.findUserInfo(usernamefromprofile);
	    	user2=healthymedb.findUserInfo1(usernamefromprofile);
	    	temporary=usernamefromprofile;
		}
//    	System.out.println("usernamefromprofile==="+usernamefromprofile);
//    	System.out.println("usernamefromphysicalinfo==="+usernamefromphysicalinfo);
//    	System.out.println("user2.getUserheight()"+user2.getUserheight());
//    	System.out.println("user2.getUserage()"+user2.getUserage());
//    	System.out.println("user2.getUserweight()"+user2.getUserweight());
    	if((!usernamefromprofile.equals("null") && user2.getUserheight()==null) || (!usernamefromprofile.equals("null") && user2.getUserweight()==null) || (!usernamefromprofile.equals("null") && user2.getUserage()==null)) //do some thing
    	{
    		Intent intentphysicalinfo = new Intent(context , Physicalinfo.class);
    		intentphysicalinfo.putExtra(EXTRA_Usernamefrompersonalinfo, usernamefromprofile);
    		startActivity(intentphysicalinfo);	
    		
    	}
    	else if((!usernamefromphysicalinfo.equals("null") && user2.getUserheight()==null) || (!usernamefromphysicalinfo.equals("null") && user2.getUserweight()==null) || (!usernamefromphysicalinfo.equals("null") && user2.getUserage()==null)) //do some thing
    	{
    		Intent intentphysicalinfo = new Intent(context , Physicalinfo.class);
    		intentphysicalinfo.putExtra(EXTRA_Usernamefrompersonalinfo, usernamefromphysicalinfo);
    		startActivity(intentphysicalinfo);	
    		
    	}else{
    		setContentView(R.layout.activity_personal_info);
    		//listent the button 
    		Button personalinfomodify = (Button) findViewById(R.id.personalinfomodify);
    		personalinfomodify.setOnClickListener(new View.OnClickListener() {
    			@Override public void onClick(View v) {
    				// TODO Auto-generated method stub 
    	    		Intent intentpersonalinfomodify = new Intent(context , PersonalInfoModifyActivity.class);
    	    		intentpersonalinfomodify.putExtra(EXTRA_Usernamefrompersonalinfo, temporary);
    	    		startActivity(intentpersonalinfomodify);	
    				} 
    			}
    		);
    		//listent the button 
    		Button physicalinfomodify = (Button) findViewById(R.id.physicalinfomodify);
    		physicalinfomodify.setOnClickListener(new View.OnClickListener() {
    			@Override public void onClick(View v) {
    				// TODO Auto-generated method stub 
    	    		Intent intentpersonalinfomodify = new Intent(context , PhysicalInfoModifyActivity.class);
    	    		intentpersonalinfomodify.putExtra(EXTRA_Usernamefrompersonalinfo, temporary);
    	    		startActivity(intentpersonalinfomodify);	
    				} 
    			}
    		);
    		//listent the button 
    		Button cancel = (Button) findViewById(R.id.cancel);
    		cancel.setOnClickListener(new View.OnClickListener() {
    			@Override public void onClick(View v) {
    				// TODO Auto-generated method stub 
    				Intent intent = new Intent(PersonalInfoActivity.this, ProfileActivity.class);
    				intent.putExtra(EXTRA_Usernamefrompersonalinfo, temporary);	
    				startActivity(intent);
    				} 
    			}
    		);
    		
    	}
    	
    
    	
	}

//	public void onDestroyView() {
//        super.onDestroyView();
//        if (view != null) {
//            ViewGroup parentViewGroup = (ViewGroup) view.getParent();
//            if (parentViewGroup != null) {
//                parentViewGroup.removeAllViews();
//            }
//        }
//    }
//	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_info, menu);
		//View result = inflater.inflate(R.layout.customer_layout, container, false);
		return true;
	}

}
