package com.redmadrobot.gears.kotlin

/**
 * Calls the specified function [block] with [this] value as its receiver if the [condition] is `true`
 * and returns its result.
 */
public inline fun <T> T.applyIf(
    condition: Boolean,
    block: T.() -> T,
): T = if (condition) block() else this

/**
 * Calls the specified function [block] with [this] value as its receiver if the [value] is not null
 * and returns its result.
 */
public inline fun <T, P : Any> T.applyIfNotNull(
    value: P?,
    block: T.(P) -> T
): T = if (value != null) block(value) else this
