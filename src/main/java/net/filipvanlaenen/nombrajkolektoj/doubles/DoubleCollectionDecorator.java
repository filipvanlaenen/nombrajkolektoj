package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract decorator class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} interface.
 */
abstract class DoubleCollectionDecorator implements DoubleCollection {
    @Override
    public boolean contains(final Double element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    /**
     * Returns the internal decorated collection.
     *
     * @return The internal decorated collection
     */
    abstract Collection<Double> getDecoratedCollection();

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public Double max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Double max = null;
        for (Double n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Double min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Double min = null;
        for (Double n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Double product() {
        Double product = 1D;
        for (Double n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public Double sum() {
        Double sum = 0D;
        for (Double n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public Double[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.DOUBLES);
    }
}
