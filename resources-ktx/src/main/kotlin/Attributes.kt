package com.redmadrobot.extensions.resources

import android.content.Context
import android.util.TypedValue
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
 * Returns the color for the provided [colorAttributeResId] or throws an exception
 * if the attribute is not set in the current theme.
 */
@ColorInt
public fun Context.resolveColor(@AttrRes colorAttributeResId: Int): Int {
    return resolveAttributeOrThrow(colorAttributeResId).data
}

/**
 * Returns the color for the provided [colorAttributeResId], or the [defaultValue]
 * if the attribute is not set in the current theme.
 */
@ColorInt
public fun Context.resolveColor(
    @AttrRes colorAttributeResId: Int,
    @ColorInt defaultValue: Int,
): Int {
    return resolveAttribute(colorAttributeResId)?.data ?: defaultValue
}

/**
 * Retrieves the value of an attribute in the Context theme.
 * Throws an exception if the attribute was not found.
 */
public fun Context.resolveAttributeOrThrow(@AttrRes attributeResId: Int): TypedValue {
    return requireNotNull(resolveAttribute(attributeResId)) {
        val attributeName: String = resources.getResourceName(attributeResId)
        "Attribute $attributeName required to be set in your app theme."
    }
}

/**
 * Retrieves the value of an attribute in the Context theme.
 * Returns `null` if the attribute was not found.
 */
public fun Context.resolveAttribute(@AttrRes attributeResId: Int): TypedValue? {
    return TypedValue().takeIf { theme.resolveAttribute(attributeResId, it, true) }
}
