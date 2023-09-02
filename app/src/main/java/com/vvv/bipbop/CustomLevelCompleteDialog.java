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
    public int score;
    public int timeRemaining;

    public CustomLevelCompleteDialog(@NonNull Context context, int score, int timeRemaining) {
        super(context);
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

