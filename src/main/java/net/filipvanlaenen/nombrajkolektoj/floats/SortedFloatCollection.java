package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * floats and containing inner classes with concrete implementations.
 */
public abstract class SortedFloatCollection extends AbstractSortedFloatCollection
        implements SortedNumericCollection<Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedFloatCollection {
        /**
         * Constructs a sorted collection from a collection, with the same floats and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<Float> comparator, final Collection<Float> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a sorted collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The floats of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
                final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Float>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The floats of the sorted collection.
         */
        public ArrayCollection(final Comparator<Float> comparator, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Float>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedFloatCollection {
        /**
         * Constructs a sorted collection from a collection, with the same floats and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Float> comparator, final Collection<Float> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a sorted collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The floats of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
                final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Float>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The floats of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Float> comparator, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Float>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the floats.
     */
    private final SortedCollection<Float> collection;

    /**
     * Private constructor taking a sorted collection with the floats as its parameter.
     *
     * @param collection The sorted collection holding the floats.
     */
    private SortedFloatCollection(final SortedCollection<Float> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(final Float element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty sorted floats collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted floats collection.
     */
    static SortedFloatCollection empty(final Comparator<Float> comparator) {
        return new ArrayCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Float element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Float> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Float getGreaterThan(final Float element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Float getGreaterThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Float getLessThan(final Float element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Float getLessThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Float element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Float> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new sorted floats collection with the specified floats.
     *
     * @param numbers    The floats for the new sorted floats collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted floats collection with the specified floats.
     */
    static SortedFloatCollection of(final Comparator<Float> comparator, final Float... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The floats for the new sorted floats collection.
     * @return A new sorted floats collection with the specified element cardinality and the floats.
     */
    static SortedFloatCollection of(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
            final Float... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public int lastIndexOf(final Float element) {
        return collection.lastIndexOf(element);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Float[] toArray() {
        return collection.toArray(EmptyArrays.FLOATS);
    }
}
