package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LevelThree extends BaseLevelFragment {

    private boolean bubble1Popped = false;
    private boolean bubble2Popped = false;
    private boolean bubble3Popped = false;
    private boolean bubble4Popped = false;
    private boolean bubble5Popped = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_three, container, false);

        ImageView bubble1 = view.findViewById(R.id.bubble1);
        ImageView bubble2 = view.findViewById(R.id.bubble2);
        ImageView bubble3 = view.findViewById(R.id.bubble3);
        ImageView bubble4 = view.findViewById(R.id.bubble4);
        ImageView bubble5 = view.findViewById(R.id.bubble5);

        ((MainActivity) requireActivity()).currentLevel(3);

        bubble1.setOnClickListener((view1 -> {
            if (!bubble1Popped) {
                bubble1.setImageResource(R.drawable.red_big_popped);
                bubble1Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble1.setEnabled(false);
                if (isLevelThreeCompleted()) {
                    onLevelCompleted();
                }
            }
        }));

        bubble2.setOnClickListener((view1 -> {
            if (!bubble2Popped) {
                bubble2.setImageResource(R.drawable.blue_big_popped);
                bubble2Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble2.setEnabled(false);
                if (isLevelThreeCompleted()) {
                    onLevelCompleted();
                }
            }
        }));
        bubble3.setOnClickListener((view1 -> {
            if (!bubble3Popped) {
                bubble3.setImageResource(R.drawable.green_big_popped);
                bubble3Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble3.setEnabled(false);
                if (isLevelThreeCompleted()) {
                    onLevelCompleted();
                }
            }
        }));
        bubble4.setOnClickListener((view1 -> {
            if (!bubble4Popped) {
                bubble4.setImageResource(R.drawable.pink_popped);
                bubble4Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble4.setEnabled(false);
                if (isLevelThreeCompleted()) {
                    onLevelCompleted();
                }
            }
        }));
        bubble5.setOnClickListener((view1 -> {
            if (!bubble5Popped) {
                bubble5.setImageResource(R.drawable.yellow_reg_popped);
                bubble5Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble5.setEnabled(false);
                if (isLevelThreeCompleted()) {
                    onLevelCompleted();
                }
            }
        }));

        return view;
    }

    protected boolean isLevelThreeCompleted() {
        return bubble1Popped && bubble2Popped && bubble3Popped && bubble4Popped && bubble5Popped;
    }
}
