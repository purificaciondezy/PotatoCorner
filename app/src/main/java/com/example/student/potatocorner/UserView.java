package com.example.student.potatocorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
    }

    public void orderhistory(View v)
    {
        Intent intent = new Intent(UserView.this, OrderHistory.class);
        startActivity(intent);
        finish();
    }

    public void ordernow(View v)
    {
        Intent intent = new Intent(UserView.this, Category.class);
        startActivity(intent);
        finish();
    }

    public void editaccount(View v)
    {
        Intent intent = new Intent(UserView.this, EditAcountDetails.class);
        startActivity(intent);
        finish();
    }

    public void logout(View v)
    {
        Intent intent = new Intent(UserView.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Back/Exit
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(UserView.this, MainActivity.class));
        finish();
    }
}
