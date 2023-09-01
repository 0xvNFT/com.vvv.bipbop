package com.vvv.bipbop;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.MessageFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ImageView home;
    private ImageView pause_play;
    private ImageView leaderboard;
    private TextView score;
    private int userScore = 0;
    private TextView timerTextView;

    private TextView level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home);
        pause_play = findViewById(R.id.pause_play);
        level = findViewById(R.id.level);
        score = findViewById(R.id.score);
        timerTextView = findViewById(R.id.timer);
        leaderboard = findViewById(R.id.leaderboard);

        startTimer();

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

    private void startTimer() {
        new CountDownTimer(30000, 1000) { // 30 seconds, tick every 1 second
            public void onTick(long millisUntilFinished) {
                // Calculate minutes and seconds from milliseconds
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;

                // Format the time as "mm:ss"
                String time = String.format(Locale.US, "%02d:%02d", minutes, seconds);

                // Update the timer TextView with the formatted time
                timerTextView.setText(time);
            }

            public void onFinish() {
                // Handle timer completion here, e.g., end the game or take appropriate action
                timerTextView.setText(getString(R.string.timer_text));
            }
        }.start();
    }


}