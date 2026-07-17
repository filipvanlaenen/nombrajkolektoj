package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
 * BigDecimals and containing inner classes with concrete implementations.
 */
public interface SortedBigDecimalCollection extends SortedNumericCollection<BigDecimal>, OrderedBigDecimalCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<BigDecimal> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same BigDecimals and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            decoratedCollection = new SortedArrayCollection<BigDecimal>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The BigDecimals collection to create a new sorted BigDecimals collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super BigDecimal> comparator,
                final Collection<BigDecimal> source) {
            decoratedCollection = new SortedArrayCollection<BigDecimal>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigDecimals of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super BigDecimal> comparator,
                final BigDecimal... numbers) {
            decoratedCollection = new SortedArrayCollection<BigDecimal>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same BigDecimals and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted BigDecimals collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        @Override
        SortedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigDecimals collection.
     */
    static SortedBigDecimalCollection empty(final Comparator<? super BigDecimal> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers    The BigDecimals for the new sorted BigDecimals collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted BigDecimals collection with the specified BigDecimals.
     */
    static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigDecimals collection.
     * @return A new sorted BigDecimals collection cloned from the provided BigDecimals collection.
     */
    static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from a range in the provided ordered BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted BigDecimals collection cloned from a range in the provided ordered collection.
     */
    static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final OrderedNumericCollection<BigDecimal> collection, final int fromIndex, final int toIndex) {
        ModifiableBigDecimalCollection slice = ModifiableBigDecimalCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigDecimals for the new sorted BigDecimals collection.
     * @return A new sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static SortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original BigDecimals collection.
     * @return A new sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static SortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @return A new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    static SortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @param range      The range.
     * @return A new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    static SortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection, final Range<BigDecimal> range) {
        ModifiableBigDecimalCollection slice = ModifiableBigDecimalCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (BigDecimal element : collection) {
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
