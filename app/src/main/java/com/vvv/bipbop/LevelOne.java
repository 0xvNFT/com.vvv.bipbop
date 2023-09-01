package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LevelOne extends Fragment {
    private boolean bubble1Popped = false;
    private boolean bubble2Popped = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_one, container, false);

        ImageView bubble1 = view.findViewById(R.id.bubble1);
        ImageView bubble2 = view.findViewById(R.id.bubble2);
        ((MainActivity) requireActivity()).currentLevel(1);

        bubble1.setOnClickListener(view1 -> {
            if (!bubble1Popped) {
                bubble1.setImageResource(R.drawable.purple_big_popped);
                bubble1Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble1.setEnabled(false);
            }
        });
        bubble2.setOnClickListener(view1 -> {
            if (!bubble2Popped) {
                bubble2.setImageResource(R.drawable.purple_big_popped);
                bubble2Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble2.setEnabled(false);
            }
        });


        return view;
    }
}
