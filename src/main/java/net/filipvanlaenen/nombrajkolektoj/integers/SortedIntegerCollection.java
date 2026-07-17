package net.filipvanlaenen.nombrajkolektoj.integers;

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
 * integers and containing inner classes with concrete implementations.
 */
public interface SortedIntegerCollection extends SortedNumericCollection<Integer>, OrderedIntegerCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<Integer> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same integers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Integer> comparator, final Integer... numbers) {
            decoratedCollection = new SortedArrayCollection<Integer>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The integers collection to create a new sorted integers collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Integer> comparator,
                final Collection<Integer> source) {
            decoratedCollection = new SortedArrayCollection<Integer>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Integer> comparator,
                final Integer... numbers) {
            decoratedCollection = new SortedArrayCollection<Integer>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same integers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Integer... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Integer> comparator, final Integer... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted integers collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        @Override
        SortedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted integers collection.
     */
    static SortedIntegerCollection empty(final Comparator<? super Integer> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted integers collection with the specified integers.
     *
     * @param numbers    The integers for the new sorted integers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted integers collection with the specified integers.
     */
    static SortedIntegerCollection of(final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original integers collection.
     * @return A new sorted integers collection cloned from the provided integers collection.
     */
    static SortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final NumericCollection<Integer> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted integers collection cloned from a range in the provided ordered integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted integers collection cloned from a range in the provided ordered collection.
     */
    static SortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final OrderedNumericCollection<Integer> collection, final int fromIndex, final int toIndex) {
        ModifiableIntegerCollection slice = ModifiableIntegerCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The integers for the new sorted integers collection.
     * @return A new sorted integers collection with the specified element cardinality and the integers.
     */
    static SortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original integers collection.
     * @return A new sorted integers collection with the specified element cardinality and the integers.
     */
    static SortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Integer> comparator, final NumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @return A new sorted integers collection cloned from the provided sorted integers collection.
     */
    static SortedIntegerCollection of(final SortedNumericCollection<Integer> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @param range      The range.
     * @return A new sorted integers collection cloned from the provided sorted integers collection.
     */
    static SortedIntegerCollection of(final SortedNumericCollection<Integer> collection, final Range<Integer> range) {
        ModifiableIntegerCollection slice = ModifiableIntegerCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Integer element : collection) {
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
