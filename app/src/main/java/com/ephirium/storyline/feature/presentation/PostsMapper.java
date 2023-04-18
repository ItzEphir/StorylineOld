package com.ephirium.storyline.feature.presentation;

import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.feature.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsMapper {
    public static List<Post> convert(List<PostDto> postData){
        List<Post> converted = new ArrayList<>();

        for(PostDto post : postData){
            assert post.id != null;
            assert post.name != null;
            assert post.description != null;
            Post newPost = new Post(post.id, post.name, post.description, post.id + ".jpg");
            converted.add(newPost);
        }

        return converted;
    }
}
