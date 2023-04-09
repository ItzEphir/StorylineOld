package com.ephirium.storyline.domain.model

import com.google.firebase.firestore.DocumentId

data class PostDto(
    @DocumentId
    @JvmField var id: String? = null,
    @JvmField var name: String? = null,
    @JvmField var description: String? = null
)