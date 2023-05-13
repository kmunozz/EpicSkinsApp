package com.kmunoz.epicskins;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kmunoz.epicskins.DB.AppDataBase;

@Entity(tableName = AppDataBase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;
    private boolean mIsAdmin;
    private String mCartStringList;

    public User(String username, String password, boolean isAdmin, String cartStringList) {
        mUsername = username;
        mPassword = password;
        mIsAdmin = isAdmin;
        mCartStringList = cartStringList;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public boolean isAdmin() {
        return mIsAdmin;
    }

    public void setAdmin(boolean admin) {
        mIsAdmin = admin;
    }

    public String getCartStringList() {
        return mCartStringList;
    }

    public void setCartStringList(String cartStringList) {
        mCartStringList = cartStringList;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserId=" + mUserId +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mIsAdmin=" + mIsAdmin +
                ", mCartStringList='" + mCartStringList + '\'' +
                '}';
    }
}
