package com.e.mar7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usrname,pass;
    Button btn;
    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrname = findViewById(R.id.editText1);
        pass = findViewById(R.id.editText2);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usrname.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(user.equals(s1) && password.equals(s2))
                {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Username Is not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("com.e.mar7",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putString("name",usrname.getText().toString().trim());
        //editor.putString("name",pass.getText().toString().trim());
        editor.putString("Username","nikhil.gupta_mca18@gla.ac.in");
        editor.putString("Password","123456");
        editor.putBoolean("bool",true);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.e.mar7",MODE_PRIVATE);
        s1 = sharedPreferences.getString("uesername", "user");
        s2 = sharedPreferences.getString("Password","Pass");
        Boolean remember =sharedPreferences.getBoolean("Bool",false);
        Toast.makeText(this, "Bool: "+remember, Toast.LENGTH_SHORT).show();
        usrname.setText(s1);
        pass.setText(s2);



    }
}
