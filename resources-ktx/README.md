# resources-ktx <GitLab path="rmr_android/ktx/tree/master/resources-ktx"/>
[![License](https://img.shields.io/badge/license-MIT-green)][license]

A set of Kotlin extensions for accessing resources.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Extensions](#extensions)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:
```groovy
repositories {
    maven {
        url("https://nexus.redmadrobot.com/repository/android/")
        credentials {
            username = "android-consumer"
            password = "**************"
        }
    }
}

dependencies {
    implementation("com.redmadrobot.extensions:resources-ktx:0.3")
}
```

## Extensions

Accessors for `View`:
- `View.getColor(@ColorRes resId: Int): Int`
- `View.getColorStateList(@ColorRes resId: Int): ColorStateList?`
- `View.getDimension(@DimenRes resId: Int): Float`
- `View.getDrawable(@DrawableRes resId: Int): Drawable?`
- `View.requireDrawable(@DrawableRes resId: Int): Drawable`
- `View.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable?`
- `View.getString(@StringRes resId: Int): String`
- `View.getString(@StringRes resId: Int, vararg formatArgs: Any): String`

Accessors for `Fragment`:
- `Fragment.getColor(@ColorRes resId: Int): Int`
- `Fragment.getColorStateList(@ColorRes resId: Int): ColorStateList?`
- `Fragment.getDrawable(@DrawableRes resId: Int): Drawable?`
- `Fragment.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable?`
- `Fragment.getDimension(@DimenRes resId: Int): Float`

Extensions for `Drawable`:
- `Drawable.withTint(@ColorInt tint: Int): Drawable`

Dimension converters for `Context` (the same available for `Resources`):
- `Context.dpToPx(dp: Int): Int`
- `Context.dpToPx(dp: Float): Int`
- `Context.dpToPxPrecisely(dp: Int): Float`
- `Context.dpToPxPrecisely(dp: Float): Float`
- `Context.pxToDp(px: Int): Float`
- `Context.pxToDp(px: Float): Float`

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[license]: https://git.redmadrobot.com/android-research/knowledge/blob/master/LICENSE
