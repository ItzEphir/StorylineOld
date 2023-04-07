package com.ephirium.storyline.domain.interact;

import static com.ephirium.storyline.StorylineLog.errorTag;
import static com.ephirium.storyline.StorylineLog.log_error;

import android.util.Log;

import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.domain.repository.PostsRepository;
import com.ephirium.storyline.domain.util.DataListener;

import java.util.List;

public class PostsInteract {

    public static void observe(DataListener<List<PostDto>> listener) {
        PostsRepository.observePosts(listener, exception -> log_error(errorTag, "Error in Downloading"));
    }
}
