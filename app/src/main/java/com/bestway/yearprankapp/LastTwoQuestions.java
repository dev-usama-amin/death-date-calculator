package com.bestway.yearprankapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class LastTwoQuestions extends AppCompatActivity {

    private EditText editText;
    private EditText spinner;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_two_questions);

        //change status bar color
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        init();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToNext();
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FirstTwoQuestions.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

    }

    private void init(){
        editText = findViewById(R.id.et_age);
        spinner = findViewById(R.id.spinner_smoker);
    }

    private Boolean validateFields(){

        if (editText.getText().toString().isEmpty()){
            editText.setError("Enter correct number");
            return false;
        }

        if (spinner.getText().toString().isEmpty()){
            spinner.setError("Enter correct number");
            return false;
        }
        return true;

    }


    private void proceedToNext(){

        if (!validateFields()){
            return;
        }

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }
}
