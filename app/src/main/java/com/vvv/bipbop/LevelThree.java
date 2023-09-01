package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LevelThree extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_three, container, false);

        ImageView bubble1 = view.findViewById(R.id.bubble1);
        ImageView bubble2 = view.findViewById(R.id.bubble2);
        ImageView bubble3 = view.findViewById(R.id.bubble3);
        ImageView bubble4 = view.findViewById(R.id.bubble4);
        ImageView bubble5 = view.findViewById(R.id.bubble5);

        bubble1.setOnClickListener(view1 -> bubble1.setImageResource(R.drawable.red_big_popped));
        bubble2.setOnClickListener(view1 -> bubble2.setImageResource(R.drawable.blue_big_popped));
        bubble3.setOnClickListener(view1 -> bubble3.setImageResource(R.drawable.green_big_popped));
        bubble4.setOnClickListener(view1 -> bubble4.setImageResource(R.drawable.pink_popped));
        bubble5.setOnClickListener(view1 -> bubble5.setImageResource(R.drawable.yellow_reg_popped));

        return view;
    }
}
