# resources-ktx <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/resources-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/resources-ktx?style=flat-square)][mavenCentral] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

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
    implementation("com.redmadrobot.extensions:resources-ktx:1.2.0-1")
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

Accessors for `Fragment`:
- `Fragment.getColor(@ColorRes resId: Int): Int`
- `Fragment.getColorStateList(@ColorRes resId: Int): ColorStateList?`
- `Fragment.getDrawable(@DrawableRes resId: Int): Drawable?`
- `Fragment.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable?`
- `Fragment.getDimension(@DimenRes resId: Int): Float`
- `Fragment.getDimensionPixelSize(@DimenRes resId: Int): Int`
- `Fragment.getDimensionPixelOffset(@DimenRes resId: Int): Int`

Extensions for `Drawable`:
- `Drawable.withTint(@ColorInt tint: Int): Drawable`

Extensions to resolve attributes:
- `Context.resolveAttribute(@AttrRes attributeResId: Int): TypedValue?`
- `Context.resolveAttributeOrThrow(@AttrRes attributeResId: Int): TypedValue`
- `Context.resolveColor(@AttrRes colorAttributeResId: Int): Int`
- `Context.resolveColor(@AttrRes colorAttributeResId: Int, @ColorInt defaultValue: Int): Int`
- `Context.resolveResourceId(@AttrRes attributeResId: Int): Int`

Dimension converters for `Context` (the same available for `Resources`):
- `Context.dpToPx(dp: Int): Int`
- `Context.dpToPx(dp: Float): Int`
- `Context.dpToPxPrecisely(dp: Int): Float`
- `Context.dpToPxPrecisely(dp: Float): Float`
- `Context.pxToDp(px: Int): Float`
- `Context.pxToDp(px: Float): Float`

### Wrapper `Text` 

**Text** is a wrapper to make it possible to work with plain `String` and `StringRes` in the same way.
It may be useful for cases when you want to fallback to `StringRes` if desired string value is `null`.

You can wrap `String` and `StringRes` into `Text` using `Text.Plain(String)` and `Text.Resource(Int)`, accordingly and use method `Text.get(Context)` to retrieve `String`:

```kotlin
// in some place where we can't access Context
val errorMessage = exception.message?.let(Text::Plain) ?: Text.Resource(R.string.unknown_error)
showMessage(errorMessage)

// in Activity, Fragment or View
fun showMessage(text: Text) {
    val messageText = text.get(context)
    //...
}
```

There are extensions to work with `Text` like with `StringRes`:

- `Context.getString(text: Text): String`
- `Fragment.getString(text: Text): String`
- `View.getString(text: Text): String`

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/resources-ktx
[license]: ../LICENSE
