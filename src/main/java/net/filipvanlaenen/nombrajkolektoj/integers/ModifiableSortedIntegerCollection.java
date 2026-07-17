package net.filipvanlaenen.nombrajkolektoj.integers;

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
 * interface for integers and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedIntegerCollection
        extends ModifiableSortedNumericCollection<Integer>, SortedIntegerCollection, ModifiableIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<Integer> decoratedCollection;

        @Override
        ModifiableSortedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same integers and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Integer> comparator, final Integer... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Integer>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same integers and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a modifiable sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Integer... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Integer>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted integers collection.
     */
    static ModifiableSortedIntegerCollection empty(final Comparator<Integer> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted integers collection with the specified integers.
     *
     * @param numbers    The integers for the new modifiable sorted integers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted integers collection with the specified integers.
     */
    static ModifiableSortedIntegerCollection of(final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted integers collection cloned from the provided integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original integers collection.
     * @return A new sorted modifiable integers collection cloned from the provided integers collection.
     */
    static ModifiableSortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final NumericCollection<Integer> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted integers collection cloned from a range in the provided ordered integers
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted integers collection cloned from a range in the provided ordered integers
     *         collection.
     */
    static ModifiableSortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final OrderedNumericCollection<Integer> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedIntegerCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The integers for the new modifiable sorted integers collection.
     * @return A new modifiable sorted integers collection with the specified element cardinality and the integers.
     */
    static ModifiableSortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted integers collection with the specified element cardinality cloned from the
     * provided integers collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original integers collection.
     * @return A new modifiable sorted integers collection with the specified element cardinality cloned from the
     *         provided integers collection.
     */
    static ModifiableSortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Integer> comparator, final NumericCollection<Integer> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @return A new modifiable sorted integers collection cloned from the provided sorted integers collection.
     */
    static ModifiableSortedIntegerCollection of(final SortedNumericCollection<Integer> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @param range      The range.
     * @return A new modifiable sorted integers collection cloned from the provided sorted integers collection.
     */
    static ModifiableSortedIntegerCollection of(final SortedNumericCollection<Integer> collection,
            final Range<Integer> range) {
        ModifiableSortedIntegerCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Integer element : collection) {
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
