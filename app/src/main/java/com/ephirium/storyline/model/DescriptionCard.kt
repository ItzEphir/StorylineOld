package com.ephirium.storyline.model

import com.ephirium.storyline.common.recycler.delegate.DelegateItem

data class DescriptionCard(val name: String, val description: String) : DelegateItem {
    override fun getDelegateId(): String {
        return name
    }

    override fun getDelegateContent(): String {
        return name + description
    }
}
