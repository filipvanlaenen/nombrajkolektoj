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
         * @param integers            The integers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(elementCardinality, integers));
        }

        /**
         * Constructs an ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param integers The integers of the ordered collection.
         */
        public ArrayCollection(final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(integers));
        }
    }

    /**
     * The ordered collection holding the integers.
     */
    private final OrderedCollection<Integer> integers;

    /**
     * Private constructor taking an ordered collection with the integers as its parameter.
     *
     * @param integers The ordered collection holding the integers.
     */
    private OrderedIntegerCollection(final OrderedCollection<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public boolean contains(final Integer element) {
        return integers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return integers.containsAll(collection);
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
        return integers.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return integers.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return integers.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return integers.iterator();
    }

    /**
     * Returns a new ordered integers collection with the specified integers.
     *
     * @param integers The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified integers.
     */
    static OrderedIntegerCollection of(final Integer... integers) {
        return new ArrayCollection(integers);
    }

    /**
     * Returns a new ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param integers            The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified element cardinality and the integers.
     */
    static OrderedIntegerCollection of(final ElementCardinality elementCardinality, final Integer... integers) {
        return new ArrayCollection(elementCardinality, integers);
    }

    @Override
    public int size() {
        return integers.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return integers.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return integers.toArray(EmptyArrays.INTEGERS);
    }
}
