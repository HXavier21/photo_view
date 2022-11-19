package com.example.photo;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static DataBase db;

    @Override
    public void onCreate() {
        db = Room.databaseBuilder(getApplicationContext(), DataBase.class, "database-name").build();

        super.onCreate();

    }
}
