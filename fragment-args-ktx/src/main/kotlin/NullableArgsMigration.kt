package com.redmadrobot.extensions.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.SparseArray
import androidx.fragment.app.Fragment
import java.io.Serializable
import kotlin.properties.ReadWriteProperty

/** @see Bundle.booleanArray */
@Deprecated("Use 'booleanArray' instead", ReplaceWith("this.booleanArray(key, default)"))
@JvmName("booleanArrayNotNullable")
public fun Bundle?.booleanArrayNullable(
    key: String? = null,
    default: (key: String) -> BooleanArray,
): ReadWriteProperty<Fragment, BooleanArray> = booleanArray(key, default)

/** @see Bundle.byteArray */
@Deprecated("Use 'byteArray' instead", ReplaceWith("this.byteArray(key, default)"))
@JvmName("byteArrayNotNullable")
public fun Bundle?.byteArrayNullable(
    key: String? = null,
    default: (key: String) -> ByteArray,
): ReadWriteProperty<Fragment, ByteArray> = byteArray(key, default)

/** @see Bundle.charArray */
@Deprecated("Use 'charArray' instead", ReplaceWith("this.charArray(key, default)"))
@JvmName("charArrayNotNullable")
public fun Bundle?.charArrayNullable(
    key: String? = null,
    default: (key: String) -> CharArray,
): ReadWriteProperty<Fragment, CharArray> = charArray(key, default)

/** @see Bundle.charSequence */
@Deprecated("Use 'charSequence' instead", ReplaceWith("this.charSequence(key, default)"))
@JvmName("charSequenceNotNullable")
public fun Bundle?.charSequenceNullable(
    key: String? = null,
    default: (key: String) -> CharSequence,
): ReadWriteProperty<Fragment, CharSequence> = charSequence(key, default)

/** @see Bundle.charSequenceArray */
@Deprecated("Use 'charSequenceArray' instead", ReplaceWith("this.charSequenceArray(key, default)"))
@JvmName("charSequenceArrayNotNullable")
public fun Bundle?.charSequenceArrayNullable(
    key: String? = null,
    default: (key: String) -> Array<CharSequence>,
): ReadWriteProperty<Fragment, Array<CharSequence>> = charSequenceArray(key, default)

/** @see Bundle.charSequenceList */
@Deprecated("Use 'charSequenceList' instead", ReplaceWith("this.charSequenceList(key, default)"))
@JvmName("charSequenceListNotNullable")
public fun Bundle?.charSequenceListNullable(
    key: String? = null,
    default: (key: String) -> List<CharSequence>,
): ReadWriteProperty<Fragment, List<CharSequence>> = charSequenceList(key, default)

/** @see Bundle.doubleArray */
@Deprecated("Use 'doubleArray' instead", ReplaceWith("this.doubleArray(key, default)"))
@JvmName("doubleArrayNotNullable")
public fun Bundle?.doubleArrayNullable(
    key: String? = null,
    default: (key: String) -> DoubleArray,
): ReadWriteProperty<Fragment, DoubleArray> = doubleArray(key, default)

/** @see Bundle.floatArray */
@Deprecated("Use 'floatArray' instead", ReplaceWith("this.floatArray(key, default)"))
@JvmName("floatArrayNotNullable")
public fun Bundle?.floatArrayNullable(
    key: String? = null,
    default: (key: String) -> FloatArray,
): ReadWriteProperty<Fragment, FloatArray> = floatArray(key, default)

/** @see Bundle.intArray */
@Deprecated("Use 'intArray' instead", ReplaceWith("this.intArray(key, default)"))
@JvmName("intArrayNotNullable")
public fun Bundle?.intArrayNullable(
    key: String? = null,
    default: (key: String) -> IntArray,
): ReadWriteProperty<Fragment, IntArray> = intArray(key, default)

/** @see Bundle.intList */
@Deprecated("Use 'intList' instead", ReplaceWith("this.intList(key, default)"))
@JvmName("intListNotNullable")
public fun Bundle?.intListNullable(
    key: String? = null,
    default: (key: String) -> List<Int>,
): ReadWriteProperty<Fragment, List<Int>> = intList(key, default)

/** @see Bundle.longArray */
@Deprecated("Use 'longArray' instead", ReplaceWith("this.longArray(key, default)"))
@JvmName("longArrayNotNullable")
public fun Bundle?.longArrayNullable(
    key: String? = null,
    default: (key: String) -> LongArray,
): ReadWriteProperty<Fragment, LongArray> = longArray(key, default)

/** @see Bundle.parcelable */
@Deprecated("Use 'parcelable' instead", ReplaceWith("this.parcelable(key, default)"))
@JvmName("parcelableNotNullable")
public fun <T : Parcelable> Bundle?.parcelableNullable(
    key: String? = null,
    default: (key: String) -> T,
): ReadWriteProperty<Fragment, T> = parcelable(key, default)

/** @see Bundle.sparseParcelableArray */
@Deprecated("Use 'sparseParcelableArray' instead", ReplaceWith("this.sparseParcelableArray(key, default)"))
@JvmName("sparseParcelableArrayNotNullable")
public fun <T : Parcelable> Bundle?.sparseParcelableArrayNullable(
    key: String? = null,
    default: (key: String) -> SparseArray<T>,
): ReadWriteProperty<Fragment, SparseArray<T>> = sparseParcelableArray(key, default)

/** @see Bundle.parcelableList */
@Deprecated("Use 'parcelableList' instead", ReplaceWith("this.parcelableList(key, default)"))
@JvmName("parcelableListNotNullable")
public fun <T : Parcelable> Bundle?.parcelableListNullable(
    key: String? = null,
    default: (key: String) -> List<T>,
): ReadWriteProperty<Fragment, List<T>> = parcelableList(key, default)

/** @see Bundle.serializable */
@Deprecated("Use 'serializable' instead", ReplaceWith("this.serializable(key, default)"))
@JvmName("serializableNotNullable")
public fun <T : Serializable> Bundle?.serializableNullable(
    key: String? = null,
    default: (key: String) -> T,
): ReadWriteProperty<Fragment, T> = serializable(key, default)

/** @see Bundle.serializableList */
@Deprecated("Use 'serializableList' instead", ReplaceWith("this.serializableList(key, default)"))
@JvmName("serializableListNotNullable")
public fun <T : Serializable> Bundle?.serializableListNullable(
    key: String? = null,
    default: (key: String) -> List<T>,
): ReadWriteProperty<Fragment, List<T>> = serializableList(key, default)

/** @see Bundle.shortArray */
@Deprecated("Use 'shortArray' instead", ReplaceWith("this.shortArray(key, default)"))
@JvmName("shortArrayNotNullable")
public fun Bundle?.shortArrayNullable(
    key: String? = null,
    default: (key: String) -> ShortArray,
): ReadWriteProperty<Fragment, ShortArray> = shortArray(key, default)

/** @see Bundle.string */
@Deprecated("Use 'string' instead", ReplaceWith("this.string(key, default)"))
@JvmName("stringNotNullable")
public fun Bundle?.stringNullable(
    key: String? = null,
    default: (key: String) -> String,
): ReadWriteProperty<Fragment, String> = string(key, default)

/** @see Bundle.stringArray */
@Deprecated("Use 'stringArray' instead", ReplaceWith("this.stringArray(key, default)"))
@JvmName("stringArrayNotNullable")
public fun Bundle?.stringArrayNullable(
    key: String? = null,
    default: (key: String) -> Array<String>,
): ReadWriteProperty<Fragment, Array<String>> = stringArray(key, default)

/** @see Bundle.stringList */
@Deprecated("Use 'stringList' instead", ReplaceWith("this.stringList(key, default)"))
@JvmName("stringListNotNullable")
public fun Bundle?.stringListNullable(
    key: String? = null,
    default: (key: String) -> List<String>,
): ReadWriteProperty<Fragment, List<String>> = stringList(key, default)
