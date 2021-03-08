package com.redmadrobot.extensions.viewbinding

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.Lifecycle.State.INITIALIZED
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Delegate returning ViewBinding bounded to [Fragment]'s lifecycle.
 *
 * Usage:
 * ```
 *  class ProfileFragment : Fragment(R.layout.fragment_profile) {
 *
 *      private val binding: FragmentProfileBinging by viewBinding()
 *
 *      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 *          super.onViewCreated(view, savedInstanceState)
 *
 *          with(binding) {
 *              // use binding fields
 *          }
 *      }
 *  }
 * ```
 * Accessing `binding` before `onViewCreated` or after `onViewDestroy` throws [IllegalStateException].
 */
public inline fun <reified VB : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Any?, VB> {
    return ViewBindingDelegate(this, VB::class)
}

/** @see viewBinding */
@PublishedApi
internal class ViewBindingDelegate<VB : ViewBinding> constructor(
    private val fragment: Fragment,
    private val viewBindingClass: KClass<VB>,
) : ReadOnlyProperty<Any?, VB> {

    private var binding: VB? = null

    private val bindingCleaner: LifecycleObserver by lazy {
        object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == ON_DESTROY) {
                    binding = null
                    source.lifecycle.removeObserver(this)
                }
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): VB = binding ?: obtainBinding()

    private fun obtainBinding(): VB {
        val view = checkNotNull(fragment.view) {
            "ViewBinding is only valid between onCreateView and onDestroyView."
        }
        return viewBindingClass.bind(view)
            .also(::saveBindingIfNeed)
    }

    private fun saveBindingIfNeed(binding: VB) {
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        // Save binding if view is not destroyed
        if (lifecycle.currentState.isAtLeast(INITIALIZED)) {
            this.binding = binding
            // Clean binding on view destroy
            lifecycle.addObserver(bindingCleaner)
        }
    }
}
