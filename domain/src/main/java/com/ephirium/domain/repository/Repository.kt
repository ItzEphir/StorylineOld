package com.ephirium.domain.repository

import com.ephirium.common.listener.DataListener
import com.ephirium.common.listener.ErrorListener

interface Repository<T> {
    fun observe(dataListener: DataListener<T>, errorListener: ErrorListener)
}