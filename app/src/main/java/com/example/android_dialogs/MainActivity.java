package com.example.android_dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button customAlertBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAlertBtn = findViewById(R.id.button1);

        customAlertBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mDialog = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
                final EditText mEmail =  mView.findViewById(R.id.etEmail);
                final EditText mPassword = mView.findViewById(R.id.etPass);
                Button loginButton = mView.findViewById(R.id.button);

                loginButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        } else{
                            Toast.makeText(MainActivity.this, "One of the field is empty", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                mDialog.setView(mView);
                AlertDialog dialog = mDialog.create();
                dialog.show();

            }
        });
    }
}
