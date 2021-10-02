package com.redmadrobot.extensions.resources

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.util.TypedValue.*
import androidx.annotation.AnyRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

/**
 * Returns the resource id for the provided [attributeResId] or `ID_NULL` (0) if the attribute
 * is not set in the [Context] theme or not contains resource reference.
 */
@AnyRes
public fun Context.resolveResourceId(@AttrRes attributeResId: Int): Int {
    return resolveAttribute(attributeResId)?.resourceId ?: 0
}

/**
 * Returns the [Boolean] for the provided [attributeResId] or throws an exception
 * if the attribute is not set in the [Context] theme or contains not a boolean value.
 */
public fun Context.resolveBoolean(@AttrRes attributeResId: Int): Boolean {
    val attribute = resolveAttributeOrThrow(attributeResId)
    require(attribute.type == TYPE_INT_BOOLEAN) {
        wrongValueTypeMessage(attribute, attributeResId, expectedType = "boolean")
    }
    return attribute.data != 0
}

/**
 * Returns the color for the provided [attributeResId] or throws an exception
 * if the attribute is not set in the [Context] theme or contains not a color value.
 */
@ColorInt
public fun Context.resolveColor(@AttrRes attributeResId: Int): Int {
    return resolveAttributeOrThrow(attributeResId).requireColor {
        wrongValueTypeMessage(this, attributeResId, expectedType = "color")
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
 * Returns dimension value multiplied by the appropriate metric for the provided [attributeResId]
 * or throws an exception if the attribute is not set in the [Context] theme or contains not a dimension value.
 */
public fun Context.resolveDimension(@AttrRes attributeResId: Int): Float {
    return resolveDimension(attributeResId, TypedValue::complexToDimension)
}

/**
 * Returns number of pixels for the provided [attributeResId] or throws an exception
 * if the attribute is not set in the [Context] theme or contains not a dimension value.
 *
 * A size conversion involves rounding the base value,
 * and ensuring that a non-zero base value is at least one pixel in size.
 */
public fun Context.resolveDimensionPixelSize(@AttrRes attributeResId: Int): Int {
    return resolveDimension(attributeResId, TypedValue::complexToDimensionPixelSize)
}

/**
 * Returns number of pixels for the provided [attributeResId] or throws an exception
 * if the attribute is not set in the [Context] theme or contains not a dimension value.
 *
 * An offset conversion involves simply truncating the base value to an integer.
 */
public fun Context.resolveDimensionPixelOffset(@AttrRes attributeResId: Int): Int {
    return resolveDimension(attributeResId, TypedValue::complexToDimensionPixelOffset)
}

private inline fun <T : Number> Context.resolveDimension(
    @AttrRes attributeResId: Int,
    complexToDimension: (data: Int, metrics: DisplayMetrics) -> T,
): T {
    val attribute = resolveAttributeOrThrow(attributeResId)
    require(attribute.type == TYPE_DIMENSION) {
        wrongValueTypeMessage(attribute, attributeResId, expectedType = "dimensional")
    }
    return complexToDimension(attribute.data, resources.displayMetrics)
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

@Suppress("NullableToStringCall")
private fun Context.wrongValueTypeMessage(value: TypedValue, attrRes: Int, expectedType: String): String {
    return "Attribute ${nameOf(attrRes)} should contain $expectedType value but it contains '${value.coerceToString()}'"
}

private fun Context.nameOf(@AnyRes resId: Int): String = resources.getResourceName(resId)
