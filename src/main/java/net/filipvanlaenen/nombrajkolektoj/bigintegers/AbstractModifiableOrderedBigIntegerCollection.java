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
            if (originalValue != null) {
                results[i] = originalValue.add(addend);
                changed |= !Objects.equals(originalValue, results[i]);
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results);
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
            if (originalValue != null) {
                results[i] = originalValue.multiply(multiplicand);
                changed |= !Objects.equals(originalValue, results[i]);
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public boolean negate() {
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            BigInteger originalValue = results[i];
            if (results[i] != null) {
                results[i] = originalValue.negate();
                changed |= !Objects.equals(originalValue, results[i]);
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results);
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

    private void putResults(BigInteger[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        BigInteger counter = BigInteger.ZERO;
        while (!allUpdated) {
            allUpdated = true;
            for (int i = 0; i < n; i++) {
                if (!updated[i]) {
                    try {
                        putAt(i, results[i]);
                        updated[i] = true;
                    } catch (IllegalArgumentException iae) {
                        allUpdated = false;
                        try {
                            putAt(i, counter);
                        } catch (IllegalArgumentException iae2) {
                        }
                        counter = counter.add(BigInteger.ONE);
                    }
                }
            }
        }
    }
}
