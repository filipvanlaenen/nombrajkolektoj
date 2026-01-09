package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class SortedBigDecimalCollection extends AbstractSortedBigDecimalCollection
        implements SortedNumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedBigDecimalCollection {
        /**
         * Constructs a sorted collection from a collection, with the same BigDecimals and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_DECIMALS));
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
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<BigDecimal>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<BigDecimal>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedBigDecimalCollection {
        /**
         * Constructs a sorted collection from a collection, with the same BigDecimals and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_DECIMALS));
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
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigDecimal>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the BigDecimals.
     */
    private final SortedCollection<BigDecimal> collection;

    /**
     * Private constructor taking a sorted collection with the BigDecimals as its parameter.
     *
     * @param collection The sorted collection holding the BigDecimals.
     */
    private SortedBigDecimalCollection(final SortedCollection<BigDecimal> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigDecimals collection.
     */
    public static SortedBigDecimalCollection empty(final Comparator<? super BigDecimal> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super BigDecimal> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public BigDecimal getGreaterThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public BigDecimal getGreaterThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigDecimal getLessThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public BigDecimal getLessThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers    The BigDecimals for the new sorted BigDecimals collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted BigDecimals collection with the specified BigDecimals.
     */
    public static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigDecimals collection.
     * @return A new sorted BigDecimals collection cloned from the provided BigDecimals collection.
     */
    public static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final BigDecimalCollection collection) {
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
    public static SortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final OrderedBigDecimalCollection collection, final int fromIndex, final int toIndex) {
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
    public static SortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @return A new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    public static SortedBigDecimalCollection of(final SortedBigDecimalCollection collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @param range      The range.
     * @return A new sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    public static SortedBigDecimalCollection of(final SortedBigDecimalCollection collection, final Range<BigDecimal> range) {
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

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return collection.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
