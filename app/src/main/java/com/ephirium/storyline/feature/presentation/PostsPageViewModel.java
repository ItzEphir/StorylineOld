package com.ephirium.storyline.feature.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ephirium.storyline.domain.interact.PostsInteract;
import com.ephirium.storyline.feature.model.Post;

import java.util.List;

public class PostsPageViewModel extends ViewModel {
    private final MutableLiveData<List<Post>> mutPostsList = new MutableLiveData<>();
    public final LiveData<List<Post>> postsList = mutPostsList;

    public void observePosts() {
        PostsInteract.observe(value -> mutPostsList.postValue(PostsMapper.convert(value)));
    }
}