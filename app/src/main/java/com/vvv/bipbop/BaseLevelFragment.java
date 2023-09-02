package com.vvv.bipbop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseLevelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Implement common onCreateView logic here
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void onLevelCompleted() {
        showLevelCompleteDialog();
    }

    protected void showLevelCompleteDialog() {
        pauseTimer();
        CustomLevelCompleteDialog dialog = new CustomLevelCompleteDialog(requireContext(), ((MainActivity) requireActivity()).getScore(), ((MainActivity) requireActivity()).getTimeRemaining());

        dialog.setScore(((MainActivity) requireActivity()).getScore());
        dialog.setTimeRemaining(((MainActivity) requireActivity()).getTimeRemaining());
        dialog.setNextLevelClickListener(view -> {
            ((MainActivity) requireActivity()).proceedToNextLevel();
            dialog.dismiss();
            restartTimer();
        });

        dialog.show();
    }

    protected void pauseTimer() {
        if (((MainActivity) requireActivity()).timer != null) {
            ((MainActivity) requireActivity()).timer.cancel();
        }
    }

    protected void restartTimer() {
        ((MainActivity) requireActivity()).timer.cancel();
        ((MainActivity) requireActivity()).timer.start();
    }

}
