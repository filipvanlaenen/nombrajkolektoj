package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;

import java.util.Objects;

import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableOrderedNumericCollection} interface.
 */
abstract class ModifiableOrderedShortCollectionDecorator extends ModifiableShortCollectionDecorator
        implements ModifiableOrderedShortCollection {
    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends Short> otherCollection)
            throws IndexOutOfBoundsException {
        return getDecoratedCollection().addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Short element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().addAt(index, element);
    }

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
            if (originalValue != null && addend != (short) 0) {
                results[i] = (short) (originalValue + addend);
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
    public int firstIndexOf(final Short element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    abstract ModifiableOrderedCollection<Short> getDecoratedCollection();

    @Override
    public int indexOf(final Short element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Short element) {
        return getDecoratedCollection().lastIndexOf(element);
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
            if (originalValue != null && originalValue != (short) 0 && multiplicand != (short) 1) {
                results[i] = (short) (originalValue * multiplicand);
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

    @Override
    public Short putAt(final int index, final Short element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return getDecoratedCollection().putAt(index, element);
    }

    @Override
    public Short removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }

    @Override
    public Short subtract(final int index, final Short subtrahend)
            throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Cannot subtract an element at a position beyond the size of the collection.");
        }
        Short originalValue = getAt(index);
        if (originalValue == null && subtrahend == null) {
            return null;
        }
        if (originalValue == null || subtrahend == null) {
            throw new NullPointerException("Cannot subtract a null value from a number.");
        }
        Short result = (short) (originalValue - subtrahend);
        if (getElementCardinality() == DISTINCT_ELEMENTS && contains(result)
                && !Objects.equals(originalValue, result)) {
            throw new IllegalArgumentException(
                    "Cannot subtract the element at the position into a duplicate element due to the cardinality constraint.");
        }
        putAt(index, result);
        return originalValue;
    }

    @Override
    public boolean subtract(final OrderedNumericCollection<Short> subtrahends)
            throws IllegalArgumentException, NullPointerException {
        int n = size();
        if (n != subtrahends.size()) {
            throw new IllegalArgumentException("Cannot subtract a collection from a collection of a different size.");
        }
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            Short subtrahend = subtrahends.getAt(i);
            if (originalValue == null ^ subtrahend == null) {
                throw new NullPointerException(
                        "Cannot subtract a collection from a collection when null values don't match.");
            }
            if (originalValue != null && subtrahend != (short) 0) {
                results[i] = (short) (originalValue - subtrahend);
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
