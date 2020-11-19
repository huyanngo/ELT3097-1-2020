package com.example.chooseimage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonImage1;
    Button buttonImage2;
    Button buttonImage3;
    Button buttonImage4;
    Button buttonCheck;

    int choose = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonImage1 = findViewById(R.id.button1);
        buttonImage2 = findViewById(R.id.button2);
        buttonImage3 = findViewById(R.id.button3);
        buttonImage4 = findViewById(R.id.button4);
        buttonCheck = findViewById(R.id.button5);

        buttonImage1.setOnClickListener(mListener);
        buttonImage2.setOnClickListener(mListener);
        buttonImage3.setOnClickListener(mListener);
        buttonImage4.setOnClickListener(mListener);
        buttonCheck.setOnClickListener(mListener);


    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            switch (Id) {
                case R.id.button1:
                    choose=0;
                    buttonCheck.setEnabled(true);
                    buttonCheck.setBackgroundResource(R.drawable.custom_kiemtra);
                    break;

                case R.id.button2:
                    choose = 0;
                    buttonCheck.setEnabled(true);
                    buttonCheck.setBackgroundResource(R.drawable.custom_kiemtra);

                    break;
                case R.id.button3:
                    choose = 1;
                    buttonCheck.setEnabled(true);
                    buttonCheck.setBackgroundResource(R.drawable.custom_kiemtra);
                    break;

                case R.id.button4:
                    choose = 0;
                    buttonCheck.setEnabled(true);
                    buttonCheck.setBackgroundResource(R.drawable.custom_kiemtra);
                    break;

                case R.id.button5:
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    if(choose == 1) {
                        builder.setMessage("Congratulation! That's a correct answer");
                    }
                    else {
                        builder.setMessage("Wrong answer :((");
                    }
                    break;
                default:
                    break;

            }
        };
    };
}