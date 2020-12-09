package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ChooseCorrectAnswer extends AppCompatActivity {
    Button check;
    Button option1;
    Button option2;
    Button option3;
    String compare;
    int lives;
    TextView liveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_choose_corect);

        liveText = findViewById(R.id.lives);
        Intent intent = getIntent();
        lives = intent.getIntExtra("lives", 0);
        liveText.setText("" + lives);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        check =  findViewById(R.id.Check);
        check.setEnabled(false);

        ArrayList<String> list = new ArrayList<String>();
        list.add("We have some food");
        list.add("We eat bread");
        list.add("We have the coffee");
        Collections.shuffle(list);
        option1.setText(list.get(0));
        option2.setText(list.get(1));
        option3.setText(list.get(2));

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option1,option2,option3);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option2,option1,option3);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option3,option2,option1);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCorrectAnswer.this);
                if(compare.equalsIgnoreCase("We eat bread")){
                    builder.setMessage("Congratulation! That's a correct answer");
                }else{
                    lives = lives -1;
                    if(lives<0){
                        builder.setMessage("GAME OVER");
                    }else{
                        builder.setMessage("Wrong answer :((");
                    }
                }

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if(lives<0){
                            Intent intent2 = new Intent(ChooseCorrectAnswer.this, MainActivity.class);
                            startActivity(intent2);
                        }else {
                            Intent intent2 = new Intent(ChooseCorrectAnswer.this, ChooseThemOrThey.class);
                            intent2.putExtra("lives", lives);
                            startActivity(intent2);
                        }
                    }
                });
                builder.show();
            }
        });
    }

    protected void SetBtn(Button change, Button Other1, Button Other2) {
        change.setBackgroundResource(R.drawable.buttonblue);
        Other1.setBackgroundResource(R.drawable.buttonwhite);
        Other2.setBackgroundResource(R.drawable.buttonwhite);
        check.setEnabled(true);
        check.setBackgroundResource(R.drawable.buttongreen);
        compare = change.getText().toString();
    }
}