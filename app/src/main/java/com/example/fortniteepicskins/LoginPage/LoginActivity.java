package com.example.fortniteepicskins.LoginPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fortniteepicskins.databinding.ActivityLoginBinding;

import org.w3c.dom.Text;

import java.time.temporal.Temporal;

public class LoginActivity extends AppCompatActivity {

    private TextView mLoginDisplay;
    private TextView mAdminDisplay;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private EditText mAdminCodeField;
    private Button mLoginButton;
    private Button mRegisterButton;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mLoginDisplay = binding.loginDisplay;
        mAdminDisplay = binding.loginAdminDisplay;

        mUsernameField = binding.loginUsernameEditText;
        mPasswordField = binding.loginPasswordEditText;
        mAdminCodeField = binding.loginAdminCodeText;

        mLoginButton = binding.loginLoginButton;
    }
}