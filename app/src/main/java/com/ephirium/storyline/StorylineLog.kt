@file:JvmName("StorylineLog")

package com.ephirium.storyline

import android.util.Log

@JvmField
var defaultTag = "Debug"
@JvmField
var infoTag = "Info"
@JvmField
var warningTag = "Warning"
@JvmField
var errorTag = "Error"


@JvmOverloads
fun log(tag: String = defaultTag, message: String) = Log.d(tag, message)

fun <T> log(tag: String, message: String, clazz: Class<T>? = null) =
    Log.d(tag, message + " " + clazz?.typeName)

infix fun Any.log(message: String) = log(defaultTag, message, this.javaClass)

@JvmOverloads
fun logError(tag: String = errorTag, message: String) = Log.d(tag, message)

fun <T> logError(tag: String = errorTag, message: String, clazz: Class<T>? = null) =
    Log.e(tag, message + " " + clazz?.typeName)

infix fun Any.logError(message: String) = logError(defaultTag, message, this.javaClass)

@JvmOverloads
fun info(tag: String = infoTag, message: String) = Log.i(tag, message)

fun <T> info(tag: String = infoTag, message: String, clazz: Class<T>? = null) =
    Log.i(tag, message + " " + clazz?.typeName)

infix fun Any.info(message: String) = info(infoTag, message, this.javaClass)

@JvmOverloads
fun warning(tag: String = warningTag, message: String) = Log.w(tag, message)

fun <T> warning(tag: String = warningTag, message: String, clazz: Class<T>? = null) =
    Log.w(tag, message + " " + clazz?.typeName)

infix fun Any.warning(message: String) = warning(warningTag, message, this.javaClass)

@JvmOverloads
fun error(tag: String = errorTag, message: String) = Log.e(tag, message)

fun <T> error(tag: String = errorTag, message: String, clazz: Class<T>? = null) =
    Log.e(tag, message + " " + clazz?.typeName)

infix fun Any.error(message: String) = error(errorTag, message, this.javaClass)
