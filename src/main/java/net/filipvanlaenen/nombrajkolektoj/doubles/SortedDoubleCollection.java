package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * doubles and containing inner classes with concrete implementations.
 */
public abstract class SortedDoubleCollection extends AbstractSortedDoubleCollection
        implements SortedNumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedDoubleCollection {
        /**
         * Constructs a sorted collection from a collection, with the same doubles and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param doubles            The doubles of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Double> comparator,
                final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Double>(elementCardinality, comparator,
                    doubles));
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param doubles    The doubles of the sorted collection.
         */
        public ArrayCollection(final Comparator<Double> comparator, final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Double>(comparator, doubles));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedDoubleCollection {
        /**
         * Constructs a sorted collection from a collection, with the same doubles and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param doubles            The doubles of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Double> comparator,
                final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(elementCardinality,
                    comparator, doubles));
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param doubles    The doubles of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Double> comparator, final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(comparator, doubles));
        }
    }

    /**
     * The sorted collection holding the doubles.
     */
    private final SortedCollection<Double> doubles;

    /**
     * Private constructor taking a sorted collection with the doubles as its parameter.
     *
     * @param doubles The sorted collection holding the doubles.
     */
    private SortedDoubleCollection(final SortedCollection<Double> doubles) {
        this.doubles = doubles;
    }

    @Override
    public boolean contains(final Double element) {
        return doubles.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return doubles.containsAll(collection);
    }

    /**
     * Returns a new empty sorted doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted doubles collection.
     */
    static SortedDoubleCollection empty(final Comparator<Double> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return doubles.get();
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return doubles.getAt(index);
    }

    @Override
    public Comparator<? super Double> getComparator() {
        return doubles.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return doubles.getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return doubles.iterator();
    }

    /**
     * Returns a new sorted doubles collection with the specified doubles.
     *
     * @param doubles    The doubles for the new sorted doubles collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted doubles collection with the specified doubles.
     */
    static SortedDoubleCollection of(final Comparator<Double> comparator, final Double... doubles) {
        return new ArrayCollection(comparator, doubles);
    }

    /**
     * Returns a new sorted doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param doubles            The doubles for the new sorted doubles collection.
     * @return A new sorted doubles collection with the specified element cardinality and the doubles.
     */
    static SortedDoubleCollection of(final ElementCardinality elementCardinality, final Comparator<Double> comparator,
            final Double... doubles) {
        return new ArrayCollection(elementCardinality, comparator, doubles);
    }

    @Override
    public int size() {
        return doubles.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return doubles.spliterator();
    }

    @Override
    public Double[] toArray() {
        return doubles.toArray(EmptyArrays.DOUBLES);
    }
}
