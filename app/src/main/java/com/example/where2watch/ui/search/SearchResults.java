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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where2watch.R;
import com.example.where2watch.databinding.FragmentHomeBinding;
import com.example.where2watch.ui.adapter.MovieAdapter;
import com.example.where2watch.ui.adapter.PlatformAdapter;
import com.example.where2watch.ui.model.Movie;
import com.example.where2watch.ui.model.Platform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        initData();

        // Initialize data
        SetRecyclerView();
    }

    private void SetRecyclerView() {
        //VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList, requireContext());
        recyclerView.setAdapter(platformAdapter);
        recyclerView.setHasFixedSize(true);
    }
    private void initData() {

        // Initialize movie list and add movies
        movieList = new ArrayList<>();
        movieList.add(new Movie("Grown Ups", "Comedy", new String[]{"Hulu", "Disney+", "Netflix"}, new String[]{"Free", "Free", "Free"}, 5.0f, R.drawable.grown_ups));
        movieList.add(new Movie("Forrest Gump", "Drama", new String[]{"Paramount Plus", "Amazon"}, new String[]{"Free", "$3.99"}, 5.0f, R.drawable.forrest_gump));
        movieList.add(new Movie("Interstellar", "Science Fiction", new String[]{"Paramount Plus", "Amazon"}, new String[]{"Free", "$2.50"}, 4.5f, R.drawable.interstellar));
        movieList.add(new Movie("The Lion King", "Children's Animation",new String[]{"Disney+", "Amazon"}, new String[]{"Free", "$3.50"}, 4.5f, R.drawable.lion_king));
        movieList.add(new Movie("Ferris Bueller's Day Off", "Comedy",new String[]{"Paramount Plus", "Amazon", "Apple TV"}, new String[]{"Free", "Free", "Free"}, 4.5f, R.drawable.ferris));
        movieList.add(new Movie("Dumb and Dumber", "Comedy", new String[]{"Amazon", "Apple TV"}, new String[]{"$2.50", "$3.00"},4.0f, R.drawable.dumb_dumber));
        movieList.add(new Movie("Step Brothers", "Comedy", new String[]{"Amazon", "Apple TV"}, new String[]{"$6.00", "$4.50"},3.5f, R.drawable.step_brothers));
        movieList.add(new Movie("Crazy Rich Asians", "Romantic Comedy", new String[]{"Netflix"}, new String[]{"Free"}, 3.5f, R.drawable.crazy_rich_asians));
        movieList.add(new Movie("How to Lose a Guy in 10 Days", "Romantic Comedy", new String[]{"Paramount Plus", "Amazon", "Apple TV"}, new String[]{"Free", "$2.99", "$3.99"}, 3.5f, R.drawable.how_to_lose_a_guy));
        movieList.add(new Movie("10 Things I Hate About You", "Romantic Comedy", new String[]{"Disney+", "Hulu", "Amazon"}, new String[]{"Free", "Free", "$3.99"}, 3.0f, R.drawable.ten_things));

        // Initialize platform list and add platforms
        platformList = new ArrayList<>();
        platformList.add(new Platform("Netflix", "Included in Subscription", "https://www.netflix.com", R.drawable.netflix));
        platformList.add(new Platform("Hulu", "Included in Subscription", "https://www.hulu.com", R.drawable.hulu));
        platformList.add(new Platform("Amazon", "Paid", "https://www.amazon.com", R.drawable.prime));
        platformList.add(new Platform("Disney+", "Included in Subscription", "https://www.disneyplus.com", R.drawable.disney));
        platformList.add(new Platform("Apple TV", "Paid", "https://www.apple.com", R.drawable.apple));
        platformList.add(new Platform("Paramount Plus", "Included in Subscription", "https://www.paramountplus.com", R.drawable.paramount));

        Platform nullDatabase = new Platform("Movie Not in Database", "", "", R.drawable.no_results);
        Platform nullPlatform = new Platform("Movie Not on Selected Platform", "", "", R.drawable.no_results);

        // Filter the movie list based on searchQuery
        if (searchQuery != null && !searchQuery.isEmpty()) {
            movieList.removeIf(movie -> !movie.getTitle().toLowerCase().contains(searchQuery.toLowerCase().trim()));
        }

        // Create a set of all platforms from the filtered movie list
        Set<String> includedPlatforms = new HashSet<>();
        for (Movie movie : movieList) {
            for (String platform : movie.getPlatform()) {
                includedPlatforms.add(platform);
            }
        }

        // Remove any platforms from the platform list that are not in the includedPlatforms set (name)
        platformList.removeIf(platform -> !includedPlatforms.contains(platform.getPlatform()));
        if(platformList.isEmpty()) {
            platformList.add(nullDatabase);
        }

        // Filter the platform list based on selectedItems
        if (selectedItems != null && !selectedItems.isEmpty()) {
            platformList.removeIf(platform -> !selectedItems.contains(platform.getPlatform()));
        }
        if(platformList.isEmpty()) {
            platformList.add(nullPlatform);
        }

        for (Movie movie : movieList) {
            String[] platforms = movie.getPlatform();
            String[] prices = movie.getPrice();

            for (int i = 0; i < platforms.length; i++) {
                String platformName = platforms[i];
                String price = prices[i];

                for (Platform platform : platformList) {
                    if (platform.getPlatform().equalsIgnoreCase("Amazon") && platformName.equalsIgnoreCase("Amazon")) {
                        platform.setPrice(price);
                        Log.d("PlatformUpdate", "Updated Amazon Prime Video price to: " + price);
                    } else if (platform.getPlatform().equalsIgnoreCase("Apple TV") && platformName.equalsIgnoreCase("Apple TV")) {
                        platform.setPrice(price);
                    }
                }
            }
        }

        // Initialize VersionsAdapter before using it
        movieAdapter = new MovieAdapter(movieList);
        platformAdapter = new PlatformAdapter(platformList, getContext());

        // Log the contents of the movie list
        for (Movie movie : movieList) {
            Log.d("MovieList", "Title: " + movie.getTitle() + ", Genre: " + movie.getGenre() + ", Rating: " + movie.getRating());
        }

        recyclerView.setAdapter(platformAdapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
