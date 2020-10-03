package com.redmadrobot.extensions.viewbinding

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
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
inline fun <reified VB : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Any?, VB> {
    return ViewBindingDelegate(this, VB::class)
}

/** @see viewBinding */
@PublishedApi
internal class ViewBindingDelegate<VB : ViewBinding> constructor(
    private val fragment: Fragment,
    private val viewBindingClass: KClass<VB>
) : ReadOnlyProperty<Any?, VB>, LifecycleEventObserver {

    private var binding: VB? = null
    private val handler = Handler(Looper.getMainLooper())

    init {
        fragment.viewLifecycleOwnerLiveData.observe(
            fragment,
            Observer { it.lifecycle.addObserver(this) }
        )
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): VB = binding ?: obtainBinding()

    private fun obtainBinding(): VB {
        val view = checkNotNull(fragment.view) {
            "ViewBinding is only valid between onCreateView and onDestroyView."
        }
        return viewBindingClass.bind(view)
            .also { binding = it }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.lifecycle.removeObserver(this)
            handler.post { binding = null }
        }
    }
}
