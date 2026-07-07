package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for shorts.
 */
abstract class ShortCollectionDecorator implements ShortCollection {
    @Override
    public Short max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Short max = null;
        for (Short n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Short min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Short min = null;
        for (Short n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Short product() {
        Short product = (short) 1;
        for (Short n : this) {
            if (n != null) {
                product = (short) (product * n);
            }
        }
        return product;
    }

    @Override
    public Short sum() {
        Short sum = (short) 0;
        for (Short n : this) {
            if (n != null) {
                sum = (short) (sum + n);
            }
        }
        return sum;
    }

    abstract Collection<Short> getDecoratedCollection();

    @Override
    public boolean contains(final Short element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<Short> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public Short[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.SHORTS);
    }
}
