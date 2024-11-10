package com.example.where2watch.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.appcompat.widget.SearchView;

import com.example.where2watch.databinding.FragmentHomeBinding;
import com.example.where2watch.R;
import com.example.where2watch.ui.adapter.MovieAdapter;
import com.example.where2watch.ui.model.Movie;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SearchView searchView;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    ChipGroup chipGroup;
    Set<String> selectedItems = new HashSet<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String[] item = {"Disney+", "Hulu", "Netflix", "Amazon Prime Video", "Apple TV", "Paramount+"};

        autoCompleteTextView = view.findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(requireContext(), R.layout.filter_list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Check if the item is already selected
                if (!selectedItems.contains(selectedItem)) {
                    // Add chip to ChipGroup
                    addChip(selectedItem);
                    // Add the selected item to the set
                    selectedItems.add(selectedItem);
                } else {
                    // Notify the user or handle the case where the item is already selected
                    Toast.makeText(requireContext(), "Item already selected", Toast.LENGTH_SHORT).show();
                }

                // Clear the text in AutoCompleteTextView after selection
                autoCompleteTextView.setText("");
            }
        });

        chipGroup = view.findViewById(R.id.chipGroup);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchView = view.findViewById(R.id.searchView);

        // Set up the search view to filter the recycler view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Pass information to the search results
                Bundle bundle = new Bundle();
                bundle.putString("search_query", query);
                bundle.putStringArrayList("filter_items", new ArrayList<>(selectedItems));

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_searchFragment_to_searchResultsFragment, bundle);

                selectedItems.clear();
                chipGroup.removeAllViews();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.clearFocus();

    }

    private void addChip(String text) {
        Chip chip = new Chip(requireContext());
        chip.setText(text);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup.removeView(chip);
                selectedItems.remove(text);
            }
        });

        chipGroup.addView(chip);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}