package com.example.hp.vinya.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by hp on 19-09-2018.
 */
@Database(entities = User.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null)
        {
            synchronized (AppDatabase.class)
            {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"user_DB").build();

            }
        }
    return INSTANCE;
    }
}
