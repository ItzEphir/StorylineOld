package com.ephirium.storyline.presentation;

import com.ephirium.data.storage.PostDto;
import com.ephirium.storyline.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsMapper {
    public static List<Post> convert(List<PostDto> postData) {
        List<Post> converted = new ArrayList<>();

        for (PostDto post : postData) {
            Post newPost = new Post(post.getId(), post.getName(), post.getDescription(), post.getId() + ".jpg");
            converted.add(newPost);
        }

        return converted;
    }
}
