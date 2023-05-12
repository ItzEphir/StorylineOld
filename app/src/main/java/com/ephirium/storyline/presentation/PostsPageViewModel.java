package com.ephirium.storyline.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ephirium.storyline.domain.interact.PostInteract;
import com.ephirium.storyline.model.Post;

import java.util.List;

public class PostsPageViewModel extends ViewModel {
    private final MutableLiveData<List<Post>> mutPostsList = new MutableLiveData<>();
    public final LiveData<List<Post>> postsList = mutPostsList;

    public void observePosts() {
        PostInteract.observe(value -> mutPostsList.postValue(PostsMapper.convert(value)));
    }
}