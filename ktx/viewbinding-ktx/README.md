# viewbinding-ktx <GitHub path="RedMadRobot/gears-android/tree/main/ktx/viewbinding-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/viewbinding-ktx?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

A set of Kotlin extensions for dealing with ViewBinding.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
  - [Delegate](#delegate)
  - [Extensions](#extensions)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:

```kotlin
repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.redmadrobot.extensions:viewbinding-ktx:4.2.1-0")
}
```

Enable ViewBinding in build script:

```kotlin
android {
    // For Android Gradle Plugin 4.0+
    buildFeatures.viewBinding = true

    // For Android Gradle Plugin prior to 3.6
    viewBinding.isEnabled = true
}
```

## Usage

### Delegate

For Fragments' layouts use `ViewBinding` delegate.
Resulting binding bounded to Fragment View's lifecycle.
It will be cleared after `onDestroyView`.

```kotlin
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding: FragmentProfileBinging by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            // use binding fields
        }
    }
}
```

### Extensions

Inflate `ViewBinding` using `LayoutInflater`:

```kotlin
class PickDateFragment : DialogFragment() {

    private lateinit val binding: DialogPickDateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflateViewBinding(container, attachToRoot = false)
        return binding.root
    }
}
```

Inflate `ViewBinding` using `Context`:

```kotlin
fun createDetailsView(card: Card): MaterialTextView {
    return requireContext().inflateViewBinding<ViewCardDetailsBinding>().apply {
        name.text = card.name
        //...
    }
}
```

Inflate `ViewBinding` and attach it to `ViewGroup`:

```kotlin
class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewErrorBinding = inflateViewBinding()
}
```

Obtain `ViewBinding` from inflated view:

```kotlin
class TransactionsItem : Item {

    override val layoutId = R.layout.item_transaction

    private lateinit var binding: ItemTransactionBinding

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        binding = viewHolder.itemView.getBinding()
        with(binding) {
            // ...
        }
    }
}
```

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/viewbinding-ktx
[license]: ../../LICENSE
