package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * integers and containing inner classes with concrete implementations.
 */
public abstract class SortedIntegerCollection extends AbstractSortedIntegerCollection
        implements SortedNumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedIntegerCollection {
        /**
         * Constructs a sorted collection from a collection, with the same integers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
                final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Integer>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public ArrayCollection(final Comparator<Integer> comparator, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Integer>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedIntegerCollection {
        /**
         * Constructs a sorted collection from a collection, with the same integers and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
                final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Integer> comparator, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the integers.
     */
    private final SortedCollection<Integer> collection;

    /**
     * Private constructor taking a sorted collection with the integers as its parameter.
     *
     * @param collection The sorted collection holding the integers.
     */
    private SortedIntegerCollection(final SortedCollection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Integer element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted integers collection.
     */
    static SortedIntegerCollection empty(final Comparator<Integer> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Integer element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Integer> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Integer element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted integers collection with the specified integers.
     *
     * @param numbers    The integers for the new sorted integers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted integers collection with the specified integers.
     */
    static SortedIntegerCollection of(final Comparator<Integer> comparator, final Integer... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The integers for the new sorted integers collection.
     * @return A new sorted integers collection with the specified element cardinality and the integers.
     */
    static SortedIntegerCollection of(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
            final Integer... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return collection.toArray(EmptyArrays.INTEGERS);
    }
}
