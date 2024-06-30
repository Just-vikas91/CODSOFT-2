package com.example.quotesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import android.widget.TextView;

public class FavoriteFragment extends Fragment {

    private MaterialButton favoriteButton;
    private TextView quoteTextView;
    private MaterialCardView quoteCard;
    private ImageButton sharebutton;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        // Initialize views
        favoriteButton = view.findViewById(R.id.favoriteButton);
        quoteTextView = view.findViewById(R.id.quoteTextView);
        quoteCard = view.findViewById(R.id.QuoteCard);
        sharebutton = view.findViewById(R.id.shareButton);

        // Set click listener for favorite button
             favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle saving quote to favorites
                    String quote = quoteTextView.getText().toString();

                    // Example: Save quote to database or perform relevant action
                    // For now, just show a toast
                    Toast.makeText(getActivity(), "Quote saved to favorites: " + quote, Toast.LENGTH_SHORT).show();
                }
            });

        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share functionality
                String quoteText = quoteTextView.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, quoteText);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });


        return view;
    }
}
