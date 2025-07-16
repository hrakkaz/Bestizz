package com.example.bestizz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bestizz.databinding.ActivityQuizzBinding;

public class Quizz extends AppCompatActivity {

    private ActivityQuizzBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialisation de la musique de fond
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true); // Pour que la musique tourne en boucle
        mediaPlayer.start();

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

            // Arrêter la musique avant de quitter
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }

            getSharedPreferences("quizz_activity", MODE_PRIVATE).edit().putInt("score", score).apply();
            Log.d("Quizz", "score final = " + score);

            Intent intent = new Intent(this, Result.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
