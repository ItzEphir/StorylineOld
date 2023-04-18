package com.ephirium.storyline.feature.ui.main.recycler.post;

import static com.ephirium.storyline.StorylineLog.logError;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ephirium.storyline.databinding.ViewPostBinding;
import com.ephirium.storyline.feature.model.Post;
import com.ephirium.storyline.feature.ui.main.recycler.post.callback.PostCallback;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

class PostViewHolder extends RecyclerView.ViewHolder {

    private final ViewPostBinding binding;
    private final PostCallback callback;

    public PostViewHolder(@NonNull ViewPostBinding binding, PostCallback callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
    }

    public void bind(Post post) {
        binding.progressBar.setVisibility(View.VISIBLE);
        if (post.getDrawable() == null)
            FirebaseStorage.getInstance().getReference().child(post.getFileSource()).getDownloadUrl()
                    .addOnSuccessListener(uri -> {
                        Picasso.get().load(uri).into(binding.image);
                        post.setDrawable(binding.image.getDrawable());
                        binding.progressBar.setVisibility(View.GONE);
                    }).addOnFailureListener(e ->
                            logError("Error in downloading image", PostViewHolder.class));
        else {
            binding.progressBar.setVisibility(View.GONE);
            binding.image.setImageDrawable(post.getDrawable());
        }
        binding.layout.setOnClickListener(v -> callback.onClick(post));
        binding.name.setText(post.getName());
        binding.description.setText(post.getDescription());
    }
}
