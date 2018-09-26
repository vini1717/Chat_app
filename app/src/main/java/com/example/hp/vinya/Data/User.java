package com.example.hp.vinya.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by hp on 19-09-2018.
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    private  Long mobileno;
    @ColumnInfo(name="password")
    private String password;
    @ColumnInfo(name="email")
    private String email;

    public void  setMobileno(Long mobileno)
    {
        this.mobileno=mobileno;

    }
   public  Long getMobileno()
    {
        return mobileno;
    }
   public void setPassword(String password)
    {
        this.password=password;
    }
   public String getPassword()
    {
        return  password;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
   public  String getEmail()
    {
        return email;
    }
}
