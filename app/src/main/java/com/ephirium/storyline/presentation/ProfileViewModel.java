package com.ephirium.storyline.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ephirium.storyline.common.recycler.delegate.DelegateItem;
import com.ephirium.storyline.domain.interact.PostInteract;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<List<DelegateItem>> mutDelegates = new MutableLiveData<>();
    public final LiveData<List<DelegateItem>> delegates = mutDelegates;

    public void observeDelegates(){
        // PostInteract.observeProfile(mutDelegates::postValue);
    }
}
