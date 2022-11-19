package com.example.photo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.photo.FileClass;

import java.util.List;

@Dao
public interface FileClassDao {
    @Insert
    void insertAll(FileClass...fileClasses);

    @Delete
    void delete(FileClass fileClass);

    @Query("SELECT * FROM fileclass")
    public List<FileClass> getFileClasses();

}
