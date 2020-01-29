package com.example.sdcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageHolder;
    EditText editText;


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    Dao dao;
    Database database;
    Entity entity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageHolder = findViewById(R.id.captured_photo);
        editText = findViewById(R.id.editText);

        database = Database.getInstance(this);
        dao = database.getVisitorDao();

    }

    public void clickMe(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == RESULT_OK && requestCode == 123) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("image");
                imageHolder.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "Image Captured Failed", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

            Toast.makeText(this, "Image Captured Failed", Toast.LENGTH_LONG).show();
        }
    }


    public void clickMe2(View view) {

        entity = new Entity();
        entity.setEmail(editText.getText().toString());

        dao.insert(entity);

        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();

        editText.setText("");

    }

    public void retrieve(View view) {
        dao.loadAllUsers();
        entity = new Entity();
        String text = entity.getEmail();
        editText.setText(text);

    }
}
