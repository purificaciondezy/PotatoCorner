package com.example.student.potatocorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Fries extends AppCompatActivity {

    ImageButton imgbtnJumboFries, imgbtnOriginalFries, imgbtnBbq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries);

        imgbtnJumboFries = (ImageButton) findViewById(R.id.imgbtnJumboFries);
        imgbtnOriginalFries = (ImageButton) findViewById(R.id.imgbtnOriginalFries);
        imgbtnBbq = (ImageButton) findViewById(R.id.imgbtnBbq);
    }

    public void jumbofries(View v)
    {
        imgbtnJumboFries.setEnabled(false);
        imgbtnJumboFries.setClickable(false);
    }

    public void originalfries(View v)
    {
        imgbtnOriginalFries.setEnabled(false);
        imgbtnOriginalFries.setClickable(false);
    }

    public void bbqfries(View v)
    {
        imgbtnBbq.setEnabled(false);
        imgbtnBbq.setClickable(false);
    }

    public void nextfries(View v)
    {
        Intent intent = new Intent(Fries.this, drinks.class);
        startActivity(intent);
        finish();
    }

    //Back/Exit
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Fries.this, Category.class));
        finish();
    }
}
