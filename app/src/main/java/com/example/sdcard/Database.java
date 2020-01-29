package com.example.sdcard;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
@androidx.room.Database(entities = {Entity.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {


    private static Database database;


    public abstract Dao getVisitorDao();

    public static Database getInstance(Context context) {


        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), Database.class, "translabHSR2.db").allowMainThreadQueries().build();
        }

        return database;
    }
}