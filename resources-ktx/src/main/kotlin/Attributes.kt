package com.redmadrobot.extensions.resources

import android.content.Context
import android.util.TypedValue
import android.util.TypedValue.*
import androidx.annotation.AnyRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

/**
 * Returns the resource id for the provided [attributeResId] or `0` if the attribute
 * is not set in the current theme or not contains resource reference.
 */
@AnyRes
public fun Context.resolveResourceId(@AttrRes attributeResId: Int): Int {
    return resolveAttribute(attributeResId)?.resourceId ?: 0
}

/**
 * Returns the color for the provided [attributeResId] or throws an exception
 * if the attribute is not set in the [Context] theme or contains not a color value.
 */
@ColorInt
public fun Context.resolveColor(@AttrRes attributeResId: Int): Int {
    return resolveAttributeOrThrow(attributeResId).requireColor {
        "Attribute ${nameOf(attributeResId)} should contain color value but it contains '${coerceToString()}'"
    }
}

/**
 * Returns the color for the provided [attributeResId], or the [defaultValue]
 * if the attribute is not set in the [Context] theme or contains not a color value.
 */
@ColorInt
public fun Context.resolveColor(
    @AttrRes attributeResId: Int,
    @ColorInt defaultValue: Int,
): Int {
    return resolveAttribute(attributeResId)
        ?.requireColor { return defaultValue }
        ?: defaultValue
}

@ColorInt
private inline fun TypedValue.requireColor(lazyMessage: TypedValue.() -> String): Int {
    require(type in TYPE_FIRST_COLOR_INT..TYPE_LAST_COLOR_INT) { lazyMessage() }
    return data
}

/**
 * Retrieves the value of an attribute in the Context theme.
 * Throws an exception if the attribute was not found.
 */
public fun Context.resolveAttributeOrThrow(@AttrRes attributeResId: Int): TypedValue {
    return requireNotNull(resolveAttribute(attributeResId)) {
        "Attribute ${nameOf(attributeResId)} required to be set in your app theme."
    }
}

/**
 * Retrieves the value of an attribute in the Context theme.
 * Returns `null` if the attribute was not found.
 */
public fun Context.resolveAttribute(@AttrRes attributeResId: Int): TypedValue? {
    return TypedValue().takeIf { theme.resolveAttribute(attributeResId, it, true) }
}

private fun Context.nameOf(@AnyRes resId: Int): String = resources.getResourceName(resId)
