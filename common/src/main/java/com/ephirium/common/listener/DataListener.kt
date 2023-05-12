package com.ephirium.common.listener

interface DataListener<T> {
    fun onChange(value: T)
}