package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class StartQuiz extends AppCompatActivity {

    private String answer;
    private String questionList[]={
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that\n" +
                    "invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package\n" +
                    "‘pkg’?",
            "What is the return type of Constructors?"
    };

    private String optionList[][]={
            {"finalize method","main method","static method","private method"},
            {"import","this","catch","abstract"},
            {"public","protected","private","All of the mentioned"},
            {"Import pkg.","import pkg.*","Import pkg.*","import pkg."},
            {"int","float","void","None of the mentioned"}
    };

    private String correctAnswer[]={
            "main method","this","public","import pkg.*","None of the mentioned"
    };



    TextView greeting,scoreView,question;
    RadioGroup selectedOpt;
    RadioButton opt1,opt2,opt3,opt4;

    Button nextQuestion,quit;
    int num=0,score=0,incorrect=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.blue));

        greeting=(TextView) findViewById(R.id.textView2);
        scoreView=(TextView) findViewById(R.id.textView5);
        question=(TextView) findViewById(R.id.textView3);

        selectedOpt=findViewById(R.id.radioGroup);
        nextQuestion=findViewById(R.id.button6);
        quit=findViewById(R.id.button7);

        opt1=findViewById(R.id.radioButton1);
        opt2=findViewById(R.id.radioButton2);
        opt3=findViewById(R.id.radioButton3);
        opt4=findViewById(R.id.radioButton4);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        greeting.setText("Hello "+name);

        updateQuestion();

        nextQuestion.setOnClickListener(new View.OnClickListener() {

            int flag=0;

            int ans=0;
            @Override
            public void onClick(View view) {

                int selectId= selectedOpt.getCheckedRadioButtonId();
                RadioButton select=selectedOpt.findViewById(selectId);
                System.out.println(select.getText().toString());

                if(select.getText().toString().equals(correctAnswer[ans]))
                        {
                            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                            score=score+1;
                            updateScore();
                        }





//                selectedOpt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//                    @Override
//                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                        RadioButton select=radioGroup.findViewById(i);
//                        System.out.println(select.getText().toString());
//                        if(select.getText().toString().equalsIgnoreCase(correctAnswer[ans]))
//                        {
//                            flag=1;
//                        }
//                    }
//                });





                else {


                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    incorrect=incorrect+1;


                }

                updateQuestion();
                ans++;

            }
        });


        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resIntent=new Intent(getApplicationContext(), ResultActivity.class);
                resIntent.putExtra("correct",score);
                resIntent.putExtra("incorrect",incorrect);
                startActivity(resIntent);
            }
        });



    }

    private void updateQuestion(){

        if(num>4){
            Intent resIntent=new Intent(getApplicationContext(), ResultActivity.class);
            resIntent.putExtra("correct",score);
            resIntent.putExtra("incorrect",incorrect);
            startActivity(resIntent);

        }
        question.setText(questionList[num]);
        opt1.setText(optionList[num][0]);
        opt2.setText(optionList[num][1]);
        opt3.setText(optionList[num][2]);
        opt4.setText(optionList[num][3]);
        num++;
    }

    private void updateScore(){

        scoreView.setText(""+score);
    }

}