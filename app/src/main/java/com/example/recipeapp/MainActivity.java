package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
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


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //deklarasi beberapa variabel kayak button editext, databaserefrence, firebaseauth
    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText editEmail;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variabel tadi untuk memanggil fungsi
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        // diatur sesuai id komponennya
        editEmail = (EditText)findViewById(R.id.Email);
        editPassword = (EditText)findViewById(R.id.Password);
        btnLogin = (Button) findViewById(R.id.btn_sign);
        btnRegister = (Button)findViewById(R.id.btn_create);

        //nambahin method onClick, biar tombolnya bisa diklik
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    //fungsi signin untuk mengkonfirmasi data pengguna yang sudah mendaftar sebelumnya
    private void signIn() {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());
                        //hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(MainActivity.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //fungsi dipanggil ketika proses Authentikasi berhasil
    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());

        // membuat User admin baru
        writeNewAdmin(user.getUid(), username, user.getEmail());

        // Go to MainActivity
        startActivity(new Intent(MainActivity.this, Home.class));
        finish();
    }

    /*
        ini fungsi buat bikin username dari email
            contoh email: abcdefg@mail.com
            maka username nya: abcdefg
     */
    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    //fungsi untuk memvalidasi EditText email dan password agar tak kosong dan sesuai format
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

    //menulis ke Database
    private void writeNewAdmin(String userId, String username, String email) {
        Admin admin = new Admin(username, email);

        mDatabase.child("admins").child(userId).setValue(admin);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_sign) {
            signIn();
        }
        else if (i == R.id.btn_create){
            Intent intent = new Intent(this,Register.class);
            startActivity(intent);
        }
    }

}
