package com.redmadrobot.extensions.resources

import android.content.Context
import android.util.TypedValue

import androidx.annotation.AttrRes

/**
 * Retrieves the value of an attribute in the Context theme.
 * Throws an exception if the attribute was not found.
 */
public fun Context.resolveAttributeOrThrow(@AttrRes attributeResId: Int): TypedValue {
    return requireNotNull(resolveAttribute(attributeResId)) {
        "Attribute ${resources.getResourceName(attributeResId)} required to be set in your app theme."
    }
}

/**
 * Retrieves the value of an attribute in the Context theme.
 * Returns `null` if the attribute was not found.
 */
public fun Context.resolveAttribute(@AttrRes attributeResId: Int): TypedValue? {
    return TypedValue().takeIf { theme.resolveAttribute(attributeResId, it, true) }
}
