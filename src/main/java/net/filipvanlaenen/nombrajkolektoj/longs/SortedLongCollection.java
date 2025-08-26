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
         * @param longs            The longs of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
                final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Long>(elementCardinality, comparator,
                    longs));
        }

        /**
         * Constructs a sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param longs    The longs of the sorted collection.
         */
        public ArrayCollection(final Comparator<Long> comparator, final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Long>(comparator, longs));
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
         * @param longs            The longs of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
                final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Long>(elementCardinality,
                    comparator, longs));
        }

        /**
         * Constructs a sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param longs    The longs of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Long> comparator, final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Long>(comparator, longs));
        }
    }

    /**
     * The sorted collection holding the longs.
     */
    private final SortedCollection<Long> longs;

    /**
     * Private constructor taking a sorted collection with the longs as its parameter.
     *
     * @param longs The sorted collection holding the longs.
     */
    private SortedLongCollection(final SortedCollection<Long> longs) {
        this.longs = longs;
    }

    @Override
    public boolean contains(final Long element) {
        return longs.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return longs.containsAll(collection);
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
    public Long get() throws IndexOutOfBoundsException {
        return longs.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return longs.getAt(index);
    }

    @Override
    public Comparator<? super Long> getComparator() {
        return longs.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return longs.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return longs.iterator();
    }

    /**
     * Returns a new sorted longs collection with the specified longs.
     *
     * @param longs    The longs for the new sorted longs collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted longs collection with the specified longs.
     */
    static SortedLongCollection of(final Comparator<Long> comparator, final Long... longs) {
        return new ArrayCollection(comparator, longs);
    }

    /**
     * Returns a new sorted longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param longs            The longs for the new sorted longs collection.
     * @return A new sorted longs collection with the specified element cardinality and the longs.
     */
    static SortedLongCollection of(final ElementCardinality elementCardinality, final Comparator<Long> comparator,
            final Long... longs) {
        return new ArrayCollection(elementCardinality, comparator, longs);
    }

    @Override
    public int size() {
        return longs.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return longs.spliterator();
    }

    @Override
    public Long[] toArray() {
        return longs.toArray(EmptyArrays.LONGS);
    }
}
