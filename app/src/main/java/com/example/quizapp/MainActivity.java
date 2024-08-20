package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button start,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));

        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.blue));

        name=(EditText) findViewById(R.id.editTextText);
        start= (Button) findViewById(R.id.button);
        about=(Button) findViewById(R.id.button2);

        start.setOnClickListener(
                v->{
                    String str= name.getText().toString();

                    if(str.equalsIgnoreCase("")){
                        Toast.makeText(getApplicationContext(),"First enter your name to start the quiz",Toast.LENGTH_LONG).show();
                    }

                    else{
                        Intent intent = new Intent(getApplicationContext(), StartQuiz.class);
                        intent.putExtra("name",str);
                        startActivity(intent);
                    }
                }
        );

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}