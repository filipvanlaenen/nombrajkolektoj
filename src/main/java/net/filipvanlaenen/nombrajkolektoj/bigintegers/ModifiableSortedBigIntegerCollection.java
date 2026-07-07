package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * interface for BigIntegers and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedBigIntegerCollection
        extends ModifiableSortedNumericCollection<BigInteger>, SortedBigIntegerCollection, ModifiableBigIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedBigIntegerCollectionDecorator {
        private ModifiableSortedTreeCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableSortedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigIntegers and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<BigInteger>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigIntegers and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<BigInteger>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigIntegers collection.
     */
    public static ModifiableSortedBigIntegerCollection empty(final Comparator<BigInteger> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers    The BigIntegers for the new modifiable sorted BigIntegers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted BigIntegers collection with the specified BigIntegers.
     */
    public static ModifiableSortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final BigInteger... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection cloned from the provided BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigIntegers collection.
     * @return A new sorted modifiable BigIntegers collection cloned from the provided BigIntegers collection.
     */
    public static ModifiableSortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final NumericCollection<BigInteger> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection cloned from a range in the provided ordered BigIntegers
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered BigIntegers collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted BigIntegers collection cloned from a range in the provided ordered BigIntegers
     *         collection.
     */
    public static ModifiableSortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final OrderedNumericCollection<BigInteger> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedBigIntegerCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigIntegers for the new modifiable sorted BigIntegers collection.
     * @return A new modifiable sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableSortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection with the specified element cardinality cloned from the
     * provided BigIntegers collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original BigIntegers collection.
     * @return A new modifiable sorted BigIntegers collection with the specified element cardinality cloned from the
     *         provided BigIntegers collection.
     */
    public static ModifiableSortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigInteger> comparator, final NumericCollection<BigInteger> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @return A new modifiable sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    public static ModifiableSortedBigIntegerCollection of(final SortedNumericCollection<BigInteger> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @param range      The range.
     * @return A new modifiable sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    public static ModifiableSortedBigIntegerCollection of(final SortedNumericCollection<BigInteger> collection,
            final Range<BigInteger> range) {
        ModifiableSortedBigIntegerCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (BigInteger element : collection) {
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
