package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for BigDecimals.
 */
abstract class AbstractModifiableOrderedBigDecimalCollection extends AbstractModifiableBigDecimalCollection
        implements ModifiableOrderedNumericCollection<BigDecimal> {
    @Override
    public BigDecimal augment(final int index, final BigDecimal addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        BigDecimal originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot augment a null value with a number.");
        }
        BigDecimal result = originalValue.add(addend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<BigDecimal> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            BigDecimal addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null && addend != BigDecimal.ZERO) {
                results[i] = originalValue.add(addend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public BigDecimal multiply(final int index, final BigDecimal multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        BigDecimal originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        BigDecimal result = originalValue.multiply(multiplicand);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<BigDecimal> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            BigDecimal multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null && originalValue != BigDecimal.ZERO && multiplicand != BigDecimal.ONE) {
                results[i] = originalValue.multiply(multiplicand);
                changed = true;
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
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO) {
                results[i] = originalValue.negate();
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public BigDecimal negate(final int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        BigDecimal originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        BigDecimal result = originalValue.negate();
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    private void putResults(BigDecimal[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        BigDecimal counter = BigDecimal.ZERO;
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
                            allUpdated = false;
                        }
                        counter = counter.add(BigDecimal.ONE);
                    }
                }
            }
        }
    }
}
