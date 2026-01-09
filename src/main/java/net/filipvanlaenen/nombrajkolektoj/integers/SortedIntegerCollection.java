package net.filipvanlaenen.nombrajkolektoj.integers;

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
        public ArrayCollection(final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Integer> comparator,
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
        public ArrayCollection(final Comparator<? super Integer> comparator, final Integer... numbers) {
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
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Integer> comparator, final Integer... numbers) {
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
        public SortedTreeCollection(final Comparator<? super Integer> comparator, final Integer... numbers) {
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
    public static SortedIntegerCollection empty(final Comparator<? super Integer> comparator) {
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
    public Integer getGreaterThan(final Integer element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Integer getGreaterThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Integer getLessThan(final Integer element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Integer getLessThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
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
    public static SortedIntegerCollection of(final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original integers collection.
     * @return A new sorted integers collection cloned from the provided integers collection.
     */
    public static SortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final IntegerCollection collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted integers collection cloned from a range in the provided ordered integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted integers collection cloned from a range in the provided ordered collection.
     */
    public static SortedIntegerCollection of(final Comparator<? super Integer> comparator,
            final OrderedIntegerCollection collection, final int fromIndex, final int toIndex) {
        ModifiableIntegerCollection slice = ModifiableIntegerCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The integers for the new sorted integers collection.
     * @return A new sorted integers collection with the specified element cardinality and the integers.
     */
    public static SortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Integer> comparator, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @return A new sorted integers collection cloned from the provided sorted integers collection.
     */
    public static SortedIntegerCollection of(final SortedIntegerCollection collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted integers collection cloned from the provided sorted integers collection.
     *
     * @param collection The original sorted integers collection.
     * @param range      The range.
     * @return A new sorted integers collection cloned from the provided sorted integers collection.
     */
    public static SortedIntegerCollection of(final SortedIntegerCollection collection, final Range<Integer> range) {
        ModifiableIntegerCollection slice = ModifiableIntegerCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Integer element : collection) {
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
