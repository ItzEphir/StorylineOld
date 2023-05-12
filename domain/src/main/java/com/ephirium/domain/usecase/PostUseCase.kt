package com.ephirium.domain.usecase

import com.ephirium.domain.dto.ItemDto
import com.ephirium.common.listener.DataListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.repository.Repository

class PostUseCase(private val repository: Repository<List<ItemDto>>) {


    fun observePosts(
        dataListener: DataListener<List<ItemDto>>,
        errorListener: ErrorListener
    ) {
        repository.observe(dataListener, errorListener)
    }
}