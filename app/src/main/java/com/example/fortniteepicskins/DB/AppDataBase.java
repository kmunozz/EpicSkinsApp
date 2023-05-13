package com.example.fortniteepicskins.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fortniteepicskins.LandingPage.Skins;
import com.example.fortniteepicskins.LoginPage.User;

@Database(entities = {User.class, Skins.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "FORTNITESKINS_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String SKINS_TABLE = "SKINS_TABLE";

    public abstract FortniteEpicSkinsDAO FortniteEpicSkinsDAO();
}
