package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * bytes and containing inner classes with concrete implementations.
 */
public abstract class SortedByteCollection extends AbstractSortedByteCollection
        implements SortedNumericCollection<Byte> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedByteCollection {
        /**
         * Constructs a sorted collection from a collection, with the same bytes and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The bytes of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Byte> comparator,
                final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Byte>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public ArrayCollection(final Comparator<Byte> comparator, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Byte>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedByteCollection {
        /**
         * Constructs a sorted collection from a collection, with the same bytes and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The bytes of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Byte> comparator,
                final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Byte> comparator, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the bytes.
     */
    private final SortedCollection<Byte> collection;

    /**
     * Private constructor taking a sorted collection with the bytes as its parameter.
     *
     * @param collection The sorted collection holding the bytes.
     */
    private SortedByteCollection(final SortedCollection<Byte> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Byte element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted bytes collection.
     */
    static SortedByteCollection empty(final Comparator<Byte> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Byte> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Byte> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted bytes collection with the specified bytes.
     *
     * @param numbers    The bytes for the new sorted bytes collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted bytes collection with the specified bytes.
     */
    static SortedByteCollection of(final Comparator<Byte> comparator, final Byte... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The bytes for the new sorted bytes collection.
     * @return A new sorted bytes collection with the specified element cardinality and the bytes.
     */
    static SortedByteCollection of(final ElementCardinality elementCardinality, final Comparator<Byte> comparator,
            final Byte... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return collection.toArray(EmptyArrays.BYTES);
    }
}
