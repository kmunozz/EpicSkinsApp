package com.example.fortniteepicskins.LoginPage;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.fortniteepicskins.DB.AppDataBase;

import java.util.ArrayList;

@Entity(tableName = AppDataBase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;
    private boolean mIsAdmin;
    
    ArrayList<String> cartList = new ArrayList<String>();

    public User(String username, String password, boolean isAdmin, String cartStringList) {
        mUsername = username;
        mPassword = password;
        mIsAdmin = isAdmin;
        mCartStringList = cartStringList;
    }
}
