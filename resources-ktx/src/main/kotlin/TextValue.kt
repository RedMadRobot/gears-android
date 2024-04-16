package com.redmadrobot.extensions.resources

import androidx.annotation.StringRes
import com.redmadrobot.textvalue.TextValue

@Deprecated(
    "Text renamed to TextValue for compatibility with compose",
    ReplaceWith("TextValue", "com.redmadrobot.extensions.TextValue")
)
public typealias Text = TextValue

@Suppress("FunctionName")
@Deprecated(
    "Text renamed to TextValue for compatibility with compose",
    ReplaceWith("TextValue(resourceId)", "com.redmadrobot.extensions.TextValue")
)
public fun TextValue.Companion.Resource(@StringRes resourceId: Int): TextValue.Resource = TextValue.Resource(resourceId)

@Suppress("FunctionName")
@Deprecated(
    "Text renamed to TextValue for compatibility with compose",
    ReplaceWith("TextValue(string)", "com.redmadrobot.extensions.TextValue")
)
public fun TextValue.Companion.Plain(string: String): TextValue.Plain = TextValue.Plain(string)
