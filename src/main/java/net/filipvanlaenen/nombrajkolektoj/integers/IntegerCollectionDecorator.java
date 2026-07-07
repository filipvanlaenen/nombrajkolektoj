package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for integers.
 */
abstract class IntegerCollectionDecorator implements IntegerCollection {
    @Override
    public Integer max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Integer max = null;
        for (Integer n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Integer min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Integer min = null;
        for (Integer n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Integer product() {
        Integer product = 1;
        for (Integer n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Integer n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    abstract Collection<Integer> getDecoratedCollection();

    @Override
    public boolean contains(final Integer element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public Integer[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.INTEGERS);
    }
}
