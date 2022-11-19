package com.example.photo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FileClass{
    @PrimaryKey
    @NonNull
    public String filepath;

    @ColumnInfo(name = "file_name")
    public String filename;

    public FileClass (@NonNull String filepath,String filename){
        this.filepath = filepath;
        this.filename = filename;
    }
}

