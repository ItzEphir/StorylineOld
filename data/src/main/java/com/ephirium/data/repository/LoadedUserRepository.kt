package com.ephirium.data.repository

import com.ephirium.common.listener.DataConstListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.common.log.logError
import com.ephirium.data.storage.UserDto
import com.ephirium.domain.repository.LoadedUserRepositoryBase
import com.google.firebase.firestore.FirebaseFirestore

class LoadedUserRepository : LoadedUserRepositoryBase<UserDto> {
    override fun observe(
        email: String,
        dataListener: DataConstListener<UserDto>,
        errorListener: ErrorListener
    ) {
        FirebaseFirestore.getInstance().collection("users").whereEqualTo("email", email)
            .addSnapshotListener { value, error ->
                run {
                    error?.let { logError(error.toString()) }

                    value?.let {
                        it.toObjects(UserDto::class.java)[0]?.let { it1 -> dataListener.onChange(it1) }
                    }
                }
            }
    }
}