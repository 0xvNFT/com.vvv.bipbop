package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LevelTwo extends Fragment {
    private boolean bubble1Popped = false;
    private boolean bubble2Popped = false;
    private boolean bubble3Popped = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_two, container, false);

        ImageView bubble1 = view.findViewById(R.id.bubble1);
        ImageView bubble2 = view.findViewById(R.id.bubble2);
        ImageView bubble3 = view.findViewById(R.id.bubble3);

        ((MainActivity) requireActivity()).currentLevel(2);

        bubble1.setOnClickListener(view1 -> {
            if (!bubble1Popped) {
                bubble1.setImageResource(R.drawable.orange_big_popped);
                bubble1Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble1.setEnabled(false);
            }
        });
        bubble2.setOnClickListener(view1 -> {
            if (!bubble2Popped) {
                bubble2.setImageResource(R.drawable.red_big_popped);
                bubble2Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble2.setEnabled(false);
            }
        });
        bubble3.setOnClickListener(view1 -> {
            if (!bubble3Popped) {
                bubble3.setImageResource(R.drawable.yellow_big_popped);
                bubble3Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble3.setEnabled(false);
            }
        });

        return view;
    }
}
