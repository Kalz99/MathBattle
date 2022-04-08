package com.example.mathbattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
TextView reg;
    EditText Email, Password;
    Button login;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = (EditText) findViewById(R.id.txtLoginMail);
        Password = (EditText) findViewById(R.id.txtLoginPw);
        login=(Button)findViewById(R.id.btnLogin);
        reg=(TextView) findViewById(R.id.txtReg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mail = Email.getText().toString().trim();
                final String password = Password.getText().toString();
                Toast.makeText(getApplicationContext(), mail, Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();

                } else {

                    auth.signInWithEmailAndPassword(mail, password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(Login.this,MainMenu.class);
                                        intent.putExtra("uname", mail);
                                        startActivity(intent);


                                    } else {
                                        String msg = task.getException().getMessage();
                                        Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();
                                        if (password.length() < 6) {
                                            Toast.makeText(getApplicationContext(), "Your password must be atleast 6 characters", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                }
                            });


                }
            }
        });

    }
}