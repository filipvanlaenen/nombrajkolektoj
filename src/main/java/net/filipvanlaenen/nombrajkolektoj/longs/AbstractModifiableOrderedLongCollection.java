package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for longs.
 */
abstract class AbstractModifiableOrderedLongCollection extends AbstractModifiableLongCollection
        implements ModifiableOrderedNumericCollection<Long> {
    @Override
    public Long augment(final int index, final Long addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        Long originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot add a null value to a number.");
        }
        Long result = originalValue + addend;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<Long> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            Long addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null) {
                results[i] = originalValue + addend;
                changed |= results[i] != originalValue;
            }
            i++;
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public Long multiply(final int index, final Long multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        Long originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        Long result = originalValue * multiplicand;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<Long> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            Long multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null) {
                results[i] = originalValue * multiplicand;
                changed |= results[i] != originalValue;
            }
            i++;
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public boolean negate() {
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Long originalValue = results[i];
            if (results[i] != null) {
                results[i] = -originalValue;
                changed |= results[i] != originalValue;
            }
            i++;
        }
        if (!changed) {
            return false;
        }
        putResults(results);
        return true;
    }

    @Override
    public Long negate(final int index)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        Long originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        Long result = -originalValue;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    private void putResults(Long[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        Long counter = 0L;
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
                        counter += 1L;
                    }
                }
            }
        }
    }
}
