package com.example.aplikasilaundry;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activitylogin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    //kenalkan widget didalam method create
        edUsername= (EditText) findViewById(R.id.edUsername);
        edPassword= (EditText) findViewById(R.id.edPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);


    //event handler ketika button klik login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edUsername.getText().toString())){
                    Toast.makeText(LoginActivity.this, "username tidak boleh kosong",Toast.LENGTH_LONG).show();

                }else if (TextUtils.isEmpty(edPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this, "password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else {

                    //Toast.makeText(LoginActivity.this, "kanai coret dari kk", Toast.LENGTH_LONG).show();
                    //intent ketika di klik login akan pindah ke main activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    //kirim data username ke activity main menggunakan intent
                    intent.putExtra("username", edUsername.getText().toString());
                    startActivity(intent);
                    //setelah tombol di klik maka login akan dimatikan
                    finish();
                }
            }
        });
    }
}