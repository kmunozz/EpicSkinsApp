package com.kmunoz.epicskins.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kmunoz.epicskins.Skin;
import com.kmunoz.epicskins.User;

@Database(entities = {User.class, Skin.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "EPIC_SKINS_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String SKIN_TABLE = "SKIN_TABLE";

    public abstract EpicSkinsDAO FortniteEpicSkinsDAO();
}
