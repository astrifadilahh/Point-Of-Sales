package com.example.pos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LoginCafe extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail, editPassword;
    private TextView tvPindah;
    private Button btnLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cafe);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), HomeCafe.class));
        }

        editEmail = (EditText) findViewById(R.id.eEmailCafe);
        editPassword = (EditText) findViewById(R.id.ePasswordCafe);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvPindah = (TextView) findViewById(R.id.tvPindah);

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(this);
        tvPindah.setOnClickListener(this);
    }

    private void userLogin(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "isi email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "isi password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Login user");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(), HomeCafe.class));
                }
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin){
            userLogin();
        }
        if (view == tvPindah){
            finish();
            startActivity(new Intent(this, Register2Cafe.class));
        }
    }
}
