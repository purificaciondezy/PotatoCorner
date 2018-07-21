package com.example.student.potatocorner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;


public class registration extends AppCompatActivity
{
     Spinner spnAccountType;
     EditText txtUsernameRegistration;
     EditText txtPasswordRegistration;
     EditText txtFirstName;
     EditText txtLastName;
     EditText txtContactNumber;
     EditText txtEmail;

     Button btnRegister;


    DBTools dbTools = new DBTools(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        spnAccountType = (Spinner) findViewById(R.id.spnAccountType);
        txtUsernameRegistration = (EditText) findViewById(R.id.txtUsernameRegistration);
        txtPasswordRegistration  = (EditText) findViewById(R.id.txtPasswordRegistration);
        txtFirstName  = (EditText) findViewById(R.id.txtFirstName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtContactNumber  = (EditText) findViewById(R.id.txtContactNumber);
        txtEmail  = (EditText) findViewById(R.id.txtEmail);

        btnRegister = (Button) findViewById(R.id.btnRegister);

    }

    private void ClearAllFields()
    {
        txtUsernameRegistration.setText("");
        txtPasswordRegistration.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtContactNumber.setText("");
        txtEmail.setText("");
    }

    private void SaveUserDetails(){
        HashMap<String, String> queryValues = new HashMap<String, String>();
        queryValues.put("UserName", txtUsernameRegistration.getText().toString());
        queryValues.put("Password", txtPasswordRegistration.getText().toString());
        queryValues.put("Company", txtFirstName.getText().toString());
        queryValues.put("Position", txtLastName.getText().toString());
        queryValues.put("Address", txtContactNumber.getText().toString());
        queryValues.put("PhoneNo", txtEmail.getText().toString());
        int success = (int)dbTools.insertCustomer(queryValues);

        if (success > 0)
            Toast.makeText(getApplicationContext(), "LOG IN TO CONTINUE", Toast.LENGTH_LONG).show();
        ClearAllFields();
        finish();
    }



    public void onClick(View v)
    {
        if (v.getId() == R.id.btnRegister)
        {
            //save the user details
            if (!isAllRequiredFieldsNotEmpy()){
                Toast.makeText(getApplicationContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show();
                return;
            }
            else
                Toast.makeText(getApplicationContext(), "LOG IN TO CONTINUE", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(registration.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean isAllRequiredFieldsNotEmpy()
    {
        return ((txtUsernameRegistration.getText().toString().length() != 0) && (txtPasswordRegistration.getText().toString().length() != 0) && (txtFirstName.getText().toString().length() != 0)&& (txtLastName.getText().toString().length() != 0)&& (txtContactNumber.getText().toString().length() != 0)&& (txtEmail.getText().toString().length() != 0));
    }

    //Back/Exit
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(registration.this, MainActivity.class));
        finish();
    }
}

