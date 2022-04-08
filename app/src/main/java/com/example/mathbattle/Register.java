package com.example.mathbattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
   EditText uname,pw,email;
   Button regBtn;
   TextView login;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        login=(TextView) findViewById(R.id.txtlog);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        regBtn=(Button)findViewById(R.id.btnRegister);
        uname=(EditText) findViewById(R.id.txtUname);
        pw=(EditText) findViewById(R.id.txtPassword);
        email=(EditText) findViewById(R.id.txtEmail);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = uname.getText().toString();
                String psw = pw.getText().toString();
                String Email = email.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(Email, psw)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getInstance().getCurrentUser();
                                    String id = user.getIdToken(true).toString();
                                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("USERS");
                                    Player player = new Player(Username,Email,psw,0,1);
                                    ref.child(user.getUid()).setValue(player);
                                    Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register.this, Login.class);
                                    startActivity(intent);


                                } else {
                                    String msg = task.getException().getMessage();
                                    Toast.makeText(Register.this, msg, Toast.LENGTH_SHORT).show();



                                }
                            }
                        });

            }
        });

    }
}