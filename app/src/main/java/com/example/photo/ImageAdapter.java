package com.example.photo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<FileClass> fileClasses;

    public ImageAdapter(List<FileClass> fileClasses) {
        this.fileClasses = fileClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photoview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FileClass fileClass = fileClasses.get(position);
        Bitmap bitmap = BitmapFactory.decodeFile(fileClass.filepath);
        String filename = fileClass.filename;
        holder.fileimage.setImageBitmap(bitmap);
        holder.filetext.setText(filename);
    }

    @Override
    public int getItemCount() {
        return fileClasses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fileimage;
        TextView filetext;

        public ViewHolder(View view){
            super(view);
            fileimage = (ImageView) view.findViewById(R.id.image);
            filetext = (TextView) view.findViewById(R.id.name);
        }
    }
}