package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * Created by Admin on 11/5/17.
 */

public class LoginActivity extends AppCompatActivity {

    public static Intent newIntent(Context context)
    {
        Intent intent= new Intent(context,LoginActivity.class);
        return intent;
    }

    private static final String CORRECT_EMAIL= "abc@gmail.com";
    private static final String CORRECT_PASSWORD="Abcde"; // Constant Attribute
    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassword;
    private TextView btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         btnLogin = findViewById(R.id.btn_login);
         etEmailOrPhone = findViewById(R.id.et_email_or_phone);
         etPassword=findViewById(R.id.et_password);
         btnForgotPassword=findViewById(R.id.btn_forgot_password);
         btnRegister=findViewById(R.id.btn_register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Snackbar.make(v,"Your login session is processing",Snackbar.LENGTH_LONG).show();
                // Toast.makeText(v.getContext(),"your login session is processing",Toast.LENGTH_SHORT).show();

             String EmailOrPhone =  etEmailOrPhone.getText().toString();
             String Password = etPassword.getText().toString();

             if(TextUtils.isEmpty(EmailOrPhone))
             {
                 etEmailOrPhone.setError("Email or Phone cannot be empty");
                 return;
             }
             if (TextUtils.isEmpty(Password))
             {
                 etPassword.setError("Password cannot be empty");
                 return;
             }

             if(TextUtils.equals(EmailOrPhone, CORRECT_EMAIL) && TextUtils.equals(Password, CORRECT_PASSWORD))

             {
                 //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();

               Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
               startActivity(intent);
             }
             else
             {
                 Snackbar.make(v,"Incorrect email or password.PLease try again",Snackbar.LENGTH_INDEFINITE).show();
             }

            }


        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"\"Forgot password\" is coming soon",Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}
