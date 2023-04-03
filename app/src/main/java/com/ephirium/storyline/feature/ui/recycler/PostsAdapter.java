package com.ephirium.storyline.feature.ui.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ephirium.storyline.databinding.LayoutPostBinding;
import com.ephirium.storyline.feature.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostBinding binding =LayoutPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts){
        int size = getItemCount();
        Log.d("MyTag", "Adapter set");
        this.posts = new ArrayList<>(posts);
        notifyDataSetChanged();
    }
}

class PostViewHolder extends RecyclerView.ViewHolder {

    LayoutPostBinding binding;

    public PostViewHolder(@NonNull LayoutPostBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Post post){
        binding.name.setText(post.getName());
        binding.description.setText(post.getDescription());
    }
}
