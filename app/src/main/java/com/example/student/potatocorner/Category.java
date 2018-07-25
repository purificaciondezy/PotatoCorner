package com.example.student.potatocorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void friescombos(View v)
    {
        Intent intent = new Intent(Category.this, Fries.class);
        startActivity(intent);
        finish();
    }

    public void chickencombos(View v)
    {
        Intent intent = new Intent(Category.this, chicken.class);
        startActivity(intent);
        finish();
    }

    public void bakedpotatoes(View v)
    {
        Intent intent = new Intent(Category.this, sweetpotatoes.class);
        startActivity(intent);
        finish();
    }

    public void drinks(View v)
    {
        Intent intent = new Intent(Category.this, drinks.class);
        startActivity(intent);
        finish();
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
