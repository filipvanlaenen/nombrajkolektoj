package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * longs and containing inner classes with concrete implementations.
 */
public abstract class OrderedLongCollection extends AbstractOrderedLongCollection
        implements OrderedNumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedLongCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same longs and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs an ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param longs            The longs of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(elementCardinality, longs));
        }

        /**
         * Constructs an ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param longs The longs of the ordered collection.
         */
        public ArrayCollection(final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(longs));
        }
    }

    /**
     * The ordered collection holding the longs.
     */
    private final OrderedCollection<Long> longs;

    /**
     * Private constructor taking an ordered collection with the longs as its parameter.
     *
     * @param longs The ordered collection holding the longs.
     */
    private OrderedLongCollection(final OrderedCollection<Long> longs) {
        this.longs = longs;
    }

    @Override
    public boolean contains(final Long element) {
        return longs.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return longs.containsAll(collection);
    }

    /**
     * Returns a new empty ordered longs collection.
     *
     * @return A new empty ordered longs collection.
     */
    static OrderedLongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return longs.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return longs.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return longs.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return longs.iterator();
    }

    /**
     * Returns a new ordered longs collection with the specified longs.
     *
     * @param longs The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified longs.
     */
    static OrderedLongCollection of(final Long... longs) {
        return new ArrayCollection(longs);
    }

    /**
     * Returns a new ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param longs            The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified element cardinality and the longs.
     */
    static OrderedLongCollection of(final ElementCardinality elementCardinality, final Long... longs) {
        return new ArrayCollection(elementCardinality, longs);
    }

    @Override
    public int size() {
        return longs.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return longs.spliterator();
    }

    @Override
    public Long[] toArray() {
        return longs.toArray(EmptyArrays.LONGS);
    }
}
