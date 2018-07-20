package com.example.student.potatocorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    //Back/Exit
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Category.this, UserView.class));
        finish();
    }
}
