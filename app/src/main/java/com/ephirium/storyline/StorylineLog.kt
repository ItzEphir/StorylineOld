@file:JvmName("StorylineLog")

package com.ephirium.storyline

import android.util.Log

@JvmField
var defaultTag = "Storyline"
@JvmField
var infoTag = "StorylineInfo"
@JvmField
var warningTag = "StorylineWarning"
@JvmField
var errorTag = "StorylineError"
@JvmField
var nullMessage = "Success"
@JvmField
var nullWarning = "Warning"
@JvmField
var nullError = "Error"

fun log(tag: String = defaultTag, message: String = nullMessage) = Log.d(tag, message)

fun <T> log(tag: String = defaultTag, message: String = nullMessage, clazz: Class<T>? = null) =
    Log.d(tag, message + " " + clazz?.typeName)

fun log_error(tag: String = errorTag, message: String = nullError) = Log.d(tag, message)

fun <T> log_error(tag: String = errorTag, message: String = nullError, clazz: Class<T>? = null) =
    Log.e(tag, message + " " + clazz?.typeName)

fun info(tag: String = infoTag, message: String) = Log.i(tag, message)

fun <T> info(tag: String = infoTag, message: String, clazz: Class<T>? = null) =
    Log.i(tag, message + " " + clazz?.typeName)

fun warning(tag: String = warningTag, message: String = nullWarning) = Log.w(tag, message)

fun <T> warning(tag: String = warningTag, message: String = nullWarning, clazz: Class<T>? = null) =
    Log.w(tag, message + " " + clazz?.typeName)

fun error(tag: String = errorTag, message: String = nullError) = Log.e(tag, message)

fun <T> error(tag: String = errorTag, message: String = nullError, clazz: Class<T>? = null) =
    Log.e(tag, message + " " + clazz?.typeName)
