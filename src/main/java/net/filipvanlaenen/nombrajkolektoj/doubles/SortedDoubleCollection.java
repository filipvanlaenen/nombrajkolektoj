package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
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
        public ArrayCollection(final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The doubles of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Double> comparator,
                final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Double>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The doubles of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Double> comparator, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Double>(comparator, numbers));
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
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Collection<Double> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a sorted collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The doubles of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Double> comparator, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The doubles of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Double> comparator, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Double>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the doubles.
     */
    private final SortedCollection<Double> collection;

    /**
     * Private constructor taking a sorted collection with the doubles as its parameter.
     *
     * @param collection The sorted collection holding the doubles.
     */
    private SortedDoubleCollection(final SortedCollection<Double> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Double element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted doubles collection.
     */
    public static SortedDoubleCollection empty(final Comparator<? super Double> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Double element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Double> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Double getGreaterThan(final Double element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Double getGreaterThanOrEqualTo(final Double element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Double getLessThan(final Double element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Double getLessThanOrEqualTo(final Double element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Double element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Double> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted doubles collection with the specified doubles.
     *
     * @param numbers    The doubles for the new sorted doubles collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted doubles collection with the specified doubles.
     */
    public static SortedDoubleCollection of(final Comparator<? super Double> comparator, final Double... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original doubles collection.
     * @return A new sorted doubles collection cloned from the provided doubles collection.
     */
    public static SortedDoubleCollection of(final Comparator<? super Double> comparator,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted doubles collection cloned from a range in the provided ordered doubles collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted doubles collection cloned from a range in the provided ordered collection.
     */
    public static SortedDoubleCollection of(final Comparator<? super Double> comparator,
            final OrderedNumericCollection<Double> collection, final int fromIndex, final int toIndex) {
        ModifiableDoubleCollection slice = ModifiableDoubleCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The doubles for the new sorted doubles collection.
     * @return A new sorted doubles collection with the specified element cardinality and the doubles.
     */
    public static SortedDoubleCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Double> comparator, final Double... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @return A new sorted doubles collection cloned from the provided sorted doubles collection.
     */
    public static SortedDoubleCollection of(final SortedNumericCollection<Double> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted doubles collection cloned from the provided sorted doubles collection.
     *
     * @param collection The original sorted doubles collection.
     * @param range      The range.
     * @return A new sorted doubles collection cloned from the provided sorted doubles collection.
     */
    public static SortedDoubleCollection of(final SortedNumericCollection<Double> collection,
            final Range<Double> range) {
        ModifiableDoubleCollection slice = ModifiableDoubleCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Double element : collection) {
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
    public int lastIndexOf(final Double element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Double[] toArray() {
        return collection.toArray(EmptyArrays.DOUBLES);
    }
}
