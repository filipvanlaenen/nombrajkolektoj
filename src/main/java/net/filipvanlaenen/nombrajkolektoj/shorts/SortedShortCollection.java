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
         * @param shorts            The shorts of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
                final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(elementCardinality, comparator,
                    shorts));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param shorts    The shorts of the sorted collection.
         */
        public ArrayCollection(final Comparator<Short> comparator, final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(comparator, shorts));
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
         * @param shorts            The shorts of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
                final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(elementCardinality,
                    comparator, shorts));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param shorts    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Short> comparator, final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(comparator, shorts));
        }
    }

    /**
     * The sorted collection holding the shorts.
     */
    private final SortedCollection<Short> shorts;

    /**
     * Private constructor taking a sorted collection with the shorts as its parameter.
     *
     * @param shorts The sorted collection holding the shorts.
     */
    private SortedShortCollection(final SortedCollection<Short> shorts) {
        this.shorts = shorts;
    }

    @Override
    public boolean contains(final Short element) {
        return shorts.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return shorts.containsAll(collection);
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
    public Short get() throws IndexOutOfBoundsException {
        return shorts.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return shorts.getAt(index);
    }

    @Override
    public Comparator<? super Short> getComparator() {
        return shorts.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return shorts.getElementCardinality();
    }

    @Override
    public Iterator<Short> iterator() {
        return shorts.iterator();
    }

    /**
     * Returns a new sorted shorts collection with the specified shorts.
     *
     * @param shorts    The shorts for the new sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted shorts collection with the specified shorts.
     */
    static SortedShortCollection of(final Comparator<Short> comparator, final Short... shorts) {
        return new ArrayCollection(comparator, shorts);
    }

    /**
     * Returns a new sorted shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param shorts            The shorts for the new sorted shorts collection.
     * @return A new sorted shorts collection with the specified element cardinality and the shorts.
     */
    static SortedShortCollection of(final ElementCardinality elementCardinality, final Comparator<Short> comparator,
            final Short... shorts) {
        return new ArrayCollection(elementCardinality, comparator, shorts);
    }

    @Override
    public int size() {
        return shorts.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return shorts.spliterator();
    }

    @Override
    public Short[] toArray() {
        return shorts.toArray(EmptyArrays.SHORTS);
    }
}
