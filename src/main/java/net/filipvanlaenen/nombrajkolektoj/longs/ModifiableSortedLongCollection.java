package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * interface for longs and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedLongCollection
        extends ModifiableSortedNumericCollection<Long>, SortedLongCollection, ModifiableLongCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedLongCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<Long> decoratedCollection;

        @Override
        ModifiableSortedCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same longs and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Long> comparator, final Collection<Long> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The longs of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Long> comparator, final Long... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Long>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same longs and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Long> comparator, final Collection<Long> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a modifiable sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The longs of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Long> comparator, final Long... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Long>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted longs collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted longs collection.
     */
    static ModifiableSortedLongCollection empty(final Comparator<Long> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted longs collection with the specified longs.
     *
     * @param numbers    The longs for the new modifiable sorted longs collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted longs collection with the specified longs.
     */
    static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator, final Long... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided longs collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original longs collection.
     * @return A new sorted modifiable longs collection cloned from the provided longs collection.
     */
    static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator,
            final NumericCollection<Long> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from a range in the provided ordered longs
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered longs collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted longs collection cloned from a range in the provided ordered longs
     *         collection.
     */
    static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator,
            final OrderedNumericCollection<Long> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedLongCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The longs for the new modifiable sorted longs collection.
     * @return A new modifiable sorted longs collection with the specified element cardinality and the longs.
     */
    static ModifiableSortedLongCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Long> comparator, final Long... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted longs collection with the specified element cardinality cloned from the
     * provided longs collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original longs collection.
     * @return A new modifiable sorted longs collection with the specified element cardinality cloned from the
     *         provided longs collection.
     */
    static ModifiableSortedLongCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Long> comparator, final NumericCollection<Long> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided sorted longs collection.
     *
     * @param collection The original sorted longs collection.
     * @return A new modifiable sorted longs collection cloned from the provided sorted longs collection.
     */
    static ModifiableSortedLongCollection of(final SortedNumericCollection<Long> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided sorted longs collection.
     *
     * @param collection The original sorted longs collection.
     * @param range      The range.
     * @return A new modifiable sorted longs collection cloned from the provided sorted longs collection.
     */
    static ModifiableSortedLongCollection of(final SortedNumericCollection<Long> collection,
            final Range<Long> range) {
        ModifiableSortedLongCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Long element : collection) {
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
