package com.vvv.bipbop;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    private ImageView home;
    private ImageView pause_play;
    private ImageView leaderboard;
    private TextView score;
    private int userScore = 0;
    private TextView timer;
    private TextView level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home);
        pause_play = findViewById(R.id.pause_play);
        level = findViewById(R.id.level);
        score = findViewById(R.id.score);
        leaderboard = findViewById(R.id.leaderboard);

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainer, new LevelFour());
            ft.commit();
        }
    }

    public void updateScore(int points) {
        userScore += points;
        score.setText(MessageFormat.format("Score: {0}", userScore));
    }

    public void currentLevel(int levels) {
        level.setText(MessageFormat.format("Level: {0}", levels));
    }

}