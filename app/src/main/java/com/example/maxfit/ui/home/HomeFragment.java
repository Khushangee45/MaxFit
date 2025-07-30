package com.example.maxfit.ui.home;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.maxfit.R;
import com.example.maxfit.databinding.FragmentHomeBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    CircularProgressBar circularProgressBar,circularProgressBarHeart;
    TextView progressText, progressTextHeart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        circularProgressBar = root.findViewById(R.id.circularProgressBar);
        progressText = root.findViewById(R.id.progressText);

        // Set max value
        int maxSteps = 8000;
        int currentSteps = 7589;

        circularProgressBar.setProgressMax(maxSteps);
        circularProgressBar.setProgressWithAnimation(currentSteps, 1500L);

        // Animate number text from 0 to 3609
        ValueAnimator animator = ValueAnimator.ofInt(0, (int) currentSteps);
        animator.setDuration(1500);
        animator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            progressText.setText(String.valueOf(value));
        });
        animator.start();

        circularProgressBarHeart = root.findViewById(R.id.circularProgressBarHeart);
        progressTextHeart = root.findViewById(R.id.progressTextHeart);

        // Set max value
        int maxHeart = 20;
        int currentHeart = 18;

        circularProgressBarHeart.setProgressMax(maxHeart);
        circularProgressBarHeart.setProgressWithAnimation(currentHeart, 1500L);

        // Animate number text from 0 to 3609
        ValueAnimator animatorHeart = ValueAnimator.ofInt(0, (int) currentHeart);
        animatorHeart.setDuration(1500);
        animatorHeart.addUpdateListener(animationHeart -> {
            int valueHeart = (int) animationHeart.getAnimatedValue();
            progressTextHeart.setText(String.valueOf(valueHeart));
        });
        animatorHeart.start();
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}