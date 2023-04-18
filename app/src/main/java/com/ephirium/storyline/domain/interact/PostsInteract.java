package com.ephirium.storyline.domain.interact;

import static com.ephirium.storyline.StorylineLog.logError;

import com.ephirium.storyline.common.util.DataListener;
import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.domain.repository.PostsRepository;

import java.util.List;

public class PostsInteract {

    public static void observe(DataListener<List<PostDto>> listener) {
        PostsRepository.observePosts(listener, exception -> logError("Error in downloading"));
    }
}
