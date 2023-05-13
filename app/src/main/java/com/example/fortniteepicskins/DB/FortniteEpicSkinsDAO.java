package com.example.fortniteepicskins.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fortniteepicskins.LandingPage.Skins;
import com.example.fortniteepicskins.LoginPage.User;

import java.util.List;

@Dao
public interface FortniteEpicSkinsDAO {

    //User
    @Insert
    void insert(User...users);

    @Update
    void update(User...users);

    @Delete
    void delete(User...users);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUsername =:username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUserId =:userId")
    User getUserByUserId(String userId);

    @Query("DELETE FROM " + AppDataBase.USER_TABLE + " WHERE mUserId =:userId")
    void deleteUserById(int userId);

    //Skins
    @Insert
    void insert(Skins...skins);

    @Update
    void update(Skins...skins);

    // TODO: Finish making queries

}
