package com.example.projet_g_f;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditText_Email,mEditText_Password;
    private CardView mCardView_LogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mEditText_Email = findViewById(R.id.EditText_Email);
        mEditText_Password = findViewById(R.id.EditText_Password);
        mCardView_LogIn = findViewById(R.id.CardView_Login);

        mCardView_LogIn.setEnabled(false);
        
        mEditText_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCardView_LogIn.setEnabled(s.toString().length() != 0 && mEditText_Password.length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCardView_LogIn.setEnabled(s.toString().length() != 0 && mEditText_Password.length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCardView_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityIntent = new Intent(LoginActivity.this, MainActivity.class);//précise la paramètres d'une nouvelle activité à créer
                startActivity(ActivityIntent);//démarre l'activité
            }
        });
    }
}