package com.vvv.bipbop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {
    private List<Integer> userScores;
    private ScoreListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        ListView scoreListView = findViewById(R.id.scoreList);

        userScores = getUserScores();
        if (userScores == null) {
            userScores = new ArrayList<>();
        }
        adapter = new ScoreListAdapter(this, userScores);


        int userScore = getUserScoreFromPrefs();
        addNewScore(userScore);

        scoreListView.setAdapter(adapter);
    }

    private List<Integer> getUserScores() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String scoresString = sharedPreferences.getString("USER_SCORES", "");
        List<Integer> scores = new ArrayList<>();

        if (!scoresString.isEmpty()) {
            String[] scoreArray = scoresString.split(",");
            for (String scoreStr : scoreArray) {
                scores.add(Integer.parseInt(scoreStr));
            }
        }

        return scores;
    }

    private int getUserScoreFromPrefs() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getInt("USER_SCORE", 0);
    }

    private void addNewScore(int newScore) {
        userScores.add(newScore);

        adapter.notifyDataSetChanged();

        saveUserScores(userScores);
    }

    private void saveUserScores(List<Integer> scores) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        StringBuilder scoresString = new StringBuilder();
        for (Integer score : scores) {
            scoresString.append(score).append(",");
        }

        if (scoresString.length() > 0) {
            scoresString.deleteCharAt(scoresString.length() - 1);
        }

        editor.putString("USER_SCORES", scoresString.toString());
        editor.apply();
    }
}
