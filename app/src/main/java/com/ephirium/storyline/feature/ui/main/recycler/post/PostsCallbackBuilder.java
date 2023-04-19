package com.ephirium.storyline.feature.ui.main.recycler.post;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ephirium.storyline.feature.model.Post;
import com.ephirium.storyline.feature.ui.main.recycler.post.callback.PostOnClickCallback;

@Deprecated
public class PostsCallbackBuilder {

    @Nullable
    private OnClickCallback onClickCallback;

    @Nullable
    private OnMoveCallback onMoveCallback;

    @Nullable
    private OnSwipeCallback onSwipeCallback;

    public PostsCallbackBuilder(){}

    public PostsCallbackBuilder(PostCallback callback){
        onClickCallback = callback::onClick;
        onMoveCallback = callback::onMove;
        onSwipeCallback = callback::onSwipe;
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public PostsCallbackBuilder addOnClickCallback(@NonNull OnClickCallback callback) {
        onClickCallback = callback;
        return this;
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public PostsCallbackBuilder addOnMoveCallback(@NonNull OnMoveCallback callback) {
        onMoveCallback = callback;
        return this;
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public PostsCallbackBuilder addOnSwipeCallback(@NonNull OnSwipeCallback callback) {
        onSwipeCallback = callback;
        return this;
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public PostCallback build() {
        return new PostCallback() {
            @Override
            public void onClick(Post post) {
                assert onClickCallback != null;
                onClickCallback.onClick(post);
            }

            @Override
            public void onMove(int from, int to) {
                assert onMoveCallback != null;
                onMoveCallback.onMove(from, to);
            }

            @Override
            public void onSwipe(int direction, int pos) {
                assert onSwipeCallback != null;
                onSwipeCallback.onSwipe(direction, pos);
            }
        };
    }

    public com.ephirium.storyline.feature.ui.main.recycler.post.callback.PostCallback actual(){
        PostCallback callback = build();
        return new com.ephirium.storyline.feature.ui.main.recycler.post.callback.PostCallback(callback::onClick)
                .addOnMoveCallback(callback::onMove)
                .addOnSwipeCallback(callback::onSwipe);
    }

    public interface OnClickCallback {
        void onClick(Post post);
    }

    public interface OnMoveCallback {
        void onMove(int from, int to);
    }

    public interface OnSwipeCallback {
        void onSwipe(int direction, int position);
    }
}
