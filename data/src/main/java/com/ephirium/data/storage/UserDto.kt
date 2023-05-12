package com.ephirium.data.storage

import com.google.firebase.firestore.DocumentId

data class UserDto(
    @DocumentId
    @JvmField var login: String,
    @JvmField var email: String,
    @JvmField var description: String
)
