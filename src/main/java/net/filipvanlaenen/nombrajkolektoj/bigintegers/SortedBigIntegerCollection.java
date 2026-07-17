package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * BigIntegers and containing inner classes with concrete implementations.
 */
public interface SortedBigIntegerCollection extends SortedNumericCollection<BigInteger>, OrderedBigIntegerCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedBigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<BigInteger> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same BigIntegers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            decoratedCollection = new SortedArrayCollection<BigInteger>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The BigIntegers collection to create a new sorted BigIntegers collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super BigInteger> comparator,
                final Collection<BigInteger> source) {
            decoratedCollection = new SortedArrayCollection<BigInteger>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigIntegers of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super BigInteger> comparator,
                final BigInteger... numbers) {
            decoratedCollection = new SortedArrayCollection<BigInteger>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedBigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same BigIntegers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted BigIntegers collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        @Override
        SortedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigIntegers collection.
     */
    static SortedBigIntegerCollection empty(final Comparator<? super BigInteger> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers    The BigIntegers for the new sorted BigIntegers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted BigIntegers collection with the specified BigIntegers.
     */
    static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigIntegers collection.
     * @return A new sorted BigIntegers collection cloned from the provided BigIntegers collection.
     */
    static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from a range in the provided ordered BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered BigIntegers collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted BigIntegers collection cloned from a range in the provided ordered collection.
     */
    static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final OrderedNumericCollection<BigInteger> collection, final int fromIndex, final int toIndex) {
        ModifiableBigIntegerCollection slice = ModifiableBigIntegerCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigIntegers for the new sorted BigIntegers collection.
     * @return A new sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static SortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original BigIntegers collection.
     * @return A new sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static SortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigInteger> comparator, final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @return A new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    static SortedBigIntegerCollection of(final SortedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @param range      The range.
     * @return A new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    static SortedBigIntegerCollection of(final SortedNumericCollection<BigInteger> collection, final Range<BigInteger> range) {
        ModifiableBigIntegerCollection slice = ModifiableBigIntegerCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (BigInteger element : collection) {
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
