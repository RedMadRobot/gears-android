package com.redmadrobot.extensions.resources

import android.net.Uri
import androidx.annotation.DrawableRes

/** Wrapper to work with remote image as uri and drawable resource id in the same way. */
public sealed interface Image {

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    /** Remote image uri. */
    public data class Remote(public val uri: Uri) : Image

    /** Drawable resource by id. */
    public data class Res(@DrawableRes public val resourceId: Int) : Image
}
