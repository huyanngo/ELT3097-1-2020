package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Vocabulary extends AppCompatActivity {

    Button check;
    TextView textInput;
    int lives;
    TextView liveText;

    private TextWatcher textWatcher = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_vocab);

        liveText = findViewById(R.id.lives);
        Intent intent = getIntent();
        lives = intent.getIntExtra("lives", 0);
        liveText.setText("" + lives);

        check = findViewById(R.id.button);
        textInput = findViewById(R.id.textview);
        check.setEnabled(false);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textInput.getText().toString();
                if(!str.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Vocabulary.this);
                    if(str.equalsIgnoreCase("hot")){
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
                                Intent intent2 = new Intent(Vocabulary.this, MainActivity.class);
                                startActivity(intent2);
                            }else{
                                Intent intent2 = new Intent(Vocabulary.this, ChooseCorrectAnswer.class);
                                intent2.putExtra("lives",lives);
                                startActivity(intent2);
                            }
                        }
                    });
                    builder.show();
                }
            }
        });

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!textInput.getText().toString().isEmpty()){
                    check.setEnabled(true);
                    check.setBackgroundResource(R.drawable.buttongreen);
                    check.setTextColor(Color.parseColor("#ffffff"));
                }else{
                    check.setEnabled(false);
                    check.setBackgroundResource(R.drawable.button);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textInput.addTextChangedListener(textWatcher);
    }
}