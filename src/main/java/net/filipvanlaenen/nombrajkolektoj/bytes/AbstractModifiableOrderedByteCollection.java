package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for bytes.
 */
abstract class AbstractModifiableOrderedByteCollection extends AbstractModifiableByteCollection
        implements ModifiableOrderedNumericCollection<Byte> {
    @Override
    public Byte augment(final int index, final Byte addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        Byte originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot augment a null value with a number.");
        }
        Byte result = (byte) (originalValue + addend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<Byte> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            Byte addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null && addend != (byte) 0) {
                results[i] = (byte) (originalValue + addend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot augment with the addends due to the cardinality constraint.");
        return true;
    }

    @Override
    public Byte multiply(final int index, final Byte multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        Byte originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        Byte result = (byte) (originalValue * multiplicand);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<Byte> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            Byte multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null && originalValue != (byte) 0 && multiplicand != (byte) 1) {
                results[i] = (byte) (originalValue * multiplicand);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot multiply with the multiplicands due to the cardinality constraint.");
        return true;
    }

    @Override
    public Byte negate(final int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        Byte originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        Byte result = (byte) (-originalValue);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public Byte subtract(final int index, final Byte subtrahend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot subtract an element at a position beyond the size of the collection.");
        }
        Byte originalValue = getAt(index);
        if (originalValue == null && subtrahend == null) {
            return null;
        }
        if (originalValue == null || subtrahend == null) {
            throw new NullPointerException("Cannot subtract a null value from a number.");
        }
        Byte result = (byte) (originalValue - subtrahend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot subtract the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean subtract(final OrderedNumericCollection<Byte> subtrahends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != subtrahends.size()) {
            throw new IllegalArgumentException("Cannot subtract a collection from a collection of a different size.");
        }
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            Byte subtrahend = subtrahends.getAt(i);
            if (originalValue == null ^ subtrahend == null) {
                throw new NullPointerException(
                        "Cannot subtract a collection from a collection when null values don't match.");
            }
            if (originalValue != null && subtrahend != (byte) 0) {
                results[i] = (byte) (originalValue - subtrahend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot subtract the subtrahends due to the cardinality constraint.");
        return true;
    }
}
