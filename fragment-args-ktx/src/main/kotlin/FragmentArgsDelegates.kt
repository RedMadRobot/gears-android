// Public API
@file:Suppress("unused")

package com.redmadrobot.extensions.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.SparseArray
import androidx.fragment.app.Fragment
import com.redmadrobot.extensions.fragment.internal.delegate
import java.io.Serializable
import kotlin.properties.ReadWriteProperty

/**
 * Creates a delegate to read and write argument containing [Boolean] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `false`.
 */
fun Bundle?.boolean(key: String? = null, default: () -> Boolean = { false }): ReadWriteProperty<Fragment, Boolean> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getBoolean(propertyKey, default()) },
        setValue = { propertyKey, value -> putBoolean(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [BooleanArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.booleanArray(
    key: String? = null,
    default: () -> BooleanArray = { booleanArrayOf() }
): ReadWriteProperty<Fragment, BooleanArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getBooleanArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putBooleanArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [BooleanArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.booleanArrayNullable(
    key: String? = null,
    default: () -> BooleanArray? = { null }
): ReadWriteProperty<Fragment, BooleanArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getBooleanArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putBooleanArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Byte] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
fun Bundle?.byte(key: String? = null, default: () -> Byte = { 0 }): ReadWriteProperty<Fragment, Byte> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getByte(propertyKey, default()) },
        setValue = Bundle::putByte
    )
}

/**
 * Creates a delegate to read and write argument containing [ByteArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.byteArray(
    key: String? = null,
    default: () -> ByteArray = { byteArrayOf() }
): ReadWriteProperty<Fragment, ByteArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getByteArray(propertyKey) ?: default() },
        setValue = Bundle::putByteArray
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [ByteArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.byteArrayNullable(
    key: String? = null,
    default: () -> ByteArray? = { null }
): ReadWriteProperty<Fragment, ByteArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getByteArray(propertyKey) ?: default() },
        setValue = Bundle::putByteArray
    )
}

/**
 * Creates a delegate to read and write argument containing [Char] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
fun Bundle?.char(key: String? = null, default: () -> Char = { '\u0000' }): ReadWriteProperty<Fragment, Char> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getChar(propertyKey, default()) },
        setValue = Bundle::putChar
    )
}

/**
 * Creates a delegate to read and write argument containing [CharArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.charArray(
    key: String? = null,
    default: () -> CharArray = { charArrayOf() }
): ReadWriteProperty<Fragment, CharArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharArray(propertyKey) ?: default() },
        setValue = Bundle::putCharArray
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [CharArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.charArrayNullable(
    key: String? = null,
    default: () -> CharArray? = { null }
): ReadWriteProperty<Fragment, CharArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharArray(propertyKey) ?: default() },
        setValue = Bundle::putCharArray
    )
}

/**
 * Creates a delegate to read and write argument containing [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty char sequence.
 */
fun Bundle?.charSequence(
    key: String? = null,
    default: () -> CharSequence = { "" }
): ReadWriteProperty<Fragment, CharSequence> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequence(propertyKey, default()) },
        setValue = Bundle::putCharSequence
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.charSequenceNullable(
    key: String? = null,
    default: () -> CharSequence? = { null }
): ReadWriteProperty<Fragment, CharSequence?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequence(propertyKey, default()) },
        setValue = Bundle::putCharSequence
    )
}

/**
 * Creates a delegate to read and write argument containing array of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.charSequenceArray(
    key: String? = null,
    default: () -> Array<CharSequence> = { arrayOf() }
): ReadWriteProperty<Fragment, Array<CharSequence>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArray(propertyKey) ?: default() },
        setValue = Bundle::putCharSequenceArray
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.charSequenceArrayNullable(
    key: String? = null,
    default: () -> Array<CharSequence>? = { null }
): ReadWriteProperty<Fragment, Array<CharSequence>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArray(propertyKey) ?: default() },
        setValue = Bundle::putCharSequenceArray
    )
}

/**
 * Creates a delegate to read and write argument containing list of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty list.
 */
fun Bundle?.charSequenceList(
    key: String? = null,
    default: () -> List<CharSequence> = ::emptyList
): ReadWriteProperty<Fragment, List<CharSequence>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putCharSequenceArrayList(propertyKey, ArrayList(value)) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.charSequenceListNullable(
    key: String? = null,
    default: () -> List<CharSequence>? = { null }
): ReadWriteProperty<Fragment, List<CharSequence>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putCharSequenceArrayList(propertyKey, value?.let { ArrayList(it) }) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Double] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0.0`.
 */
fun Bundle?.double(key: String? = null, default: () -> Double = { 0.0 }): ReadWriteProperty<Fragment, Double> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getDouble(propertyKey, default()) },
        setValue = { propertyKey, value -> putDouble(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [DoubleArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.doubleArray(
    key: String? = null,
    default: () -> DoubleArray = { doubleArrayOf() }
): ReadWriteProperty<Fragment, DoubleArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getDoubleArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putDoubleArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [Double] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.doubleArrayNullable(
    key: String? = null,
    default: () -> DoubleArray? = { null }
): ReadWriteProperty<Fragment, DoubleArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getDoubleArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putDoubleArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Float] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0.0`.
 */
fun Bundle?.float(key: String? = null, default: () -> Float = { 0f }): ReadWriteProperty<Fragment, Float> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getFloat(propertyKey, default()) },
        setValue = Bundle::putFloat
    )
}

/**
 * Creates a delegate to read and write argument containing [FloatArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.floatArray(
    key: String? = null,
    default: () -> FloatArray = { floatArrayOf() }
): ReadWriteProperty<Fragment, FloatArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getFloatArray(propertyKey) ?: default() },
        setValue = Bundle::putFloatArray
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [FloatArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.floatArrayNullable(
    key: String? = null,
    default: () -> FloatArray? = { null }
): ReadWriteProperty<Fragment, FloatArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getFloatArray(propertyKey) ?: default() },
        setValue = Bundle::putFloatArray
    )
}

/**
 * Creates a delegate to read and write argument containing [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
fun Bundle?.int(key: String? = null, default: () -> Int = { 0 }): ReadWriteProperty<Fragment, Int> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getInt(propertyKey, default()) },
        setValue = { propertyKey, value -> putInt(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [IntArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.intArray(
    key: String? = null,
    default: () -> IntArray = { intArrayOf() }
): ReadWriteProperty<Fragment, IntArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putIntArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [IntArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.intArrayNullable(
    key: String? = null,
    default: () -> IntArray? = { null }
): ReadWriteProperty<Fragment, IntArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putIntArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty list.
 */
fun Bundle?.intList(
    key: String? = null,
    default: () -> List<Int> = ::emptyList
): ReadWriteProperty<Fragment, List<Int>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntegerArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putIntegerArrayList(propertyKey, ArrayList(value)) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.intListNullable(
    key: String? = null,
    default: () -> ArrayList<Int>? = { null }
): ReadWriteProperty<Fragment, ArrayList<Int>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntegerArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putIntegerArrayList(propertyKey, value?.let { ArrayList(it) }) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Long] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
fun Bundle?.long(key: String? = null, default: () -> Long = { 0 }): ReadWriteProperty<Fragment, Long> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getLong(propertyKey, default()) },
        setValue = { propertyKey, value -> putLong(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [LongArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.longArray(
    key: String? = null,
    default: () -> LongArray = { longArrayOf() }
): ReadWriteProperty<Fragment, LongArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getLongArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putLongArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [LongArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.longArrayNullable(
    key: String? = null,
    default: () -> LongArray? = { null }
): ReadWriteProperty<Fragment, LongArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getLongArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putLongArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is undefined.
 */
fun <T : Parcelable> Bundle?.parcelable(
    key: String? = null,
    default: () -> T = ::noDefaultValue
): ReadWriteProperty<Fragment, T> {
    @Suppress("USELESS_CAST") // Can't infer type without cast (check in kotlin 1.4)
    return delegate(
        key = key,
        getValue = { propertyKey -> (getParcelable(propertyKey) ?: default()) as T },
        setValue = Bundle::putParcelable
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun <T : Parcelable> Bundle?.parcelableNullable(
    key: String? = null,
    default: () -> T? = { null }
): ReadWriteProperty<Fragment, T?> {
    @Suppress("USELESS_CAST") // Can't infer type without cast (check in kotlin 1.4)
    return delegate(
        key = key,
        getValue = { propertyKey -> (getParcelable(propertyKey) ?: default()) as T? },
        setValue = Bundle::putParcelable
    )
}

/**
 * Creates a delegate to read and write argument containing sparse array of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun <T : Parcelable> Bundle?.sparseParcelableArray(
    key: String? = null,
    default: () -> SparseArray<T> = { SparseArray() }
): ReadWriteProperty<Fragment, SparseArray<T>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getSparseParcelableArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putSparseParcelableArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable sparse array of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun <T : Parcelable> Bundle?.sparseParcelableArrayNullable(
    key: String? = null,
    default: () -> SparseArray<T>? = { null }
): ReadWriteProperty<Fragment, SparseArray<T>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getSparseParcelableArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putSparseParcelableArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty list.
 */
fun <T : Parcelable> Bundle?.parcelableList(
    key: String? = null,
    default: () -> List<T> = ::emptyList
): ReadWriteProperty<Fragment, List<T>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getParcelableArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putParcelableArrayList(propertyKey, ArrayList(value)) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun <T : Parcelable> Bundle?.parcelableListNullable(
    key: String? = null,
    default: () -> List<T>? = { null }
): ReadWriteProperty<Fragment, List<T>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getParcelableArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putParcelableArrayList(propertyKey, value?.let { ArrayList(it) }) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is undefined.
 */
fun <T : Serializable> Bundle?.serializable(
    key: String? = null,
    default: () -> T = ::noDefaultValue
): ReadWriteProperty<Fragment, T> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default()) as T },
        setValue = Bundle::putSerializable
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun <T : Serializable> Bundle?.serializableNullable(
    key: String? = null,
    default: () -> T? = { null }
): ReadWriteProperty<Fragment, T?> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default()) as T? },
        setValue = Bundle::putSerializable
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty list.
 */
fun <T : Serializable> Bundle?.serializableList(
    key: String? = null,
    default: () -> List<T> = ::emptyList
): ReadWriteProperty<Fragment, List<T>> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default()) as List<T> },
        setValue = { propertyKey, value -> putSerializable(propertyKey, value as Serializable) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun <T : Serializable> Bundle?.serializableListNullable(
    key: String? = null,
    default: () -> List<T>? = { null }
): ReadWriteProperty<Fragment, List<T>?> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default()) as List<T>? },
        setValue = { propertyKey, value -> putSerializable(propertyKey, value as Serializable) }
    )
}

/**
 * Creates a delegate to read and write argument containing [Short] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
fun Bundle?.short(key: String? = null, default: () -> Short = { 0 }): ReadWriteProperty<Fragment, Short> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getShort(propertyKey, default()) },
        setValue = Bundle::putShort
    )
}

/**
 * Creates a delegate to read and write argument containing [ShortArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.shortArray(
    key: String? = null,
    default: () -> ShortArray = { shortArrayOf() }
): ReadWriteProperty<Fragment, ShortArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getShortArray(propertyKey) ?: default() },
        setValue = Bundle::putShortArray
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [ShortArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.shortArrayNullable(
    key: String? = null,
    default: () -> ShortArray? = { null }
): ReadWriteProperty<Fragment, ShortArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getShortArray(propertyKey) ?: default() },
        setValue = Bundle::putShortArray
    )
}

/**
 * Creates a delegate to read and write argument containing [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty string.
 */
fun Bundle?.string(key: String? = null, default: () -> String = { "" }): ReadWriteProperty<Fragment, String> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getString(propertyKey, default()) },
        setValue = { propertyKey, value -> putString(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.stringNullable(
    key: String? = null,
    default: () -> String? = { null }
): ReadWriteProperty<Fragment, String?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getString(propertyKey, default()) },
        setValue = { propertyKey, value -> putString(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing array of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty array.
 */
fun Bundle?.stringArray(
    key: String? = null,
    default: () -> Array<String> = ::emptyArray
): ReadWriteProperty<Fragment, Array<String>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putStringArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.stringArrayNullable(
    key: String? = null,
    default: () -> Array<String>? = { null }
): ReadWriteProperty<Fragment, Array<String>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArray(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putStringArray(propertyKey, value) }
    )
}

/**
 * Creates a delegate to read and write argument containing list of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty list.
 */
fun Bundle?.stringList(
    key: String? = null,
    default: () -> List<String> = ::emptyList
): ReadWriteProperty<Fragment, List<String>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putStringArrayList(propertyKey, ArrayList(value)) }
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
fun Bundle?.stringListNullable(
    key: String? = null,
    default: () -> List<String>? = { null }
): ReadWriteProperty<Fragment, List<String>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArrayList(propertyKey) ?: default() },
        setValue = { propertyKey, value -> putStringArrayList(propertyKey, value?.let { ArrayList(it) }) }
    )
}

private fun noDefaultValue(): Nothing = error("No default value specified")
