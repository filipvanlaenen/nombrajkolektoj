package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for BigIntegers.
 */
abstract class AbstractModifiableOrderedBigIntegerCollection extends AbstractModifiableBigIntegerCollection
        implements ModifiableOrderedNumericCollection<BigInteger> {
    @Override
    public BigInteger augment(final int index, final BigInteger addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        BigInteger originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot augment a null value with a number.");
        }
        BigInteger result = originalValue.add(addend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<BigInteger> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            BigInteger addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null && addend != BigInteger.ZERO) {
                results[i] = originalValue.add(addend);
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
    public BigInteger multiply(final int index, final BigInteger multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        BigInteger originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        BigInteger result = originalValue.multiply(multiplicand);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<BigInteger> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            BigInteger multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null && originalValue != BigInteger.ZERO && multiplicand != BigInteger.ONE) {
                results[i] = originalValue.multiply(multiplicand);
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
    public BigInteger negate(final int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        BigInteger originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        BigInteger result = originalValue.negate();
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public BigInteger subtract(final int index, final BigInteger subtrahend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot subtract an element at a position beyond the size of the collection.");
        }
        BigInteger originalValue = getAt(index);
        if (originalValue == null && subtrahend == null) {
            return null;
        }
        if (originalValue == null || subtrahend == null) {
            throw new NullPointerException("Cannot subtract a null value from a number.");
        }
        BigInteger result = originalValue.subtract(subtrahend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot subtract the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean subtract(final OrderedNumericCollection<BigInteger> subtrahends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != subtrahends.size()) {
            throw new IllegalArgumentException("Cannot subtract a collection from a collection of a different size.");
        }
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            BigInteger subtrahend = subtrahends.getAt(i);
            if (originalValue == null ^ subtrahend == null) {
                throw new NullPointerException(
                        "Cannot subtract a collection from a collection when null values don't match.");
            }
            if (originalValue != null && subtrahend != BigInteger.ZERO) {
                results[i] = originalValue.subtract(subtrahend);
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
