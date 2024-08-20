package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView correct,incorrect,total;

    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));

        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.blue));

        correct=findViewById(R.id.textView6);
        incorrect=findViewById(R.id.textView7);
        total=findViewById(R.id.textView8);

        restart=findViewById(R.id.button3);

        Intent pIntent=getIntent();
        int cInt=pIntent.getIntExtra("correct",0);
        int iInt=pIntent.getIntExtra("incorrect",0);

        correct.setText("Correct Answers: "+cInt);
        incorrect.setText("Incorrect Answers: "+iInt);
        total.setText("Final Score: "+cInt);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}