package com.ephirium.storyline.feature.presentation;

import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.feature.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsMapper {
    public static List<Post> convert(List<PostDto> postData){
        List<Post> converted = new ArrayList<>();

        for(PostDto post : postData){
            Post newPost = new Post(post.name, post.description, post.id + ".jpg");
            converted.add(newPost);
        }

        return converted;
    }
}
