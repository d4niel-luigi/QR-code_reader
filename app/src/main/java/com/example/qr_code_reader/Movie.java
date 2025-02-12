package com.example.qr_code_reader;
public class Movie {

    private String director;    // Rendező
    private int duration;       // Időtartam percben
    private float rating;       // Értékelés
    private String category;    // Kategória
    private int year;           // Megjelenési év

    // Alapértelmezett konstruktor
    public Movie() {
    }

    // Paraméteres konstruktor
    public Movie(String director, int duration, float rating, String category, int year) {
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.category = category;
        this.year = year;
    }

    // Getter és Setter metódusok
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                ", year=" + year +
                '}';
    }
}

