package com.vvv.bipbop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ScoreListAdapter extends ArrayAdapter<Integer> {
    private final Context context;
    private final List<Integer> scores;

    public ScoreListAdapter(Context context, List<Integer> userScores) {
        super(context, R.layout.list_item_score, userScores);
        this.context = context;
        this.scores = userScores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_item_score, null);
        }

        TextView scoreTextView = view.findViewById(R.id.scoreItemTextView);

        scoreTextView.setText(String.valueOf(scores.get(position)));

        return view;
    }
}
