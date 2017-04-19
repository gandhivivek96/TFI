package com.example.vivekgandhi.tfi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String email,pass;
    private EditText e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        e = (EditText) findViewById(R.id.email);
        p = (EditText) findViewById(R.id.password);
        email = e.getText().toString().trim();
        pass = p.getText().toString().trim();
        if(email.equals("admin") && pass.equals("tfi"))
        {
            Intent i = new Intent(MainActivity.this,Admin.class);
            startActivity(i);
        }
        else
        {
            Intent i = new Intent(MainActivity.this,FilterActivity.class);
            startActivity(i);

        }

    }
}
