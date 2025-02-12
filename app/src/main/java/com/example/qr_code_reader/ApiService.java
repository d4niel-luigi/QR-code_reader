package com.example.qr_code_reader;

import android.graphics.Movie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("movie")
    Call<List<Movie>> getMovies();

    // Film törlése (DELETE)
    @DELETE("movie/{id}")
    Call<Void> deleteMovie(@Path("id") int id);

    // Film hozzáadása (POST)
    @POST("movie")
    Call<Movie> addMovie(@Body Movie movie);
}
