// Public API
@file:Suppress("unused")

package com.redmadrobot.extensions.fragment

import androidx.activity.OnBackPressedCallback
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment

/**
 * Create and add a new [OnBackPressedCallback] tied to [Fragment.getViewLifecycleOwner]
 * that calls [onBackPressed] in [OnBackPressedCallback.handleOnBackPressed].
 *
 * Callback should be added in [Fragment.onAttach] or later. Callbacks are tied to [Fragment.getViewLifecycleOwner] so
 * it will only be added when the fragment view's Lifecycle is [androidx.lifecycle.Lifecycle.State.STARTED].
 * ```
 *  class FormEntryFragment : Fragment() {
 *      override fun onAttach(context: Context) {
 *          super.onAttach(context)
 *          addOnBackPressedCallback {
 *              showAreYouSureDialog()
 *          }
 *      }
 *  }
 * ```
 * @param enabled Callback state. By default is `true`.
 * @return Created callback. You can manage it using [OnBackPressedCallback.setEnabled] and
 * [OnBackPressedCallback.remove].
 * @see OnBackPressedCallback
 * @see androidx.activity.OnBackPressedDispatcher
 */
@MainThread
public inline fun Fragment.addOnBackPressedCallback(
    enabled: Boolean = true,
    crossinline onBackPressed: OnBackPressedCallback.() -> Unit
): OnBackPressedCallback {
    return object : OnBackPressedCallback(enabled) {
        override fun handleOnBackPressed() = onBackPressed()
    }.also { requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, it) }
}
