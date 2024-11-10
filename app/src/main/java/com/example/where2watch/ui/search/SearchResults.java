package com.example.where2watch.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where2watch.R;
import com.example.where2watch.databinding.FragmentHomeBinding;
import com.example.where2watch.ui.adapter.MovieAdapter;
import com.example.where2watch.ui.adapter.PlatformAdapter;
import com.example.where2watch.ui.model.Movie;
import com.example.where2watch.ui.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends Fragment {

    private FragmentHomeBinding binding;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList;
    private List<Platform> platformList;
    private PlatformAdapter platformAdapter;
    private RecyclerView recyclerView;
    String searchQuery;
    ArrayList<String> selectedItems;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        Bundle bundle = getArguments();
        if(bundle != null) {
            searchQuery = bundle.getString("search_query");
            selectedItems = bundle.getStringArrayList("filter_items");
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView search_results = view.findViewById(R.id.results_text);
        if(searchQuery != null) {
            search_results.setText("Search results for: " + searchQuery);
        }
        else {
            search_results.setText("No search results");
        }

        //recyclerView = view.findViewById(R.id.RecyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        initData();

        // Initialize data
        //SetRecyclerView();
    }

    private void SetRecyclerView() {
        //VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList, requireContext());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setHasFixedSize(true);
    }
    private void initData() {

        // Initialize movie list and add movies
        movieList = new ArrayList<>();
        movieList.add(new Movie("#1 Grown Ups", "Comedy", new String[]{""},5.0f, R.drawable.grown_ups));
        movieList.add(new Movie("#2 Forrest Gump", "Drama", new String[]{""}, 5.0f, R.drawable.forrest_gump));
        movieList.add(new Movie("#3 Interstellar", "Science Fiction", new String[]{""}, 4.5f, R.drawable.interstellar));
        movieList.add(new Movie("#4 The Lion King", "Children's Animation",new String[]{""}, 4.5f, R.drawable.lion_king));
        movieList.add(new Movie("#5 Ferris Bueller's Day Off", "Comedy",new String[]{""}, 4.5f, R.drawable.ferris));
        movieList.add(new Movie("#6 Dumb and Dumber", "Comedy", new String[]{""},4.0f, R.drawable.dumb_dumber));
        movieList.add(new Movie("#7 Step Brothers", "Comedy", new String[]{""},3.5f, R.drawable.step_brothers));
        movieList.add(new Movie("#8 Crazy Rich Asians", "Romantic Comedy", new String[]{""}, 3.5f, R.drawable.crazy_rich_asians));
        movieList.add(new Movie("#9 How to Lose a Guy in 10 Days", "Romantic Comedy", new String[]{""}, 3.5f, R.drawable.how_to_lose_a_guy));
        movieList.add(new Movie("#10 10 Things I Hate About You", "Romantic Comedy", new String[]{""}, 3.0f, R.drawable.ten_things));

        platformList = new ArrayList<>();


        // Filter the movie list based on selectedItems
        if (selectedItems != null && !selectedItems.isEmpty()) {
            movieList.removeIf(movie -> !selectedItems.contains(movie.getPlatform()));
        }

        // Initialize VersionsAdapter before using it
        movieAdapter = new MovieAdapter(movieList);

        // Log the contents of the movie list
        for (Movie movie : movieList) {
            Log.d("MovieList", "Title: " + movie.getTitle() + ", Genre: " + movie.getGenre() + ", Rating: " + movie.getRating());
        }

        //recyclerView.setAdapter(movieAdapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
