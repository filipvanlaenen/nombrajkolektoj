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
            if (originalValue != null) {
                results[i] = (byte) (originalValue + addend);
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
            if (originalValue != null) {
                results[i] = (byte) (originalValue * multiplicand);
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
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Byte originalValue = results[i];
            if (results[i] != null) {
                results[i] = (byte) (-originalValue);
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

    private void putResults(Byte[] results) {
        int n = size();
        boolean[] updated = new boolean[n];
        boolean allUpdated = false;
        Byte counter = (byte) 0;
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
                        // EQMU: Replacing the byte addition with subtraction below produces an equivalent mutant.
                        counter = (byte) (counter + 1);
                    }
                }
            }
        }
    }
}
