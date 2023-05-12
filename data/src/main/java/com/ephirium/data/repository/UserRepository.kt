package com.ephirium.data.repository

import com.ephirium.data.storage.UserDto
import com.ephirium.common.listener.DataListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.repository.Repository
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository : Repository<List<UserDto>> {
    override fun observe(dataListener: DataListener<List<UserDto>>, errorListener: ErrorListener) {
        FirebaseFirestore.getInstance().collection("users").get()
            .addOnSuccessListener {
                dataListener.onChange(it.toObjects(UserDto::class.java))
            }
            .addOnFailureListener {
                errorListener.onError(it)
            }
    }

}