package com.example.sdcard;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity
public class Entity {

    @PrimaryKey
    @ColumnInfo(name = "Entity_Email")
    @NonNull
    String email;

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }
}
