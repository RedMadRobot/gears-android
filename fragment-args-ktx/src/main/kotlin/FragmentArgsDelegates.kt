package com.redmadrobot.extensions.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.SparseArray
import androidx.fragment.app.Fragment
import com.redmadrobot.extensions.fragment.internal.BundleGetter
import com.redmadrobot.extensions.fragment.internal.delegate
import java.io.Serializable
import kotlin.properties.ReadWriteProperty

/**
 * Creates a delegate to read and write argument containing [Boolean] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.boolean(
    key: String? = null,
    default: (key: String) -> Boolean = ::noDefaultValue,
): ReadWriteProperty<Fragment, Boolean> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getBoolean(it) }, orElse = default) },
        setValue = { propertyKey, value -> putBoolean(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [BooleanArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.booleanArray(
    key: String? = null,
    default: (key: String) -> BooleanArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, BooleanArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getBooleanArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putBooleanArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [BooleanArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.booleanArrayNullable(key: String? = null): ReadWriteProperty<Fragment, BooleanArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getBooleanArray(propertyKey) },
        setValue = { propertyKey, value -> putBooleanArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Byte] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.byte(
    key: String? = null,
    default: (key: String) -> Byte = ::noDefaultValue,
): ReadWriteProperty<Fragment, Byte> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getByte(it) }, orElse = default) },
        setValue = Bundle::putByte,
    )
}

/**
 * Creates a delegate to read and write argument containing [ByteArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.byteArray(
    key: String? = null,
    default: (key: String) -> ByteArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, ByteArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getByteArray(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putByteArray,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [ByteArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.byteArrayNullable(key: String? = null): ReadWriteProperty<Fragment, ByteArray?> {
    return delegate(
        key = key,
        getValue = Bundle::getByteArray,
        setValue = Bundle::putByteArray,
    )
}

/**
 * Creates a delegate to read and write argument containing [Char] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.char(
    key: String? = null,
    default: (key: String) -> Char = ::noDefaultValue,
): ReadWriteProperty<Fragment, Char> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getChar(it) }, orElse = default) },
        setValue = Bundle::putChar,
    )
}

/**
 * Creates a delegate to read and write argument containing [CharArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.charArray(
    key: String? = null,
    default: (key: String) -> CharArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, CharArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharArray(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putCharArray,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [CharArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.charArrayNullable(key: String? = null): ReadWriteProperty<Fragment, CharArray?> {
    return delegate(
        key = key,
        getValue = Bundle::getCharArray,
        setValue = Bundle::putCharArray,
    )
}

/**
 * Creates a delegate to read and write argument containing [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.charSequence(
    key: String? = null,
    default: (key: String) -> CharSequence = ::noDefaultValue,
): ReadWriteProperty<Fragment, CharSequence> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequence(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putCharSequence,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.charSequenceNullable(key: String? = null): ReadWriteProperty<Fragment, CharSequence?> {
    return delegate(
        key = key,
        getValue = Bundle::getCharSequence,
        setValue = Bundle::putCharSequence,
    )
}

/**
 * Creates a delegate to read and write argument containing array of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.charSequenceArray(
    key: String? = null,
    default: (key: String) -> Array<CharSequence> = ::noDefaultValue,
): ReadWriteProperty<Fragment, Array<CharSequence>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArray(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putCharSequenceArray,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.charSequenceArrayNullable(key: String? = null): ReadWriteProperty<Fragment, Array<CharSequence>?> {
    return delegate(
        key = key,
        getValue = Bundle::getCharSequenceArray,
        setValue = Bundle::putCharSequenceArray,
    )
}

/**
 * Creates a delegate to read and write argument containing list of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.charSequenceList(
    key: String? = null,
    default: (key: String) -> List<CharSequence> = ::noDefaultValue,
): ReadWriteProperty<Fragment, List<CharSequence>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArrayList(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putCharSequenceArrayList(propertyKey, ArrayList(value)) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [CharSequence] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.charSequenceListNullable(key: String? = null): ReadWriteProperty<Fragment, List<CharSequence>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getCharSequenceArrayList(propertyKey) },
        setValue = { propertyKey, value -> putCharSequenceArrayList(propertyKey, value?.let { ArrayList(it) }) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Double] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.double(
    key: String? = null,
    default: (key: String) -> Double = ::noDefaultValue,
): ReadWriteProperty<Fragment, Double> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getDouble(it) }, orElse = default) },
        setValue = { propertyKey, value -> putDouble(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [DoubleArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.doubleArray(
    key: String? = null,
    default: (key: String) -> DoubleArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, DoubleArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getDoubleArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putDoubleArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [Double] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.doubleArrayNullable(key: String? = null): ReadWriteProperty<Fragment, DoubleArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getDoubleArray(propertyKey) },
        setValue = { propertyKey, value -> putDoubleArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Float] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.float(
    key: String? = null,
    default: (key: String) -> Float = ::noDefaultValue,
): ReadWriteProperty<Fragment, Float> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getFloat(propertyKey) }, orElse = default) },
        setValue = Bundle::putFloat,
    )
}

/**
 * Creates a delegate to read and write argument containing [FloatArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.floatArray(
    key: String? = null,
    default: (key: String) -> FloatArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, FloatArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getFloatArray(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putFloatArray,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [FloatArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.floatArrayNullable(key: String? = null): ReadWriteProperty<Fragment, FloatArray?> {
    return delegate(
        key = key,
        getValue = Bundle::getFloatArray,
        setValue = Bundle::putFloatArray,
    )
}

/**
 * Creates a delegate to read and write argument containing [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.int(
    key: String? = null,
    default: (key: String) -> Int = ::noDefaultValue,
): ReadWriteProperty<Fragment, Int> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getInt(it) }, orElse = default) },
        setValue = { propertyKey, value -> putInt(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [IntArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.intArray(
    key: String? = null,
    default: (key: String) -> IntArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, IntArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putIntArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [IntArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.intArrayNullable(key: String? = null): ReadWriteProperty<Fragment, IntArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntArray(propertyKey) },
        setValue = { propertyKey, value -> putIntArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.intList(
    key: String? = null,
    default: (key: String) -> List<Int> = ::noDefaultValue,
): ReadWriteProperty<Fragment, List<Int>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntegerArrayList(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putIntegerArrayList(propertyKey, ArrayList(value)) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Int] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.intListNullable(key: String? = null): ReadWriteProperty<Fragment, List<Int>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getIntegerArrayList(propertyKey) },
        setValue = { propertyKey, value -> putIntegerArrayList(propertyKey, value?.let { ArrayList(it) }) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Long] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.long(
    key: String? = null,
    default: (key: String) -> Long = ::noDefaultValue,
): ReadWriteProperty<Fragment, Long> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getLong(it) }, orElse = default) },
        setValue = { propertyKey, value -> putLong(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [LongArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.longArray(
    key: String? = null,
    default: (key: String) -> LongArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, LongArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getLongArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putLongArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [LongArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.longArrayNullable(key: String? = null): ReadWriteProperty<Fragment, LongArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getLongArray(propertyKey) },
        setValue = { propertyKey, value -> putLongArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun <T : Parcelable> Bundle?.parcelable(
    key: String? = null,
    default: (key: String) -> T = ::noDefaultValue,
): ReadWriteProperty<Fragment, T> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getParcelable(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putParcelable,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun <T : Parcelable> Bundle?.parcelableNullable(key: String? = null): ReadWriteProperty<Fragment, T?> {
    return delegate(
        key = key,
        getValue = Bundle::getParcelable,
        setValue = Bundle::putParcelable,
    )
}

/**
 * Creates a delegate to read and write argument containing sparse array of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun <T : Parcelable> Bundle?.sparseParcelableArray(
    key: String? = null,
    default: (key: String) -> SparseArray<T> = ::noDefaultValue,
): ReadWriteProperty<Fragment, SparseArray<T>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getSparseParcelableArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putSparseParcelableArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable sparse array of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun <T : Parcelable> Bundle?.sparseParcelableArrayNullable(
    key: String? = null,
): ReadWriteProperty<Fragment, SparseArray<T>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getSparseParcelableArray(propertyKey) },
        setValue = { propertyKey, value -> putSparseParcelableArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun <T : Parcelable> Bundle?.parcelableList(
    key: String? = null,
    default: (key: String) -> List<T> = ::noDefaultValue,
): ReadWriteProperty<Fragment, List<T>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getParcelableArrayList(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putParcelableArrayList(propertyKey, ArrayList(value)) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Parcelable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun <T : Parcelable> Bundle?.parcelableListNullable(key: String? = null): ReadWriteProperty<Fragment, List<T>?> {
    return delegate(
        key = key,
        getValue = Bundle::getParcelableArrayList,
        setValue = { propertyKey, value -> putParcelableArrayList(propertyKey, value?.let { ArrayList(it) }) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun <T : Serializable> Bundle?.serializable(
    key: String? = null,
    default: (key: String) -> T = ::noDefaultValue,
): ReadWriteProperty<Fragment, T> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default(propertyKey)) as T },
        setValue = Bundle::putSerializable,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun <T : Serializable> Bundle?.serializableNullable(key: String? = null): ReadWriteProperty<Fragment, T?> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> getSerializable(propertyKey) as? T },
        setValue = Bundle::putSerializable,
    )
}

/**
 * Creates a delegate to read and write argument containing list of [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun <T : Serializable> Bundle?.serializableList(
    key: String? = null,
    default: (key: String) -> List<T> = ::noDefaultValue,
): ReadWriteProperty<Fragment, List<T>> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> (getSerializable(propertyKey) ?: default(propertyKey)) as List<T> },
        setValue = { propertyKey, value -> putSerializable(propertyKey, value as Serializable) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [Serializable] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun <T : Serializable> Bundle?.serializableListNullable(
    key: String? = null,
): ReadWriteProperty<Fragment, List<T>?> {
    @Suppress("UNCHECKED_CAST")
    return delegate(
        key = key,
        getValue = { propertyKey -> getSerializable(propertyKey) as? List<T> },
        setValue = { propertyKey, value -> putSerializable(propertyKey, value as Serializable) },
    )
}

/**
 * Creates a delegate to read and write argument containing [Short] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.short(
    key: String? = null,
    default: (key: String) -> Short = ::noDefaultValue,
): ReadWriteProperty<Fragment, Short> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getOrElse(propertyKey, getter = { getShort(it) }, orElse = default) },
        setValue = Bundle::putShort,
    )
}

/**
 * Creates a delegate to read and write argument containing [ShortArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.shortArray(
    key: String? = null,
    default: (key: String) -> ShortArray = ::noDefaultValue,
): ReadWriteProperty<Fragment, ShortArray> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getShortArray(propertyKey) ?: default(propertyKey) },
        setValue = Bundle::putShortArray,
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [ShortArray] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.shortArrayNullable(key: String? = null): ReadWriteProperty<Fragment, ShortArray?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getShortArray(propertyKey) },
        setValue = Bundle::putShortArray,
    )
}

/**
 * Creates a delegate to read and write argument containing [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.string(
    key: String? = null,
    default: (key: String) -> String = ::noDefaultValue,
): ReadWriteProperty<Fragment, String> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getString(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putString(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.stringNullable(key: String? = null): ReadWriteProperty<Fragment, String?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getString(propertyKey) },
        setValue = { propertyKey, value -> putString(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing array of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.stringArray(
    key: String? = null,
    default: (key: String) -> Array<String> = ::noDefaultValue,
): ReadWriteProperty<Fragment, Array<String>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArray(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putStringArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable array of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.stringArrayNullable(key: String? = null): ReadWriteProperty<Fragment, Array<String>?> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArray(propertyKey) },
        setValue = { propertyKey, value -> putStringArray(propertyKey, value) },
    )
}

/**
 * Creates a delegate to read and write argument containing list of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key,
 * or throws [IllegalStateException] if [default] is not specified.
 */
public fun Bundle?.stringList(
    key: String? = null,
    default: (key: String) -> List<String> = ::noDefaultValue,
): ReadWriteProperty<Fragment, List<String>> {
    return delegate(
        key = key,
        getValue = { propertyKey -> getStringArrayList(propertyKey) ?: default(propertyKey) },
        setValue = { propertyKey, value -> putStringArrayList(propertyKey, ArrayList(value)) },
    )
}

/**
 * Creates a delegate to read and write argument containing nullable list of [String] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns `null` if there is no argument associated with the given key.
 */
public fun Bundle?.stringListNullable(key: String? = null): ReadWriteProperty<Fragment, List<String>?> {
    return delegate(
        key = key,
        getValue = Bundle::getStringArrayList,
        setValue = { propertyKey, value -> putStringArrayList(propertyKey, value?.let { ArrayList(it) }) },
    )
}

private inline fun <T> Bundle.getOrElse(
    key: String,
    crossinline getter: BundleGetter<T>,
    crossinline orElse: (key: String) -> T,
): T {
    return if (containsKey(key)) getter(key) else orElse(key)
}

private fun noDefaultValue(key: String): Nothing =
    error("Value for the key '$key' is not assigned and default is not set.")
