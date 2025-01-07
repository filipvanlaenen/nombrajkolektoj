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
         * @param floats            The floats of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
                final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Float>(elementCardinality, comparator,
                    floats));
        }

        /**
         * Constructs a sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param floats    The floats of the sorted collection.
         */
        public ArrayCollection(final Comparator<Float> comparator, final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Float>(comparator, floats));
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
         * @param floats            The floats of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
                final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Float>(elementCardinality,
                    comparator, floats));
        }

        /**
         * Constructs a sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param floats    The floats of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Float> comparator, final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Float>(comparator, floats));
        }
    }

    /**
     * The sorted collection holding the floats.
     */
    private final SortedCollection<Float> floats;

    /**
     * Private constructor taking a sorted collection with the floats as its parameter.
     *
     * @param floats The sorted collection holding the floats.
     */
    private SortedFloatCollection(final SortedCollection<Float> floats) {
        this.floats = floats;
    }

    @Override
    public boolean contains(final Float element) {
        return floats.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return floats.containsAll(collection);
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
    public Float get() throws IndexOutOfBoundsException {
        return floats.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return floats.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return floats.getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return floats.iterator();
    }

    /**
     * Returns a new sorted floats collection with the specified floats.
     *
     * @param floats    The floats for the new sorted floats collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted floats collection with the specified floats.
     */
    static SortedFloatCollection of(final Comparator<Float> comparator, final Float... floats) {
        return new ArrayCollection(comparator, floats);
    }

    /**
     * Returns a new sorted floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param floats            The floats for the new sorted floats collection.
     * @return A new sorted floats collection with the specified element cardinality and the floats.
     */
    static SortedFloatCollection of(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
            final Float... floats) {
        return new ArrayCollection(elementCardinality, comparator, floats);
    }

    @Override
    public int size() {
        return floats.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return floats.spliterator();
    }

    @Override
    public Float[] toArray() {
        return floats.toArray(EmptyArrays.FLOATS);
    }
}
