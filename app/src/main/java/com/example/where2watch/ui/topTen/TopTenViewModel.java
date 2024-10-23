package com.example.where2watch.ui.topTen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopTenViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TopTenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is topTen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}