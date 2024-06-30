package com.example.quotesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        Button nextButton = findViewById(R.id.nextButton);
        ImageButton shareButton = findViewById(R.id.shareButton);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomQuote();
            }
        });

        // Set listener for share button
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        // Set listener for bottom navigation view
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Display a random quote when the app starts
        displayRandomQuote();
    }

    private void displayRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(Quotes.quotes.length);
        String randomQuote = Quotes.quotes[index];
        quoteTextView.setText(randomQuote);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener;

    {
        navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.fragment_home) {
                    // Handle navigation to Home fragment or activity
                    // selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.fragment_container) {
                    // Handle navigation to Favorite fragment or activity
                    navigateToFavorite();
                }

                return true; // Return true to indicate navigation item selection was handled
            }
        };
    }

    private void navigateToFavorite() {
        Toast.makeText(this, "Navigate to Favorite", Toast.LENGTH_SHORT).show();

    }
}
