package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for floats.
 */
abstract class ModifiableSortedFloatCollectionDecorator extends ModifiableFloatCollectionDecorator
        implements ModifiableSortedFloatCollection {
    @Override
    abstract ModifiableSortedCollection<Float> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Float element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Float element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Float element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Float removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
