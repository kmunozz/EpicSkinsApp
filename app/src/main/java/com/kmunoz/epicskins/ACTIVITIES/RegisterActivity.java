package com.kmunoz.epicskins.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kmunoz.epicskins.DB.AppDataBase;
import com.kmunoz.epicskins.DB.EpicSkinsDAO;
import com.kmunoz.epicskins.R;

import com.kmunoz.epicskins.User;
import com.kmunoz.epicskins.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsernameField;
    private EditText mPasswordField;
    private EditText mAdminCodeField;

    private Button mRegisterButton;

    private ActivityRegisterBinding binding;

    private EpicSkinsDAO mEpicSkinsDAO;

    private User mUser = null;

    private String mUsername;
    private String mPassword;
    private String mAdminCode;

    private boolean mIsAdmin = false;
    private static final String mValidAdminCode = "epic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mUsernameField = binding.registerUsernameEditText;
        mPasswordField = binding.registerPasswordEditText;
        mAdminCodeField = binding.registerAdminCodeField;
        mRegisterButton = binding.registerRegisterAccountButton;

        getDatabase();

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. grab user input
                if(retrieveUserInfo()){
                    // 2. check user doesn't already exist
                    if(!checkForDuplicateUser()){
                        // 3. add user to db
                        addUserToDataBase();
                        //4. send to login page
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "A user with this username already exists. Please choose another username.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean retrieveUserInfo(){
        mUsername = mUsernameField.getText().toString().trim();
        mPassword = mPasswordField.getText().toString().trim();
        mAdminCode = mAdminCodeField.getText().toString().trim();

        if(!verifyNoEmptyFields()){
            return true;
        }

        return false;
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

    private void verifyAdmin(){
        if(mAdminCode.equals(mValidAdminCode)){
            mIsAdmin = true;
        }
    }

    private boolean checkForDuplicateUser(){
        mUser = mEpicSkinsDAO.getUserByUsername(mUsername);
        if(mUser == null){
            return false;
        }


        return true;
    }

    private void addUserToDataBase(){
        verifyAdmin();
        mUser = new User(mUsername, mPassword, mIsAdmin, "");
        mEpicSkinsDAO.insert(mUser);

        User testUser = mEpicSkinsDAO.getUserByUsername(mUser.getUsername());
        Toast.makeText(getApplicationContext(), testUser.toString(), Toast.LENGTH_SHORT).show();
    }

    private void getDatabase(){
        mEpicSkinsDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .FortniteEpicSkinsDAO();
    }
}