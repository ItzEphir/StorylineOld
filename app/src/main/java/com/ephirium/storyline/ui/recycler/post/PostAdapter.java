package com.ephirium.storyline.ui.recycler.post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ephirium.storyline.databinding.ViewPostBinding;
import com.ephirium.storyline.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts = new ArrayList<>();

    private final com.ephirium.storyline.ui.recycler.post.callback.PostCallback callback;

    public PostAdapter(com.ephirium.storyline.ui.recycler.post.callback.PostCallback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewPostBinding binding = ViewPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        int size = getItemCount();
        this.posts = new ArrayList<>(posts);
        notifyItemRangeChanged(0, Math.max(size, getItemCount()));
    }
}

