# resources-ktx <GitHub path="RedMadRobot/gears-android/tree/main/ktx/resources-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/resources-ktx?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

A set of Kotlin extensions for accessing resources.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Extensions](#extensions)
  - [Wrapper `Text`](#wrapper-text)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:
```groovy
repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.redmadrobot.extensions:resources-ktx:1.3.1-0")
}
```

## Extensions

Accessors for `View`:
- `View.getColor(@ColorRes resId: Int): Int`
- `View.getColorStateList(@ColorRes resId: Int): ColorStateList?`
- `View.getDimension(@DimenRes resId: Int): Float`
- `View.getDimensionPixelSize(@DimenRes resId: Int): Int`
- `View.getDimensionPixelOffset(@DimenRes resId: Int): Int`
- `View.getDrawable(@DrawableRes resId: Int): Drawable?`
- `View.requireDrawable(@DrawableRes resId: Int): Drawable`
- `View.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable?`
- `View.getString(@StringRes resId: Int): String`
- `View.getString(@StringRes resId: Int, vararg formatArgs: Any): String`
- `View.getQuantityString(@PluralsRes resId: Int, quantity: Int): String`
- `View.getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String`

Accessors for `Fragment`:
- `Fragment.getColor(@ColorRes resId: Int): Int`
- `Fragment.getColorStateList(@ColorRes resId: Int): ColorStateList?`
- `Fragment.getDrawable(@DrawableRes resId: Int): Drawable?`
- `Fragment.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable?`
- `Fragment.getDimension(@DimenRes resId: Int): Float`
- `Fragment.getDimensionPixelSize(@DimenRes resId: Int): Int`
- `Fragment.getDimensionPixelOffset(@DimenRes resId: Int): Int`
- `Fragment.getQuantityString(@PluralsRes resId: Int, quantity: Int): String`
- `Fragment.getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String`

Extensions for `Drawable`:
- `Drawable.withTint(@ColorInt tint: Int): Drawable`

Extensions to resolve attributes from `Context` theme:
- `Context.resolveAttribute(@AttrRes attributeResId: Int): TypedValue?`
- `Context.resolveAttributeOrThrow(@AttrRes attributeResId: Int): TypedValue`
- `Context.resolveBoolean(@AttrRes attributeResId: Int): Boolean`
- `Context.resolveColor(@AttrRes attributeResId: Int): Int`
- `Context.resolveColor(@AttrRes attributeResId: Int, @ColorInt defaultValue: Int): Int`
- `Context.resolveDimension(@AttrRes attributeResId: Int): Float`
- `Context.resolveDimensionPixelSize(@AttrRes attributeResId: Int): Int`
- `Context.resolveDimensionPixelOffset(@AttrRes attributeResId: Int): Int`
- `Context.resolveFloat(@AttrRes attributeResId: Int): Float`
- `Context.resolveInt(@AttrRes attributeResId: Int): Int`
- `Context.resolveString(@AttrRes attributeResId: Int): CharSequence?`
- `Context.resolveResourceId(@AttrRes attributeResId: Int): Int`

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

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/resources-ktx
[license]: ../../LICENSE
