package com.vvv.bipbop;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.MessageFormat;
import java.util.Objects;

public class CustomLevelCompleteDialog extends Dialog {
    private final TextView scoreTextView;
    private final TextView timeRemainingTextView;
    private final TextView nextLevelTexView;
    protected int score;
    protected int timeRemaining;

    public CustomLevelCompleteDialog(@NonNull Context context, int score, int timeRemaining) {
        super(context);
        View decorView = Objects.requireNonNull(getWindow()).getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        this.score = score;
        this.timeRemaining = timeRemaining;

        setContentView(R.layout.custom_dialog_level_complete);
        setTitle(null);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Objects.requireNonNull(getWindow()).setBackgroundDrawableResource(android.R.color.transparent);

        scoreTextView = findViewById(R.id.scoreTextView);
        timeRemainingTextView = findViewById(R.id.timeRemainingTextView);
        nextLevelTexView = findViewById(R.id.nextLevelTexView);
    }

    public void setScore(int score) {
        this.score = score;
        scoreTextView.setText(MessageFormat.format("Score: {0}", score));
    }

    public void setTimeRemaining(int timeRemainingInSeconds) {
        this.timeRemaining = timeRemainingInSeconds;
        timeRemainingTextView.setText(MessageFormat.format("Time Remaining: {0}s", timeRemainingInSeconds));
    }

    public void setNextLevelClickListener(View.OnClickListener listener) {
        nextLevelTexView.setOnClickListener(listener);
    }
}

