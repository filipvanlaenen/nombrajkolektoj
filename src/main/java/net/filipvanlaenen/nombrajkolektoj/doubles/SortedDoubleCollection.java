package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.array.SortedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * doubles and containing inner classes with concrete implementations.
 */
public interface SortedDoubleCollection extends SortedNumericCollection<Double>, OrderedDoubleCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<Double> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same doubles and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The doubles of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Double> comparator, final Double... numbers) {
            decoratedCollection = new SortedArrayCollection<Double>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The doubles collection to create a new sorted doubles collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Double> comparator,
                final Collection<Double> source) {
            decoratedCollection = new SortedArrayCollection<Double>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The doubles of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Double> comparator,
                final Double... numbers) {
            decoratedCollection = new SortedArrayCollection<Double>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same doubles and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The doubles of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Double... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The doubles of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Double> comparator, final Double... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted doubles collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Double> comparator, final Collection<Double> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        @Override
        SortedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted doubles collection.
     */
    static SortedDoubleCollection empty(final Comparator<? super Double> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted doubles collection with the specified doubles.
     *
     * @param numbers    The doubles for the new sorted doubles collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted doubles collection with the specified doubles.
     */
    static SortedDoubleCollection of(final Comparator<? super Double> comparator, final Double... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original doubles collection.
     * @return A new sorted doubles collection cloned from the provided doubles collection.
     */
    static SortedDoubleCollection of(final Comparator<? super Double> comparator,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted doubles collection cloned from a range in the provided ordered doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted doubles collection cloned from a range in the provided ordered collection.
     */
    static SortedDoubleCollection of(final Comparator<? super Double> comparator,
            final OrderedNumericCollection<Double> collection, final int fromIndex, final int toIndex) {
        ModifiableDoubleCollection slice = ModifiableDoubleCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The doubles for the new sorted doubles collection.
     * @return A new sorted doubles collection with the specified element cardinality and the doubles.
     */
    static SortedDoubleCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Double> comparator, final Double... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original doubles collection.
     * @return A new sorted doubles collection with the specified element cardinality and the doubles.
     */
    static SortedDoubleCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Double> comparator, final NumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @return A new sorted doubles collection cloned from the provided sorted doubles collection.
     */
    static SortedDoubleCollection of(final SortedNumericCollection<Double> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @param range      The range.
     * @return A new sorted doubles collection cloned from the provided sorted doubles collection.
     */
    static SortedDoubleCollection of(final SortedNumericCollection<Double> collection, final Range<Double> range) {
        ModifiableDoubleCollection slice = ModifiableDoubleCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Double element : collection) {
            if (below && !range.isBelow(collection.getComparator(), element)) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(collection.getComparator(), element)) {
                    break;
                }
                slice.add(element);
            }
        }
        return new ArrayCollection(collection.getComparator(), slice);
    }
}
