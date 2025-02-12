package com.example.qr_code_reader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMovieActivity extends AppCompatActivity {

    private EditText directorEditText, durationEditText, ratingEditText, categoryEditText, yearEditText;
    private Button addButton;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        // Az intentből kinyerjük a base URL-t
        Intent intent = getIntent();
        baseUrl = intent.getStringExtra("BASE_URL");

        // UI elemek
        directorEditText = findViewById(R.id.directorEditText);
        durationEditText = findViewById(R.id.durationEditText);
        ratingEditText = findViewById(R.id.ratingEditText);
        categoryEditText = findViewById(R.id.categoryEditText);
        yearEditText = findViewById(R.id.yearEditText);
        addButton = findViewById(R.id.addButton);

        // Film hozzáadása
        addButton.setOnClickListener(v -> addMovie());
    }

    private void addMovie() {
        String director = directorEditText.getText().toString();
        String durationStr = durationEditText.getText().toString();
        String ratingStr = ratingEditText.getText().toString();
        String category = categoryEditText.getText().toString();
        String yearStr = yearEditText.getText().toString();

        if (director.isEmpty() || durationStr.isEmpty() || ratingStr.isEmpty() || category.isEmpty() || yearStr.isEmpty()) {
            Toast.makeText(this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
            return;
        }

        int duration = Integer.parseInt(durationStr);
        float rating = Float.parseFloat(ratingStr);
        int year = Integer.parseInt(yearStr);

        // Itt az API POST kérését kell megvalósítani (a base URL és a film adatai alapján)
        // Például, egy Retrofit hívással elküldhetjük az adatokat az API-ra.

        // Sikeres film hozzáadása után
        Toast.makeText(this, "Film hozzáadva!", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish(); // Bezárja az Activity-t és visszatér a SecondActivity-ba
    }
}

