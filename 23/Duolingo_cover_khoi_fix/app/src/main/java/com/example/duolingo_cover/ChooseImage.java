package com.example.duolingo_cover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChooseImage extends AppCompatActivity {
    ImageButton imgButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button1.setOnClickListener(mListener);
        button2.setOnClickListener(mListener);
        button3.setOnClickListener(mListener);
        button4.setOnClickListener(mListener);
        button5.setOnClickListener(mListener);
    }

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = v.getId();
                switch (Id) {
                    case R.id.button1:
                        button5.setEnabled(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        button1.setSelected(true);
                        button2.setSelected(false);
                        button3.setSelected(false);
                        button4.setSelected(false);
                        break;
                    case R.id.button2:
                        button5.setEnabled(true);
                        button2.setSelectAllOnFocus(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        button2.setSelected(true);
                        button1.setSelected(false);
                        button3.setSelected(false);
                        button4.setSelected(false);
                        break;
                    case R.id.button3:
                        button5.setEnabled(true);
                        button3.setSelectAllOnFocus(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        button3.setSelected(true);
                        button1.setSelected(false);
                        button4.setSelected(false);
                        button2.setSelected(false);
                        break;
                    case R.id.button4:
                        button5.setEnabled(true);
                        button4.setSelected(true);
                        button1.setSelected(false);
                        button3.setSelected(false);
                        button2.setSelected(false);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        break;

                    case R.id.button5:
                        if(button4.isSelected()) {
                        }
                        else {
                        }
                        break;
                    default:
                        break;

                }
            };
        };
}