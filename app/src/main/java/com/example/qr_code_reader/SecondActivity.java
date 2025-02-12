package com.example.qr_code_reader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private TextView urlTextView;
    private Button fetchMoviesButton, addMovieButton;
    private ListView listView;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList;
    private String baseUrl;  // A QR kód alapján kapott URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Az intentből kinyerjük a QR kódot tartalmazó base URL-t
        Intent intent = getIntent();
        baseUrl = intent.getStringExtra("BASE_URL");

        urlTextView = findViewById(R.id.urlTextView);
        fetchMoviesButton = findViewById(R.id.fetchMoviesButton);
        addMovieButton = findViewById(R.id.addMovieButton);
        listView = findViewById(R.id.listView);

        // Megjelenítjük a base URL-t
        urlTextView.setText(baseUrl);

        // Filmlista inicializálása
        movieList = new ArrayList<>();

        // A gombok funkciói
        fetchMoviesButton.setOnClickListener(v -> fetchMovies());

        addMovieButton.setOnClickListener(v -> openAddMovieActivity());

        // Adapter beállítása
        movieAdapter = new MovieAdapter(this, movieList);
        listView.setAdapter(movieAdapter);
    }

    // Filmek lekérése Retrofit-tel
    private void fetchMovies() {
        // Itt a Retrofit API hívást implementálhatjuk a baseUrl alapján
        // Egy egyszerű példa arra, hogy a lista megtöltődhet a választott filmes API segítségével
        // Most egy egyszerű bemutató adatokat adunk a listához

        // Példa adatok
        movieList.clear();
        movieList.add(new Movie("Christopher Nolan", 150, 4.9f, "Sci-Fi", 2020));
        movieList.add(new Movie("Steven Spielberg", 120, 4.7f, "Adventure", 2018));

        movieAdapter.notifyDataSetChanged();  // Frissítjük a listát
        Toast.makeText(this, "Filmek lekérve!", Toast.LENGTH_SHORT).show();
    }

    // Új film hozzáadásának Activity-jére való navigálás
    private void openAddMovieActivity() {
        Intent intent = new Intent(this, AddMovieActivity.class);
        intent.putExtra("BASE_URL", baseUrl);  // Átadjuk a base URL-t
        startActivityForResult(intent, 1);  // Visszatéréskor frissítjük a filmlistát
    }

    // Ha új film lett hozzáadva, akkor frissítjük a listát
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            fetchMovies();  // Frissítjük a listát
        }
    }
}
