package com.example.bestizz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bestizz.databinding.ActivityQuizzBinding;

public class Quizz extends AppCompatActivity {

    private ActivityQuizzBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnResultat.setOnClickListener(view -> {
            Log.i("QuizzActivity", "Click on btnResultat");
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        });
    }
}
