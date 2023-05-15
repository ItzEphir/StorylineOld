package com.ephirium.data.repository

import android.net.Uri
import com.ephirium.common.listener.DataConstListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.repository.PostImageRepositoryBase
import com.google.firebase.storage.FirebaseStorage
import java.lang.RuntimeException

class PostImageRepository : PostImageRepositoryBase<Uri> {

    override fun observe(
        source: String,
        dataListener: DataConstListener<Uri>,
        errorListener: ErrorListener
    ) {
        FirebaseStorage.getInstance().reference.child(source).downloadUrl
            .addOnSuccessListener {
                dataListener.onChange(it);
            }.addOnFailureListener {
                errorListener.onError(it)
            }
    }
}