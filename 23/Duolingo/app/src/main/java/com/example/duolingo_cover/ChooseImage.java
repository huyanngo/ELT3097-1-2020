package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ChooseImage extends AppCompatActivity {
    Button buttonImage1;
    Button buttonImage2;
    Button buttonImage3;
    Button buttonImage4;
    Button check;
    int lives;
    TextView liveText;
    ArrayList<Integer> imageList;

    String compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_choose_image);

        liveText = findViewById(R.id.lives);
        Intent intent = getIntent();
        lives = intent.getIntExtra("lives", 0);
        liveText.setText("" + lives);

        buttonImage1 = findViewById(R.id.button1);
        buttonImage2 = findViewById(R.id.button2);
        buttonImage3 = findViewById(R.id.button3);
        buttonImage4 = findViewById(R.id.button4);
        check = findViewById(R.id.button5);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.bread);
        imageList.add(R.drawable.coffee);
        imageList.add(R.drawable.food);
        imageList.add(R.drawable.rice);
        Collections.shuffle(imageList);

        buttonImage1.setCompoundDrawablesWithIntrinsicBounds(0, imageList.get(0),0,0);
        shuffleText(0,buttonImage1);
        buttonImage2.setCompoundDrawablesWithIntrinsicBounds(0,imageList.get(1),0,0);
        shuffleText(1,buttonImage2);
        buttonImage3.setCompoundDrawablesWithIntrinsicBounds(0,imageList.get(2),0,0);
        shuffleText(2,buttonImage3);
        buttonImage4.setCompoundDrawablesWithIntrinsicBounds(0,imageList.get(3),0,0);
        shuffleText(3,buttonImage4);


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
                    SetBtn(buttonImage1,buttonImage2,buttonImage3,buttonImage4);
                    break;

                case R.id.button2:
                    SetBtn(buttonImage2,buttonImage1,buttonImage3,buttonImage4);

                    break;
                case R.id.button3:
                    SetBtn(buttonImage3,buttonImage1,buttonImage2,buttonImage4);
                    break;

                case R.id.button4:
                    SetBtn(buttonImage4,buttonImage1,buttonImage2,buttonImage3);
                    break;

                case R.id.button5:
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseImage.this);
                    if(compare.equalsIgnoreCase("food")) {
                        builder.setMessage("Congratulation! That's a correct answer");
                    }
                    else {
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
                                Intent intent2 = new Intent(ChooseImage.this, MainActivity.class);
                                startActivity(intent2);
                            }else {
                                Intent intent2 = new Intent(ChooseImage.this, Vocabulary.class);
                                intent2.putExtra("lives", lives);
                                startActivity(intent2);
                            }
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
        compare = change.getText().toString();
        check.setEnabled(true);
        check.setBackgroundResource(R.drawable.buttongreen);
        check.setTextColor(Color.parseColor("#ffffff"));
    }

    protected void shuffleText(int i,Button button){
        if(imageList.get(i) == R.drawable.bread){
            button.setText("Bread");
        }else if (imageList.get(i) == R.drawable.coffee){
            button.setText("Coffee");
        }else if (imageList.get(i) == R.drawable.food){
            button.setText("Food");
        }else if (imageList.get(i) == R.drawable.rice){
            button.setText("Rice");
        }
    }
}