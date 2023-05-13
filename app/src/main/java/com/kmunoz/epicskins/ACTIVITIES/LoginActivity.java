package com.kmunoz.epicskins.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kmunoz.epicskins.DB.AppDataBase;
import com.kmunoz.epicskins.DB.EpicSkinsDAO;
import com.kmunoz.epicskins.R;

import com.kmunoz.epicskins.User;
import com.kmunoz.epicskins.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private static final String IS_ADMIN_KEY  = "com.kmunoz.epicskins.isAdminKey";
    private static final String PREFERENCES_KEY = "com.kmunoz.epicskins.PREFERENCES_KEY";

    private TextView mLoginDisplay;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mLoginButton;
    private Button mRegisterButton;

    private User mUser = null;
    private String mUsername;
    private String mPassword;
    private boolean mIsAdmin;

    private ActivityMainBinding binding;

    private EpicSkinsDAO mEpicSkinsDAO;

    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mLoginDisplay = binding.loginDisplay;

        mUsernameField = binding.loginUsernameEditText;
        mPasswordField = binding.loginPasswordEditText;

        mLoginButton = binding.loginLoginButton;
        mRegisterButton = binding.loginRegisterButton;

        getDatabase();
        getPreferences();

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retrieveUserInfo()){
                    if(verifyValidLoginCredentials()){
                        Intent intent = new Intent(getApplicationContext(), LandingPageActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Please enter valid login credentials or feel free to register for an account with us.",
                                Toast.LENGTH_LONG).show();
                    }
                }




            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean retrieveUserInfo(){
        mUsername = mUsernameField.getText().toString().trim();
        mPassword = mPasswordField.getText().toString().trim();

        if(!verifyNoEmptyFields()){
            mUser = mEpicSkinsDAO.getUserByUsername(mUsername);
            if(mUser == null){
                Toast.makeText(this, "Invalid login credentials. Try again or please reigster for an account.", Toast.LENGTH_SHORT).show();
                return false;
            }
            mIsAdmin = mUser.isAdmin();
            updateSharedPreferences();
            return true;
        }

        return false;
    }

    private void updateSharedPreferences(){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(IS_ADMIN_KEY, mIsAdmin);
        editor.apply();
    }

    private boolean verifyValidLoginCredentials(){
        if(mPassword.equals(mUser.getPassword())){
            return true;
        }

        return false;
    }

    private void getDatabase(){
        mEpicSkinsDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .FortniteEpicSkinsDAO();
    }

    private void getPreferences(){
        mSharedPreferences = getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    private boolean verifyNoEmptyFields(){
        if(mUsernameField.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(), "Please enter a username.", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(mPasswordField.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(), "Please enter a password.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

}