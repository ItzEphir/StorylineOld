package com.ephirium.storyline.domain.repository;

import com.ephirium.storyline.domain.model.PostDto;
import com.ephirium.storyline.domain.util.DataListener;
import com.ephirium.storyline.domain.util.ErrorListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

public class PostsRepository {
    public static void observePosts(DataListener<List<PostDto>> listener, ErrorListener errorListener){
        FirebaseFirestore.getInstance().collection("posts")
                .get()
                .addOnSuccessListener(documentSnapshot ->
                        listener.onChange(documentSnapshot.toObjects(PostDto.class)))
                .addOnFailureListener(errorListener::onError);
    }
}
