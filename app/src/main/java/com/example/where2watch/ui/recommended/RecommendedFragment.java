package com.example.where2watch.ui.recommended;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where2watch.R;
import com.example.where2watch.ui.adapter.MovieAdapter;
import com.example.where2watch.ui.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class RecommendedFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommended, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize movie list and add movies
        movieList = new ArrayList<>();
        movieList.add(new Movie("#1 Grown Ups", "Comedy", new String[]{"Hulu", "Disney+", "Netflix"}, new String[]{"Free", "Free", "Free"}, 5.0f, R.drawable.grown_ups));
        movieList.add(new Movie("#2 Forrest Gump", "Drama", new String[]{"Paramount Plus", "Amazon"}, new String[]{"Free", "$3.99"}, 5.0f, R.drawable.forrest_gump));
        movieList.add(new Movie("#3 Interstellar", "Science Fiction", new String[]{"Paramount Plus", "Amazon"}, new String[]{"Free", "$2.50"}, 4.5f, R.drawable.interstellar));
        movieList.add(new Movie("#4 The Lion King", "Children's Animation",new String[]{"Disney+", "Amazon"}, new String[]{"Free", "$3.50"}, 4.5f, R.drawable.lion_king));
        movieList.add(new Movie("#5 Ferris Bueller's Day Off", "Comedy",new String[]{"Paramount Plus", "Amazon", "Apple TV"}, new String[]{"Free", "Free", "Free"}, 4.5f, R.drawable.ferris));
        movieList.add(new Movie("#6 Dumb and Dumber", "Comedy", new String[]{"Amazon", "Apple TV"}, new String[]{"$2.50", "$3.00"},4.0f, R.drawable.dumb_dumber));
        movieList.add(new Movie("#7 Step Brothers", "Comedy", new String[]{"Amazon", "Apple TV"}, new String[]{"$6.00", "$4.50"},3.5f, R.drawable.step_brothers));
        movieList.add(new Movie("#8 Crazy Rich Asians", "Romantic Comedy", new String[]{"Netflix"}, new String[]{"Free"}, 3.5f, R.drawable.crazy_rich_asians));
        movieList.add(new Movie("#9 How to Lose a Guy in 10 Days", "Romantic Comedy", new String[]{"Paramount Plus", "Amazon", "Apple TV"}, new String[]{"Free", "$2.99", "$3.99"}, 3.5f, R.drawable.how_to_lose_a_guy));
        movieList.add(new Movie("#10 10 Things I Hate About You", "Romantic Comedy", new String[]{"Disney+", "Hulu", "Amazon"}, new String[]{"Free", "Free", "$3.99"}, 3.0f, R.drawable.ten_things));

        movieAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(movieAdapter);

        return view;
    }
}