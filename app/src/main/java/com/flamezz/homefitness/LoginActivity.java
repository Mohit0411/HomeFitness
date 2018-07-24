package com.flamezz.homefitness;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton,signupButton,backButton;
    private EditText edittextEmail,editTextPassword;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_login);
        InitlaizeControls();
        setUpSignUp();
        setUpSingIn();
    }

    private void InitlaizeControls()
    {
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        edittextEmail = findViewById(R.id.edittext_email);
        editTextPassword  = findViewById(R.id.edittext_password);
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
                    startActivity(intent);

                }
            }
        };

    }
    protected void onStart()
    {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    private void setUpSignUp()
    {
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(LoginActivity.this);
                alertdialog.setTitle("\t\t\t\t\t\t\t\t\t\t\t\t\tCreate Account");
                View mview = getLayoutInflater().inflate(R.layout.alert_dialog, null);
                final EditText fullName = mview.findViewById(R.id.fullName);
                final EditText emailID = mview.findViewById(R.id.emailID);
                final EditText password = mview.findViewById(R.id.password);
                final EditText cnPassword = mview.findViewById(R.id.confirmPassword);
                final EditText phoneNo = mview.findViewById(R.id.phoneNo);
                backButton = mview.findViewById(R.id.backButton);
                backButtonPressed();
                Button createAccountButton = mview.findViewById(R.id.createAccountButton);
                createAccountButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        databaseReference = FirebaseDatabase.getInstance().getReference();
                        String name = fullName.getText().toString().trim();
                        String email = emailID.getText().toString().trim();
                        String pass = password.getText().toString().trim();
                        String cnpass = cnPassword.getText().toString().trim();
                        String phone = phoneNo.getText().toString().trim();
                        final User user = new User(name,email,pass,cnpass,phone);
                        if (!name.isEmpty() && !email.isEmpty() && !pass.isEmpty() && !cnpass.isEmpty() && !phone.isEmpty() ||
                                password.equals(cnPassword) && !(phone.length() <= 10)) {
                            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Creating Account", "Please be Patient", false);
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        databaseReference.child(user.getPhone()).setValue(user);
                                        Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(), "Account Created Succesfully", Toast.LENGTH_SHORT).show();
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Error Creating Account", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            fullName.setError("Field cannot be empty");
                            emailID.setError("Field cannot be empty");
                            password.setError("Field cannot be empty");
                            cnPassword.setError("Field cannot be empty");
                            phoneNo.setError("Field cannot be empty");

                        }
                    }

                });
                alertdialog.setView(mview);
                alertdialog.create();
                alertdialog.show();

            }
        });
    }

    private void setUpSingIn()
    {

       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                String login_email = edittextEmail.getText().toString().trim();
                String login_password = editTextPassword.getText().toString().trim();
               if(!login_email.isEmpty() || !login_password.isEmpty())
               {
                   firebaseAuth.signInWithEmailAndPassword(login_email,login_password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                       ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"Checking Credentials","Please Wait",false);
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           progressDialog.dismiss();
                           if(task.isSuccessful())
                           {
                               Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
                               startActivity(intent);
                               finish();
                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               else
               {
                   edittextEmail.setError("Field Cannot be empty");
                   editTextPassword.setError("Field Cannot be empty");
               }
           }
       });


    }


    private void backButtonPressed()
    {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
