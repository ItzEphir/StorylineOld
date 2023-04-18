package com.ephirium.storyline.feature.ui.main.recycler.post;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ephirium.storyline.feature.model.Post;

@Deprecated
public class PostsCallbackBuilder {

    @Nullable
    private OnClickCallback onClickCallback;

    @Nullable
    private OnMoveCallback onMoveCallback;

    @Nullable
    private OnSwipeCallback onSwipeCallback;

    @Nullable
    private OnLikeCallback onLikeCallback;

    public PostsCallbackBuilder addOnClickCallback(@NonNull OnClickCallback callback) {
        onClickCallback = callback;
        return this;
    }

    public PostsCallbackBuilder addOnMoveCallback(@NonNull OnMoveCallback callback) {
        onMoveCallback = callback;
        return this;
    }

    public PostsCallbackBuilder addOnSwipeCallback(@NonNull OnSwipeCallback callback) {
        onSwipeCallback = callback;
        return this;
    }

    public PostsCallbackBuilder addOnLikeCallback(@NonNull OnLikeCallback callback) {
        onLikeCallback = callback;
        return this;
    }

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

            @Override
            public void onLike(Post post) {
                assert onLikeCallback != null;
                onLikeCallback.onLikeClicked(post);
            }
        };
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

    public interface OnLikeCallback {
        void onLikeClicked(Post post);
    }
}
