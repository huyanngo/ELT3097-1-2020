package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseImage extends AppCompatActivity {
    Button buttonImage1;
    Button buttonImage2;
    Button buttonImage3;
    Button buttonImage4;
    Button check;

    int choose = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_choose_image);

        buttonImage1 = findViewById(R.id.button1);
        buttonImage2 = findViewById(R.id.button2);
        buttonImage3 = findViewById(R.id.button3);
        buttonImage4 = findViewById(R.id.button4);
        check = findViewById(R.id.button5);

        buttonImage1.setOnClickListener(mListener);
        buttonImage2.setOnClickListener(mListener);
        buttonImage3.setOnClickListener(mListener);
        buttonImage4.setOnClickListener(mListener);
        check.setOnClickListener(mListener);


    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            switch (Id) {
                case R.id.button1:
                    choose=0;
                    SetBtn(buttonImage1,buttonImage2,buttonImage3,buttonImage4);
                    break;

                case R.id.button2:
                    choose = 0;
                    SetBtn(buttonImage2,buttonImage1,buttonImage3,buttonImage4);

                    break;
                case R.id.button3:
                    choose = 1;
                    SetBtn(buttonImage3,buttonImage1,buttonImage2,buttonImage4);
                    break;

                case R.id.button4:
                    choose = 0;
                    SetBtn(buttonImage4,buttonImage1,buttonImage2,buttonImage3);
                    break;

                case R.id.button5:
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseImage.this);
                    if(choose == 1) {
                        builder.setMessage("Congratulation! That's a correct answer");
                    }
                    else {
                        builder.setMessage("Wrong answer :((");
                    }

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            startActivity(new Intent(ChooseImage.this, Vocabulary.class));
                        }
                    });
                    builder.show();
                    break;
                default:
                    break;

            }
        };
    };

    protected void SetBtn(Button change, Button Other1, Button Other2, Button Other3) {
        change.setBackgroundResource(R.drawable.buttonblue);
        Other1.setBackgroundResource(R.drawable.buttonwhite);
        Other2.setBackgroundResource(R.drawable.buttonwhite);
        Other3.setBackgroundResource(R.drawable.buttonwhite);
        check.setEnabled(true);
        check.setBackgroundResource(R.drawable.buttongreen);
        check.setTextColor(Color.parseColor("#ffffff"));
    }
}