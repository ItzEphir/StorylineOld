package com.ephirium.domain.mapper

import com.ephirium.domain.dto.ItemDto
import com.ephirium.domain.mapper.model.DelegateItem

interface Mapper {
    fun convert(from: ItemDto, to: DelegateItem)
}