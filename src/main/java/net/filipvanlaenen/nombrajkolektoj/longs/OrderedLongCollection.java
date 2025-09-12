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
         * @param numbers            The longs of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the ordered collection.
         */
        public ArrayCollection(final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(numbers));
        }
    }

    /**
     * The ordered collection holding the longs.
     */
    private final OrderedCollection<Long> collection;

    /**
     * Private constructor taking an ordered collection with the longs as its parameter.
     *
     * @param numbers The ordered collection holding the longs.
     */
    private OrderedLongCollection(final OrderedCollection<Long> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
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
    public int firstIndexOf(final Long element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Long element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Long element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered longs collection with the specified longs.
     *
     * @param numbers The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified longs.
     */
    static OrderedLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified element cardinality and the longs.
     */
    static OrderedLongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray(EmptyArrays.LONGS);
    }
}
