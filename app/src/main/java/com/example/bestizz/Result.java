package com.example.bestizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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
        int score = getIntent().getIntExtra("score", 0);

        // Affichage dynamique
        binding.Name.setText("Bonjour " + userName);
        binding.Score.setText("Votre Score est : " + score + " /5");
        binding.Message.setText(getMessage(score));

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
                return "😵 0/5 ! Ouch... T’es sûr(e) que tu fais partie du groupe ? 😂";
            case 1:
                return "😬 1/5 ! Hmm… On dirait que t’as un peu zappé les discussions de groupe !";
            case 2:
                return "🤔 2/5 ! Tu nous connais un peu, mais y’a des trous dans ta mémoire 👀";
            case 3:
                return "😎 3/5 ! Pas mal ! On voit que tu nous connais, mais y’a encore des secrets à découvrir 😉";
            case 4:
                return "🔥 4/5 ! Woah, presque un(e) expert(e) en potins de besties ! T’es à deux doigts du titre de Bestie suprême 💖";
            case 5:
                return "🏆 5/5 ! INCROYABLE ! Toi, c’est sûr, t’es le/la bestie officiel(le), tu connais tout sur tout 😍";
            default:
                return "🤨 Score inconnu… Les besties valideront-ils ce score ? 👀";
        }
    }

}
