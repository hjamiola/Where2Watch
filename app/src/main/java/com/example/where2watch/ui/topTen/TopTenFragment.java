package com.example.where2watch.ui.topTen;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.where2watch.R;

import com.example.where2watch.databinding.FragmentToptenBinding;
import com.example.where2watch.ui.model.Movie;
import com.example.where2watch.ui.model.TopTenCardView;
import java.util.ArrayList;
import java.util.List;

public class TopTenFragment extends Fragment {

    private LinearLayout[] containers;
    private List<List<Movie>> movieLists;  // Array of movie lists


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topten, container, false);
        containers = new LinearLayout[]{
                view.findViewById(R.id.top_ten_container_action),
                view.findViewById(R.id.top_ten_container_sci_fi),
                view.findViewById(R.id.top_ten_container_horror)
        };
        initializeMovieList();
        for (int i = 0; i < containers.length; i++) {
            populateTopTen(movieLists.get(i), containers[i]);
        }
        return view;
    }
    private void initializeMovieList() {
        movieLists = new ArrayList<>();
        List<Movie> actionMovies = new ArrayList<>();
        List<Movie> sciFiMovies = new ArrayList<>();
        List<Movie> horrorMovies = new ArrayList<>();

        actionMovies.add(new Movie("The Fall Guy", "action", 5.0f, R.drawable.thefallguy));
        actionMovies.add(new Movie("Rebel Ridge", "action", 5.0f, R.drawable.rebelridge));
        actionMovies.add(new Movie("The Killer", "action", 4.5f, R.drawable.thekiller));
        actionMovies.add(new Movie("Hit Man", "action", 4.5f, R.drawable.hitman));
        actionMovies.add(new Movie("Twisters", "action", 4.5f, R.drawable.twisters));
        actionMovies.add(new Movie("Baby Driver", "action", 4.5f, R.drawable.babydriverjpg));
        actionMovies.add(new Movie("Borderlands", "action", 4.5f, R.drawable.borderlands));
        actionMovies.add(new Movie("Kingdom of the Planet of the Apes", "action", 4.5f, R.drawable.planetoftheapes));
        actionMovies.add(new Movie("Extraction 2", "action", 4.5f, R.drawable.extraction2));
        actionMovies.add(new Movie("Madame Web", "action", 4.5f, R.drawable.mamdameweb));

        sciFiMovies.add(new Movie("Interstellar", "sci-fi", 5.0f, R.drawable.interstellar));
        sciFiMovies.add(new Movie("The Wild Robot", "sci-fi", 5.0f, R.drawable.thewildrobot));
        sciFiMovies.add(new Movie("The Martian", "sci-fi", 5.0f, R.drawable.martian));
        sciFiMovies.add(new Movie("Ad Astra", "sci-fi", 5.0f, R.drawable.adastra));
        sciFiMovies.add(new Movie("Arrival", "sci-fi", 5.0f, R.drawable.arrival));
        sciFiMovies.add(new Movie("Gravity", "sci-fi", 5.0f, R.drawable.gravity));
        sciFiMovies.add(new Movie("Alien: Romulus", "sci-fi", 5.0f, R.drawable.alienromulus));
        sciFiMovies.add(new Movie("Blade Runner 2049", "sci-fi", 5.0f, R.drawable.bladerunner2049));
        sciFiMovies.add(new Movie("Deadpool & Wolverine", "sci-fi", 5.0f, R.drawable.deadpoolwolverine));
        sciFiMovies.add(new Movie("Afraid", "sci-fi", 5.0f, R.drawable.afraid));

        horrorMovies.add(new Movie("Don't Move", "horror", 5.0f, R.drawable.dontmove1));
        horrorMovies.add(new Movie("Smile 2", "horror", 5.0f, R.drawable.smile2));
        horrorMovies.add(new Movie("Apartment 7A", "horror", 5.0f, R.drawable.apt7a));
        horrorMovies.add(new Movie("Longlegs", "horror", 5.0f, R.drawable.longlegs));
        horrorMovies.add(new Movie("Oddity", "horror", 5.0f, R.drawable.oddity));
        horrorMovies.add(new Movie("Cuckoo", "horror", 5.0f, R.drawable.cuckoo));
        horrorMovies.add(new Movie("Trap", "horror", 5.0f, R.drawable.trap));
        horrorMovies.add(new Movie("The Watchers", "horror", 5.0f, R.drawable.thewatchers));
        horrorMovies.add(new Movie("The Substsance", "horror", 5.0f, R.drawable.thesubstance));
        horrorMovies.add(new Movie("The Deliverance", "horror", 5.0f, R.drawable.thedeliverance));

        movieLists.add(actionMovies);
        movieLists.add(sciFiMovies);
        movieLists.add(horrorMovies);
    }

    private void populateTopTen(List<Movie> movies, LinearLayout container) {
        if (movies == null || movies.isEmpty() || container == null) {
            return;
        }
        container.removeAllViews(); // Clear existing views
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            TopTenCardView cardView = new TopTenCardView(requireContext());

            cardView.setMovieImage(movie.getImageResId());
            cardView.setMovieTitle(movie.getTitle());
            cardView.setMovieNumber(String.valueOf(i + 1) + ".");

            container.addView(cardView);
        }
    }

//    public void updateMovieLists(List<List<Movie>> newMovieLists) { //use this to add a new movielist for the actual app.
//        movieLists = newMovieLists;
//        for (int i = 0; i < containers.length; i++) {
//            populateTopTen(movieLists.get(i), containers[i]);
//        }
//    }

    private FragmentToptenBinding binding;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}