package com.ephirium.storyline.ui.recycler.post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ephirium.common.delegate.AdapterDelegate;
import com.ephirium.common.delegate.DelegateItem;
import com.ephirium.storyline.databinding.ViewPostBinding;
import com.ephirium.storyline.model.Post;
import com.ephirium.storyline.ui.recycler.post.callback.PostCallback;

public class PostAdapterDelegate implements AdapterDelegate {

    private final com.ephirium.storyline.ui.recycler.post.callback.PostCallback callback;

    @SuppressWarnings("unused")
    public PostAdapterDelegate(){
        callback = new com.ephirium.storyline.ui.recycler.post.callback.PostCallback();
    }

    @SuppressWarnings("unused")
    public PostAdapterDelegate(PostCallback callback){
        this.callback = callback;
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
