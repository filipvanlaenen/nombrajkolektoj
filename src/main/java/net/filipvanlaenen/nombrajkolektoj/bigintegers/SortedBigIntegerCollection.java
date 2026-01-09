package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class SortedBigIntegerCollection extends AbstractSortedBigIntegerCollection
        implements SortedNumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedBigIntegerCollection {
        /**
         * Constructs a sorted collection from a collection, with the same BigIntegers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_INTEGERS));
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
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<BigInteger>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<BigInteger>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedBigIntegerCollection {
        /**
         * Constructs a sorted collection from a collection, with the same BigIntegers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_INTEGERS));
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
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<BigInteger>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the BigIntegers.
     */
    private final SortedCollection<BigInteger> collection;

    /**
     * Private constructor taking a sorted collection with the BigIntegers as its parameter.
     *
     * @param collection The sorted collection holding the BigIntegers.
     */
    private SortedBigIntegerCollection(final SortedCollection<BigInteger> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final BigInteger element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigIntegers collection.
     */
    public static SortedBigIntegerCollection empty(final Comparator<? super BigInteger> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final BigInteger element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super BigInteger> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public BigInteger getGreaterThan(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public BigInteger getGreaterThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigInteger getLessThan(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public BigInteger getLessThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final BigInteger element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers    The BigIntegers for the new sorted BigIntegers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted BigIntegers collection with the specified BigIntegers.
     */
    public static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigIntegers collection.
     * @return A new sorted BigIntegers collection cloned from the provided BigIntegers collection.
     */
    public static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final BigIntegerCollection collection) {
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
    public static SortedBigIntegerCollection of(final Comparator<? super BigInteger> comparator,
            final OrderedBigIntegerCollection collection, final int fromIndex, final int toIndex) {
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
    public static SortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigInteger> comparator, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @return A new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    public static SortedBigIntegerCollection of(final SortedBigIntegerCollection collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     *
     * @param collection The original sorted BigIntegers collection.
     * @param range      The range.
     * @return A new sorted BigIntegers collection cloned from the provided sorted BigIntegers collection.
     */
    public static SortedBigIntegerCollection of(final SortedBigIntegerCollection collection, final Range<BigInteger> range) {
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

    @Override
    public int lastIndexOf(final BigInteger element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return collection.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
