package com.ephirium.storyline.model

import android.graphics.drawable.Drawable
import com.ephirium.common.delegate.DelegateItem

data class Post(val id: String, val name: String, val description: String, val fileSource: String) :
    DelegateItem {
    var drawable: Drawable? = null
    override fun getDelegateId(): String {
        return id
    }

    override fun getDelegateContent(): String {
        return name + description + fileSource
    }
}
