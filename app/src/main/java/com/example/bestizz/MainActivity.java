package com.example.bestizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bestizz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnJouer.setOnClickListener(view -> {
            String prenom = binding.nom.getText().toString().trim();

            // Sauvegarder le prénom dans SharedPreferences
            preferences = getSharedPreferences("QuizAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", prenom);
            editor.apply();

            // Aller vers la page Quizz
            Log.i("MainActivity", "Click on play");
            Intent intent = new Intent(this, Quizz.class);
            startActivity(intent);
        });

    }
}
