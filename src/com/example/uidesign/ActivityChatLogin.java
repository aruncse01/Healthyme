package com.example.uidesign;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.quickblox.core.QBCallbackImpl;
import com.quickblox.core.QBSettings;
import com.quickblox.core.result.Result;
import com.quickblox.internal.core.request.QBPagedRequestBuilder;
import com.quickblox.module.auth.QBAuth;
import com.quickblox.module.auth.result.QBSessionResult;
import com.quickblox.module.users.QBUsers;
import com.quickblox.module.users.model.QBUser;
import com.quickblox.module.users.result.QBUserPagedResult;
import com.example.chat.DataHolder;

public class ActivityChatLogin extends Activity {

    private final String FIRST_USER_PASSWORD = "arunvivek";
    private final String FIRST_USER_LOGIN = "arun1";
    private final String SECOND_USER_PASSWORD = "shruthi1";
    private final String SECOND_USER_LOGIN = "shruthi1";

    private final int firstUserId = 667404;
    private final String firstUserName = "first user";
    private final String secondUserName = "second user";
    private final int secondUserId = 667405;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setup UI
        //
        setContentView(R.layout.activity_chat_login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.setCancelable(false);

        findViewById(R.id.loginByFirstUserBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                createSession(FIRST_USER_LOGIN, FIRST_USER_PASSWORD);
            }
        });

        findViewById(R.id.loginBySecondUserBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                createSession(SECOND_USER_LOGIN, SECOND_USER_PASSWORD);
            }
        });

        // Set QuickBlox credentials here
        //
        QBSettings.getInstance().fastConfigInit("5005", "mp8-7T2y3fsksnx", "tdAjrrgGVjbLsW6");
    }

    @Override
    public void onResume() {
        progressDialog.dismiss();
        super.onResume();
    }

    private void createSession(String login, final String password) {

        // Create QuickBlox session with user
        //
    	//QBPagedRequestBuilder pagedRequestBuilder = new QBPagedRequestBuilder();
       // pagedRequestBuilder.setPage(1);
        //pagedRequestBuilder.setPerPage(5);

        /*QBUsers.getUsers(pagedRequestBuilder, new QBCallbackImpl() {
            @Override
            public void onComplete(Result result) {
                if (result.isSuccess()) {
                    QBUserPagedResult usersResult = (QBUserPagedResult) result;
                    ArrayList<QBUser> users = usersResult.getUsers();
                    for(QBUser user:users)
                    {
                    	Log.i("userid",String.valueOf(user.getId()));
                    	Date db=user.getUpdatedAt();
                    	
                    }
                   Log.i(">>> Users: " , users.toString());


                    System.out.println("currentPage: " + usersResult.getCurrentPage());
                    System.out.println("totalEntries: " + usersResult.getTotalEntries());
                    System.out.println("perPage: " + usersResult.getPerPage());
                    System.out.println("totalPages: " + usersResult.getTotalPages());
                } else {
                    
                }
            }
        });*/
        QBAuth.createSession(login, password, new QBCallbackImpl() {
            @Override
            public void onComplete(Result result) {
                if (result.isSuccess()) {
                    // save current user
                    DataHolder.getInstance().setCurrentQbUser(((QBSessionResult) result).getSession().getUserId(), password);

                    // show next activity
                    showCallUserActivity();
                }
            }
        });
    }

    private void showCallUserActivity() {
        Intent intent = new Intent(this, ActivityCallUser.class);
        intent.putExtra("userId", DataHolder.getInstance().getCurrentQbUser().getId() == firstUserId ? secondUserId : firstUserId);
        intent.putExtra("userName", DataHolder.getInstance().getCurrentQbUser().getId() == firstUserId ? secondUserName : firstUserName);
        startActivity(intent);
        finish();
    }
}
