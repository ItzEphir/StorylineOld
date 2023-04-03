package com.ephirium.storyline.feature.ui.recycler;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ephirium.storyline.databinding.LayoutPostBinding;
import com.ephirium.storyline.feature.model.Post;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts = new ArrayList<>();

    private final PostsCallback callback;

    public PostsAdapter(PostsCallback callback){
        this.callback = callback;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostBinding binding = LayoutPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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

    public void setPosts(List<Post> posts){
        int size = getItemCount();
        this.posts = new ArrayList<>(posts);
        notifyItemRangeChanged(0, Math.max(size, getItemCount()));
    }
}

class PostViewHolder extends RecyclerView.ViewHolder {

    private final LayoutPostBinding binding;
    private final PostsCallback callback;

    public PostViewHolder(@NonNull LayoutPostBinding binding, PostsCallback callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
    }

    public void bind(Post post){
        binding.progressBar.setVisibility(View.VISIBLE);
        FirebaseStorage.getInstance().getReference().child(post.getFileSource()).getDownloadUrl()
                .addOnSuccessListener(uri -> {
                    Picasso.get().load(uri).into(binding.image);
                    binding.progressBar.setVisibility(View.GONE);
                }).addOnFailureListener(Throwable::printStackTrace);
        binding.name.setText(post.getName());
        binding.description.setText(post.getDescription());
    }
}
