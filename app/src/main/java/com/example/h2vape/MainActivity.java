package com.example.h2vape;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Email;
    private EditText Password;
    private Button login_btn;
    private TextView signup_intent_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.input_email);
        Password = findViewById(R.id.input_password);
        login_btn = findViewById(R.id.btn_login);
        signup_intent_txt = findViewById(R.id.link_signup);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        signup_intent_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupIntent();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void Login() {
        mAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "fe 7aga 8lt ya ba4a", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });

    }
    private void SignupIntent(){
        Intent i = new Intent(this,SignupActivity.class);
        startActivity(i);
    }
}
