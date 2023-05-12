package com.ephirium.storyline.ui.main.recycler.post;

import com.ephirium.storyline.model.Post;

@Deprecated
public interface PostCallback {
    void onClick(Post post);
    void onMove(int from, int to);
    void onSwipe(int direction, int pos);
}

