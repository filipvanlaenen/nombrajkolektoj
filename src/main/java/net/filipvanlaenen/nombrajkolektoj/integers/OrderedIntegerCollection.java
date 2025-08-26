package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * integers and containing inner classes with concrete implementations.
 */
public abstract class OrderedIntegerCollection extends AbstractOrderedIntegerCollection
        implements OrderedNumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedIntegerCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same integers and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs an ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the ordered collection.
         */
        public ArrayCollection(final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(numbers));
        }
    }

    /**
     * The ordered collection holding the integers.
     */
    private final OrderedCollection<Integer> collection;

    /**
     * Private constructor taking an ordered collection with the integers as its parameter.
     *
     * @param numbers The ordered collection holding the integers.
     */
    private OrderedIntegerCollection(final OrderedCollection<Integer> numbers) {
        this.collection = numbers;
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
     * Returns a new empty ordered integers collection.
     *
     * @return A new empty ordered integers collection.
     */
    static OrderedIntegerCollection empty() {
        return new ArrayCollection();
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
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new ordered integers collection with the specified integers.
     *
     * @param numbers The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified integers.
     */
    static OrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified element cardinality and the integers.
     */
    static OrderedIntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
