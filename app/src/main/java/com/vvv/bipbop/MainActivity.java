package com.vvv.bipbop;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.MessageFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public CountDownTimer timer;
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
        timer = startTimer();

        home = findViewById(R.id.home);
        pause_play = findViewById(R.id.pause_play);
        level = findViewById(R.id.level);
        score = findViewById(R.id.score);
        timerTextView = findViewById(R.id.timer);
        leaderboard = findViewById(R.id.leaderboard);

        leaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainer, new LevelOne());
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

    private CountDownTimer startTimer() {
        return new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;
                String time = String.format(Locale.US, "%02d:%02d", minutes, seconds);
                timerTextView.setText(time);
            }
            public void onFinish() {
                timerTextView.setText(getString(R.string.timer_text));
            }
        }.start();
    }

    public void proceedToNextLevel() {
        int nextLevel = getCurrentLevel() + 1;
        Fragment nextLevelFragment = getLevelFragment(nextLevel);
        if (nextLevelFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, nextLevelFragment);
            ft.commit();
            currentLevel(nextLevel);
        } else {
            finish();
        }
    }

    private int getCurrentLevel() {
        return 1;
    }

    private Fragment getLevelFragment(int level) {
        switch (level) {
            case 1:
                return new LevelOne();
            case 2:
                return new LevelTwo();
            case 3:
                return new LevelThree();
            case 4:
                return new LevelFour();
            default:
                return null;
        }
    }


    public int getScore() {
        return userScore;
    }

    public int getTimeRemaining() {
        String timerText = timerTextView.getText().toString();
        String[] timeParts = timerText.split(":");

        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            return minutes * 60 + seconds;
        } else {
            return 0;
        }
    }


//    public int getTimeRemaining() {
//        return timerTextView.getText().length();
//    }
}