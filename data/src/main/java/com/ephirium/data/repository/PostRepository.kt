package com.ephirium.data.repository

import com.ephirium.data.storage.PostDto
import com.ephirium.common.listener.DataListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.repository.Repository
import com.google.firebase.firestore.FirebaseFirestore

class PostRepository : Repository<List<PostDto>> {
    override fun observe(dataListener: DataListener<List<PostDto>>, errorListener: ErrorListener) {
        FirebaseFirestore.getInstance().collection("posts").get()
            .addOnSuccessListener {
                dataListener.onChange(it.toObjects(PostDto::class.java))
            }.addOnFailureListener {
                errorListener.onError(it)
            }
    }
}