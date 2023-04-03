package com.ephirium.storyline.feature.ui.recycler;

import com.ephirium.storyline.feature.model.Post;

public interface PostsCallback {
    void onClick(Post post);
    void onMove(int from, int to);
    void onSwipe(int direction, int pos);
}
