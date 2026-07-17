package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
 * interface for BigDecimals and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedBigDecimalCollection
        extends ModifiableSortedNumericCollection<BigDecimal>, SortedBigDecimalCollection, ModifiableBigDecimalCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableSortedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigDecimals and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<BigDecimal>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigDecimals and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<BigDecimal>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigDecimals collection.
     */
    static ModifiableSortedBigDecimalCollection empty(final Comparator<BigDecimal> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers    The BigDecimals for the new modifiable sorted BigDecimals collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted BigDecimals collection with the specified BigDecimals.
     */
    static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigDecimals collection.
     * @return A new sorted modifiable BigDecimals collection cloned from the provided BigDecimals collection.
     */
    static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final NumericCollection<BigDecimal> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from a range in the provided ordered BigDecimals
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted BigDecimals collection cloned from a range in the provided ordered BigDecimals
     *         collection.
     */
    static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final OrderedNumericCollection<BigDecimal> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedBigDecimalCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigDecimals for the new modifiable sorted BigDecimals collection.
     * @return A new modifiable sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableSortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection with the specified element cardinality cloned from the
     * provided BigDecimals collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original BigDecimals collection.
     * @return A new modifiable sorted BigDecimals collection with the specified element cardinality cloned from the
     *         provided BigDecimals collection.
     */
    static ModifiableSortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final NumericCollection<BigDecimal> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @return A new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    static ModifiableSortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @param range      The range.
     * @return A new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    static ModifiableSortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection,
            final Range<BigDecimal> range) {
        ModifiableSortedBigDecimalCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (BigDecimal element : collection) {
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
