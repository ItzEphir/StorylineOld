package com.ephirium.storyline.feature.model

import android.graphics.drawable.Drawable

data class Post(val name: String, val description: String, val fileSource: String){
    var drawable: Drawable? = null
}
