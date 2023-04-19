package com.ephirium.storyline.feature.ui.main.recycler.post;

import com.ephirium.storyline.feature.model.Post;

@Deprecated
public interface PostCallback {
    void onClick(Post post);
    void onMove(int from, int to);
    void onSwipe(int direction, int pos);
}

