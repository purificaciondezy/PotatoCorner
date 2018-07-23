package com.example.student.potatocorner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText txtUsernameLogin;
    EditText txtPasswordLogin;
    Button btnLogin;
    Button btnRegisterLogin;

    DBTools dbTools = new DBTools(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegisterLogin = (Button) findViewById(R.id.btnRegisterLogin);

        btnLogin.setOnClickListener(new ButtonEventHandler());
        btnRegisterLogin.setOnClickListener(new ButtonEventHandler());

        txtUsernameLogin = (EditText) findViewById(R.id.txtUsernameLogin);
        txtPasswordLogin = (EditText) findViewById(R.id.txtPasswordLogin);
    }


    private class ButtonEventHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnLogin:
                    verifyLogInUser();
                    break;
                case R.id.btnRegisterLogin:
                    register();
                    break;
            }
        }
    }
    private void register(){
        Intent intent = new Intent(getApplicationContext(),registration.class);
        startActivity(intent);
    }

    private void verifyLogInUser(){

        String username = txtUsernameLogin.getText().toString();
        String password = txtPasswordLogin.getText().toString();

        HashMap<String, String> result = dbTools.getUserByUserNamePassword(username, password);

        if (result.isEmpty()){
            txtUsernameLogin.setText("");
            txtPasswordLogin.setText("");
            Toast.makeText(this, "User name and/or password is incorrect", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Login successfull", Toast.LENGTH_LONG ).show();
            Intent intent2 = new Intent(MainActivity.this, Category.class);
            Bundle b = new Bundle();
            b.putString("UserName", result.get("UserName"));
            b.putInt("UserID", Integer.valueOf(result.get("UserID")));

            intent2.putExtras(b);
            startActivity(intent2);
            finish();
        }
    }

    private  void exit(){
        this.finish();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
            alertbox.setTitle("Close Application");
            alertbox.setMessage("Exit application?");

            alertbox.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            exit();
                        }
                    });
            alertbox.setNeutralButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
            alertbox.show();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }



}
