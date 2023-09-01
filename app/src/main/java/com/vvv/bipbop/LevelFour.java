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

        bubble1.setOnClickListener(view1 -> bubble1.setImageResource(R.drawable.purple_small_popped));
        bubble2.setOnClickListener(view1 -> bubble2.setImageResource(R.drawable.pink_small_popped));
        bubble3.setOnClickListener(view1 -> bubble3.setImageResource(R.drawable.red_small_popped));
        bubble4.setOnClickListener(view1 -> bubble4.setImageResource(R.drawable.orange_small_popped));
        bubble5.setOnClickListener(view1 -> bubble5.setImageResource(R.drawable.yellow_small_popped));
        bubble6.setOnClickListener(view1 -> bubble6.setImageResource(R.drawable.green_small_popped));
        bubble7.setOnClickListener(view1 -> bubble7.setImageResource(R.drawable.blue_small_popped));
        bubble8.setOnClickListener(view1 -> bubble8.setImageResource(R.drawable.indigo_small_popped));


        return view;
    }
}
