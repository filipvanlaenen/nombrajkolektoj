package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for integers.
 */
abstract class AbstractModifiableOrderedIntegerCollection extends AbstractModifiableIntegerCollection
        implements ModifiableOrderedNumericCollection<Integer> {
    @Override
    public Integer augment(final int index, final Integer addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        Integer originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot augment a null value with a number.");
        }
        Integer result = originalValue + addend;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<Integer> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            Integer addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null && addend != 0) {
                results[i] = originalValue + addend;
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
    public Integer multiply(final int index, final Integer multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        Integer originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        Integer result = originalValue * multiplicand;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<Integer> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            Integer multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null && originalValue != 0 && multiplicand != 1) {
                results[i] = originalValue * multiplicand;
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
    public Integer negate(final int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        Integer originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        Integer result = -originalValue;
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }
}
