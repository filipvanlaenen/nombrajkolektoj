package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection} for shorts.
 */
abstract class AbstractModifiableOrderedShortCollection extends AbstractModifiableShortCollection
        implements ModifiableOrderedNumericCollection<Short> {
    @Override
    public Short augment(final int index, final Short addend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot augment an element at a position beyond the size of the collection.");
        }
        Short originalValue = getAt(index);
        if (originalValue == null && addend == null) {
            return null;
        }
        if (originalValue == null || addend == null) {
            throw new NullPointerException("Cannot augment a null value with a number.");
        }
        Short result = (short) (originalValue + addend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot augment the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean augment(final OrderedNumericCollection<Short> addends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != addends.size()) {
            throw new IllegalArgumentException("Cannot augment a collection with a collection of a different size.");
        }
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            Short addend = addends.getAt(i);
            if (originalValue == null ^ addend == null) {
                throw new NullPointerException(
                        "Cannot augment a collection with a collection when null values don't match.");
            }
            if (originalValue != null) {
                results[i] = (short) (originalValue + addend);
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
    public Short multiply(final int index, final Short multiplicand)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot multiply an element at a position beyond the size of the collection.");
        }
        Short originalValue = getAt(index);
        if (originalValue == null && multiplicand == null) {
            return null;
        }
        if (originalValue == null || multiplicand == null) {
            throw new NullPointerException("Cannot multiply a null value with a number.");
        }
        Short result = (short) (originalValue * multiplicand);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot multiply the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean multiply(final OrderedNumericCollection<Short> multiplicands)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != multiplicands.size()) {
            throw new IllegalArgumentException("Cannot multiply a collection with a collection of a different size.");
        }
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            Short multiplicand = multiplicands.getAt(i);
            if (originalValue == null ^ multiplicand == null) {
                throw new NullPointerException(
                        "Cannot multiply a collection with a collection when null values don't match.");
            }
            if (originalValue != null) {
                results[i] = (short) (originalValue * multiplicand);
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
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Short originalValue = results[i];
            if (results[i] != null) {
                results[i] = (short) (-originalValue);
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
    public Short negate(final int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot negate an element at a position beyond the size of the collection.");
        }
        Short originalValue = getAt(index);
        if (originalValue == null) {
            return null;
        }
        Short result = (short) (-originalValue);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot negate the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    private void putResults(Short[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        Short counter = (short) 0;
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
                        // EQMU: Replacing the short addition with subtraction below produces an equivalent mutant.
                        counter = (short) (counter + 1);
                    }
                }
            }
        }
    }
}
