package com.example.bestizz;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.CheckBox;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.bestizz.databinding.ActivityQuizzBinding;

public class Quizz extends AppCompatActivity {
    private ActivityQuizzBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quizz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(view -> {
            Log.i("Quizz", "Button Submit");

            int score = 0;

            if(binding.chkHafsa1.isChecked()) {
                score++;
                Log.d("Quizz", "Bonne réponse à la 1 : " + score);
            }
            if(!binding.chkHafsa2.isChecked() &&
                    binding.chkVictor2.isChecked() &&
                    binding.chkEnzo2.isChecked() &&
                    binding.chkStadiane2.isChecked()) {
                score++;
                Log.d("Quizz", "Bonne réponse à la 2 : " + score);
            }
            if(binding.chkMartin3.isChecked()){
                score++;
                Log.d("Quizz", "Bonne réponse à la 3 : " + score);
            }
            if(binding.chkElsa4.isChecked()){
                score++;
                Log.d("Quizz", "Bonne réponse à la 4 : " + score);
            }
            if(binding.chkEnzo5.isChecked()){
                score++;
                Log.d("Quizz", "Bonne réponse à la 5 : " + score);
            }


            getSharedPreferences("quizz_activity", MODE_PRIVATE).edit().putInt("score", score).apply();
            Log.d("MainActivity", "score final = " + score);

            Intent intent = new Intent(this, Result.class);
            intent.putExtra("score", score);

            startActivity(intent);
        });
    }
}