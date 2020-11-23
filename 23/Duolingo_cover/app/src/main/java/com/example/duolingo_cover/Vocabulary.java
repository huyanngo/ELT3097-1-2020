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

public class Vocabulary extends AppCompatActivity {

    Button check;
    TextView textInput;

    private TextWatcher textWatcher = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_vocab);
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
                        builder.setMessage("Wrong answer :((");
                    }
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            startActivity(new Intent(Vocabulary.this, ChooseCorrectAnswer.class));
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