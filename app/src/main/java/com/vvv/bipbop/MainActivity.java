package com.vvv.bipbop;

import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public CountDownTimer timer;
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

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(v -> {
            onBackPressed();
        });
        ImageView pause_play = findViewById(R.id.pause_play);
        pause_play.setOnClickListener(v -> {
            onPause();
        });
        level = findViewById(R.id.level);
        score = findViewById(R.id.score);
        timerTextView = findViewById(R.id.timer);
        ImageView leaderboard = findViewById(R.id.leaderboard);

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
        saveScore(userScore);
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
                userScore = 0;
                score.setText(MessageFormat.format("Score: {0}", userScore));
                showTimeIsUpDialog();
            }
        }.start();
    }

    private void showTimeIsUpDialog() {
        CustomTimeIsUpDialog dialog = new CustomTimeIsUpDialog(this, this.getTimeRemaining());
        dialog.show();

        dialog.setRetryClickListener(view -> {
            retryCurrentLevel();
            timer.start();

            dialog.dismiss();
        });
    }

    private void retryCurrentLevel() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, Objects.requireNonNull(getLevelFragment(getCurrentLevel())));
        ft.commit();
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

    public int getCurrentLevel() {
        String levelText = level.getText().toString();
        String numericPart = levelText.replaceAll("[^\\d.]", "");
        return Integer.parseInt(numericPart);
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

    private void saveScore(int userScore) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("USER_SCORE", userScore);
        editor.apply();
    }

    public void onPause() {
        super.onPause();
        pauseTimer();
    }

    private void pauseTimer() {
        timer.cancel();
    }

    public void onResume() {
        super.onResume();
        restartTimer();
    }

    private void restartTimer() {
        timer.start();
    }
}