package com.example.sharedprefrence;

import static com.example.sharedprefrence.R.id.clear_data;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView userTV,passTv;
    EditText userED,passED;
    Button save,clear;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userED=findViewById(R.id.user);
        passED=findViewById(R.id.pass);

        userTV=findViewById(R.id.user_name);
        passTv=findViewById(R.id.password);

        save=findViewById(R.id.save_Data);
        clear=findViewById(R.id.clear_data);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userED.getText().toString();
                String pas = passED.getText().toString();
                Util.storeCred(id, pas, MainActivity.this);
               // Util.ShowAlert();
                showData();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "data Clear", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void showData() {
        String [] ans = Util.getCred();

        userTV.setText(ans[0]);
        passTv.setText(ans[1]);

    }
}