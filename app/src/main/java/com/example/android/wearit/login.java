package com.example.android.wearit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Divyani on 08-03-2017.
 */
public class login extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void add(View v)
    {
        Intent i=new Intent(this,CreateAccount.class);
        startActivity(i);
    }

}
