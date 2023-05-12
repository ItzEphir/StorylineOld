package com.ephirium.data.storage

import com.ephirium.domain.dto.ItemDto
import com.google.firebase.firestore.DocumentId

data class PostDto(
    @DocumentId override var id: String,
    var name: String,
    var description: String
) : ItemDto
