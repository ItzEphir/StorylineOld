package com.ephirium.domain.usecase

import com.ephirium.common.listener.DataConstListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.dto.UserDtoBase
import com.ephirium.domain.repository.LoadedUserRepositoryBase
import com.ephirium.domain.repository.UserRepositoryBase

class LoadedUserUseCase<T : UserDtoBase>(private val repository: LoadedUserRepositoryBase<T>) {
    fun observeUser(
        userId: String,
        dataListener: DataConstListener<T>,
        errorListener: ErrorListener
    ) {
        repository.observe(userId, dataListener, errorListener)
    }
}