package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Admin on 11/16/17.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etRegisterPassword;
    private EditText etConfirmPassword;
    private RadioGroup rdgGender;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    private EditText etAddress;
    private CheckBox chkhome;
    private CheckBox chkawayhome;
    private Button btnRegister;

    public static Intent newIntent (Context context)
    {
        Intent intent = new Intent(context,RegisterActivity.class);
                return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        rdgGender = findViewById(R.id.rdg_gender);
        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);
        etAddress = findViewById(R.id.et_address);
        chkhome = findViewById(R.id.checkbox_home);
        btnRegister = findViewById(R.id.btn_register_confirm);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString();
                String Phone = etPhone.getText().toString();
                String Email = etEmail.getText().toString();
                String Password = etRegisterPassword.getText().toString();
                String ConfirmPassword = etConfirmPassword.getText().toString();
                String Address = etAddress.getText().toString();

//                String radioMale=((RadioButton)findViewById(rdgGender.getCheckedRadioButtonId())).getText().toString();
//                String radioFemale=((RadioButton)findViewById(rdgGender.getCheckedRadioButtonId())).getText().toString();


                if (TextUtils.isEmpty(Name)) {
                    etName.setError("Enter a name ");
                    return;
                }
                if (TextUtils.isEmpty(Email)) {
                    etEmail.setError("Enter a email address");
                    return;
                }
                if (TextUtils.isEmpty(Phone)) {
                    etPhone.setError("Enter a phone number");
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    etRegisterPassword.setError("Enter a password");
                    return;
                }
                if (TextUtils.isEmpty(ConfirmPassword)) {
                    etConfirmPassword.setError("Enter a confirm password");
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    etAddress.setError("Enter an address");
                    return;

                }
                if (radioFemale.isChecked() || radioMale.isChecked()) {
                    Log.d("LOG", "Operation success");
                } else {
                    Toast.makeText(RegisterActivity.this, "Please choose a gender", Toast.LENGTH_SHORT).show();
                    return;
                }



                if (TextUtils.equals(Password, ConfirmPassword)) {

                    Intent intent = LoginActivity.newIntent(getApplicationContext());
                    startActivity(intent);


                }
                else
                {
                    Snackbar.make(v,"Password and Confrim password must be the same",Snackbar.LENGTH_INDEFINITE).show();
                }


            }

        });
    }

    }

