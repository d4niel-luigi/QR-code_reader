package com.example.qr_code_reader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size(); // Visszaadja a lista méretét
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position); // Az aktuális film objektumot adja vissza
    }

    @Override
    public long getItemId(int position) {
        return position; // A lista pozíciója (hash vagy más, de most elég a pozíció)
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Az egyes elemek megjelenítéséhez egy View objektumot kell létrehozni
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_movieadapter, parent, false);
        }

        Movie movie = movies.get(position);

        // Adatok kitöltése a UI elemekbe
        TextView directorTextView = convertView.findViewById(R.id.directorTextView);
        TextView durationTextView = convertView.findViewById(R.id.durationTextView);
        TextView ratingTextView = convertView.findViewById(R.id.ratingTextView);
        TextView categoryTextView = convertView.findViewById(R.id.categoryTextView);

        directorTextView.setText(movie.getDirector());
        durationTextView.setText(formatDuration(movie.getDuration()));
        ratingTextView.setText(String.valueOf(movie.getRating()));
        categoryTextView.setText(movie.getCategory());

        return convertView;
    }

    private String formatDuration(int durationInMinutes) {
        int hours = durationInMinutes / 60;
        int minutes = durationInMinutes % 60;
        return hours + " óra " + minutes + " perc";
    }
}
