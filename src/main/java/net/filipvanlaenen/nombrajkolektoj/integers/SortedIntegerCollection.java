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
         * @param integers            The integers of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
                final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Integer>(elementCardinality, comparator,
                    integers));
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param integers    The integers of the sorted collection.
         */
        public ArrayCollection(final Comparator<Integer> comparator, final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Integer>(comparator, integers));
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
         * @param integers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
                final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(elementCardinality,
                    comparator, integers));
        }

        /**
         * Constructs a sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param integers    The integers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Integer> comparator, final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Integer>(comparator, integers));
        }
    }

    /**
     * The sorted collection holding the integers.
     */
    private final SortedCollection<Integer> integers;

    /**
     * Private constructor taking a sorted collection with the integers as its parameter.
     *
     * @param integers The sorted collection holding the integers.
     */
    private SortedIntegerCollection(final SortedCollection<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public boolean contains(final Integer element) {
        return integers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return integers.containsAll(collection);
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
    public Integer get() throws IndexOutOfBoundsException {
        return integers.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return integers.getAt(index);
    }

    @Override
    public Comparator<? super Integer> getComparator() {
        return integers.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return integers.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return integers.iterator();
    }

    /**
     * Returns a new sorted integers collection with the specified integers.
     *
     * @param integers    The integers for the new sorted integers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted integers collection with the specified integers.
     */
    static SortedIntegerCollection of(final Comparator<Integer> comparator, final Integer... integers) {
        return new ArrayCollection(comparator, integers);
    }

    /**
     * Returns a new sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param integers            The integers for the new sorted integers collection.
     * @return A new sorted integers collection with the specified element cardinality and the integers.
     */
    static SortedIntegerCollection of(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
            final Integer... integers) {
        return new ArrayCollection(elementCardinality, comparator, integers);
    }

    @Override
    public int size() {
        return integers.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return integers.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return integers.toArray(EmptyArrays.INTEGERS);
    }
}
