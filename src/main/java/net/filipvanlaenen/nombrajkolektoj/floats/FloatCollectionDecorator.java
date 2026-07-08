package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} interface.
 */
abstract class FloatCollectionDecorator implements FloatCollection {
    @Override
    public boolean contains(final Float element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    /**
     * Returns the internal decorated collection.
     *
     * @return The internal decorated collection
     */
    abstract Collection<Float> getDecoratedCollection();

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public Float max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Float max = null;
        for (Float n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Float min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Float min = null;
        for (Float n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Float product() {
        Float product = 1F;
        for (Float n : this) {
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
    public Spliterator<Float> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public Float sum() {
        Float sum = 0F;
        for (Float n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public Float[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.FLOATS);
    }
}
