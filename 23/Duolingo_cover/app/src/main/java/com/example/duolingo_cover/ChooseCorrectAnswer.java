package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseCorrectAnswer extends AppCompatActivity {
    Button check;
    Button option1;
    Button option2;
    Button option3;
    int choose = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_choose_corect);

        check =  findViewById(R.id.Check);
        check.setEnabled(false);

        option1 = findViewById(R.id.option1);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option1,option2,option3);
                choose=1;
            }
        });
        option2 = findViewById(R.id.option2);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option2,option1,option3);
                choose=2;
            }
        });
        option3 = findViewById(R.id.option3);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(option3,option2,option1);
                choose=3;
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCorrectAnswer.this);
                if(choose==3){
                    builder.setMessage("Congratulation! That's a correct answer");
                }else{
                    builder.setMessage("Wrong answer :((");
                }

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(ChooseCorrectAnswer.this, ChooseThemOrThey.class));
                    }
                });
                builder.show();
            }
        });
    }

    protected void SetBtn(Button change, Button Other1, Button Other2) {
        change.setBackgroundColor(Color.parseColor("#92ebff"));
        Other1.setBackgroundColor(Color.parseColor("white"));
        Other2.setBackgroundColor(Color.parseColor("white"));
        check.setEnabled(true);
        check.setBackgroundColor(Color.parseColor("#31cb06"));
    }
}