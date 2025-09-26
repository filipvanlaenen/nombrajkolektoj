package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * shorts and containing inner classes with concrete implementations.
 */
public abstract class SortedShortCollection extends AbstractSortedShortCollection
        implements SortedNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedShortCollection {
        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The shorts of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
                final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public ArrayCollection(final Comparator<Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedShortCollection {
        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The shorts of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
                final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the shorts.
     */
    private final SortedCollection<Short> collection;

    /**
     * Private constructor taking a sorted collection with the shorts as its parameter.
     *
     * @param collection The sorted collection holding the shorts.
     */
    private SortedShortCollection(final SortedCollection<Short> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Short element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted shorts collection.
     */
    static SortedShortCollection empty(final Comparator<Short> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Short element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Short> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Short getGreaterThan(final Short element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Short getGreaterThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Short getLessThan(final Short element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Short getLessThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Short element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Short> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted shorts collection with the specified shorts.
     *
     * @param numbers    The shorts for the new sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted shorts collection with the specified shorts.
     */
    static SortedShortCollection of(final Comparator<Short> comparator, final Short... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The shorts for the new sorted shorts collection.
     * @return A new sorted shorts collection with the specified element cardinality and the shorts.
     */
    static SortedShortCollection of(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
            final Short... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public int lastIndexOf(final Short element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Short[] toArray() {
        return collection.toArray(EmptyArrays.SHORTS);
    }
}
