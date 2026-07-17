package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for doubles and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedDoubleCollection
        extends ModifiableSortedNumericCollection<Double>, SortedDoubleCollection, ModifiableDoubleCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<Double> decoratedCollection;

        @Override
        ModifiableSortedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same doubles and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The doubles of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Double> comparator, final Double... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Double>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same doubles and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a modifiable sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The doubles of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Double... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Double>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted doubles collection.
     */
    static ModifiableSortedDoubleCollection empty(final Comparator<Double> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted doubles collection with the specified doubles.
     *
     * @param numbers    The doubles for the new modifiable sorted doubles collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted doubles collection with the specified doubles.
     */
    static ModifiableSortedDoubleCollection of(final Comparator<? super Double> comparator, final Double... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted doubles collection cloned from the provided doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original doubles collection.
     * @return A new sorted modifiable doubles collection cloned from the provided doubles collection.
     */
    static ModifiableSortedDoubleCollection of(final Comparator<? super Double> comparator,
            final NumericCollection<Double> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted doubles collection cloned from a range in the provided ordered doubles
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted doubles collection cloned from a range in the provided ordered doubles
     *         collection.
     */
    static ModifiableSortedDoubleCollection of(final Comparator<? super Double> comparator,
            final OrderedNumericCollection<Double> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedDoubleCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The doubles for the new modifiable sorted doubles collection.
     * @return A new modifiable sorted doubles collection with the specified element cardinality and the doubles.
     */
    static ModifiableSortedDoubleCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Double> comparator, final Double... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted doubles collection with the specified element cardinality cloned from the
     * provided doubles collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original doubles collection.
     * @return A new modifiable sorted doubles collection with the specified element cardinality cloned from the
     *         provided doubles collection.
     */
    static ModifiableSortedDoubleCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Double> comparator, final NumericCollection<Double> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @return A new modifiable sorted doubles collection cloned from the provided sorted doubles collection.
     */
    static ModifiableSortedDoubleCollection of(final SortedNumericCollection<Double> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @param range      The range.
     * @return A new modifiable sorted doubles collection cloned from the provided sorted doubles collection.
     */
    static ModifiableSortedDoubleCollection of(final SortedNumericCollection<Double> collection,
            final Range<Double> range) {
        ModifiableSortedDoubleCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Double element : collection) {
            if (below && !range.isBelow(collection.getComparator(), element)) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(collection.getComparator(), element)) {
                    break;
                }
                result.add(element);
            }
        }
        return result;
    }
}
