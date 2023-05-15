package com.ephirium.storyline.presentation;

import com.ephirium.common.delegate.DelegateItem;
import com.ephirium.data.storage.PostDto;
import com.ephirium.storyline.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DelegateItemMapper {
    public static List<DelegateItem> convert(List<PostDto> items) {
        var result = new ArrayList<DelegateItem>();
        items.forEach(postDto -> result.add(new Post(postDto.getId(), postDto.getName(), postDto.getDescription(), postDto.getId() + ".jpg")));
        return result;
    }
}
