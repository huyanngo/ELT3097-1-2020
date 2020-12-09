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

import java.util.ArrayList;
import java.util.Collections;

public class ChooseThemOrThey extends AppCompatActivity {
    Button check;
    Button option1;
    Button option2;
    int lives;
    String compare;
    TextView liveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_them_or_they);

        liveText = findViewById(R.id.lives);
        Intent intent = getIntent();
        lives = intent.getIntExtra("lives", 0);
        liveText.setText("" + lives);

        check = findViewById(R.id.ktra);
        check.setEnabled(false);
        option1 = findViewById(R.id.btn_them);
        option2 = findViewById(R.id.btn_they);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Them");
        list.add("They");
        Collections.shuffle(list);
        option1.setText(list.get(0));
        option2.setText(list.get(1));

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackgroundResource(R.drawable.buttonblue);
                option2.setBackgroundResource(R.drawable.buttonwhite);
                check.setEnabled(true);
                check.setBackgroundResource(R.drawable.buttongreen);
                compare = option1.getText().toString();
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2.setBackgroundResource(R.drawable.buttonblue);
                option1.setBackgroundResource(R.drawable.buttonwhite);
                check.setEnabled(true);
                check.setBackgroundResource(R.drawable.buttongreen);
                compare = option2.getText().toString();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseThemOrThey.this);
                if(compare.equalsIgnoreCase("them")){
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
                            Intent intent2 = new Intent(ChooseThemOrThey.this, MainActivity.class);
                            startActivity(intent2);
                        }else {
                            Intent intent2 = new Intent(ChooseThemOrThey.this, ChooseImage.class);
                            intent2.putExtra("lives", lives);
                            startActivity(intent2);
                        }
                    }
                });
                builder.show();
                }
        });
    }
}