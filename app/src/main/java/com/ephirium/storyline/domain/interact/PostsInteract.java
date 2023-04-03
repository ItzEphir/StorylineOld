package com.ephirium.storyline.domain.interact;

import android.util.Log;


import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.domain.repository.PostsRepository;
import com.ephirium.storyline.domain.util.DataListener;

import java.util.ArrayList;
import java.util.List;

public class PostsInteract {

    private static List<PostDto> posts = new ArrayList<>();

    public static List<PostDto> getPosts(){
        PostsRepository.observePosts(value -> posts = value, exception -> Log.d("ErrorTag", "Error in Downloading"));

        return posts;
    }

    public static void observe(DataListener<List<PostDto>> listener){
        PostsRepository.observePosts(listener, exception -> Log.d("ErrorTag", "Error in Downloading"));
    }
}
