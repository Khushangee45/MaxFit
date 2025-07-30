package com.example.maxfit.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.maxfit.HomeActivity;
import com.example.maxfit.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView name = view.findViewById(R.id.profile_name);
        TextView email = view.findViewById(R.id.profile_email);

        // Sample data – replace with real user info
        name.setText("User");
        email.setText("user@example.com");

        // Set click listeners
        view.findViewById(R.id.profile_option_activities).setOnClickListener(v ->
                Toast.makeText(getContext(), "My Activities clicked", Toast.LENGTH_SHORT).show());

        view.findViewById(R.id.profile_option_edit).setOnClickListener(v ->
                Toast.makeText(getContext(), "Edit Profile clicked", Toast.LENGTH_SHORT).show());

        view.findViewById(R.id.profile_option_settings).setOnClickListener(v ->
                Toast.makeText(getContext(), "Settings clicked", Toast.LENGTH_SHORT).show());

        view.findViewById(R.id.profile_option_logout).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });
        return view;
    }
}


/*public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}*/