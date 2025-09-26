package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * longs and containing inner classes with concrete implementations.
 */
public abstract class SortedLongCollection extends AbstractSortedLongCollection
        implements SortedNumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedLongCollection {
        /**
         * Constructs a sorted collection from a collection, with the same longs and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Long> comparator, final Collection<Long> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a sorted collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The longs of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
                final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Long>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The longs of the sorted collection.
         */
        public ArrayCollection(final Comparator<Long> comparator, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Long>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedLongCollection {
        /**
         * Constructs a sorted collection from a collection, with the same longs and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Long> comparator, final Collection<Long> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a sorted collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The longs of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
                final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Long>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The longs of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Long> comparator, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Long>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the longs.
     */
    private final SortedCollection<Long> collection;

    /**
     * Private constructor taking a sorted collection with the longs as its parameter.
     *
     * @param collection The sorted collection holding the longs.
     */
    private SortedLongCollection(final SortedCollection<Long> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted longs collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted longs collection.
     */
    static SortedLongCollection empty(final Comparator<Long> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Long element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Long> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Long getGreaterThan(final Long element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Long getGreaterThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Long getLessThan(final Long element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Long getLessThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Long element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted longs collection with the specified longs.
     *
     * @param numbers    The longs for the new sorted longs collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted longs collection with the specified longs.
     */
    static SortedLongCollection of(final Comparator<Long> comparator, final Long... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The longs for the new sorted longs collection.
     * @return A new sorted longs collection with the specified element cardinality and the longs.
     */
    static SortedLongCollection of(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
            final Long... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public int lastIndexOf(final Long element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray(EmptyArrays.LONGS);
    }
}
