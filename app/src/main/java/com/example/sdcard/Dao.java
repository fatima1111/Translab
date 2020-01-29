package com.example.sdcard;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {


    @Insert
    public void insert(Entity entity);


    @Query("SELECT * FROM entity")
    public List<Entity> loadAllUsers();
}
