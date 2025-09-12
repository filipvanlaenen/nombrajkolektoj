package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * doubles and containing inner classes with concrete implementations.
 */
public abstract class OrderedDoubleCollection extends AbstractOrderedDoubleCollection
        implements OrderedNumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedDoubleCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same doubles and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs an ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the ordered collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(numbers));
        }
    }

    /**
     * The ordered collection holding the doubles.
     */
    private final OrderedCollection<Double> collection;

    /**
     * Private constructor taking an ordered collection with the doubles as its parameter.
     *
     * @param numbers The ordered collection holding the doubles.
     */
    private OrderedDoubleCollection(final OrderedCollection<Double> numbers) {
        this.collection = numbers;
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
     * Returns a new empty ordered doubles collection.
     *
     * @return A new empty ordered doubles collection.
     */
    static OrderedDoubleCollection empty() {
        return new ArrayCollection();
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
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Double element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Double> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Double element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified doubles.
     */
    static OrderedDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified element cardinality and the doubles.
     */
    static OrderedDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
