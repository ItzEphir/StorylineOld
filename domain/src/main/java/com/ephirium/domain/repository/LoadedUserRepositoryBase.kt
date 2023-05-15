package com.ephirium.domain.repository

import com.ephirium.common.listener.DataConstListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.domain.dto.UserDtoBase

interface LoadedUserRepositoryBase<T : UserDtoBase>{
    fun observe(email: String, dataListener: DataConstListener<T>, errorListener: ErrorListener)
}