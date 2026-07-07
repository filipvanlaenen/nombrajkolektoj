package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for floats.
 */
abstract class SortedFloatCollectionDecorator extends OrderedFloatCollectionDecorator
        implements SortedFloatCollection {
    @Override
    abstract SortedCollection<Float> getDecoratedCollection();

    @Override
    public Comparator<? super Float> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Float getGreaterThan(final Float element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Float getGreaterThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Float getLessThan(final Float element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Float getLessThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
