package com.example.hp.vinya.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by hp on 19-09-2018.
 */
@Dao
public interface UserDao {
    @Query("Select * from user ")
    List<User>getAll();
    @Query("Select * From user Where mobileno Like :mobileno And Password Like :password")
    boolean getauth(Long mobileno,String password);
    @Insert
    void insertAll(User user);
    @Delete
    void delete(User user);
}
