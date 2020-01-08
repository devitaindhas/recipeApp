package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    //deklarasi beberapa variabel kayak button editext, databaserefrence, firebaseauth
    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText editEmail;
    private EditText editPassword;
    private Button buttonRegister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //variabel tadi untuk memanggil fungsi
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        buttonRegister2 = (Button) findViewById(R.id.btn_sign2);

        editEmail = (EditText)findViewById(R.id.Email);
        editPassword = (EditText)findViewById(R.id.Password);
        buttonRegister2.setOnClickListener(this);

    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("Required");
            result = false;
        } else {
            editEmail.setError(null);
        }

        if (TextUtils.isEmpty(editPassword.getText().toString())) {
            editPassword.setError("Required");
            result = false;
        } else {
            editPassword.setError(null);
        }

        return result;
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    //menulis ke Database
    private void writeNewAdmin(String userId, String username, String email) {
        Admin admin = new Admin(username, email);

        mDatabase.child("admins").child(userId).setValue(admin);
    }

    //fungsi dipanggil ketika proses Authentikasi berhasil
    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());

        // membuat User admin baru
        writeNewAdmin(user.getUid(), username, user.getEmail());

        // Go to MainActivity
        startActivity(new Intent(Register.this, MainActivity.class));
        finish();
    }

    //fungsi ini untuk mendaftarkan data pengguna ke Firebase
    private void signUp() {
        Log.d(TAG, "signUp");
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
                        //hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(Register.this, "Sign Up Failed",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {

        signUp();
    }
}
