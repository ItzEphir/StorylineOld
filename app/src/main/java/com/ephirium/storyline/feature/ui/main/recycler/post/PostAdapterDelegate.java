package com.ephirium.storyline.feature.ui.main.recycler.post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ephirium.storyline.common.recycler.delegate.AdapterDelegate;
import com.ephirium.storyline.common.recycler.delegate.DelegateItem;
import com.ephirium.storyline.databinding.ViewPostBinding;
import com.ephirium.storyline.feature.model.Post;
import com.ephirium.storyline.feature.ui.main.recycler.post.callback.PostCallback;

public class PostAdapterDelegate implements AdapterDelegate {

    private final PostCallback callback;

    @SuppressWarnings("unused")
    public PostAdapterDelegate(){
        callback = new PostCallback();
    }

    @SuppressWarnings("unused")
    public PostAdapterDelegate(PostCallback callback){
        this.callback = callback;
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public PostAdapterDelegate(com.ephirium.storyline.feature.ui.main.recycler.post.PostCallback callback){
        this.callback = new PostsCallbackBuilder(callback).actual();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ViewPostBinding binding = ViewPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding, callback);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, DelegateItem item) {
        ((PostViewHolder) holder).bind((Post) item);
    }

    @Override
    public Boolean isOfViewType(DelegateItem item) {
        return item instanceof Post;
    }
}
