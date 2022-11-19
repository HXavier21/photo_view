package com.example.photo;

import static com.example.photo.App.db;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.room.Room;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.InputStream;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    EditText pWPicpathEditText = null;
    Button button;
    Button button1;
    ImageView pWPicpathView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pWPicpathEditText = (EditText) findViewById(R.id.editText_url);
        pWPicpathView = (ImageView) findViewById(R.id.p_w_picpathView);
        button = (Button) findViewById(R.id.button_get);
        button1 = (Button) findViewById(R.id.button2);
        FileClassDao fileClassDao = App.db.fileClassDao();
        button.setOnClickListener(v -> new Thread(() -> {

            // TODO Auto-generated method stub
            String Url = pWPicpathEditText.getText().toString();
            try {
                int num = (int) (Math.random() * 100);
                InputStream data = GetImage.getImage(Url);
                File file = new File(this.getFilesDir().toString(), "filename" + num + ".jpg");
                while (file.exists())
                    num = (int) (Math.random() * 100);
                file = new File(this.getFilesDir().toString(), "filename" + num + ".jpg");
                FileUtils.copyInputStreamToFile(data, file);
                String filePath = file.getPath();
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                //显示图片
                runOnUiThread(() -> pWPicpathView.setImageBitmap(bitmap));
                FileClass fileclass1 = new FileClass(filePath, "filename" + num + ".jpg");
                fileClassDao.insertAll(fileclass1);
            } catch (Exception e) {
                Looper.prepare();
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "链接延时", Toast.LENGTH_LONG).show());
                e.printStackTrace();
            }
        }).start());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageListActivity.class);
                startActivity(intent);
            }
        });
    }
}
