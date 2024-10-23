package com.example.where2watch.ui.recommended;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecommendedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recommended fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}