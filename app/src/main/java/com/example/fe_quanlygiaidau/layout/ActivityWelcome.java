package com.example.fe_quanlygiaidau.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fe_quanlygiaidau.activity.MainActivity;
import com.example.fe_quanlygiaidau.databinding.ActivityWelcomeBinding;

public class ActivityWelcome extends AppCompatActivity {

    private ActivityWelcomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getSupportActionBar().hide();
        binding=ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityWelcome.this, MainActivity.class));
            }
        });

    }
}