package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LevelFour extends Fragment {

    private boolean bubble1Popped = false;
    private boolean bubble2Popped = false;
    private boolean bubble3Popped = false;
    private boolean bubble4Popped = false;
    private boolean bubble5Popped = false;
    private boolean bubble6Popped = false;
    private boolean bubble7Popped = false;
    private boolean bubble8Popped = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_four, container, false);

        ImageView bubble1 = view.findViewById(R.id.bubble1);
        ImageView bubble2 = view.findViewById(R.id.bubble2);
        ImageView bubble3 = view.findViewById(R.id.bubble3);
        ImageView bubble4 = view.findViewById(R.id.bubble4);
        ImageView bubble5 = view.findViewById(R.id.bubble5);
        ImageView bubble6 = view.findViewById(R.id.bubble6);
        ImageView bubble7 = view.findViewById(R.id.bubble7);
        ImageView bubble8 = view.findViewById(R.id.bubble8);

        ((MainActivity) requireActivity()).currentLevel(4);

        bubble1.setOnClickListener((view1 -> {
            if (!bubble1Popped) {
                bubble1.setImageResource(R.drawable.purple_small_popped);
                bubble1Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble1.setEnabled(false);
            }
        }));
        bubble2.setOnClickListener((view1 -> {
            if (!bubble2Popped) {
                bubble2.setImageResource(R.drawable.pink_small_popped);
                bubble2Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble2.setEnabled(false);
            }
        }));
        bubble3.setOnClickListener((view1 -> {
            if (!bubble3Popped) {
                bubble3.setImageResource(R.drawable.red_small_popped);
                bubble3Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble3.setEnabled(false);
            }
        }));
        bubble4.setOnClickListener((view1 -> {
            if (!bubble4Popped) {
                bubble4.setImageResource(R.drawable.orange_small_popped);
                bubble4Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble4.setEnabled(false);
            }
        }));
        bubble5.setOnClickListener((view1 -> {
            if (!bubble5Popped) {
                bubble5.setImageResource(R.drawable.yellow_small_popped);
                bubble5Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble5.setEnabled(false);
            }
        }));
        bubble6.setOnClickListener((view1 -> {
            if (!bubble6Popped) {
                bubble6.setImageResource(R.drawable.green_small_popped);
                bubble6Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble6.setEnabled(false);
            }
        }));
        bubble7.setOnClickListener((view1 -> {
            if (!bubble7Popped) {
                bubble7.setImageResource(R.drawable.blue_small_popped);
                bubble7Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble7.setEnabled(false);
            }
        }));
        bubble8.setOnClickListener((view1 -> {
            if (!bubble8Popped) {
                bubble8.setImageResource(R.drawable.indigo_small_popped);
                bubble8Popped = true;
                ((MainActivity) requireActivity()).updateScore(10);
                bubble8.setEnabled(false);
            }
        }));

        return view;
    }
}
