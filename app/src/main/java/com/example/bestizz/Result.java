package com.example.bestizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bestizz.databinding.ActivityResultBinding;

public class Result extends AppCompatActivity {

    private ActivityResultBinding binding;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupération prénom + score
        preferences = getSharedPreferences("QuizAppPrefs", MODE_PRIVATE);
        String userName = preferences.getString("username", "Joueur");
        Integer score = getIntent().getIntExtra("score", 0);

        Log.d("Result", "Resultat passe = " + score);

        // Affichage dynamique
        String greeting = getString(R.string.placeholder_greeting, userName);
        binding.Name.setText(greeting);
        binding.Score.setText(getString(R.string.placeholder_score, score));
        binding.Message.setText(getMessage(score));

        // Affichage de l’image selon le score
        ImageView resultImage = binding.resultImage; // l’id doit exister dans activity_result.xml
        switch (score) {
            case 0:
                resultImage.setImageResource(R.drawable.score0_img);
                break;
            case 1:
                resultImage.setImageResource(R.drawable.score1_img);
                break;
            case 2:
                resultImage.setImageResource(R.drawable.score2_img);
                break;
            case 3:
                resultImage.setImageResource(R.drawable.score3_img);
                break;
            case 4:
                resultImage.setImageResource(R.drawable.score4_img);
                break;
            case 5:
                resultImage.setImageResource(R.drawable.score5_img);
                break;
            default:
                break;
        }

        // Bouton Rejouer
        binding.Replay.setOnClickListener(v -> {
            Intent intent = new Intent(this, Quizz.class);
            startActivity(intent);
            finish();
        });

        // Bouton Accueil
        binding.HomePage.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private String getMessage(int score) {
        switch (score) {
            case 0:
                return getString(R.string.message_score_0);
            case 1:
                return getString(R.string.message_score_1);
            case 2:
                return getString(R.string.message_score_2);
            case 3:
                return getString(R.string.message_score_3);
            case 4:
                return getString(R.string.message_score_4);
            case 5:
                return getString(R.string.message_score_5);
            default:
                return getString(R.string.message_score_unknown);
        }
    }

}