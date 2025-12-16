package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for floats.
 */
abstract class AbstractModifiableOrderedFloatCollection extends AbstractModifiableFloatCollection
        implements ModifiableOrderedNumericCollection<Float> {
    @Override
    public Float augment(final int index, final Float addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        Float originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot add a null value to a number.");
        }
        Float result = originalValue + addend;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<Float> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            Float addend = addends.getAt(i);
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
    public Float multiply(final int index, final Float multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        Float originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        Float result = originalValue * multiplicand;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<Float> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            Float multiplicand = multiplicands.getAt(i);
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
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Float originalValue = results[i];
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
    public Float negate(final int index)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        Float originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        Float result = -originalValue;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    private void putResults(Float[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        Float counter = 0F;
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
                        counter += 1F;
                    }
                }
            }
        }
    }
}
