package com.vvv.bipbop;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Objects;

public class CustomTimeIsUpDialog extends Dialog {
    private final TextView retryTextView;
    protected int timeRemaining;

    public CustomTimeIsUpDialog(@NonNull Context context, int timeRemaining) {
        super(context);
        View decorView = Objects.requireNonNull(getWindow()).getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        this.timeRemaining = timeRemaining;
        setContentView(R.layout.custom_dialog_timer_expired);
        setTitle(null);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Objects.requireNonNull(getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        retryTextView = findViewById(R.id.retryTextView);
    }

    public void setRetryClickListener(View.OnClickListener listener) {
        retryTextView.setOnClickListener(listener);
    }

}
