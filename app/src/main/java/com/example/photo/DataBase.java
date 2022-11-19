package com.example.photo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FileClass.class},version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract FileClassDao fileClassDao();

}
